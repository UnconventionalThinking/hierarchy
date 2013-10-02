#!/usr/bin/perl

# The purpose of the file

print "Modifying the Parser.java file...\n";




$parser_dir = "";  #  Typically, equals something like: "./../src/net/unconventionalthinking/hierarchy/grammar/parser"
$parser_fileName = "Parser.java";
$parser_out_filename = "Parser.java.out";


$parser_switch1_filename = "Parser.switch1.txt";
$parser_switch2_filename = "Parser.switch2.txt";


$CASE_NUM_SPLIT = 2100;
#$CASE_NUM_SPLIT = 14;


#  Get the Parser Directory from the command line
$nextArg_Is_InputFileDir = 0;
$first_PathPart = 1;

$already_modified = 0;


while (<@ARGV>) {

    if ($nextArg_Is_InputFileDir == 1) {
        if ($first_PathPart == 1) {
            $parser_dir = $_;
            $first_PathPart = 0;
        } else {
            #  Perl breaks args with spaces into multiple arguments, even if, on the cmdline, it has quotes around it.
            #  So, this means you had a space character in your path, and you need to add the next arg to the inputfile
 			#  dir.
            #  NOTE: this doesn't handle two or more spaces in a row in a path, just one!
            $parser_dir = $parser_dir . " " . $_;  #  notice the space needs to be added
        }
    }

    if ($_ == "-d") {
        $nextArg_Is_InputFileDir = 1;
    } else {
        $nextArg_Is_InputFileDir = 0;
    }
}
$parser_file_path = "${parser_dir}/${parser_fileName}";
$parser_out_file_path = "${parser_dir}/${parser_out_filename}";

$parser_switch1_file_path = "${parser_dir}/${parser_switch1_filename}";
$parser_switch2_file_path = "${parser_dir}/${parser_switch2_filename}";

print "   Parser Dir is: $parser_dir \n   and Parser File is : $parser_file_path\n";
$|++; # flush print buffer



# open file Parser.Java and read it into variable

open InputFile, "< ${parser_file_path}"
	or die "  ERROR: couldn't find the input file: $!";

#	
open OutputFile, "> ${parser_out_file_path}"
	or die "  ERROR: couldn't open the output file: $!";

open ParserSwitch1_tempFile, "> ${parser_switch1_file_path}"
	or die "  ERROR: couldn't open the output file: $!";
open ParserSwitch2_tempFile, "> ${parser_switch2_file_path}"
	or die "  ERROR: couldn't open the output file: $!";



$have_processedCases = 0;
$first_SuppressWarning_After_Cases_Found = 0;


while (<InputFile>) {
	
	if ($_ =~/^\s+switch\(this\.action\[1\]\)/) {
		
		print "  Generating method calls...";
		$|++; # flush print buffer
		
		print OutputFile "\n\n" . 
						"\t\t\t\t\t{\n" .
						"\t\t\t\t\t\t//  ** MATRIX GENERATED **\n" .
						"\t\t\t\t\t\tint CASE_NUM_SPLIT = ${CASE_NUM_SPLIT};\n" . 
						"\t\t\t\t\t\tif (this.action[1] < CASE_NUM_SPLIT) \n" . 
						"\t\t\t\t\t\t\tparse_switch1(this.action[1]); \n" .
        				"\t\t\t\t\t\telse \n" .
        				"\t\t\t\t\t\t\tparse_switch2(this.action[1]);\n\n\n\n";


		print " done\n\n";
		print " Processing first switch...";
		$|++; # flush print buffer


		$caseString1 = "";
		$caseSplitFound = 0;
		
		$_ = <InputFile>;
		while (!$caseSplitFound) {
			if ($_ =~ /^\s+case $CASE_NUM_SPLIT:/) {
				$caseSplitFound = 1;
			} else {
				#  Save the cases into a string var
				#$caseString1 = $caseString1 . $_;
				# output to tempfile instead
				print ParserSwitch1_tempFile $_;
			
				$_ = <InputFile>;
			}
		}
		close ParserSwitch1_tempFile;
#		print "DEBUG: caseString1:\n ${caseString1}\n\n\n";
		
		
		print " done\n\n";
		print " Processing second switch... ";
		$|++; # flush print buffer
		
		
		$caseString2 = "";
		$lastCaseBreakFound = 0;
		$prevLine = "";
		$currLine = $_;
		
		while (!$lastCaseBreakFound) {
			
			if ($prevLine =~ /^\s*break;/ && !($currLine =~ /^\s*case/) ) {
				$lastCaseBreakFound = 1;
			} else {
				#$caseString2 = $caseString2 . $currLine;
				# output to tempfile instead
				print ParserSwitch2_tempFile $currLine;
				
				$prevLine = $currLine;
				$currLine = <InputFile>;
				
			}
			
			
		}
		close ParserSwitch2_tempFile;
#		print "DEBUG: caseString2:\n ${caseString2}\n\n";
		
		
		$have_processedCases = 1;
		$_ = $currLine;
		print OutputFile $_;
		
	} elsif ($_ =~ /^\s+int CASE_NUM_SPLIT = /) {
		
		# We've already add this in, don't add it in twice, just ignore
		$already_modified = 1;	
		die "  ERROR: We've already modified the Parser.Java file, regenerate it first, then re-run this script."
		
		
	} elsif ($have_processedCases && !$first_SuppressWarning_After_Cases_Found &&
		$_ =~ /^\s*[@]SuppressWarnings/) {

		$first_SuppressWarning_After_Cases_Found = 1;
		$suppressWarning_Line = $_;
		
		
		
		#  Output the first Switch methond
		open ParserSwitch1_tempFile, "< ${parser_switch1_file_path}"
			or die "  ERROR: couldn't open the input file: $!";
		
		print OutputFile 
			"\tprivate void parse_switch1(int caseNum) throws ParserException, LexerException, IOException {\n" .
	       	"\t\tswitch(caseNum)\n";

		while(<ParserSwitch1_tempFile>) {
			print OutputFile $_;
		}
		
		print OutputFile 
			"\t\t}\n" .	
			"\t}\n\n"; 
		close ParserSwitch1_tempFile;
		unlink $parser_switch1_file_path;  # delete file



		open ParserSwitch2_tempFile, "< ${parser_switch2_file_path}"
			or die "  ERROR: couldn't open the input file: $!";
		print OutputFile 
			"\tprivate void parse_switch2(int caseNum) throws ParserException, LexerException, IOException {\n" .
	       	"\t\tswitch(caseNum)\n".
			"\t\t{\n";   # the first parse_switch doesn't need the '{' for the switch, but the 2nd does!	

		while(<ParserSwitch2_tempFile>) {
			print OutputFile $_;
		}
			
		print OutputFile 
			"\t\t}\n" .	
			"\t}\n\n\n"
	    	; 
		close ParserSwitch2_tempFile;
		unlink $parser_switch2_file_path; # delete file
		

		#  Don't forget to add that suppress warning line in
		print OutputFile $suppressWarning_Line; 
				
	} else {
		print OutputFile $_; 
	}
}

close OutputFile;

print "Done.\n\n";

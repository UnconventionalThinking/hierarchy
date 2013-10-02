#!/usr/bin/perl

# The purpose of the file

print "Modifying the Parser.java file...\n";




$parser_dir = "";  #  Typically, equals something like: "./../src/net/unconventionalthinking/hierarchy/grammar/parser"
$parser_fileName = "Parser.java";

$parser_out_filename = "Parser.java.out";


$CASE_NUM_SPLIT = 1500;
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

print "   Parser Dir is: $parser_dir \n   and Parser File is : $parser_file_path\n";




# open file Parser.Java and read it into variable

open InputFile, "< ${parser_file_path}"
	or die "  ERROR: couldn't find the input file: $!";

#	
open OutputFile, "> ${parser_out_file_path}"
	or die "  ERROR: couldn't open the output file: $!";



$have_processedCases = 0;
$first_SuppressWarning_After_Cases_Found = 0;


while (<InputFile>) {
	
	if ($_ =~/switch\(this\.action\[1\]\)/) {
		print OutputFile "\n\n" . 
						"\t\t\t\t\t{\n" .
						"\t\t\t\t\t\t//  ** MATRIX GENERATED **\n" .
						"\t\t\t\t\t\tint CASE_NUM_SPLIT = ${CASE_NUM_SPLIT};\n" . 
						"\t\t\t\t\t\tif (this.action[1] < CASE_NUM_SPLIT) \n" . 
						"\t\t\t\t\t\t\tparse_switch1(this.action[1]); \n" .
        				"\t\t\t\t\t\telse \n" .
        				"\t\t\t\t\t\t\tparse_switch2(this.action[1])\n\n\n\n";


		$caseString1 = "";
		$caseSplitFound = 0;
		
		$_ = <InputFile>;
		while (!$caseSplitFound) {
			if ($_ =~ /case $CASE_NUM_SPLIT:/) {
				$caseSplitFound = 1;
			} else {
				#  Save the cases into a string var
				$caseString1 = $caseString1 . $_;
			
				$_ = <InputFile>;
			}
		}
#		print "DEBUG: caseString1:\n ${caseString1}\n\n\n";
		
		$caseString2 = "";
		$lastCaseBreakFound = 0;
		$prevLine = "";
		$currLine = $_;
		
		while (!$lastCaseBreakFound) {
			$caseString2 = $caseString2 . $currLine;
			
			if ($prevLine =~ /break;/ && $currLine =~ /^\s+$/ ) {
				$lastCaseBreakFound = 1;
			}
			$prevLine = $currLine;
			$currLine = <InputFile>;
			
#print "** prevLine: '$prevLine'\n currLine: '$currLine'\n";
			
		}
#		print "DEBUG: caseString2:\n ${caseString2}\n\n";
		
		$have_processedCases = 1;
		$_ = currLine;
		
	} elsif ($_ =~ /int CASE_NUM_SPLIT = /) {
		
		# We've already add this in, don't add it in twice, just ignore
		$already_modified = 1;	
		die "  ERROR: We've already modified the Parser.Java file, regenerate it first, then re-run this script."
		
		
	} elsif ($have_processedCases && !$first_SuppressWarning_After_Cases_Found &&
		$_ =~ /[@]SuppressWarnings/) {

		$first_SuppressWarning_After_Cases_Found = 1;
		$suppressWarning_Line = $_;
		
		#  Output the first Switch methond
		
		print OutputFile 
			"\tprivate void parse_switch1(int caseNum) throws ParserException, LexerException, IOException {\n" .
	       	"\t\tswitch(caseNum)\n".

			$caseString1 .

			"\t\t}\n" .	
			"\t}\n\n"
	    	; 

		print OutputFile 
			"\tprivate void parse_switch2(int caseNum) throws ParserException, LexerException, IOException {\n" .
	       	"\t\tswitch(caseNum)\n".
			"\t\t{\n" .  # the first parse_switch doesn't need the '{' for the switch, but the 2nd does!	

			$caseString2 .

			"\t\t}\n" .	
			"\t}\n\n\n"
	    	; 
		

		#  Don't forget to add that suppress warning line in
		print OutputFile $suppressWarning_Line; 
				
	} else {
		print OutputFile $_; 
	}
}


print "Done.\n\n";

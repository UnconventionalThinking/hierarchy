#!/usr/bin/perl

# The purpose of the file is add some code to the Token class. It does this by:
# Read the Token.java file, and add the statement, "import com.abstractsystems.compiler.tools..."
# and adding a code() method to the class.

print "Modifying the Token File... \n";


$node_dir = "";  #  Typically, equals something like: "./../src/com/abstractsystems/partita/grammar/node"

#  Get the Node Directory from the command line
$nextArg_Is_NodeDir = 0;
$first_PathPart = 1;

while (<@ARGV>) {

    if ($nextArg_Is_NodeDir == 1) {
        if ($first_PathPart == 1) {
            $node_dir = $_;
            $first_PathPart = 0;
        } else {
            #  Perl breaks args with spaces into multiple arguments, even if, on the cmdline, it has quotes around it.
            #  So, this means you had a space character in your path, and you need to add the next arg to the node dir.
            #  NOTE: this doesn't handle two or more spaces in a row in a path, just one!
            $node_dir = $node_dir . " " . $_;  #  notice the space needs to be added
        }
    }

    if ($_ == "-d") {
        $nextArg_Is_NodeDir = 1;
    } else {
        $nextArg_Is_NodeDir = 0;
    }
}

print "   Node Dir is: $node_dir\n";





# open file token.Java and read it into variable

open TokenFileIn, "< ${node_dir}/Token.java"
	or die "  ERROR: couldn't find the Token file: $!";

#	
open TokenFileOut, "> ${node_dir}/Token.java.out"
	or die "  ERROR: couldn't find the token out file: $!";

$fileAlreadyModified = 0; #false

while (<TokenFileIn>) {
	
	
	# Check to see if we've already made the modifications to the file. If so, don't add them in.
	if ($_ =~ /import com\.abstractsystems\.compiler\.tools/) {
		$fileAlreadyModified = 1; #true 
	}
			
	if ($fileAlreadyModified == 0) {
		if ($_ =~/^\@SuppressWarnings/) {
			print TokenFileOut "import com.abstractsystems.compiler.tools.*;\n\n" .
				"\@SuppressWarnings(\"nls\")\n";
	
		} elsif ($_ =~/private int pos/) {

			print TokenFileOut "    private int pos;\n\n" .
			"\t/** \n  " .
			"\t* This method added in after sableCC generation. It needs to return a codeBuilder if one exists.\n " .
			"\t*/ \n " .
			"   \@Override \n " .
			"   public CodeBuilder code() { \n " .
			"       return Token_Utilities.token_code(text, codeBuilder); \n " .
			"   } \n ";
		} else {
			print TokenFileOut $_; 
		}
	} else {
		print TokenFileOut $_; 
	}
}


print "done.\n\n";

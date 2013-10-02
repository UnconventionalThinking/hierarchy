#!/usr/bin/perl

# The purpose of the file is have the Node class inherit from my Attrbiute Node. It does this by:
# Read the Node.java file, and add the statement, "import net.unconventionalthinking.compiler.tools..."
# and adding "extends AttributeNode" to the class definition

print "Modifying the Node.java file...\n";




$node_dir = "";  #  Typically, equals something like: "./../src/net/unconventionalthinking/hierarchy/grammar/node"

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




# open file Node.Java and read it into variable

open NodeFileIn, "< ${node_dir}/Node.java"
	or die "  ERROR: couldn't find the node file: $!";

#	
open NodeFileOut, "> ${node_dir}/Node.java.out"
	or die "  ERROR: couldn't find the node out file: $!";

while (<NodeFileIn>) {
	
	if ($_ =~/^import java\.util/) {
		print NodeFileOut "import java.util.*;\n" . 
			"import net.unconventionalthinking.compiler.tools.*; //  ** Matrix** modification \n";
		
	} elsif ($_ =~ /import com\.unconventionalthinking\.compiler\.tools/) {
		# We've already add this in, don't add it in twice, just ignore
			
	} elsif (/^public abstract class Node/) {
		print NodeFileOut "public abstract class Node extends AttributeNode implements Switchable, Cloneable\n";
	
	} elsif (/^[ \t]*return node\.toString/) {
		print NodeFileOut "//\t\t\treturn node.toString();\n" .
		            "\t\t\treturn super.toString_Processor(node);  // **Matrix** modification\n";

	} else {
		print NodeFileOut $_; 
	}
}


print "Done.\n\n";

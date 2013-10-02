# ReplaceText2 
# replaces text in all files, descending directories recursively
# Insert the searchString and the replaceString into code
# may have to comment out "$replaceString.." (used to translate \n into newline)

#!/perl/bin/perl -w
use strict;
use warnings;

use Cwd;

my $HeaderFilePath = "./../../04__ProductDocs/GPL License - File Header.txt";
my $HierarchyCodeDir = "..";

# Get the License header and put it in a string
open(HEADER_FILE, $HeaderFilePath) || die "Can't open file $HeaderFilePath!\n";
my $header = "";
while (<HEADER_FILE>){
	$header = $header . $_;
}
#print ($header);


navOnlyHierarchyFolders();

sub navOnlyHierarchyFolders {
	chdir($HierarchyCodeDir);
	
	my @dirItems = <Hierarchy*>;

	
	my $item;
	foreach $item (@dirItems) {
		if (-d $item) {
			nav($item);
		}
	}	
 	
}

sub nav {
	my $newDir = $_[0];
	chdir($newDir);
	
	#print ( "  cd to $newDir\n");
	
	print ("In directory: ". cwd() . "\n" );
	modifyFiles();

	my @dirItems = <*>;
	
	my $item;
	foreach $item (@dirItems) {
		#print ("    ". $newDir . "/" . "$item\n");
		if (-d $item) {
			nav($item);
		}
	}	
 	
	if ($newDir ne ".") {
		chdir("..");
		#print ( "  cd back\n");
	}
}


# modifies files in the directory

sub modifyFiles
{
	my @dirList = <*>;
	my $fileName = "";
	
	print ("In directory: ". cwd() . "\n" );

	foreach $fileName (@dirList) {
		if (-f $fileName) {
			my ($ext) = $fileName =~ /(\.[^.]+)$/;
			
			
			if ($ext eq ".java" || $ext eq ".mjava" || $ext eq ".matrix" || $ext eq ".schema") {   
				print "     Adding header to $fileName...";
				open(FILE, $fileName) || die "Can't open file $fileName!\n";

				# put file into a var
				my $lines = "";

				my $alreadyHasHeader = 0;
				my $numCharToCompare = 24;
				$lines = <FILE>;
				if (substr($lines, 0, $numCharToCompare) eq substr($header, 0, $numCharToCompare)) {
					$alreadyHasHeader = 1;
				}
				
				
				if (!$alreadyHasHeader) {
					# add header
					$lines = $header . $lines;
					# get rest of file
					while (<FILE>){
						$lines = $lines . $_;

					}

		#			($baseName,) = split(/\./, $fileName);

					close (FILE);

					open (OUTFILE, ">$fileName");
					print OUTFILE $lines;
					close (OUTFILE);
					
					print " added.\n";
				} else {
				
					close (FILE);
				
					print "  ... already has a header!\n";
				}
				
				
			}
		}
	}
	
}


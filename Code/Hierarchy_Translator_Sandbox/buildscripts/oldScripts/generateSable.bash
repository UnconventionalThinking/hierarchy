# Created by Peter Joh

ECHO
ECHO Creating SableCC classes for the grammar file:
ECHO

sourceCodeDir_Path="../src"
partitacompilerDir_FullPath="$sourceCodeDir_Path/com/abstractsystems/partita"
partitagrammarDir_Path="com/abstractsystems/partita/grammar"
partitagrammarDir_FullPath="$sourceCodeDir_Path/$partitagrammarDir_Path"



rm -f -r $partitagrammarDir_FullPath

ECHO Note, when running sableCC, you may need to increase the heap size using the -Xmx command
java -Xms128m -Xmx512m -jar "/Volumes/PETER WORK/40__DevSoftware/01__Java/Libs/sablecc-3.2/lib/sablecc.jar"  $partitacompilerDir_FullPath/Partita.grammar

#move the generated folder of code to the right place, and remove the empty directories left behind
mv $partitacompilerDir_FullPath/$partitagrammarDir_Path $partitacompilerDir_FullPath/
rm -f -r $partitacompilerDir_FullPath/com

ECHO 
ECHO Creating modified Node.Java file that inherits from AttributeNode.Java...
ECHO 

./modifyNodeFile.perl

ECHO Replacing Node.Java with modified file
rm -f -r $partitagrammarDir_FullPath/node/Node.java
mv $partitagrammarDir_FullPath/node/Node.java.out $partitagrammarDir_FullPath/node/Node.java

ECHO 
ECHO Creating modified Token.Java file 
ECHO 

./modifyTokenFile.perl

ECHO Replacing Token.Java with modified file
rm -f -r $partitagrammarDir_FullPath/node/Token.java
mv $partitagrammarDir_FullPath/node/Token.java.out $partitagrammarDir_FullPath/node/Token.java

ECHO Done.

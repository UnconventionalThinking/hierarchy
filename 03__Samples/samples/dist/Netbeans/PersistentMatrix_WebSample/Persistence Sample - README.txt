_______________________________________________________________

  Instructions on how to setup, build, and run
    the Persistence, Web Sample
_______________________________________________________________

NOTE: If you haven't does so already, please read the chapter on persistence found in the Hierarchy Developer Guide. It'll give you a good understanding of what persistent matrices are, and what's going on behind the scenes.

NOTE 2: PERSISTENCE IS ONLY A PREVIEW VERSION AT THIS POINT, SO IT'S NOT AS EASY TO USE AS THE REST OF HIERARCHY! What this means is follow these instructions very carefully! Try not to skip around or miss a step! 


1. The persistence sample project requires the installation of Apache Tomcat 6. If you don't have this on your system, please install it first.

2. Modify the path variables in the client and in the server property files.
   
   a. First, let's modify the persistence client properties file. It's located at:
   
   	    PersistentMatrix_WebSample\web\WEB-INF\client-matrix-persistence.properties
   
      - Replace all instances of the place holders, <PATH TO ...> and <DIR PATH OF ...>, with the correct ABSOLUTE paths on your local system. Specifically, replace the following (and note, there may be multiple instances of each place-holder that you need to replace):
      
		o <PATH TO DIR WHERE HIERARCHY.JAR IS LOCATED>
		o <DIR PATH OF JAVA BIN>
		o <DIR PATH OF TOMCAT 6>
		o <DIR PATH OF HIERARCHY>
		
		
	  - Also note that you need to use the correct version of the 'classpath.allphases' variable, depending on whether your using windows, or a UNIX-variant OS! Comment out the one you aren't using.
	  
	b. Next, let's modify the server properties file. It's located at:
	
		  PersistentMatrix_WebSample\server-matrix-persistence.properties
	
		- Do pretty much the same replacements in this file as you did with the client properties. Note though, there should be less place holders to replace as the server properties file is able to use more relative paths.	
		
	c. Lastly, you need to make one last modification in a third file. Open the build-util.xml file found in the root directory of the persistence sample project. Then, set the "tomcat.home" property to the directory of your Apache installation.


3. Start the Java rmi server. 
   'rmiregistry' is an executable in the bin directory of the Java JDK. To start the rmi server, execute this command, giving it the Hierarchy.jar in its classpath. So:

   a. The JDK's bin directory needs to be in your enviroment's PATH, so we can execute the rmiregistry command from a terminal window. If it isn't, you'll need to add it.

   b. Open a new terminal window and type: 
   
   	     cd <DIR PATH OF THE HIERARCHY PROJECT>

         rmiregistry -J-classpath -J.\bin\Hierarchy.jar

      * Double check to make sure that you're running rmiregistry in the ROOT directory of the Hierarchy project, NOT the 'bin' directory! rmiregistry will NOT let you know if you're in the wrong directory!
      
   c. Leave the rmi server running.


4. Open the PersistenceMatrix_WebSample project in Netbeans. Now, you'll need to clean your project before you proceed to the next step! In the IDE, simply right click on the project in the project explorer and select "clean". Honestly, we're not 100% sure why you need to do this at this point, but to get the persistence server metacompiling and running, it does seem necessary.

5. Build & start up the Persistence Server:
   
   a. In a new terminal window, cd to this sample project's directory, then type:
   
      ant -f build-util.xml start-server
      
   b. If this is the first time the server has run, it will copy over the Client's meta source-code to its own source code repository. Leave the server running.


6. In Netbeans, now, build the client project. In the IDE, simply right click on the project in the project explorer and select "build". Watch the output window for an errors. If there are any errors, it's usually because of an improper path setting you've made from a previous step.


7. Update and Deploy the Client

   Now, we're going to run an custom ant-task that
      1) Updates the client persisted matrices with the version on the server
      2) metacompiles the client
      3) compiles the client
      4) deploys the project
   
   Here's what you need to do:
   
   a. In Netbeans, open the project's build.xml in the IDE. If you're not familiar with how to find this file, you can use the file view window: In the left pane of the IDE, select the "files" tab. Then, expand the PersistentMatrix_WebSample project and open its "build.xml" file.
   
   b. In the build.xml's editor window, right click anywhere in the text. Then, select "Run Target" from the drop-down menu. 
   c. In this menu, select the "update-and-deploy" target. This will kick off the Ant script which will perform all the necessary updating, compiling, and deploying.
   
   NOTE: If you get an IOException with a Write Error, you may have to turn off Temporary Internet Files in the Java Control Panel
   

8. Now, feel free to play with the web application and its persistence:
   a. Open your browser and type in:

       http://localhost:8080/PersistentMatrix_WebSample

   b. To add new articles, click on the "administer this page" link, and fill out the form.
   
   
   c. To see that persistence works, after you add a new story, try shutting down the web server and re-deploying:
      i) To shutdown the web server: in Netbeans, in its Output window pane, select the "Tomcat 6.0" output tab, and then click on the server's stop button (it's the red square on the left edge of the window pane).
      
      ii) If you'd like, at this point, you can also shutdown the persistence server and restart this as well. This is only to prove to yourself that the persistence server doesn't need to be running as well as the web server to persist your changes.
      	a) Go to the terminal window you ran the server ant script in. It should still be running the server. Hit "ctrl-c" to stop the server. 
      	b) Now, start the server back up by retyping the command: ant -f build-util.xml start-server
      
      iii) Redo the previous step to "Update and Deploy the Client". This should also restart the web-server for you.
      iv) Now, when you go back to your browser, you should see that the client still has your additional news story.
      	
	
	
	
9. If you'd like to reset persistence, setting the persisted matrix back to its start state (with none of your new news-stories), then:
   a. Shutdown both the web-server and the persistence-server
   b. In a terminal window, cd to this sample project's directory, then type:
   
       ant -f build-util.xml reset-persistence
      
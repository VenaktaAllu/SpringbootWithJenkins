How to install Jenkins on MacOS:

Jenkins is used to build and test your product continuously, so developers can continuously integrate changes into the build. Jenkins is the most popular open source CI/CD tool on the market today and is used in support of DevOps, alongside other cloud native tools.

From terminal using brew: brew install jenkins
Start the Jenkins after installation: brew services start jenkins
Check if it is running smoothly: localhost:8080/
Setup Jenkins using initial admin password and BOOOM….
For more Info: https://www.jenkins.io/download/weekly/macos/ 

Configure Jenkins:
Navigate to Manage Jenkins > Global tool Configuration: (I won’t recommend to use install manually for JDK, git, Maven)

1. set JAVA_HOME in JDK section
2. Git should be default for now
3. Set MAVEN_HOME for Maven

Testing Java and Maven configured properly: 
1. Import sample code from https://github.com/chaitanyaallu/SpringbootWithJenkins.git
2. Open terminal, navigate to the project and hit mvn clean test
3. Create a new free style project in Jenkins, configure and build>Add build step>Execute shell

        #Add: first two lines may be optional
        1. export MAVEN_HOME=/Users/chaitu/eclipse-workspace/maven                                                                                                       
        2. export PATH=$PATH:$MAVEN_HOME/bin                                                                                                                               
        3. cd /Users/chaitu/eclipse-workspace/SpringbootwithJenkins                                                                                                       
        4. mvn clean test

4. Open the free style project, hit build now and in build history go to console output for the results.

Testing same project using Maven plugin in the Jenkins:
1. Go to manage Jenkins > mange plugins > Available and search for maven
2. Install the maven integration plugin without restart
3. Back to the dashboard > new Job > maven project > configure> build and update the path of pom.xml of sample project, specify goals as clean test
4. that is it, build the new project and open console for the logs.

Integrating Jenkins with GitHub:
1. Go to manage Jenkins > global tools > git, update path of git to /usr/bin/git and Apply, Save
2. Back to the dashboard > new Job > maven project > configure> source code management and update the repository URL, branch of sample project and specify just goals in build section as clean test
3. Build the new project and open console for the logs




ITEMS-TESTS
-----------
items-tests is an test framework to automate test cases of Stranger Things items web page. Please follow  the next instructions to execute the tests.

REQUIREMENTS
-----------------------------------

The required configuration to execute the tests is the following:

    -Java 8 JDK: https://www.oracle.com/java/technologies/downloads/
    -IntelliJ idea IDE: https://www.jetbrains.com/idea/download/#section=windows
    -Download Gradle 7.0 or superior: https://gradle.org/gradle-download/
    -Clone/download the project from GitHub repository: https://github.com/EscarlethFatima/items-selenium-tests.git
    -Create an account in BrowserStack https://www.browserstack.com/users/sign_up?ref=automate-hero

RUNNING WEB DESKTOP TESTS:
-----------------------------------
Once the requirements are done, follow these steps:

- Open the project downloaded with the IntelliJ IDE.
- Open the Gradle properties file e.g. gradle.properties file

Set the required parameters for Desktop web tests:

    browser=chrome
    
Note: It's not required to update the other properties, leave it by default.
Then, to execute the tests by command line you can use the following:


        gradle test
   
RUNNING MOBILE TESTS:
-----------------------------------
Mobile tests are running on BrowserStack,once the requirements are done, follow these steps:

- Open the project downloaded with the IntelliJ IDE.
- Open the Gradle properties file e.g. gradle.properties file

Set the access parameters:

    browser=browserstack
    #Remote Browserstack properties
    remoteUserName=     //Is the Browserstack username.
    remoteAccessKey=    //Is the Browserstack access key.
    
Set the mobile device settings, you can get the specifications from https://www.browserstack.com/automate/capabilities

    remoteBrowserName=  
    remoteBrowserVersion=
    remoteRealMobile= 
    remoteOsVersion=    

To execute the tests by command line you can use the following command:


        gradle test

To see the test execution, navigate to the Dashboard in BrowserStack and see the execution in the selected device.


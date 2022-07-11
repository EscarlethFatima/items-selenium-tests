
ITEMS-TESTS
-----------
items-tests is a framework to automate test cases of Stranger Things items web page.

REQUIREMENTS
-----------------------------------

The required configuration for this framework is the following:

    -IntelliJ idea IDE.
    -Download Gradle 4.5 or superior: https://gradle.org/gradle-download/
    -Clone/download the project from GitHub repository: https://github.com/EscarlethFatima/items-selenium-tests.git

CONFIGURATIONS
-----------------------------------
Once those requirements are done, follow these steps:

- Open the project downloaded with the IntelliJ IDE.
- Open the Gradle properties file e.g. gradle.properties file

Set the required parameters:

    urlLogin=   //Sales force login URL (e.g. https://login.salesforce.com/) 
    user=       //Sales force user.
    password=   //Sales force Login.
    APIToken=   //Is the token of your pivotal account.
    
    dockerURL=  //Put docker url (e.g. http://url:4444/wb/hub)
    browser=    //Choose only one option.
    
    #Remote Browser SauceLabs/Browserstack properties
    remoteUserName=     //Is the username of Saucelabs or Browserstack.
    remoteAccessKey=    //Is the key provided.
    remoteBrowserName=  //Is The browser that you want to execute your test
    remoteBrowserVersion=
    remoteResolution=   //Screen resolution.
    remotePlatform=     //sauce labs plataform to be remote test.
    remoteOS=        //Is the remote OS name (e.g. Windows)
    #EXPLICIT WAIT 
    explicitWait= //time for wait elements (e.g. 1920x1080).
    

After executing those steps the frame should be executed.

To execute by command line you can use the following:


        gradle clean executeFeatures 
        -PurlLogin="https://www.pivotaltracker.com/signin" -PUser="aaggon411@gmail.com" -PPassw
        ord="P@ssw0rd" -PAPIToken="9ad9814db950835a045d84d5ca9b9f78" -Pbrowser="DOCKER_FIREFOX"
        -PdockerUrl="http://10.28.109.106:4444/wd/hub" -PexplicitWait="30"
   

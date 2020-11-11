# Description  
This repo contains 1 Web and 2 API automated tests of TradeMe sandbox env.  
The tests are written in Java using BDD format(serenity-BDD) and RestAssured for API.  
Feature files @ *src/resources/features*  
StepDefinitions+IndividualSteps+TestRunner @ src/test/java/com/trademe/automation/  
Webdriver @ src/resources/webdriver/windows  
  
## Pre-Requisites:  
1)Java 1.8 or higher  
2)Maven 3.6.3 or higher  
*Note*: Please add <Install_Dir>/bin of above installations in PATH variable  
3)ChromeDriver @ <Project_Root>/src/test/resources/webdriver/windows/  
*Note*: Please add chrome driver compatable to the browser version installed on you system.You can download relevant drivers at [https://chromedriver.chromium.org/downloads](https://chromedriver.chromium.org/downloads)
  
### Basic Use:  
1)Clone this project  
2)Run below command in command prompt from the root directory(i.e textExercise)    
mvn verify  
  
*Note*: 1)If the maven is pointing to any local organisation repo,please change the to point to maven repo.You can check that in <users>/<User>/.m2 folder.  
        2) After starting give it a minute to download the dependencies from maven which you can see from the command line window.  

### IDE:  
1)Load the cloned project into any IDE(IntelliJ)  
2)Edit run configurations.Select maven and add clean install.  
3)Run 
  
### Reports:
Serenity Reports are quite powerul and useful which gives all details from Features to screenshots and time taken.  
The Reports are generated at <root>/**target**/site/serenity/index.html  
  ![Serenity Reports](https://github.com/raghu19991/textExercise/blob/main/target/site/serenity/example.JPG?raw=true)   

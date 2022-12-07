# DiplomTMS 

#### UI и API tests for **_[vsemayki.ru](https://www.vsemayki.ru/)_**

### **STARTING ALL TESTS**

#### Build:

mvn clean install -DskipTests

#### Run:

mvn clean test -Dconfig=vsemayki -DsuiteXml=DiplomTMS


#### Allure report:

allure generate target/allure-results

___________________________________________________________________
**xml files for run tests** [DiplomTMS.xml](src/test/resources/DiplomTMS.xml)   :  src/test/resources/

**Property file** [vsemayki.properties](src/main/resources/vsemayki.properties)   :  src/main/resources/

**'[Jenkinsfile](Jenkinsfile)'** is located in the root folder of the project


**[Driver factory](src/main/java/driver)**  :  src/main/java/driver/

**[Page objects](src/main/java/pageObjects)**  :  src/main/java/pageObjects/

**[Tests](src/test/java/vseMaykiTests)**   : src/test/java/
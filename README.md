# DiplomTMS
UI и API тесты для сайта vsemayki.ru

### **Запуск тестов**

#### Build:

mvn clean install -DskipTests

#### Run:

mvn clean test -Dconfig=vsemayki -DsuiteXml=DiplomTMS


#### Allure report:

allure generate target/allure-results
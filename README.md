# CucumberJava
A Maven Cucumber Selenium Java project that demos Page Object Model, Page Factory, tags, Hooks, Reporting

# Pre-conditions
User knows how to create a Maven Project and Java

# Requirements
JRE, JDK, Eclipse IDE installed. 
jre version has to be greater than 1.5.
Create a Maven Project, add Maven dependencies for Cucumber, Selenium, JUnit, Json, maven-surefire-plugin
# Usability
Run the following from cmd
```python
$mvn test
or
$mvn test -Dcucumber.options=”-p html:target/HtmlReports”
or
$mvn verify -DskipTests
```

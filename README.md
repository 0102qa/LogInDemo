# LogInDemo
 The goal is to create a selenium UI test with the credentials provided, there's 4 test cases you'll want to verify:

 

1.  Verify valid login

2.  Verify invalid username

3.  Verify invalid password

4.  Verify logout

 ## Overview
GEMS UI tests are written in Java and used such extensions:
 - [Test NG](http://testng.org/doc/index.html) - is a testing framework;
 - [Maven](https://maven.apache.org/index.html) - is a software project management and comprehension tool;
 - [Selenium WebDriver](https://www.seleniumhq.org/) - is a collection of open source APIs which are used to automate the testing of a web application.
 
 ## Run tests
To run test features, go to the project dir in console and perform:

```
mvn test
```
### Configuration
The project related configuration is stored in [data.properties](https://github.com/0102qa/LogInDemo/blob/master/src/main/java/resources/data.properties).

#### Browsers
Two browsers are allowed to be used for web interactions in the framework: _chrome_ and _firefox_. To specify browser that would be used in tests, set `chrome` or `firefox` as a value for `browser` key in [data.properties](https://github.com/0102qa/LogInDemo/blob/master/src/main/java/resources/data.properties).

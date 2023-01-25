# Tri-layer Automation Test Demo

## Introduction
In short: This is a tri-layer automation test demo for saucedemo.com done with Selenium for Java, using TestNG tool and Maven for dependencies.

The tri-layer design in context of automation testing means the following:
- First layer represents classic Page Object Model where one class/object represents one page of the app under test. In it are stored all locators and individual
methods for the given page with the idea that one method can only perform one action or interact with only one element. By doing this, the tester can group together all
the individual methods in the next layer as he sees fit. You can see all Page classes in src/main/java/pages.
- Second layer represents all complex actions/methods to be executed in tests. All these methods are made of simple one-action methods from Page classes.
For example, LoginMethod class has a method called performLogin which consist of writing username, writing password and clicking on login button. 
In these classes, there are also all relevant assertion methods that are used to check if the tests are run properly. You can see all Method classes in src/main/java/methods.
- Third layer represents the test executions. It consists of classes that use TestNG for performing individual tests. All tests call the complex action methods from the 
second layer, Methods, and also check if the tests are run properly with relevant assertion methods. You can find all Tests in src/test/java.

By layering, the tester can achieve very high reusability and maintainability level of his tests and be ready for new challenges of the project.

## Test execution
There are currently 9 complete test cases in the demo. Two of them - FailedLoginTest and FailedCheckoutTest are data driven with all the wrong combination of
credentials, so in total there are 17 tests to be executed.

There are two ways one can execute the tests.

The first one is directly from individual test classes:
- src/test/java/loginTests for LoginTest and FailedLoginTest.
- src/test/java/testsWithLoggedInUser for LogoutTest, AddToCartTest, RemoveFromCartTest, AddRandomItemToCart and AddMinMaxCostToCart.
- src/test/java/checkoutTests for SuccessfulCheckoutTest and FailedCheckoutTest.

The second way is to use test suites in src/test/java/suites. There you can find xml files with various combinations of tests:
- src/test/java/suites/loginTestsSuite.xml
- src/test/java/suites/variousToCartTestsSuite.xml
- src/test/java/suites/checkoutTests.xml
- src/test/java/suites/allTestsSuite.xml
- src/test/java/suites/allTestsAllBrowserSuite.xml


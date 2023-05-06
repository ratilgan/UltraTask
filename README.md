# Ultra_QA Automation UI Task

This test automation framework is created as a solution for the `QA Automation UI task` of `Ultra`. Test scenarios are written in `Gherkin language` according to the task. The codes are written in `Java` programming language with the implementations of `object-oriented-programming (OOP)` concepts. `Page object model (POM)` and `Singleton design pattern` are also implemented in the framework.

## Application under test
https://www.saucedemo.com/

## Info about the framework

Codes are written as dynamic as possible to increase the `readability`, `re-usability` and `maintainability` of the framework. For example;

* `Google Chrome` is default browser for now but it can be easily changed by updating `configuration.properties` file,
* The website to navigate and `window size` can be updated through `configuration.properties` file as well,
* `Random` class from `Java` is used for adding a random item each time,
* The number of the items to added to cart can be decided only by providing an `int` value to correspending lines of `Purchase.feature` file,
* User details are generated by `Java Faker` library to avoid hard-coding, and it also can be retrieved from `configuration.properties` file,
* The prices are retrieved from the webpage and converted to `double` values, then validated by comparing the total listed value,
* Login step is defined as `Background`, implemented once and doesn't being repeated for each scenario,
* If the tests fail, the failed one/s will be executed once again to able `to minimize synchronization problems`,
* `Screenshot` will be taken and stored under the `\target\` folder for the failed scenarios,
* `GitHub Actions` integration is done for `CI purposes`,
* The project can be triggered for each `push`, `pull request` etc for specific branch,
* Remote execution is scheduled as well (it is set as `8.00 am` and `5.00 pm` `everyday` with a proper `cron` expression,
* `GitHub Actions workflow runs` can be reached from https://github.com/ratilgan/UltraTask/actions/workflows/maven.yml


## What can be done as the next step?

* More scenarios can be added.

## Reporting

Reports are generated by `Cucumber` automatically under `/target/default-html-reports` package. Beside that simple reporting, more detailed and fancy reporting is also used in the framework by adding `maven-cucumber-reporting` plug-in inside the `pom.xml` file. Those reports can be reached under `/target/cucumber-html-reports`. To able to get those fancy reports, the code should be executed through maven lifecyle or from the terminal with the command of `mvn verify`. In the case of test failures, a screen-shot of the related page is embedded into the report.

## Prequisites

* `Java 11 SDK` should be installed
* `IntelliJ IDE` (any IDE is fine) 
* `Maven` as buid management tool
* Browser drivers are fetching automatically from `bonigarcia` dependency, so no need to identify the browser version



## How to execute

* https://github.com/ratilgan/UltraTask/
* Use the following command to clone the project `git clone https://github.com/ratilgan/UltraTask/`
* Use the following command to run the project `mvn verify -D"cucumber.filter.tags"="@wip"`

## Tech stack

* Java 11
* Maven
* Cucumber 7.1.0
* JUnit 7.1.0
* Selenium Webdriver 4.1.3
* IntelliJ
* GitHub
* GitHub Actions for CI implementation
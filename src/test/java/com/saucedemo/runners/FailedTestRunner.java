package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/failedTests.json",
                "html:target/failed-html-reports"},
        features = "@target/rerun.txt",
        glue = "com/ToDoMVC/stepDefinitions"
)
public class FailedTestRunner {
}

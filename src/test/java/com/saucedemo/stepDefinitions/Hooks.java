package com.saucedemo.stepDefinitions;

import com.saucedemo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.time.Duration;

public class Hooks {

  private static final Logger LOGGER = LogManager.getLogger(Hooks.class);

  @Before
  public void setUp(){
    Driver.get().manage().window().maximize();
    LOGGER.info("Window size: " + Driver.get().manage().window().getSize());
    Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  }

  @After
  public static void tearDown(Scenario scenario){
    if(scenario.isFailed ()){
      final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenshot,"image/png","screenshot");
    }
    Driver.closeDriver();
  }
}

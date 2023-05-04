package com.saucedemo.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private static final Logger LOGGER = LogManager.getLogger(Driver.class);

    private Driver() {
    }

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static synchronized WebDriver get() {
        if (driverPool.get() == null) {
            String browser =
                    System.getProperty("browser") != null ? browser = System.getProperty("browser")
                            : ConfigurationReader.get("browser");

      switch (browser) {
        case "chrome":
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments(
              "--incognito",
              "--ignore-certificate-errors",
              "--allow-insecure-localhost",
              "--acceptInsecureCerts",
              "disable-infobars",
              "--disable-dev-shm-usage",
              "--ignore-ssl-errors=yes",
              "--ignore-certificate-errors",
              "--remote-allow-origins=*",
              "--window-size=" + ConfigurationReader.get("windowSize"));
          driverPool.set(new ChromeDriver(chromeOptions));
          LOGGER.info("***** The Browser is Chrome *****");
          break;
        case "chrome-headless":
          ChromeOptions chromeHeadlessOptions = new ChromeOptions();
          chromeHeadlessOptions.addArguments(
              "--incognito",
              "--ignore-certificate-errors",
              "--allow-insecure-localhost",
              "--acceptInsecureCerts",
              "disable-infobars",
              "--disable-dev-shm-usage",
              "--ignore-ssl-errors=yes",
              "--ignore-certificate-errors",
              "--remote-allow-origins=*",
              "--window-size=" + ConfigurationReader.get("windowSize"),
              "--headless");
          driverPool.set(new ChromeDriver(chromeHeadlessOptions));
          LOGGER.info("***** The Browser is Chrome-Headless *****");
          break;
        case "firefox":
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          firefoxOptions.addArguments(
              "--headless",
              "--window-size=" + ConfigurationReader.get("windowSize"));
          driverPool.set(new FirefoxDriver());
          LOGGER.info("***** The Browser is Firefox *****");
          break;
        case "firefox-headless":
          FirefoxOptions firefoxHeadlessOptions = new FirefoxOptions();
          firefoxHeadlessOptions.addArguments(
              "--headless",
              "--window-size=" + ConfigurationReader.get("windowSize"));
          driverPool.set(new FirefoxDriver(firefoxHeadlessOptions));
          LOGGER.info("***** The Browser is Firefox-Headless *****");
          break;
        case "edge":
          driverPool.set(new EdgeDriver());
          LOGGER.info("***** The Browser is Edge *****");
          break;
        case "safari":
          driverPool.set(new SafariDriver());
          LOGGER.info("***** The Browser is Safari *****");
          break;
        case "remote_chrome":
          ChromeOptions chromeRemoteOptions = new ChromeOptions();
          try {
            driverPool.set(new RemoteWebDriver(new URL("http://xxx.xxx.x.xx:5555/wd/hub"),
                chromeRemoteOptions));
          } catch (MalformedURLException e) {
            e.printStackTrace();
          }
          LOGGER.info("***** The Browser is Remote-Chrome *****");
      }
    }
    return driverPool.get();
  }

    public static void closeDriver() {
        driverPool.get().quit();
        driverPool.remove();
    }

}

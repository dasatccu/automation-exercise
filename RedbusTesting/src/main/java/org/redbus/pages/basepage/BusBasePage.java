package org.redbus.pages.basepage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.redbus.baseElements.DriverFactory;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BusBasePage {
    private static Logger LOGGER = LogManager.getLogger(BusBasePage.class.getCanonicalName());
    private static URL GRID_URL;
    private static final String HOME_PAGE = "https://www.redbus.in/";

    static {
        try {
            GRID_URL = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @BeforeMethod
    public void openMainPage() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        LOGGER.info("Chrome Options added :: {},{},{}",chromeOptions.getBrowserName(),chromeOptions.getBrowserVersion(),chromeOptions.getCapabilityNames());
        WebDriver driver = new RemoteWebDriver(GRID_URL,chromeOptions);
        LOGGER.info("Web Driver :: {}",driver);
        DriverFactory.setDriver(driver);
        DriverFactory.openPage(HOME_PAGE);
    }

}

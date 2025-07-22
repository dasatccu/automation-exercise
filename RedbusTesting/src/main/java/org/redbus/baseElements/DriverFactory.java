package org.redbus.baseElements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);

    public static WebDriver getDriver(){
        LOGGER.info("Driver instance :: {}",driver.get());
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance){
        LOGGER.info("Driver instance set to :: {}",driverInstance);
        driver.set(driverInstance);
    }

    public static void unload(){
        LOGGER.info("Driver instance unloaded");
        driver.remove();
    }

    public static void openPage(String url){
        try{
            LOGGER.info("Opening URL :: {}",url);
            driver.get().get(url);
            LOGGER.info("{} page opened",url);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
    }
}

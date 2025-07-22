package org.redbus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.redbus.baseElements.DriverFactory;
import org.redbus.pages.basepage.BusBasePage;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {
        BusBasePage busBasePage = new BusBasePage();
        busBasePage.openMainPage();
    }
}

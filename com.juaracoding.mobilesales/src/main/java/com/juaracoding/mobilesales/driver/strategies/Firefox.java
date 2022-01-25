package com.juaracoding.mobilesales.driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

	public WebDriver setStrategy() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:/DriverFirefox/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
}

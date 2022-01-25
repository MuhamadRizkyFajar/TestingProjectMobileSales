package com.juaracoding.mobilesales.driver.strategies;

import com.juaracoding.mobilesales.utils.Constants;

public class DriverStrategyImplemantor {
	
	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case Constants.CHROME:
			
			return new Chrome();
			
		case Constants.FIREFOX:
			
			return new Firefox();

		default:
			return null;
		}
	}
	
}

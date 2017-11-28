package com.srg.finance.portfolio;

import java.util.Random;

/**
 * This class contains utility methods for monte carlo simuation
 * @author sgayakwad
 *
 */
public class AppUtilities {

	private static Random randomGenerator = new Random();	
	
	/**
	 * Suppress default consructor for non instantiablity
	 */
	private AppUtilities() {
		throw new AssertionError();	
	}
	
	public static double getRandomNumber(double mean, double stdDeviation) {
		double nextGauss = randomGenerator.nextGaussian();
		double randomNumber = nextGauss * stdDeviation + mean;
		return randomNumber;
	}
}

package com.srg.finance.portfolio.statistics;

/**
 * This class is used to represent the statistics of a portfolio.
 * @author sgayakwad
 *
 */
public class PortfolioStatistics {

	private double bestCase;	
	private double medianCase;
	private double worstCase;
	
	public PortfolioStatistics(double bestCase, double medianCase, double worstCase) {
		this.bestCase = bestCase;
		this.medianCase = medianCase;
		this.worstCase = worstCase;
	}
	
	
	public double getBestCase() {
		return bestCase;
	}

	public double getMedianCase() {
		return medianCase;
	}

	public double getWorstCase() {
		return worstCase;
	}
}

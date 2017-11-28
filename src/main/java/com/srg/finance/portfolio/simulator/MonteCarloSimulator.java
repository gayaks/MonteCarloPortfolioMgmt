package com.srg.finance.portfolio.simulator;


import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.srg.finance.portfolio.AppUtilities;
import com.srg.finance.portfolio.Percentile;
import com.srg.finance.portfolio.statistics.PortfolioStatistics;

/**
 * This is a implementation class for monte carlo simulation
 * @author sgayakwad
 *
 */
public class MonteCarloSimulator implements PortfolioSimulator {

	private static final Logger logger = LoggerFactory.getLogger(MonteCarloSimulator.class);
	
	@Override
	public PortfolioStatistics runSimulation(int numOfSimulation, int numOfYears,
											 double mean, double stdDeviation,
											 double initialInvestment, double inflation) {
				
		logger.info("=============Monte Carlo Simulation begin=================");
		
		double[] investmentPerSimulationArray = new double[numOfSimulation];
		
		for (int i = 0; i < numOfSimulation; i++) {
			
			double totalInvestment = initialInvestment;			
			
			for (int j = 0; j < numOfYears; j++) {
				double randomNumber = AppUtilities.getRandomNumber(mean, stdDeviation);
				totalInvestment = totalInvestment * (1 + randomNumber) * (1 - inflation);
			}
			
			investmentPerSimulationArray[i] = totalInvestment;
		}
		
		logger.info("=============Monte Carlo Simulation completed=================");
		
		DescriptiveStatistics descStatistics = new DescriptiveStatistics(investmentPerSimulationArray);
		PortfolioStatistics portfolioStatistics = createPortfolioStatistics(descStatistics);
		
		return portfolioStatistics;
					
	}
	
	private PortfolioStatistics createPortfolioStatistics(DescriptiveStatistics descStatistics) {
		
		double bestCase = descStatistics.getPercentile(Percentile.BEST_CASE);
		double medianCase = descStatistics.getPercentile(Percentile.MEDIAN_CASE);
		double worstCase = descStatistics.getPercentile(Percentile.WORST_CASE);
		
		return new PortfolioStatistics(bestCase, medianCase, worstCase);
	}
	
	
	
	

}













package com.srg.finance.portfolio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.srg.finance.portfolio.simulator.MonteCarloSimulator;
import com.srg.finance.portfolio.simulator.PortfolioSimulator;
import com.srg.finance.portfolio.statistics.PortfolioStatistics;

/**
 * This class covers the unit test cases for monte carlo portfolio simulation
 * @author sgayakwad
 *
 */

public class PortfolioSimulatorTest {
	@Test
	public void testRandomNumber() {
		
		assertTrue(AppUtilities.getRandomNumber(0.094321, 0.015675) >= -1);
		assertTrue(AppUtilities.getRandomNumber(0.094321, 0.015675) <= 1);
				
		assertTrue(AppUtilities.getRandomNumber(0.06189, 0.063438) >= -1);
		assertTrue(AppUtilities.getRandomNumber(0.06189, 0.063438) <= 1);
	}
	
	
	@Test 
	public void testConservativePortfolioNotNull() {
		PortfolioSimulator monteCarloSimulator = new MonteCarloSimulator();
		
		PortfolioStatistics portfolioStatistics = 
				monteCarloSimulator.runSimulation(10000, 20,  0.06189, 0.063438, 100000, 0.035);
		
		assertNotNull(portfolioStatistics);		
	}
	
	
	@Test 
	public void testAggessivePortfolioNotNull() {
		PortfolioSimulator monteCarloSimulator = new MonteCarloSimulator();
		
		PortfolioStatistics portfolioStatistics = 
				monteCarloSimulator.runSimulation(10000, 20,  0.094324, 0.15675, 100000, 0.035);
		
		assertNotNull(portfolioStatistics);		
	}
	
	@Test
	public void testBestCaseGreaterthanMedian() {
		PortfolioSimulator monteCarloSimulator = new MonteCarloSimulator();
		
		PortfolioStatistics portfolioStatistics = 
				monteCarloSimulator.runSimulation(10000, 20,  0.094324, 0.15675, 100000, 0.035);
		
		assertTrue(portfolioStatistics.getBestCase() > portfolioStatistics.getMedianCase());
	}
	
	@Test
	public void testMedianCaseGreaterthanWorst() {
		PortfolioSimulator monteCarloSimulator = new MonteCarloSimulator();
		
		PortfolioStatistics portfolioStatistics = 
				monteCarloSimulator.runSimulation(10000, 20,  0.094324, 0.15675, 100000, 0.035);
		
		assertTrue(portfolioStatistics.getMedianCase() > portfolioStatistics.getWorstCase());
	}
	
	@Test
	public void testBestCaseGreaterthanWorst() {
		PortfolioSimulator monteCarloSimulator = new MonteCarloSimulator();
		
		PortfolioStatistics portfolioStatistics = 
				monteCarloSimulator.runSimulation(10000, 20,  0.094324, 0.15675, 100000, 0.035);
		
		assertTrue(portfolioStatistics.getBestCase() > portfolioStatistics.getWorstCase());
	}
	

}

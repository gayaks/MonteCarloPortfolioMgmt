package com.srg.finance.portfolio.simulator;

import com.srg.finance.portfolio.statistics.PortfolioStatistics;

public interface PortfolioSimulator {
 public PortfolioStatistics runSimulation(int numOfSimulation, int numOfYears,
		 double mean, double stdDeviation,
		 double initialInvestment, double inflation);
}

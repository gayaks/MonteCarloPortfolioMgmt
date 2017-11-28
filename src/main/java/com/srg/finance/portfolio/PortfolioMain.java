package com.srg.finance.portfolio;

import java.text.NumberFormat;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.srg.finance.portfolio.simulator.MonteCarloSimulator;
import com.srg.finance.portfolio.simulator.PortfolioSimulator;
import com.srg.finance.portfolio.statistics.PortfolioStatistics;
import com.srg.finance.portfolio.validator.DoubleValidator;
import com.srg.finance.portfolio.validator.IntegerValidator;
import com.srg.finance.portfolio.validator.InvestmentValidator;
import com.srg.finance.portfolio.validator.VALIDATOR_TYPE;
import com.srg.finance.portfolio.validator.Validator;

/**
 * This is the entry point for monte carlo simulation. 
 * The imlementation class of portfolioSimulator can be changed depending on the business needs.
 * @author sgayakwad
 *
 */
public class PortfolioMain {

	private static final Logger logger = LoggerFactory.getLogger(PortfolioMain.class);
	
	public static void main(String[] args) {
		
		if (args.length == 6) {
			
			int numOfSimulation = Integer.valueOf(args[0]);
			int numOfYears = Integer.valueOf(args[1]);
			double mean = Double.valueOf(args[2]);
			double stdDeviation = Double.valueOf(args[3]);
			double initialInvestment = Double.valueOf(args[4]);
			double inflation = Double.valueOf(args[5]);
			
			validate(numOfSimulation, numOfYears, mean, stdDeviation, initialInvestment, inflation);
			
			logger.info("=============Portfolio simulation begin=================");
			
			PortfolioSimulator monteCarloSimulator = new MonteCarloSimulator();
				
			PortfolioStatistics portfolioStatistics = monteCarloSimulator.runSimulation(numOfSimulation, numOfYears, mean, stdDeviation, initialInvestment, inflation);
			logger.info("=============Portfolio simulation completed=================");		
	
		    Locale locale = new Locale("en", "US");
		    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	
		    System.out.println("Best Case = " + currencyFormatter.format(portfolioStatistics.getBestCase()));
		    System.out.println("Worst Case = " + currencyFormatter.format(portfolioStatistics.getWorstCase()));
		    System.out.println("Median = " + currencyFormatter.format(portfolioStatistics.getMedianCase()));
		} else {
			System.out.println("Please enter valid input in the format : <NumOfSimulation> <NumOfYears> <Mean> <StdDeviation> <initialInvestment> <Inflation>");
		}
	}
	
	private static void validate(int numOfSimulation, int numOfYears,
			 double mean, double stdDeviation,
			 double initialInvestment, double inflation){

		logger.info("=============Portfolio Input validation begin=================");
		
		Validator integerValidator = null;
		Validator doubleValidator = null;
		
		
		integerValidator = new IntegerValidator(VALIDATOR_TYPE.INTEGER, numOfSimulation);
		integerValidator.validate();
		
		integerValidator = new IntegerValidator(VALIDATOR_TYPE.INTEGER, numOfYears);
		integerValidator.validate();
		
		doubleValidator = new DoubleValidator(VALIDATOR_TYPE.DOUBLE, stdDeviation);
		doubleValidator.validate();
		
		doubleValidator = new DoubleValidator(VALIDATOR_TYPE.DOUBLE, mean);
		doubleValidator.validate();
		
		doubleValidator = new DoubleValidator(VALIDATOR_TYPE.DOUBLE, inflation);
		doubleValidator.validate();
		
		doubleValidator = new InvestmentValidator(VALIDATOR_TYPE.DOUBLE, initialInvestment);
		doubleValidator.validate();
		
		logger.info("=============Portfolio Input validation completed=================");
	}
	
}

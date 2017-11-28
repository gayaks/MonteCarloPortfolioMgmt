# MonteCarloPortfolioMgmt

Problem Statement

 Given two portfolio of varying riks along with mean, standard Deviation and inflation. Compute the portfolio after 20 years using Monte Carlo Simulation
 
 The Portfolio as follows: 
 
 Portfolio Type    | Mean      | Standard Deviation 
------------------|------------|---------------------
|Aggressive        | 9.4324%   |   15.675           |   
|Very Conservative | 6.189%    |   6.3438           |  


* Inflation : 3.5%
* Number of Simulation : 10000
* Initial Investment : $100000


Solution : Portfolio after 20 years

Portfolio Type    | Median 20th year      | 10% Best Case | 10% Worst Case 
------------------|-----------------------|---------------|-----------------|
|Aggressive        | $242,709.20           |  $548,163.45  |  $104,126.77   |
|Very Conservative | $157,297.56           |  $222,058.74  |  $111,597.90   |


How to Run : 

java -jar monte-carlo-portfolio-0.0.1-SNAPSHOT.jar  NumOfSimulation NumOfYears Mean StdDeviation initialInvestment Inflation





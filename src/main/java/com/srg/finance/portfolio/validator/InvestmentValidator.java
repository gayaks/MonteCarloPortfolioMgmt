package com.srg.finance.portfolio.validator;

/**
 * This class validates the investment value.
 * @author sgayakwad
 *
 */
public class InvestmentValidator extends DoubleValidator {
	
	public InvestmentValidator(VALIDATOR_TYPE TYPE, Double value) {
		super(TYPE, value);
	}
	
	@Override
	public boolean validate() {
		if (type == VALIDATOR_TYPE.DOUBLE) {
			Double value = (Double)this.value;
			if (value <= 0)
				throw new RuntimeException("Enter a valid non-zero double number");
			return true;
		}
		return false;
	}
	
	
}

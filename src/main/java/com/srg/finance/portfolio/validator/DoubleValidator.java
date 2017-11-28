package com.srg.finance.portfolio.validator;

/**
 * This class validates the double value.
 * @author sgayakwad
 *
 */
public class DoubleValidator extends Validator {

	public DoubleValidator(VALIDATOR_TYPE TYPE, Double value) {
		this.type = TYPE;
		this.value = value;
	}
	
	@Override
	public boolean validate() {
		if (type == VALIDATOR_TYPE.DOUBLE) {
			Double value = (Double)this.value;
			if (value <= 0 && value >= 1)
				throw new RuntimeException("Enter a valid number between 0 and 1");
			return true;
		}
		return false;
	}	
}

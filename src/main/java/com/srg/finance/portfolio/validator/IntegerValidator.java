package com.srg.finance.portfolio.validator;


/**
 * This class validates the integer value.
 * @author sgayakwad
 *
 */
public class IntegerValidator extends Validator {

	public IntegerValidator(VALIDATOR_TYPE integer, Integer value) {
		this.type = integer;
		this.value = value;
	}
	
	@Override
	public boolean validate() {
		if (type == VALIDATOR_TYPE.INTEGER) {
			Integer value = (Integer)this.value;
			if (value <= 0)
				throw new RuntimeException("Enter a valid non-zero number");
			return true;
		}
		return false;
	}	
}


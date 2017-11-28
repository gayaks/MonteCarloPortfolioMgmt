package com.srg.finance.portfolio.validator;

/**
 * Base class for the input validation.
 * @author sgayakwad
 *
 */
public abstract class  Validator {
	protected VALIDATOR_TYPE type;
	protected Object value;
	
	public abstract boolean validate();
}

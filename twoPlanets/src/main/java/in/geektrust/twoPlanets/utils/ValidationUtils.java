package in.geektrust.twoPlanets.utils;

import java.util.List;

public final class ValidationUtils {
	
	private static ValidationUtils validationUtils;
	
	private ValidationUtils(){
		
	}
	
	/**
	 * 
	 * @return singelton instance of this class
	 */
	public static ValidationUtils getValidator(){
		if(validationUtils == null){
			validationUtils = new ValidationUtils();
		}
		return validationUtils;
	}
	
	/**
	 * Generic validator for any object
	 * @param argument
	 * @param message
	 */
	public void validateArgument(Object argument,String message){
		
		if(argument == null){
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * Generic validator for any object with a given condition
	 * @param argument
	 * @param message
	 */
	public void validateArgumentByCondition(Object argument, boolean condition, String message){
		
		if(condition){
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * Throws exception in case of invalid String argument and throws exception with given message
	 * @param argument
	 * @param message
	 */
	public void validateArgument(String argument,String message){
		
		if(argument == null || argument.isEmpty()){
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * Throws exception in case of invalid List argument and throws exception with given message
	 * @param argument
	 * @param message
	 */
	public void validateArgument(List argument,String message){
		
		if(argument == null || argument.size() == 0){
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * Throws exception in case of invalid Int argument and throws exception with given message
	 * @param argument
	 * @param message
	 */
	public void validateArgument(int argument,String message){
		
		if(argument < 0){
			throw new IllegalArgumentException(message);
		}
	}
}

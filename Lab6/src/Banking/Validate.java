// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 6
// Description: Class for validating input or other variables, 
// reduce clutter in the rest of the code and provides ease in expansion of our services.

package Banking;

import java.util.Scanner;

/**
 * A class for validating any variables, or input.
 * @author Mostapha A
 * @version 1.0
 * @since 1.8
 */
public class Validate {
	private static Scanner input = new Scanner(System.in);

	// validate double values
	/**
	 * Validate a input of a double value. Display a provided 
	 * error message if it is not in the provided range.
	 * @param errorMessage The message to be displayed if the input is incorrect.
	 * @param minValue The minimum value needed for the double.
	 * @param maxValue The maximum value allowed for the double.
	 * @return The validated input double value.
	 */
	public static double iDouble(String errorMessage, double minValue, double maxValue) {
		double doubleValue;

		// loop to continue asking for input
		do {
			// validate it is a double
			while (!input.hasNextDouble()) {
				System.out.print(errorMessage);
				input.next();
			}
			// store the double
			doubleValue = input.nextDouble();

			// validate it is within range if not print message
			if (doubleValue < minValue || doubleValue > maxValue) {
				System.out.print(errorMessage);
			}

		} while (doubleValue < minValue || doubleValue > maxValue);

		// return validated input
		return doubleValue;
	}

	// validate double values
	/**
	 * Validate a input of a double value. Display a provided 
	 * error message if it is not larger than the provided minimum.
	 * @param errorMessage The message to be displayed if the input is incorrect.
	 * @param minValue The minimum value allowed for the double.
	 * @return The validated input double value.
	 */
	public static double iDouble(String errorMessage, double minValue) {
		double doubleValue;

		// loop to continue asking for input
		do {
			// validate it is a double
			while (!input.hasNextDouble()) {
				System.out.print(errorMessage);
				input.next();
			}
			// store the double
			doubleValue = input.nextDouble();

			// validate it is within range if not print message
			if (doubleValue < minValue) {
				System.out.print(errorMessage);
			}

		} while (doubleValue < minValue);

		// return validated input
		return doubleValue;
	}

	// validate long values
	/**
	 * Validate a input of a long value. Display a provided 
	 * error message if it is not larger than the provided minimum.
	 * @param errorMessage The message to be displayed if the input is incorrect.
	 * @param minValue The minimum value needed for the long.
	 * @param maxValue The maximum value allowed for the long.
	 * @return The validated input double value.
	 */
	public static long iLong(String errorMessage, long minValue, long maxValue) {
		long longValue;

		// loop to continue asking for input
		do {
			// validate it is a long
			while (!input.hasNextLong()) {
				System.out.print(errorMessage);
				input.next();
			}

			// store the long
			longValue = input.nextLong();

			// validate it is within range if not print message
			if (longValue < minValue || longValue > maxValue) {
				System.out.print(errorMessage);
			}

		} while (longValue < minValue || longValue > maxValue);

		// return validated input
		return longValue;
	}

	// validate a menu choice
	/**
	 * Validate menu options. Ensure they are one of the provided values.
	 * @param errorMessage The message to be displayed if the input is invalid.
	 * @param choices The acceptable menu options
	 * @return The validated input long.
	 */
	public static String iMenu(String errorMessage, String... choices) {
		// variable for input and loop
		String menuChoice;
		boolean loop = true;

		// loop to continue asking for input
		do {
			// store input
			menuChoice = input.next();
			// loop to check input
			for (int i = 0; i < choices.length; i++) {
				if (menuChoice.equalsIgnoreCase(choices[i])) {
					i = choices.length;
					loop = false;
				}
			}

			// if the input wasn't one of the valid choices
			if (loop == true) {
				System.out.print(errorMessage);
			}

		} while (loop == true);
		return menuChoice;
	}

	//validate string
	/**
	 * Take a string input.
	 * @return The string.
	 */
	public static String iString() {
		//take input
		String string;
		string = input.next();
		
		return string;
	}
	
	// validate strings with characters not allowed
	/**
	 * Validate that a input string does not have any provided illegal characters.
	 * @param errorMessage The message to be provided if the input is incorrect.
	 * @param illegalCharacters The characters that are not allowed in the input.
	 * @return The validated input string
	 */
	public static String iString(String errorMessage, CharSequence ...illegalCharacters) {
		String name;
		boolean loop = true;
		
		//loop to continue asking
		do {
			//store input
			name = input.next();
			
			//loop to check for illegal characters
			for(int i = 0; i < illegalCharacters.length ; i++) {
				if(name.contains(illegalCharacters[i])) {
					System.out.print(errorMessage);
					loop = true;
					i = illegalCharacters.length;
				} else {
					loop = false;
				}
			}
		}while(loop == true);
		
		return name;
	}
	
}

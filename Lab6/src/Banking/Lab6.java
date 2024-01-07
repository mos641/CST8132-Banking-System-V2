// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 6
// Description: Class for the main method

package Banking;

/**
 * This class is for the main method.
 * @author Mostapha A
 * @version 1.0
 * @since 1.8
 */
public class Lab6 {
	/**
	 * Main method to call and run the code.
	 * @param String[]
	 */
	//main method
	public static void main(String[] args) {
		String menu = "q";
		Bank bank = new Bank();
		// welcome message
		System.out.println("======= Welcome to the Banking Simulation Program =======\n");
		
		// loop to loop through program until quitting
		do {
			// menu and case structure to implement choice
			System.out.print("a: Add new account \n" + "u: Update an account\n" + "d: Display an account\n"
					+ "p: Print all accounts\n" + "m: Run monthly update\n" + "q: Quit\n" + "\n"
					+ "Enter your option: ");
			menu = Validate.iMenu("Invalid menu choice, try again : ", "a", "u", "d", "p", "m", "q");

			// switch for each option
			switch (menu.toLowerCase()) {
			case "a":
				System.out.println();
				bank.addAccount();
				System.out.println();
				break;
			case "u":
				System.out.println();
				bank.updateAccount();
				System.out.println();
				break;
			case "d":
				System.out.println("\n"+bank.displayAccount());
				break;
			case "p":
				System.out.println();
				bank.printAccountDetails();
				System.out.println();
				break;
			case "m":
				System.out.println();
				bank.monthlyUpdate();
				System.out.println("\n");
				break;
			}

		} while (!menu.equalsIgnoreCase("q"));

		// quit message
		System.out.println("\nQuit: Successfully exited the program");
	}

}

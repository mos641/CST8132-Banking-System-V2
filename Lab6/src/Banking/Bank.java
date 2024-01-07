// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 6
// Description: Class for an array of bank accounts, executes their functions as well

package Banking;

import java.util.ArrayList;

/**
 * A class for the Bank, using an array list to keep track of multiple accounts. 
 * Uses the bank account methods to execute all necessary actions.
 * @author Mostapha A
 * @version 1.0
 * @since 1.8
 */
public class Bank {
	// instance variable
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

	// no argument constructor
	/**
	 * Create a bank without any parameters.
	 */
	Bank() {
	}

	// check account type and add to array
	/**
	 * Add an account to the array list and use their methods to collect the information.
	 * @return Whether adding an account was successful or not
	 */
	public boolean addAccount() {
		boolean success = false;
		// variable to store input
		String type;
		
		//header
		System.out.println("Enter the details of account Holder " +(accounts.size()+1)+
				"\n=================================\n");

		// ask for account type
		System.out.print("Please select the type of account you wish to add. \n"
				+ "Type (without quotations) 'c' for chequing account or 's' for savings account : ");
		type = Validate.iMenu("Invalid choice, try again : ", "c", "s");

		//variable to store the bank account
		BankAccount account;
		// determine which array object needs to be created based on account type
		if (type.equalsIgnoreCase("c")) {
			// if they selected Checking type, create a checking
			account = new CheckingAccount();
			accounts.add(account);
		} else {
			// if they selected savings type, create a savings
			account = new SavingsAccount();
			accounts.add(account);
		}

		// call method to read info
		account.addBankAccount();

		// success is true
		success = true;
		return success;
	}

	// find a specific account
	/**
	 * Compare a provided account number with the account numbers in our bank
	 * @return The index value of which the account is stored, or -1 for an error.
	 */
	private int findAccount() {
		long info;
		int arrayIndex = -1;

		// validate it is correct account format
		info = Validate.iLong("Invalid account number, try again : ", 0, 99999999);

		// check if we have this account or not
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).accountNumber == info) {
				arrayIndex = i;
				i = accounts.size();
			}
		}

		// return the index number or -1
		return arrayIndex;
	}

	// use account number to display account
	/**
	 * Uses the findAccount method to return a string of
	 *  a specific accounts information or an error message.
	 * @return The string with an error message or account information.
	 */
	public String displayAccount() {
		int arrayIndex = -1;
		String info = null;

		// ask for account number
		System.out.print("Please enter an account number to display the information of : ");
		// use findAccount method
		arrayIndex = findAccount();

		// if the array was not found return error message, else return the information
		if (arrayIndex == -1) {
			info = "This account could not be found.\n";
		} else {
			info = accounts.get(arrayIndex).toString();
		}

		// return the string of error or account info
		return info;
	}

	// print all account details
	/**
	 * Uses a loop to print all the information of every account in our bank array.
	 */
	public void printAccountDetails() {
		//Header
		System.out.println("Banking System\n"
				+ "******************\n"
				+ "Number of Account Holders : "+accounts.size()+ 
				"\n");
		// print each index of the array
		for (int i = 0; i < accounts.size(); i++) {
			System.out.print(accounts.get(i).toString());
		}
	}

	// use account number to update an account
	/**
	 * Asks for a withdrawal or deposit and updates the balance of the account accordingly.
	 */
	public void updateAccount() {
		int arrayIndex = -1;
		double changes;

		// ask for account number
		System.out.print("Please enter an account number to update the balance of : ");
		// use findAccount method
		arrayIndex = findAccount();

		// if the array was not found return error message, else ask for the changes and
		// execute
		if (arrayIndex == -1) {
			System.out.println("This account could not be found.");
		} else {
			// ask for change
			System.out.print("Enter the amount to deposit/withdraw "
					+ "(positive number to deposit, negative number to withdraw) \n");
			changes = Validate.iDouble("You do not have enough (" 
					+String.format("%.1f", accounts.get(arrayIndex).balance)+ 
					") to withdraw that amount, try again : ",
					(accounts.get(arrayIndex).balance * -1));
			// update account
			accounts.get(arrayIndex).updateBalance(changes);
		}
	}

	// process monthly update for all accounts
	/**
	 * Perform all the necessary calculations for fees or interest on all accounts in our array.
	 */
	public void monthlyUpdate() {
		// update each index of the array
		for (int i = 0; i < accounts.size(); i++) {
			accounts.get(i).monthlyAccountUpdate();
		}
	}

}
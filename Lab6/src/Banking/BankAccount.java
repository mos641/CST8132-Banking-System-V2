// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 6
// Description: Abstract class to be used as the basis for savings and chequing accounts

package Banking;
import java.text.DecimalFormat;

/**
 * Bank account class to be extended by savings and chequing accounts. 
 * Contains the common attributes and behaviours.
 * @author Mostapha A
 * @version 1.0
 * @since 1.8
 */
abstract class BankAccount implements BankSimulator {
	// instance variables
	/** The bank account number, up to 8 digits **/
	protected long accountNumber;
	/** The account holder, an object of class Person **/
	protected Person accHolder = new Person();
	/** The balance of amount of funds available in the account **/
	protected double balance;

	// no argument constructor
	/**
	 * No argument constructor to create a bank account without parameters.
	 */
	BankAccount() {

	}

	
	//return the data of the account
	/**
	 * Return a formatted string of all the account information.
	 * @return The formatted string of all information
	 */
	public String toString() {
		//for formatting balance
		DecimalFormat format = new DecimalFormat("0.##");
		
		//add all the details to one string
		String details;
		details = "AccountNumber: " +accountNumber+ " | Name: " +accHolder.getName()+ 
				" | Phone Number: " +accHolder.getPhoneNumber()+ 
				" | Email Address: " +accHolder.getEmail()+ 
				" | Balance: " +format.format(balance);

		//return string
		return details;
	}

	//method for adding a bank account to the array
	/**
	 * Take input from the user and create a new Bank Account.
	 * @return A boolean value of whether it was successful or not.
	 */
	public boolean addBankAccount() {
		// ask for and store input to create a new account
		//account details
		System.out.print("Enter account number (up to 8 digits) : ");
		accountNumber = Validate.iLong("Invalid account Number, try again : " , 0, 99999999);

		// account holder details
		System.out.print("Enter first name of account holder : ");
		accHolder.setFirstName(Validate.iString("Invalid Name, try again : ", "`","~","1","2","3","4","5",
				"6","7","8","9","0","_","=","+","!","@","#","$","%","^","&","*","(",")",";",":","[",
				"]","{","}","|","\\","\"",",",".","/","<",">","?"));

		System.out.print("Enter last name of account holder : ");
		accHolder.setLastName(Validate.iString("Invalid Name, try again : ", "`","~","1","2","3","4","5",
				"6","7","8","9","0","_","=","+","!","@","#","$","%","^","&","*","(",")",";",":","[",
				"]","{","}","|","\\","\"",",",".","/","<",">","?"));

		System.out.print("Enter phone number of account holder : ");
		accHolder.setPhoneNumber(Validate.iLong("Invalid Phone Number, try again : " 
				, 1000000000L, 9999999999L));
		
		System.out.print("Enter email of account holder : ");
		accHolder.setEmail(Validate.iString());
		
		System.out.print("Enter opening balance of account holder : ");
		balance = Validate.iDouble("Invalid balance, try again : ", 0);
		
		// return boolean value to be used next lab
		return false;
	}

	//withdraw or deposit from the account
	/**
	 * Update the balance of the account based on a withdrawal or a deposit.
	 * @param The amount withdrawn or deposited.
	 */
	public void updateBalance(double changes) {
		//add or subtract from current balance
		balance = balance + changes;
	}

	//abstract to be used in sub classes
	/**
	 * Perform the necessary calculations for any monthly fees or interest.
	 */
	public abstract void monthlyAccountUpdate();
}

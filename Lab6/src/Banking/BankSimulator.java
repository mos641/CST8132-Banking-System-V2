// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 6
// Description: Interface to be implemented by BankAccount


package Banking;

/**
 * The banking interface to be implemented by the Bank Account class.
 * @author Mostapha A
 * @version 1.0
 * @since 1.8
 */
public interface BankSimulator {
	//abstract methods for implementation
	/**
	 * Return a formatted string of all the account information.
	 * @return The formatted string of all information
	 */
	public String toString();
	
	/**
	 * Take input from the user and create a new Bank Account.
	 * @return A boolean value of whether it was successful or not.
	 */
	public boolean addBankAccount();
	
	/**
	 * Update the balance of the account based on a withdrawal or a deposit.
	 * @param The amount withdrawn or deposited.
	 */
	public void updateBalance(double change);

}

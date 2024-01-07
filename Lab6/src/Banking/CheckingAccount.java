// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 6
// Description: Class for Chequing account, 
//				extend Bank account and adds chequing specific behaviours and attributes

package Banking;

/**
 * A class for a chequing account, extends the Bank account and adds 
 * additional chequing specific functionality.
 * @author Mostapha A
 * @version 1.0
 * @since 1.8
 */
public class CheckingAccount extends BankAccount {
	// instance variable
	private double fee;

	// no argument constructor
	CheckingAccount() {
	}

	// return the data of the account
	/**
	 * Return a formatted string of all the account information. 
	 * Uses the super method and adds on to it.
	 * @return The formatted string of all information
	 */
	public String toString() {
		// add all the details to one string
		String details;
		details = super.toString() + " | Fee: " +String.format("%.1f", fee)+
				"\n";

		// return string
		return details;
	}

	// add a new bank account
	/**
	 * Take input from the user and create a new Bank Account. 
	 * Uses the super method and adds on to it.
	 * @return A boolean value of whether it was successful or not
	 */
	public boolean addBankAccount() {
		// ask for and store input to create a new account
		// call super method for non checking specific information
		super.addBankAccount();

		// checking specific information
		System.out.print("Enter the Chequing Account's monthly fee : ");
		fee = Validate.iDouble("Invalid fee amount, try again : ", 0);

		// return boolean value to be used next lab
		return false;
	}

	// perform monthly updates
	/**
	 * Perform the necessary calculations for subtracting any fees from the balance.
	 */
	public void monthlyAccountUpdate() {
		//if statement to determine if balance has enough for fees
		if(balance >= fee) {
		// subtract fee from balance
		balance = balance - fee;
		} else {
			//display error message
			System.out.println("Account " +accountNumber+ 
					" does not have enough balance to subtract the fees of " +fee);
		}
	}

}

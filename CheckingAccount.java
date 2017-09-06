/**
 * A checking account that does not accumulate any interest and offers three free withdrawals
 * @author dylandecker
 *
 */

public class CheckingAccount extends BankAccount {
	
	static int transactionCount;
	static int transactionFee = 1;

	public CheckingAccount(String name, int accountNumber) {
		super (name, accountNumber);
	}
	
	// returns the transaction fee depending on the number of withdraws
	public static int getTFee() {
		if (transactionCount >= 3) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void transaction() {
		transactionCount++;
	}
	
	public static void monthEnd() {
		transactionCount = 0;
	}
	

}

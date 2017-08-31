/**
 * A checking account that does not accumulate any interest and offers three free withdrawals
 * @author dylandecker
 *
 */

public class CheckingAccount extends BankAccount {
	
	private int transactionCount;
	private int transactionFee = 1;

	public CheckingAccount(int accountNumber, double amount) {
		super (accountNumber, amount);
		transactionCount++;
	}
	
	
	public void monthEnd() {
		transactionCount = 0;
	}
	

}

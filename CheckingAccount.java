import java.util.Arrays;

/**
 * A checking account that does not accumulate any interest and offers three free withdrawals
 * @author dylandecker
 *
 */

public class CheckingAccount extends BankAccount {
	
	static int[] transactionHolder = new int[1000];
	static int[] transactionCount = new int[1000];
	static int transactionFee = 1;

	public CheckingAccount(String name, int accountNumber) {
		super (name, accountNumber);
	}
	
	// returns the transaction fee depending on the number of withdraws
	public static int getTFee(int accountNumber) {
		if (transactionHolder[accountNumber] >= 3) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void transaction(int accountNumber) {
		transactionCount[accountNumber] = transactionCount[accountNumber] + 1;
		transactionHolder[accountNumber] = transactionCount[accountNumber] + transactionCount[accountNumber];
	}
	
	public static void monthEnd() {
		transactionCount = new int[1000];
		Arrays.fill(transactionCount, 0);
	}
	

}

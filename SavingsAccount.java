/**
 * A savings account that accumulates interest monthly
 * @author Dylan Decker
 *
 */
public class SavingsAccount extends BankAccount {
	

	public SavingsAccount(String name, int accountNumber) {
		super(name, accountNumber);
	
	}

	public int computeInterest(int monthlyBalance) {
		int value = monthlyBalance * BankAccount.interestRate;
		return value;
	}
	
	public void monthEnd() {
		
	}
}
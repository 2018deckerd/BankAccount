/**
 * A savings account that accumulates interest monthly
 * @author Dylan Decker
 *
 */
public class SavingsAccount extends BankAccount {
	
	
	static double hold = 0;
	static double interestRate = 0.066;
	

	public SavingsAccount(String name, int accountNumber) {
		super(name, accountNumber);
	
	}

	public static double computeInterest(double[] array) {
		for (int k = 1; k < array.length; k++) {
			hold = array[(k - 1)];
			if (hold < array[k]) {
				array[k] = hold;
			}
			
		}
		double value = hold * interestRate;
		return value;
	}
	
	
	public void monthEnd() {
		
	}
}
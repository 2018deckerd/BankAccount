/**
 * Account for keeping basic information for all types of bank account types
 * @author Dylan Decker
 *
 */
public class BankAccount {
	
	static String name;
	static int accountNumber = 1; // account number of bank account
	static double amount; // amount of deposit or withdrawal
	static int interestRate = 6;
	static double balance;
	
	
	public BankAccount(String name, int accountNumber) {
		this.name = name;
		this.accountNumber = accountNumber;
	}
	
	/*
	 * Getter methods for the class
	 */

	public static String getName() {
		return name;
	}
	
	public static int getAccountNumber() {
		return accountNumber;
	}
	
	public static double getAmount() {
		return amount;
	}
	
	public static double getBalance() {
		return amount;
	}
	
	/*
	 * Setter methods for the class
	 */

	public static void setName(String n) {
		name = n;
	}
	
	public static void setAccountNumber(int an) {
		accountNumber = an;
	}
	
	public static void setAmount(double a) {
		amount = a;
	}
	
	public static void setBalance(double b) {
		balance = b;
	}

	/*
	 * This method prints out some general information about the bank account
	 */
	public String toString() {
		return "Name: " + name + "\nAccount Number: " + accountNumber + "\nBalance: " + balance;
	}
}


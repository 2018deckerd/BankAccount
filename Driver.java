import java.util.ArrayList;
import java.util.Scanner;

/**
 * Loops the menu
 * @author Dylan Decker
 *
 */
public class Driver {
	
	private static boolean quit = false;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] names = new String[99];
		int[] bankAccount = new int[99];
		double[] amount = new double[99];
		CheckingAccount ca = new CheckingAccount(CheckingAccount.getName(), CheckingAccount.getAccountNumber());
		SavingsAccount sa = new SavingsAccount(SavingsAccount.getName(), SavingsAccount.getAccountNumber());
		System.out.println("Enter the total number of accounts you have. (Defines array size)");
		int size = scanner.nextInt();
		for (int i = 0; i < size; i = i + 1) {
			bankAccount = new int[size];
			System.out.println("Please enter the name of account number " + (i + 1) + ".");
			names[i] = scanner.next();
		}
		for (int i = 0; i < size; i++) {
			System.out.println("Please enter the account number for " + names[i] + "'s account.");
			bankAccount[i] = scanner.nextInt();
			System.out.println("Thank you.");
		}
		while (quit != true) {
			System.out.println("What type of banking account do you have? Default options are Checking or Savings account.");
			String accountType = scanner.next();
			if (accountType.equalsIgnoreCase("Checking")) {
			System.out.println("Please select an option by entering the first letter of the choice. For instance,"
					+ " to make a deposit, enter D.");
			System.out.println("D)eposit\nW)ithdrawl\nM)onth end\nQ)uit");
			String option = scanner.next();
			if (option.equalsIgnoreCase("D")) {
				System.out.println("Please enter the account number.");
				CheckingAccount.setAccountNumber(scanner.nextInt());
				for (int i = 0; i < size; i++) {
				if (bankAccount[i] == CheckingAccount.getAccountNumber()) {
						System.out.println("Please enter the amount you desire to deposit.: ");
						CheckingAccount.setAmount(Double.parseDouble(scanner.next()));
						amount[i] = amount[i] + CheckingAccount.getAmount();
						CheckingAccount.transaction();
						System.out.println("Your balance is: " + (amount[i] - CheckingAccount.getTFee()));
					} else if (bankAccount[i] != CheckingAccount.getAccountNumber()) {
					
				}
				}
			} else if (option.equalsIgnoreCase("W")) {
				System.out.println("Please enter your name.");
				BankAccount.setName(scanner.nextLine());
				System.out.println("Please enter the account number: ");
				CheckingAccount.setAccountNumber(Integer.parseInt(scanner.nextLine()));
				System.out.println("Please enter the amount you desire to withdraw.: ");
				CheckingAccount.setAmount(Double.parseDouble(scanner.nextLine()));
				CheckingAccount.transaction();
				CheckingAccount.setBalance(CheckingAccount.getBalance() - CheckingAccount.getAmount() - CheckingAccount.getTFee());
		
				System.out.println("Your balance is: " + CheckingAccount.getBalance());
			} else if (option.equalsIgnoreCase("M")) {
				CheckingAccount.monthEnd();
				System.out.println("Transaction count cleared.\nYour balance is: " + CheckingAccount.getBalance());
			} else {
				quit = true;
			}
			}
		 
			
			if (accountType.equalsIgnoreCase("Savings")) {
				System.out.println("Please select an option by entering the first letter of the choice. For instance,"
						+ " to make a deposit, enter D.");
				System.out.println("D)eposit\nW)ithdrawl\nM)onth end\nQ)uit");
				String option = scanner.nextLine();
				if (option.equalsIgnoreCase("D")) {
					System.out.println("Please enter the account number: ");
					CheckingAccount.setAccountNumber(Integer.parseInt(scanner.nextLine()));
					System.out.println("Please enter the amount you desire to deposit.: ");
					CheckingAccount.setAmount(Double.parseDouble(scanner.nextLine()));
					CheckingAccount.setBalance(CheckingAccount.getAmount() + CheckingAccount.getBalance());
					System.out.println(CheckingAccount.getBalance());
				} else if (option.equalsIgnoreCase("W")) {
					System.out.println("Please enter the account number: ");
					CheckingAccount.setAccountNumber(Integer.parseInt(scanner.nextLine()));
					System.out.println("Please enter the amount you desire to withdraw.: ");
					CheckingAccount.setAmount(Double.parseDouble(scanner.nextLine()));
					System.out.println(CheckingAccount.getBalance());
					CheckingAccount.setBalance(CheckingAccount.getBalance() - CheckingAccount.getAmount());
					System.out.println("Your balance is: " + CheckingAccount.getBalance());
				} else if (option.equalsIgnoreCase("M")) {
					
				} else {
					quit = true;
				}
		
			}
	}
  }
 
}

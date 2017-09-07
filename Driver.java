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
		String[] names = new String[99]; // holds array of account names
		int[] bankAccount = new int[99]; // holds account numbers
		double[] amount = new double[99]; // holds balance of checking account
		double[] amount2 = new double[99]; // holds balance of savings accounts
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
						CheckingAccount.transaction(CheckingAccount.getAccountNumber());
						System.out.println("Your balance is: " + (amount[i] - CheckingAccount.getTFee(CheckingAccount.getAccountNumber())));
					} else if (bankAccount[i] != CheckingAccount.getAccountNumber()) {
					
				}
				}
			} else if (option.equalsIgnoreCase("W")) {
				System.out.println("Please enter the account number: ");
				CheckingAccount.setAccountNumber(Integer.parseInt(scanner.next()));
				for (int i = 0; i < size; i++) {
					if (bankAccount[i] == SavingsAccount.getAccountNumber()) {
					System.out.println("Please enter the amount you desire to withdraw.: ");
					CheckingAccount.setAmount(Double.parseDouble(scanner.next()));
					amount[i] = amount[i] - CheckingAccount.getAmount();
					CheckingAccount.transaction(CheckingAccount.getTFee(CheckingAccount.getAccountNumber()));
					CheckingAccount.setBalance(CheckingAccount.getBalance() - CheckingAccount.getAmount() - CheckingAccount.getTFee(CheckingAccount.getTFee(CheckingAccount.getAccountNumber())));
					System.out.println("Your balance is: " + CheckingAccount.getBalance());
			}
			}
			}	else if (option.equalsIgnoreCase("M")) {
					CheckingAccount.monthEnd();
					System.out.println("Transaction count cleared.");
					for (int i = 0; i < size; i++) {
						System.out.println("The balance of " + names[i] + "'s account is: " + (amount[i] - CheckingAccount.getTFee(CheckingAccount.getAccountNumber())));
				}
				
			} else {
				quit = true;
			}
			}
		 
			
			if (accountType.equalsIgnoreCase("Savings")) {
				System.out.println("Please select an option by entering the first letter of the choice. For instance,"
						+ " to make a deposit, enter D.");
				System.out.println("D)eposit\nW)ithdrawl\nM)onth end\nQ)uit");
				String option = scanner.next();
				if (option.equalsIgnoreCase("D")) {
					System.out.println("Please enter the account number: ");
					SavingsAccount.setAccountNumber(Integer.parseInt(scanner.next()));
					for (int i = 0; i < size; i++) {
						if (bankAccount[i] == SavingsAccount.getAccountNumber()) {
							System.out.println("Please enter the amount you desire to deposit.: ");
							SavingsAccount.setAmount(Double.parseDouble(scanner.next()));
							amount2[i] = amount2[i] + SavingsAccount.getAmount();
							System.out.println("Your balance is: " + (amount2[i]));
					}
				  }
				}else if (option.equalsIgnoreCase("W")) {
					System.out.println("Please enter the account number: ");
					CheckingAccount.setAccountNumber(Integer.parseInt(scanner.next()));
					for (int i = 0; i < size; i++) {
						if (bankAccount[i] == SavingsAccount.getAccountNumber()) {
						System.out.println("Please enter the amount you desire to withdraw.: ");
						SavingsAccount.setAmount(Double.parseDouble(scanner.next()));
						amount2[i] = amount2[i] - SavingsAccount.getAmount();
						System.out.println("Your balance is: " + amount2[i]);
					}
				  }
				} else if (option.equalsIgnoreCase("M")) {
					double hold  = SavingsAccount.computeInterest(amount2);
					System.out.println("Accumulated interest computed. You accumulated " + hold + " dollars.");
					for (int i = 0; i < size; i++) {
						if (bankAccount[i] == SavingsAccount.getAccountNumber()) {
							amount2[i] = amount2[i] + SavingsAccount.computeInterest(amount2);
							System.out.println("Your new balance is: " + amount2[i]);
						}
					}
				} else {
					quit = true;
				}
		
			}
	}
  }
 
}

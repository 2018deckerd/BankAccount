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
		CheckingAccount ca = new CheckingAccount(CheckingAccount.getAccountNumber(), CheckingAccount.getAmount());
		while (quit != true) {
			System.out.println("What type of banking account do you have? Default options are Checking or Savings account.");
			String accountType = scanner.nextLine();
			if (accountType.equalsIgnoreCase("Checking")) {
			int checkingStore[];
			checkingStore = new int[999];
			System.out.println("Please select an option by entering the first letter of the choice. For instance,"
					+ " to make a deposit, enter D.");
			System.out.println("D)eposit\nW)ithdrawl\nM)onth end\nQ)uit");
			String option = scanner.nextLine();
			if (option.equalsIgnoreCase("D")) {
				System.out.println("Please enter the account number: ");
				// creates a history array of accountNumbers
				for (int i = 0; i < 999; i++) {
					checkingStore[i] = Integer.parseInt(scanner.nextLine());
				for (int j = 0; j < 999; j++) {
				if  (CheckingAccount.getAccountNumber() == checkingStore[j]) {
						System.out.println("This account is in our system. We will add your new deposit to the current balance.");
						System.out.println("Please enter the amount you desire to deposit.: ");
						CheckingAccount.setAmount(Double.parseDouble(scanner.nextLine()));
						double balance = CheckingAccount.getAmount() + CheckingAccount.getBalance();
						CheckingAccount.setBalance(balance);
						System.out.println("Your new balance is: " + CheckingAccount.getBalance());
				} else {
					System.out.println("This is a new bank account or was not the same as the previously entered account.\nIt will be added to the history or the balance will be added cumulatively.");
					CheckingAccount.setAccountNumber(checkingStore[j]);
				}
					System.out.println("Please enter the amount you desire to deposit.: ");
					CheckingAccount.setAmount(Double.parseDouble(scanner.nextLine()));
					double balance = CheckingAccount.getAmount();
					CheckingAccount.setBalance(balance);
					System.out.println("Your new balance is: " + CheckingAccount.getBalance());
				}
			}
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

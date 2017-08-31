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

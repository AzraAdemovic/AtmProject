
public class ATmImplementation extends Account{
	
	
	public void increasBalance(double sum) {
		accountBalance += sum;
	}

	public void decreasBalance(double sum) {
		accountBalance -= sum;
	}

	public static void printoutsOfAccounts(int numberOfAccount) {
		for (int i = 0; i < accounts.size(); i++)
			if (accounts.get(i).numberOfAccount == numberOfAccount) {
				System.out.println(accounts.get(i).toString());
				return;
			}
		System.out.println("Account is incorrect.");

	}

	public static boolean validName(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isLetter(name.charAt(i))) {
				return false;
			}
		}

		return true;

	}

	
	public static boolean validPassword(String password) {
		int counter = 0;
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isLetterOrDigit(password.charAt(i))) {
				return false;
			}
			else {
				counter++;
			}

		}
		if (counter >= 8) {
			System.out.println("Password is valid.");
			return true;
		} else {
			System.out.println("Password is not valid.");
			return false;
		}
	}

	public static boolean validBalance(double balance) {
		if (balance >= 0) {
			return true;
		}
		return false;
	}
}


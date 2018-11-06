
public class Account extends FirstPage {

	protected int numberOfAccount;
	private String name;
	protected double accountBalance;

	public Account() {
	}
	
	public Account(int numberOfAccount, String name, double accountBalance) {
		this.numberOfAccount = numberOfAccount;
		this.name = name;
		this.accountBalance = accountBalance;
	}

	public int getnumberOfAccount() {
		return numberOfAccount;
	}

	public void setNumberOfAccount(int numberOfAccount) {
		this.numberOfAccount = numberOfAccount;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
		
	public static void checkBalance(int numberOfAccount) {
		for (int i = 0; i < accounts.size(); i++)
			if (accounts.get(i).numberOfAccount == numberOfAccount) {
				System.out.println(accounts.get(i).toString());
				return;
			}
		System.out.println("Account is incorrect.");

	} 

	@Override
	public String toString() {
		return "Account [\n numberOfAccount=" + numberOfAccount + "\n name=" + name + "\n accountBalance="
				+ accountBalance + "]";
	}
}

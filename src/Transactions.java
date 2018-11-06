

public class Transactions extends Account {
	protected static int sourceAccount;
	protected static int targetAccount;
	protected static double sumMoney;

	public Transactions() {

	}

	public Transactions(int sourceAccount, int targetAccount, double sumMoney) {
		Transactions.sourceAccount = sourceAccount;
		Transactions.targetAccount = targetAccount;
		Transactions.sumMoney = sumMoney;
	}

	public int getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(int sourceAccount) {
		Transactions.sourceAccount = sourceAccount;
	}

	public int getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(int targetAccount) {
		Transactions.targetAccount = targetAccount;
	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		Transactions.sumMoney = sumMoney;
	}

	/* public boolean check() {
		boolean sourceexist = false;
		boolean targetexist = false;
		boolean enough = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getnumberOfAccount() == sourceAccount) {
				sourceexist = true;
				return true;

			} else {
				System.out.println("This account does not exist.");
			}
		}

		for (int j = 0; j < accounts.size(); j++) {

			if (accounts.get(j).getnumberOfAccount() == targetAccount) {
				targetexist = true;
				return true;
			} else {
				System.out.println("The target account does not exist.");
			}
		}

		for (int k = 0; k < accounts.size(); k++) {

			if ((accounts.get(k).getAccountBalance() - sumMoney) >= 0) {
				enough = true;
				return true;
			} else {
				System.out.println("You do not have enough money on your bank account.");
			}

		}

		if (sourceexist && targetexist && enough) {
			return true;
		}

		else
			return false;
	}

	public void doTransaction() {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getnumberOfAccount() == targetAccount)
				accounts.get(i).accountBalance += sumMoney;

			if (accounts.get(i).getnumberOfAccount() == sourceAccount)
				accounts.get(i).accountBalance -= sumMoney;
		}

	}*/

} 

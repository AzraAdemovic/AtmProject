
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class FirstPage {
	
	public static ArrayList<Account> accounts = new ArrayList<Account>();
	static boolean running = true;

	public static void main(String[] args) throws IOException {
	 Scanner input = new Scanner(System.in);
	 boolean continueInput = true;
	 accounts = FR.readFromFile();
	 System.out.println("\t\t*WELCOME*");
	 while (running) {
		 
		 System.out.print("please choose an option: "
		            + "\n" 
					+ "\n 1. => Create account.\n"
					+ "\n 2. => Transfer money to another account.\n"
					+ "\n 3. => Print account details. \n" ) ;
		 
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				Account account = new Account();
				input.nextLine();
				System.out.println("Please insert your name :");
				String name = input.nextLine();
				// iskoristena metoda za provjeru imena, ubacena u petlju i sve dok je netacno, petlja se vrti
				while(!ATmImplementation.validName(name)) {
					System.out.println("Name should contain only letters.");
					System.out.println("Please insert your name :");
					name = input.nextLine();
				}
				
				
				account.setName(name);
				
				System.out.println("Please insert number of account :");
				// try - catch block u slucaju da se unese pogresan tip podataka
				do {
					try {

						int no_account = input.nextInt();

						input.nextLine();
						continueInput = false;
					
						while (!accountavaliable(no_account)) {
							
							System.out.println("Please choose another account number: ");
							no_account = input.nextInt();
						}
						account.setNumberOfAccount(no_account);
					} 
					catch (InputMismatchException ex) {
						System.out.println("Try again. (" + "Incorrect input: an integer is required)");
						input.nextLine();
						continueInput = true;
					}
				} while (continueInput);
				
				System.out.println("Insert password:");
				String password = input.nextLine();
				while (!ATmImplementation.validPassword(password)) {
					System.out
							.println("Minimum length of password is 8 characters which includes numbers and letters.");
					System.out.println("Please insert your password again :");
					password = input.nextLine();
				}
				
				System.out.println("Please insert account balance :");
				try {
				double balance = input.nextDouble();
				while (!ATmImplementation.validBalance(balance)) {
					System.out
							.println("Balance can not be negative !");
					System.out.println("Please insert your balance again :");
					balance = input.nextDouble();
				}
				account.setAccountBalance(balance);
				accounts.add(account);
				System.out.println(name + "  Your account is successfully created, your account number is  "
						+ account.getnumberOfAccount());	
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				String fileName = "racuni.txt";
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter (new File("racuni.txt"),true));

					bufferedWriter.write(account.getnumberOfAccount() + " " + name + " " +  account.getAccountBalance() );
					bufferedWriter.newLine();
					bufferedWriter.close();
				} catch (IOException ex) {
					System.out.println("Error writing to file '" + fileName + "'");

				}
		

				break;

			case 2:
				Transactions transaction = new Transactions();
				System.out.println("Enter the account number from which you want to transfer money: ");
				int sourcenumber = input.nextInt();
				input.nextLine();
				transaction.setSourceAccount(sourcenumber);
				System.out.println("Enter the account number to which you want to transfer money: ");
				int targetnumber = input.nextInt();
				input.nextLine();
				transaction.setTargetAccount(targetnumber);
				System.out.println("Enter the sum of money you want to transfer :");
				double money = input.nextDouble();
				input.nextLine();
				transaction.setSumMoney(money);
				if (TransImplementation.check()) {
					TransImplementation.doTransaction();
					System.out.println("The transaction was successfully executed.");
				} else {
					System.out.println("Something went wrong, please try again.");
				}

				break;

			case 3:
				System.out.println("Please insert your number of account :");
				int number = input.nextInt();
				for (int i = 0; i < accounts.size(); i++) {
					if (accounts.get(i).getnumberOfAccount() == number) {
						System.out.println();
						Account.checkBalance(number);
					}
				}
				break;

			default:
				System.out.println("Please choose one of offered options.");
				break;
			}

		}
	 input.close();

	}

	public static boolean accountavaliable(int no_account) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getnumberOfAccount() == no_account) {
				System.out.println("Number is already taken , please choose anotherone.");
				return false;
			}
		}
		return true;
	}

}


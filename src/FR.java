import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class FR {

	public static ArrayList<Account> readFromFile() {
		String fileName = "racuni.txt";
		ArrayList<Account> accounts = new ArrayList<Account>();
		String line = null;
		System.out.println();

		try {

			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("racuni.txt")));
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] info = line.split(" ");
				Account acc = new Account();
				acc.setNumberOfAccount(Integer.parseInt(info[0]));
				acc.setName(info[1]);
				acc.setAccountBalance(Double.parseDouble(info[2]));
				accounts.add(acc);
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
		return accounts;
	}

}

import java.util.Scanner;
import java.util.Vector;

public class Bank {

	BankAccount[] clients = new BankAccount[5];
	BankAccount currentAccount;
	Scanner input = new Scanner(System.in);
	boolean toExit = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank();
		bank.openBank();
	}

	public void openBank() {
		menu();
	}

	public void menu() {
		while (!toExit) {
			System.out.println("Select an option\n1. Login\n2. Create Account\n3. Exit\n4. Display accounts");
			int selection = input.nextInt();
			switch (selection) {
			case 1:
				input.nextLine();
				login();
				break;
			case 2:
				input.nextLine();
				openAccount();
				break;
			case 3:
				exit();
				break;
			case 4:
				displayAccounts();
				break;
			default:
				System.out.println("Not a valid option! Try again!");
			}
		}
	}

	public void login() {

		boolean noAvailableAccounts = false;
		boolean accountFound = false;
		if (clients[0] == null) {
			System.out.println("No available accounts to login to");
			noAvailableAccounts = true;
		}

		if (!noAvailableAccounts) {
			System.out.println("Enter name");
			String name = input.nextLine();
			for (int i = 0; i < clients.length; i++) {
				if (clients[i] != null && name.equals(clients[i].name)) {
					currentAccount = clients[i];
					System.out.println("Successfully logged in as: " + name);
					accountFound = true;
					bankAccountMenu();
					break;
				}
			}
		}
		if (!accountFound && !noAvailableAccounts)
			System.out.println("Account not found! Returning to menu!");

	}

	public void bankAccountMenu() {
		System.out.println("Welcome " + currentAccount.name + "! Your current balance is " + currentAccount.balance
				+ "! Select an option\n1. Withdraw\n2. Deposit\n3. Close account \n4. Log out");
		int selection = input.nextInt();
		switch (selection) {
		case 1:
			withdraw();
			bankAccountMenu();
			break;
		case 2:
			deposit();
			bankAccountMenu();
			break;
		case 3:
			closeAccount();
			logOut();
			break;
		case 4:
			logOut();
			break;
		default:
			System.out.println("Not a valid option! Try again!");
		}
	}

	public void openAccount() {
		boolean succuessful = false;
		boolean accountsAvailable = false;
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null)
				accountsAvailable = true;
		}

		if (!accountsAvailable) {
			System.out.println("No account slots available! Returning to menu!");
			accountsAvailable = false;
		}

		if (accountsAvailable) {
			outerLoop: while (!succuessful) {
				secondLoop: for (int i = 0; i < clients.length; i++)
					if (clients[i] == null) {
						System.out.println("Enter name of account");
						String name = input.nextLine();
						System.out.println("user entered " + name);
						for (int z = 0; z < clients.length; z++) {
							if (clients[z] != null && clients[z].name.equals(name)) {
								System.out.println("Account already exists! Try again!");
								succuessful = false;
								// openAccount();
								break secondLoop;
							}
						}
						System.out.println("Enter initial deposit amount");
						double initBal = 0;
						try {
							initBal = input.nextDouble();
						} catch (Exception e) {
							System.err.println("TYPE THE RIGHT THINGG!!!! NOW YOURE GOING TO HAVE TO RESTARTTT!!!!");
							input.nextLine();
							succuessful = false;
							// openAccount();
							break secondLoop;
						}
						clients[i] = new BankAccount(name, initBal);
						currentAccount = clients[i];
						System.out.println("Account created!");
						succuessful = true;
						break outerLoop;
					}
			}
		}
//		menu();
	}

	public void exit() {
		System.out.println("Exiting!");
		toExit = true;
	}

	public void withdraw() {
		System.out.println("Enter withdrawl amount");
		double amt = input.nextDouble();
		currentAccount.withdraw(amt);
		
		

	}

	public void deposit() {
		System.out.println("Enter deposit amount");
		double amt = input.nextDouble();
		currentAccount.deposit(amt);

	}
	
	public void displayAccounts() {
		for(BankAccount acc : clients) 
				System.out.println(acc);	
	}
	
	public void closeAccount() {

		for (int i = 0; i < clients.length; i++)
			if (clients[i] == currentAccount) {
				clients[i] = null;
				System.out.println("ACCOUNT SET TO NULL");
			}
		System.out.println("\n\n\n\n\n\n\n");

		BankAccount[] tempClients = new BankAccount[5];
		for (int i = 0; i < clients.length; i++)
			if (clients[i] != null)
				for (int z = 0; z < tempClients.length; z++)
					if (tempClients[z] == null) {
						tempClients[z] = clients[i];
						break;
					}
		clients = tempClients;
		System.out.println("Account closed! Returning to menu");
		System.out.println("-------------------");
	}

	public void logOut() {
		System.out.println("Logging out!");
		currentAccount = null;
		// menu();
	}

}

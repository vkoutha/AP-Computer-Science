import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	ArrayList<BankAccount> clients = new ArrayList<BankAccount>();
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
		System.out.println("Enter login name");
		if(clients.size() == 0)
			System.out.println("No accounts available to log into");
		String name = input.nextLine();
		for(int i = 0; i < clients.size(); i++){
			if(clients.get(i).name.equals(name)){
				currentAccount = clients.get(i);
				System.out.println("Successfully logged in");
				bankAccountMenu();
				return;
			}
		}
		System.out.println("No account found - Returning to login");
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
			System.out.println("Account successfully closed!!");
			break;
		case 4:
			logOut();
			break;
		default:
			System.out.println("Not a valid option! Try again!");
			bankAccountMenu();
		}
	}

	public void openAccount() {
		boolean successful = true;
		System.out.println("Enter name of account");
		String name = input.nextLine();
		for(int i = 0; i < clients.size(); i++)
			if(clients.get(i).equals(name)){
				System.out.println("Account already exists!");
				successful = false;
			}
		if(successful){
			System.out.println("Enter balance amount");
			double initial = input.nextDouble();
			clients.add(new BankAccount(name, initial));
			System.out.println("Account created!");
		}else{
			System.out.println("Not successful! Try again");
			openAccount();
		}
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
		BankAccount accToRemove = currentAccount;
		clients.remove(accToRemove);
	}

	public void logOut() {
		System.out.println("Logging out!");
		currentAccount = null;
	}

}

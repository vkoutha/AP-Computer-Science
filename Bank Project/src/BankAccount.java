
public class BankAccount {

	String name;
	double balance;

	public BankAccount(){
	}

	public BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	public double withdraw(double amt) {
		if (amt > balance)
			System.out.println("You have less money than what you want to withdraw!");
		else
			balance -= amt;
		return balance;
	}

	public double deposit(double amt) {
		balance += amt;
		return balance;
	}

	public String toString() {
		return "Name: " + name + "\nBalance: $" + balance;
	}

}

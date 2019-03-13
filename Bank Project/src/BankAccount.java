
public class BankAccount {

	String name;
	double balance;

	/**
	*
	*Default constructor for BankAccount class
	*/
	public BankAccount(){
	}

	/**
	*
	*Constructor for BankAccount class to initialize name and balance
	*@param name Name of User
	*@param balance Initial user balance
	*/
	public BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	/**
	*
	*Takes money out of user account, unless entered amount is greater than user balance
	*@param amt Amount of money to be withdrawn
	*@return New balance
	*/
	public double withdraw(double amt) {
		if (amt > balance)
			System.out.println("You have less money than what you want to withdraw!");
		else
			balance -= amt;
		return balance;
	}

	/**
	*
	*Deposits money into user account
	*@param amt Amount of money to be deposited 
	*@return New balance
	*/
	public double deposit(double amt) {
		balance += amt;
		return balance;
	}

	/**
	*
	*@see Object#toString()
	*/
	public String toString() {
		return "Name: " + name + "\nBalance: $" + balance;
	}

}

public class SavingsAccount extends BankAccount {

	private double interestRate;
	private double balance;

	public SavingsAccount(double amount, double rate) // Constructor
	{
		super(amount); // Calls the constructor in
		interestRate = rate; // BankAccount and sets balance
	}

	public void addInterest() {
		double interest = getBalance() * interestRate / 100;
		deposit(interest);
	}
	
	public void deposit(int d){
		balance+=d;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public double superGetBalance(){	
		return super.getBalance();
	}

}

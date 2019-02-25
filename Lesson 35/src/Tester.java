public class Tester {

	public static void main(String[] args){
	
		BankAccount b = new BankAccount(500);
		SavingsAccount s = new SavingsAccount(1000, 5);
	//	BankAccount p = new SavingsAccount(0, 5);
	//	p.deposit(500);
		
		s.deposit(500);
		System.out.println(s.getBalance());
		System.out.println(s.superGetBalance());
		
		
	}

}

package rnadom;

public class random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
	}

	public static int factorial(int x) {
		switch(x) {
		case 0:
			return 1;
		default:
			return x * factorial(x-1);
		}
	}
	
}

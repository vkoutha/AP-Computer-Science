
public class mathRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		newMath math = new newMath();
		System.out.println("Pow: " + math.pow(10, 2));
		System.out.println("Remainder: " + math.mod(69, 6));
		System.out.println("Ans 1: " + math.quadratic(1, 5, 6)[0]);
		System.out.println("Ans 2: " + math.quadratic(1, 5, 6)[1]);
		System.out.println("Pythag: " + math.pythag(4, 3));
		System.out.println("Factorial: " + math.factorial(6));
		System.out.println("Circle area: " + math.circArea(5));
		System.out.println("Slope: " + math.slope(10, 2, 5, 9));
	}

}

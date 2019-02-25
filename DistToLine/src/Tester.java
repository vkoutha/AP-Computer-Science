import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("Enter value for A");
		DistToLine.A = input.nextDouble();
		System.out.println("Enter value for B");
		DistToLine.B = input.nextDouble();
		System.out.println("Enter value for C");
		DistToLine.C = input.nextDouble();

		System.out.println("Enter x coordinate");
		double xCoord = input.nextDouble();
		System.out.println("Enter y coordinate");
		double yCoord = input.nextDouble();

		System.out.println("Distance to line: " + DistToLine.getDist(xCoord, yCoord));

	}

}

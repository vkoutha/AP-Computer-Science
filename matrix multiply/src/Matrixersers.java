import java.util.Scanner;

public class Matrixersers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		int[][] matrix1 = null, matrix2 = null, finalMatrix;
		//	matrix1 = initialize(matrix1);
		//	matrix2 = initialize(matrix2);
			matrix1 = new int[][] {
				{6, -2, 0},
				{7, 6, 3},
				{4, 2, 0}
			};
			
			matrix2 = new int[][] {
				{0, 2, 7, 8, 10},
				{1, 6, 7, 6, 3},
				{1, 4, 7, 4, 6}
			}; 
			
			if(matrix1[0].length != matrix2.length) {
				System.out.println("Cant work!");
				System.exit(0);
			}
				
			finalMatrix = new int[matrix1.length][matrix2[0].length];
			for(int row = 0; row < finalMatrix.length; row++)
				for(int column = 0; column < finalMatrix[row].length; column++)
					finalMatrix[row][column] = getProduct(matrix1[row], getColumnAsArray(matrix2, column));
			
			print2dArray(finalMatrix);
	}
	
	public static int[][] initialize(int[][] matrix){
		Scanner input = new Scanner(System.in);
		int rows, columns;
		System.out.println("How many rows??????");
		rows = input.nextInt();
		System.out.println("How many columns?????");
		columns = input.nextInt();
		if(rows < 1 || columns < 1) {
			System.out.println("Cant work!");
			System.exit(0);
		}
		matrix = new int[rows][columns];
		for(int row = 0; row < matrix.length; row++) {
			for(int column = 0; column < matrix[row].length; column++) {
				System.out.println("Now entering Row " + (row + 1) + ", Column " + (column+1));
				matrix[row][column] = input.nextInt();
			}
		}
		return matrix;
	}
	

	public static void print2dArray(int[][] matrix) {
		for(int row = 0; row < matrix.length; row++) {
			for(int column = 0; column < matrix[row].length; column++)
				System.out.print(matrix[row][column] + " ");
			System.out.println();
		}
	}
	
	public static int getProduct(int[] arr1, int[] arr2) {
		int sum = 0;
		for(int i = 0; i < arr1.length; i++)
			sum+= (arr1[i]*arr2[i]);
		return sum;
	}
	
	public static int[] getColumnAsArray(int[][] matrix, int column) {
		int[] arr = new int[matrix.length];
		for(int row = 0; row < matrix.length; row++)
			arr[row] = matrix[row][column];
		return arr;
	}

}

package rnadom;

public class random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2224, 222323, 223321, 2220, 69, 3, 2, 1, 424210};
		int temp;
		int n = arr.length;
		for(int i = 0; i < n; i++) {
	         for(int j=1; j < n; j++) {
	            if(arr[j-1] < arr[j]) {
	               temp = arr[j-1];
	               arr[j-1] = arr[j];
	               arr[j] = temp;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	            }
	         }
	      }
		for(int d : arr)
       	 System.out.println(d);
	   }
}

import java.util.ArrayList;

public class BinarySearch {
	
	static int counter = 0;
	public static void main(String[] args) {
		//12730000
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 5000000; i++){
			list.add(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Finished populating after " + (endTime-startTime)/1000.0 + " seconds");
		int val = 69;
		long startTime2 = System.currentTimeMillis();
		System.out.println("Found value " + val + " at index " + binarySearch(list, val, 0, list.size()) 
		+ " after " + counter + " searches");
		long endTime2 = System.currentTimeMillis();
		System.out.println("Finished searching after: " + (endTime2-startTime2)/1000.0 + " seconds");
	}
	
	public static int binarySearch(ArrayList<Integer> list, int val, int start, int end){
		counter++;
		if(start == end && list.get(start) != val){
			return -1;
		}else if (list.get((start + end)/2) == val){
			return (start+end)/2;
		}
		else if(list.get((start + end)/2) > val){
			return binarySearch(list, val, start, (start+end)/2);
		}else if (list.get((start + end)/2) < val){
			System.out.println(start);
			return binarySearch(list, val, (start+end)/2, end);
		}else{
			return -1;
		}
	}

}

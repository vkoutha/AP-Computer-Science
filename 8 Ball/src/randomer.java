import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class randomer {

	static int highestEver = -1, lowestEver = 10000000; 
	static ArrayList<Integer> highestVals = new ArrayList<Integer>();
	static ArrayList<Integer> lowestVals = new ArrayList<Integer>();
	static int[] highestIndexes = new int[10], lowestIndexes = new int[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lowestRange = 100000000;
		for(int biggy = 0; biggy < 10000; biggy++){
			int[] randomer = new int[10];
			Random rand = new Random();
			int index = 0;
			for(int i = 0; i < 10000; i++)
				randomer[rand.nextInt(10)]++;
			
			int highestIndex = -1, highestVal = -1, lowestIndex = -1, lowestVal = 100000000;
			for(int i = 0; i < randomer.length; i++){
			//	System.out.println("Index " + i + ": " + randomer[i]);
				if(randomer[i] > highestVal){
					highestIndex = i;
					highestVal = randomer[i];
				}
				if(randomer[i] < lowestVal){
					lowestIndex = i;
					lowestVal = randomer[i];
				}
				
			}
			
			highestVals.add(highestVal);
			lowestVals.add(lowestVal);
	//		System.out.println("\nHighest index: " + highestIndex + "\tValue: " + highestVal);
	//		System.out.println("Lowest index: " + lowestIndex + "\t\tValue: " + lowestVal);
			int range = highestVal - lowestVal;
	//		System.out.println("Range: " + (range));
			if(range < lowestRange)
				lowestRange = range;
			highestIndexes[highestIndex]++;
			lowestIndexes[lowestIndex]++;
		}
	//	System.out.println("View all highset vals?");
		Scanner input = new Scanner(System.in);
	/*	if(!input.equals("NO"))
			sayHighestVals();
		System.out.println("View all lowest vals?");
		if(!input.equals("NO"))
			sayLowestVals();
			*/
		int highIndexEver = -1, highValEver = -1;
		int lowIndexEver = -1, lowValEver = 1000000;
		for(int i = 0; i < highestIndexes.length; i++){
			System.out.println("Index " + i + ": " + highestIndexes[i]);
			if(highestIndexes[i] > highValEver){
				highValEver = highestIndexes[i];
				highIndexEver = i;
			}
		}
		System.out.println("\n\n\nSTARTING LOWEST INDEX COUNTS");
		
		for(int i = 0; i < lowestIndexes.length; i++){
			System.out.println("Index " + i + ": " + lowestIndexes[i]);
			if(lowestIndexes[i] > lowValEver){
				lowValEver = lowestIndexes[i];
				lowIndexEver = i;
			}
		}
		
		System.out.println("Index " + highIndexEver + " was chosen the most with " + highValEver + " times");
		System.out.println("Lowest range ever: " + lowestRange);
	}
	
	public static void sayHighestVals(){
		for(int i = 0; i < highestVals.size(); i++)
			System.out.println("Index " + i + ": " + highestVals.get(i));
	}
	
	public static void sayLowestVals(){
		for(int i = 0; i < lowestVals.size(); i++)
			System.out.println("Index " + i + ": " + lowestVals.get(i));
	}

}

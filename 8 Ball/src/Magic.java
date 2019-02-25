import java.util.Random;
import java.util.Scanner;

public class Magic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		System.out.println("Welcome, ask me a question, say STOP to stop");
		String sent = "";
		do{
			sent = input.nextLine();
			sayRandomResponse(random.nextInt(9));
		}while(!sent.equals("STOP"));
	}
	
	public static void sayRandomResponse(int randInt){
		switch(randInt){
		case 0:
			System.out.println("tell ur mum that");
			break;
		case 1:
			System.out.println("I really don't care about you");
			break;
		case 2:
			System.out.println("wow your so funny");
			break;
		case 3:
			System.out.println("tell me something else");
			break;
		case 4:
			System.out.println("thats nice");
			break;
		case 5:
			System.out.println("your kind of stupid arent you");
			break;
		case 6:
			System.out.println("your not the brightest light bulb, aren't you?");
			break;
		case 7:
			System.out.println("CAN YOU SHUT UP");
			break;
		case 8:
			System.out.println("good for you");
			break;
		}
	}

}

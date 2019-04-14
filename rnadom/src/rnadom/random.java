package rnadom;

public class random {

	public static void main(String[] args) {
		test t = random::dfg;
		t.da(t);
	}
	
	public static void dfg(test t) {
		System.out.println(t);
		inter interfac = random::awesome;
		inter interfacUltimate = random2::num2metherd;
		inter interfac2 = (x) -> ok(x);
		inter interfac3 = (x) -> testing(x);
		interfac.metherd(69);
		interfacUltimate.metherd(69);
		interfac2.metherd(69);
		interfac3.metherd(69);
	}
	
	public static void awesome(int ad){
		System.out.println(ad/2);
	}
	
	public static void ok(int x){
		System.out.println(x*2);
	}
	
	public static void testing(int x){
		System.out.println(x);
	}
	
}

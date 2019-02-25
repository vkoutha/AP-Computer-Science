
public class newMath implements interMath {

	@Override
	public double mod(double x, double y) {
		// TODO Auto-generated method stub
		int divAns = 0;
		for(int i = 0; i <= x; i++){
			if(y*i == x)
				return 0;
			else if(y*i > x){
				divAns = i-1;
				break;
			}
		}
		return x - (y*divAns);
	}

	@Override
	public double pow(double x, double y) {
		// TODO Auto-generated method stub
		double ans = 1;
		for(int i = 0; i < y; i++)
			ans = ans*x;
		return ans;
	}

	@Override
	public double[] quadratic(double a, double b, double c) {
		// TODO Auto-generated method stub
		double ans1 = (-b+Math.sqrt(pow(b,2)-(4*a*c)))/(2*a);
		double ans2 = (-b-Math.sqrt(pow(b,2)-(4*a*c)))/(2*a);
		return new double[]{ans1, ans2};
	}
	
	@Override
	public double pythag(double a, double b){
		return Math.sqrt(pow(a,2) + pow(b,2));
	}
	
	@Override
	public int factorial(int x){
		switch(x){
		case 1:
			return 1;
			default:
				return x*factorial(x-1);
		}
	}
	
	public double circArea(double radius){
		return Math.PI * pow(radius, 2);
	}
	
	public double slope(double x1, double x2, double y1, double y2){
		return (y2-y1)/(x2-x1);
	}
	

}

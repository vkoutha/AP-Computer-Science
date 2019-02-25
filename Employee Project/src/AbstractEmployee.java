
public abstract class AbstractEmployee {
	
	public String name;
	public double salary;
	
	public double setSalary(double amt){
		salary = amt;
		return salary;
	}
	
	public abstract String changeName(String name);

}

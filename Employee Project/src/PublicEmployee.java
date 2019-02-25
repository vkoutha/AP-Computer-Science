
public class PublicEmployee extends AbstractEmployee{
	
	public PublicEmployee(){
		
	}
	
	public String changeName(String name){
		this.name = name;
		return this.name;
	}
	
	public void printName(){
		System.out.println(name);
	}
	
	public void getPaid(){
		System.out.println("you got da moneys");
	}
	
	

}


public class multiD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] datboi = new int[10][10];
		int x = 0;
		for(int i = 0; i < datboi.length; i++)
			for(int i2 = 0; i2 < datboi[i].length; i2++)
				System.out.println(datboi[i][i2] + "\t" + ++x);
	}

}

package Array_String;

public class Covert_Integer_to_Binary {

	public static void main(String[] args)
	{
		int x = 9;
		StringBuffer sb = new StringBuffer();
		while(x>=1)
		{
			int rem = x%2;
			sb.append(rem);
			x = x/ 2;
		}
		System.out.println("Binary String is : " + sb.toString());
	}
	
	
}

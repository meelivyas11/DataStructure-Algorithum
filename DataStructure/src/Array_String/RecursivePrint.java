package Array_String;

public class RecursivePrint {

	public static void main(String[] args) {
		recursivePrint(20);
	}
	
	public static void recursivePrint(int n)
	{
	    if(n < 9)
	        return;
	   System.out.println(n);
	   recursivePrint(n-1);
	}
	
}

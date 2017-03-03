package Array_String;

public class ConvertIntNumberToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] a = {1,0};
		
		System.out.println(int2english(a, n));
		System.out.println(String.valueOf(10));
	}
	public static String int2english(int[] a, int n)
	{
	    if(n<10)
	       return dictOnes(a[0]);
	    else if(n%10 == 0)
	        return dictDivisibleByTen(a);
	    else if (n>10 && n <20) 
	        return dictFor11To19(a[1]-1);
	    else if(n>20 && n<100) 
	       return dicttens(a[0])+dictOnes(a[1]);
	    else if (n>100 && n<1000)
	        return dictOnes(a[0]) + "hundred" + dicttens(a[1]) + dictOnes(a[2]);
		return "0000";
	}

	static String dictFor11To19(int a)
	{
	    String[] s = {"Eleven", "Twele", "thirteen","forteen","fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	    return s[a];
	}

	static String dictDivisibleByTen(int[] n)
	{
	    String s[] = {"ten", "twenty","thirty","forty","fifty","Sixty","Seventy"};
	    return s[n[0]-1];
	}
	static String dictOnes(int x)
	{
	    String s[] = {"zero","One", "two", "Three", "four", "nine"};
	    return s[x];
	}

	static String dicttens(int x)
	{
	    String s[] = {"zero", "Eleven", "Twenty","Ninty"};
	    return s[x];
	}

}

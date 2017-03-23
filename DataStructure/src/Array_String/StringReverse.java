package Array_String;

public class StringReverse {
	
	public static void main(String[] args)
	{
	String temp = "abcdefgG";
/*	String reverseString = reverseStr(temp);
	System.out.println("Reverse : " + reverseString);
	
	finalRev(temp);*/
	
	recursiveReverse(temp, "");
	}
	
	// doesnt handle the null 
	public static String reverseStr(String temp)
	{
		String Rstr = "";
		for(int i = temp.length()-1; i >= 0; i--)
		{
			Rstr = Rstr + temp.charAt(i);
		}
		return Rstr;
	}
	
	
	public static void finalRev(String temp)
	{
		char[] tempArray =temp.toCharArray();
		int start = 0;
		int end = tempArray.length - 1;
		while (end > start)
		{
			char temp1 = tempArray[start];
			tempArray[start] = tempArray[end];
			tempArray[end] = temp1;
			start++;
			end--;
		}
		
		System.out.println(tempArray);
	}
	
	public static void recursiveReverse(String temp, String result) {
		
		//char[] tempArray =temp.toCharArray();
		if(temp.length() == 1) {
			System.out.println(result + temp.charAt(0));
		}
		else {
			recursiveReverse(temp.substring(0,temp.length()-1), result + temp.charAt(temp.length()-1));
		}
		
	}
	
	
}

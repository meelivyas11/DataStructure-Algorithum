package Array_String;

public class StringReverse {
	
	public static void Que2Main()
	{
	String temp = "abcdefgG";
	String reverseString = reverseStr(temp);
	System.out.println("Reverse : " + reverseString);
	
	finalRev(temp);
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
}

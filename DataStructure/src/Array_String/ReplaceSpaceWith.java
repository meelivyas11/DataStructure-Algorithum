package Array_String;

public class ReplaceSpaceWith {
	
	public static void main(String[] args)
	{
		// Write a method to replace all spaces in a string with ‘%20’.
		String str = "abc de fg hi jkl";
		int count = NumSpace(str);
		String strWithoutSpace = removeSpace(str,count);
		
		System.out.println(strWithoutSpace);
	}
	
	private static int NumSpace(String str)
	{
		int numSpace = 0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) == ' ')
				numSpace++;
		}
		return numSpace;
	}
	
	private static String removeSpace(String str, int count)
	{
		char[] strA = str.toCharArray();
		char[] strNew = new char[str.length()+2*count];
		
		int lastIndex = str.length()+ 2*count;
		strNew[lastIndex-1] = '\0';
		lastIndex--;
		
		for(int i =strA.length-1; i>=0; i--)
		{
			if(strA[i] == ' ')
			{
				strNew[lastIndex] = '0';
				strNew[lastIndex-1] = '2';
				strNew[lastIndex-2] = '%';
				lastIndex = lastIndex -3;
			}
			else
			{
				strNew[lastIndex] = strA[i];
				lastIndex--;
			}
		}
		
		return String.valueOf(strNew);
		
	}
}

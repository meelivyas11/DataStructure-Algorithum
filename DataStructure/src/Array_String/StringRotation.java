package Array_String;


/* Assume you have a method isSubstring which checks if one word is a substring of
another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).

input: s1 = apple, s2 = pleap ==> apple is a substring of pleappleap
input: s1 = apple, s2 = ppale ==> apple is not a substring of ppaleppale
*/

public class StringRotation {
	
	public static void main(String[] args)
	{
		String str1 = "abcde";
		String str2 = "deabc";
		boolean ans = isSubString(str1,str2);
		System.out.println(ans);
	}
	private static boolean isSubString(String s1, String s2)
	{
		int breakPoint =0;
		for(int i=0;i<s1.length(); i++)
		{
			for(int j=0; j<s2.length();j++)
			{
				if(s1.charAt(i) == s2.charAt(j))
				{
					breakPoint= j+1;
					break;
				}
			}
		}
		
		boolean flag = true;
		for(int i=0;i<s1.length(); i++)
		{
			while(flag)
			{
				if(s1.charAt(i) == s2.charAt(breakPoint%s2.length()))
				{
					breakPoint++;
					break;
				}
				
				else 
					flag = false;
			}
		}
		
		if(flag)
			return true;
		else
			return false;
	}
}

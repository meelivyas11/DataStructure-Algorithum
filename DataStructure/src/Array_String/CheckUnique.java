package Array_String;

import java.util.HashSet;

public class CheckUnique {
	
	public static void main(String[] args)
	{
	String temp = "abcdefgG";
	//System.out.println(checkUnique(temp));
	System.out.println(checkUnique2(temp.toCharArray()));
	
	int val = temp.charAt(0);
	System.out.println(val - 'a');
	System.out.println(1<<val);
	
	
	}
	public static boolean checkUnique(String temp)
	{
		for(int  i=0; i<temp.length();i++)
		{
			for(int j=i+1; j<temp.length();j++)
			{
				if(temp.charAt(i) == temp.charAt(j))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkUnique2(char[] temp) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<temp.length-1; i++) {
			if(!set.contains(temp[i]))
				set.add(temp[i]);
			else
				return false;
		}
		return true;
	}
}

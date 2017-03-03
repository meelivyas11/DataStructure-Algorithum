package Array_String;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {
	
	public static void main(String[] args )
	{
		String str1 = "Bad credit";
		String str2 = "dad bcreit";
		
		isAnagram0(str1, str2);
		isAnagram1(str1, str2);
		isAnagram2(str1, str2);
	}
	
	private static void isAnagram2(String a, String b)
	{
		char[] aa = a.replaceAll("\\s", "").toCharArray();
		char[] bb = b.replaceAll("\\s", "").toCharArray();
		
		Arrays.sort(aa); // adds the complexity of O(n log n)
		Arrays.sort(bb);
		
		System.out.println(Arrays.toString(aa) + "::::::" + Arrays.toString(bb));
		
		if(Arrays.toString(aa).equalsIgnoreCase(Arrays.toString(bb)))
		{
			System.out.println("same");
		}
		else
		{
			System.out.println("different");
		}
	}
	
	private static void isAnagram1(String a, String b)
	{
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		
		for(int i = 0; i<a.length(); i++)
		{
			if(hm.containsKey(a.charAt(i)))
			{
				int val = hm.get(a.charAt(i));
				hm.put(a.charAt(i), val+1);
			}
			else
				hm.put(a.charAt(i), 1);
		}
		
		/*for(Character key : hm.keySet())
		{
			System.out.println("key :" + key + " value: " + hm.get(key)) ;
		}*/
		
		for(int i = 0; i<b.length(); i++)
		{
			if(hm.containsKey(b.charAt(i)))
			{
				int val = hm.get(a.charAt(i));
				hm.put(b.charAt(i), val-1);
			}
			else
				hm.put(b.charAt(i), 1);
		}
		
		for(Character key : hm.keySet())
		{
			System.out.println("key :" + key + " value: " + hm.get(key)) ;
		}
		
	}
	
	private static boolean isAnagram0(String str1, String str2)
	{
		if(str1.length() != str2.length())
			return false;
		
		HashMap<Character,Integer> x1 = new HashMap<Character, Integer>();
		HashMap<Character,Integer> x2 = new HashMap<Character, Integer>();
		for(int i=0; i<str1.length();i++)
		{
			if(x1.containsKey(str1.charAt(i)))
			{
				int temp = x1.get(str1.charAt(i));
				x1.put(str1.charAt(i), temp+1);
			}
			else
			{
				x1.put(str1.charAt(i), 1);
			}
			
			if(x2.containsKey(str2.charAt(i)))
			{
				int temp = x2.get(str2.charAt(i));
				x2.put(str2.charAt(i), temp+1);
			}
			else {
				x2.put(str2.charAt(i), 1);
			}
			
		}

		for(char xx1 : x1.keySet())
		{
			if(x1.get(xx1) != x2.get(xx1))
				return false;
		}
		
		for(char xx2 : x2.keySet())
		{
			if(x1.get(xx2) != x2.get(xx2))
				return false;
		}
		
		return true;
	}
	
	
}

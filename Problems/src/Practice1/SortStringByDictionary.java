package Practice1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

//Sort the letters in one word by the order they occur in another in linear time
public class SortStringByDictionary {

	public static void main(String[] args) {
		
		
		String dict = "zhello";
		String givenStr = "llllooeheeeehhhhozzzzzzzzzzz";
		
		sol1(dict, givenStr);
		sol2(dict, givenStr);
		
	}
	public static void sol2(String dict, String givenStr){
		
		HashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		
		for(int i=0; i<dict.length(); i++){
			hm.put(dict.charAt(i), 0);
		}
		
		for(int i=0; i<givenStr.length(); i++){
			if(hm.containsKey(givenStr.charAt(i))) {
				int count = hm.get(givenStr.charAt(i));
				hm.put(givenStr.charAt(i), count+1);
			}
			else {
				hm.put(givenStr.charAt(i), 1);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(Character cc: hm.keySet()){
			int num = hm.get(cc);
			for(int i=0; i<num; i++)
				sb.append(cc);
		}
		
		System.out.println("Result: " + sb.toString());
		
	}
	public static void sol1(String dict, String givenStr){
		HashMap<Character, String> hm = new HashMap<Character, String>();
		
		
		// Reason y we are using LinkedHashSet??
			// HashSet - no ordering
			// LinkedHashSet - Insertion Order
			// TreeSet - Alphabetical Order 
		
		
		Set<Character> uniqueChar = new LinkedHashSet<Character>();
		for(Character c: dict.toCharArray())
		{
			if(!hm.containsKey(c)) {
				hm.put(c, "");
				uniqueChar.add(c);
			}
		}
		
		for(Character a: givenStr.toCharArray()) {
			hm.put(a, hm.get(a).concat(a.toString()));
		}
			
		
		for(Character b: uniqueChar)
			System.out.println(hm.get(b));
	}
}

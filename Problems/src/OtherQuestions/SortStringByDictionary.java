package OtherQuestions;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

//Sort the letters in one word by the order they occur in another in linear time
public class SortStringByDictionary {

	public static void main(String[] args) {
		
		
		String dict = "zhello";
		String givenStr = "llllooeheeeehhhhozzzzzzzzzzz";
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

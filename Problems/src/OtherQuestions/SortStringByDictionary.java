package OtherQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SortStringByDictionary {

	public static void main(String[] args) {
		//Sort the letters in one word by the order they occur in another in linear time
		
		String dict = "hello";
		String givenStr = "llllooeheeeehhhho";
		HashMap<Character, String> hm = new HashMap<Character, String>();
		Set<Character> uniqueChar = new HashSet<Character>();
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

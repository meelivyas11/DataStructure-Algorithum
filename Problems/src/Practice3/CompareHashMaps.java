package Practice3;

import java.util.HashMap;

public class CompareHashMaps {

	public static void main(String[] args) {
		
		HashMap<String,String> hm1 = new HashMap<String,String>();
		hm1.put("firstname", "meeli");
		hm1.put("lastname", "vyas");

		HashMap<String,String> hm2 = new HashMap<String,String>();
		hm2.put("firstname", "meeli");
		hm2.put("lastname", "vyas");
		//hm2.put("age", "29");
		
		
		System.out.println(hm1.entrySet().equals(hm2.entrySet()));
		compareHashmap(hm1,hm2);
	}
	
	
	public static boolean compareHashmap(HashMap<String,String> hm1, HashMap<String,String> hm2) {
		
		if(hm1.size() != hm2.size()) {
			System.out.println("Not Equal - size different");
			return false;
		}
		else if(!hm1.keySet().equals(hm2.keySet())) {
			System.out.println("Not Equal   -  keyset diffferent");
			return false;
		}
		else {
			for(String s : hm1.keySet()) {
				if(hm1.get(s) != hm2.get(s)) {
					System.out.println("Not Equal  - values different");
					return false;
				}
			}
		}
		
		System.out.println("They are Equal");
		return true;
	}
}

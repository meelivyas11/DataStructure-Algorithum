package Practice1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String start = "hit";
		String end = "cog";
		List<String> dict = new ArrayList<String>();
		
		dict.add("hit");
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");
		
		//sol1(start, end, dict);
		sol2(start, end, dict);
		
	}
	
	// Deleting while iterating through the List
	public static void sol2(String start, String end, List<String> dict) {
		String result = start + "->";
		
		if(dict.contains(start)) 
			dict.remove(start);
		
		Iterator<String> it = dict.iterator();
		while(it.hasNext()) {
			String temp = it.next();
			int num = 0;
			if(temp.length()!=start.length()) continue;
			
			for(int i=0; i<start.length(); i++) {
				if(temp.charAt(i) != start.charAt(i)) {
					num++;
				}
			}
			
			if(num >1) continue;
			
			result = result + temp + "->";
			it.remove();
			if(temp.equals(end)) break;
			start = temp;
			
		}
		
		System.out.println("Result is : " + result);
	}
	
	public static void sol1(String start, String end, List<String> dict) {
		
		List<String> visitedWords =  new ArrayList<String>();
		HashMap<String, String> hm = new HashMap<String, String>();
		Queue<String> que = new LinkedList<String>();
		que.add(start);
		while(!que.isEmpty()) {
			String wd = que.poll();
			char[] arr = wd.toCharArray();
			for(int i=0;i<arr.length;i++)
			{
				for(char j='a' ;j<'z'; j++)
				{
					char temp = arr[i];
					arr[i] = j;
					String newWord = new String(arr);
					
					if(!newWord.equals(wd) && dict.contains(newWord)) {
						
						if(!visitedWords.contains(wd))
							visitedWords.add(wd);
						visitedWords.add(newWord);
						que.add(newWord);
						hm.put(newWord, wd);
						
						if(newWord.equals(end)) {
							String output = new String();
							String parent = hm.get(newWord);
							output = newWord + "->" + parent;
							while(parent!=null && !parent.equals(start)) {
								parent = hm.get(parent);
								output = output + "->" + parent;
								
							}
							System.out.println("out:::" + output);
						}
					
					}
					arr[i] = temp;
				}
			}
		}
	}

}

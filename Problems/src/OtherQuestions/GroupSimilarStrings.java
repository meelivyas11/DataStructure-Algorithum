package OtherQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Grouping similar strings in a String array
public class GroupSimilarStrings {

	public static void main(String[] args) {
		
		String[] inputStrArry = {"asd", "dsa", "sda", "we", "ew", "rew"};
		//String[] result = new String[args2.length];
		HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
		String sortedString = "";
		
		for(int i=0; i<inputStrArry.length ; i++)
		{
			char[] charArrayForInputString = inputStrArry[i].toCharArray();
			Arrays.sort(charArrayForInputString);
			sortedString = String.valueOf(charArrayForInputString) ; //new String(charArrayForInputString);
			
			//charArrayForInputString.toString();   -- does not work as it returns a object
			
			
			if (hashMap.containsKey(sortedString)) {
				List<String> containsList = hashMap.get(sortedString);
				containsList.add(inputStrArry[i]);
				//hm.put(result[i], temp);
			}
			else {
				List<String> newList = new ArrayList<String>();
				newList.add(inputStrArry[i]);
				hashMap.put(sortedString, newList);
			}
		}
			
		for(String showValues : hashMap.keySet()) {
			System.out.println(showValues + ":" + hashMap.get(showValues));
		}
	
	
	}
}

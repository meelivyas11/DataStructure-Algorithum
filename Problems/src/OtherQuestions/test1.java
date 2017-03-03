package OtherQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	String[] inputStrArry = {"asd", "dsa", "sda", "we", "ew", "rew"};
	//String[] result = new String[args2.length];
	HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
	String sortedString = "";
	
	for(int i=0; i<inputStrArry.length ; i++)
	{
		char[] charArrayForInputString = inputStrArry[i].toCharArray();
		Arrays.sort(charArrayForInputString);
		sortedString = new String(charArrayForInputString);
		
		if (hashMap.containsKey(sortedString)) {
			List containsList = hashMap.get(sortedString);
			containsList.add(inputStrArry[i]);
			//hm.put(result[i], temp);
		}
		else {
			List newList = new ArrayList<String>();
			newList.add(inputStrArry[i]);
			hashMap.put(sortedString, newList);
		}
	}
		
	for(String showValues : hashMap.keySet()) {
		System.out.println(showValues + ":" + hashMap.get(showValues));
	}
	
	
	}
}

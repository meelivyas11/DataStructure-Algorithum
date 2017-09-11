package Practice1;

import java.util.HashMap;

public class FindOddString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] strArr = {"a", "a", "b", "b", "b", "c", "c"};		
		
		System.out.println(getOdd(strArr));
		
		System.out.println(getOdd2(strArr));
	}
	
	private static String getOdd2(String[] array)
	{
		String oddStr = "";
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
	
		for(int i=0;i<array.length;i++) {
			if(hm.containsKey(array[i])) {
				hm.put(array[i],hm.get(array[i]) + 1);
			}
			else {
				hm.put(array[i], 1);
			}
		}
		
		for(String str : hm.keySet()) {
			if(hm.get(str)%2 != 0)
				oddStr = oddStr + str +  "," ;
		}
		
	    return oddStr;
	}

	private static String getOdd(String[] sortedArray)
	{
		String oddStr = "";
	    for(int i=0;i<sortedArray.length-1;i++)
	    {
	        for(int j=i+1; j<sortedArray.length; j++)
	        {
	            if(sortedArray[i] == sortedArray[j]) {
	                i = i+1;
	                break;
	            }
	            else
	              {
	            	System.out.println("found");
	                  oddStr = sortedArray[i];      
	                  i++; 
	              }
	        }
	    }
	    return oddStr;
	}

}

package Practice2;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array arr and a number n, you have to find whether there exist a subset in arr whose sum is n. You have to print length of the subset. 
 *	1. There exists only one subset like that 
 *	2. All number in arr are positive
 */
public class SubSetSumTarget {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int n = 15;
		List<Integer> result =  getSubSet(arr,  n);
		if(result!=null)
			System.out.println(result);
		else
			System.out.println("On Subset found");
		

	}
	
	private static List<Integer> getSubSet(int[] arr, int n) {
		double pow = Math.pow(2, arr.length) -1;
		
		for(int i=0; i<= pow; i++) {
			String binary = Integer.toBinaryString(i);
			while(binary.length() < arr.length) {
				binary = "0" + binary;
			}
			
			int temp = n;
			List<Integer> lst = new ArrayList<Integer>();
			for(int j =0; j<binary.length() ; j++) {
				if(binary.charAt(j) == '1') {
					temp = temp - arr[j];
					lst.add(arr[j]);
				}
			}
			if(temp == 0) return lst;
		}
		
		return null;
	}

}

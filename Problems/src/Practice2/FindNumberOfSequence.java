package Practice2;

import java.util.ArrayList;
import java.util.List;

/*
 *  Given 3 sorted arrays. Find(x,y,z), (where x is from 1st array, y is from 2nd array, and z is from 3rd array), such that x<y<z. 

	x = element(s) from array 1 
	y= element(s) from array 2 
	z = element(s) from array 3 
	
	I can have more than 1 elements from each array. But at least 1 from each array is mandatory and elements from .
	
	
		int[] arr1 = {3};
        int[] arr2 = {11, 13,  16};
        int[] arr3 = {45};
	
	   Correct Output : 7
	
			(3,11,45)
			(3,13,45)
			(3,13,16,45)
			(3,16,45)
			(3,11,13,45)
			(3,11,16,45)
			(3,11,13,16,45)
	Need to find the number of such sequences.
 */

public class FindNumberOfSequence {

	public static void main(String[] args) {
		
		int[] A = {3};
		int[] B = { 11, 13, 16 };
		int[] C = {45};
		
		List<String> subSetsOfB =  getSubSets(B);
		for(int i = 0; i<A.length; i++) {
			for(int j =0; j<C.length; j++) {
				for(String aSet : subSetsOfB) {
					if(aSet!="") {
						System.out.println(A[i] + " " + aSet + " " + C[j]);
					}
				}
			}
		}
		

	}
	
	private static List<String> getSubSets(int[] B) {
		
		List<String> subSets = new ArrayList<String>();
		
		// powSet of power set of a set with set_size n is ((2^n)-1)
		// String[] str = {"000", "001","010","011","100", "101", "110", "111"};
		
		double powSet = Math.pow(B.length,2)-1;  // 8 for 3 elements
		
		for(int i =0; i<powSet ; i++){
			
			// convert int 0,1...7 to binary and append 0 in the begining if the length of binary is less than 3 (B.length)
			String str = Integer.toBinaryString(i);  
			while(str.length() < B.length) {
				str = "0" + str;
			}
				
			String aSet = "";
			for(int j=0; j<str.length(); j++) {
				// Check if jth bit in the pow_set[i]==1, then jth element from set(i.e. B)
				if(str.charAt(j) == '1') 
					aSet = aSet + " " + B[j];
			}
			subSets.add(aSet);
		}
		
		return subSets;
	}

}

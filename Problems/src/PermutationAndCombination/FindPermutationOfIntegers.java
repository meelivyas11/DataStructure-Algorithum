package PermutationAndCombination;

import java.util.ArrayList;

public class FindPermutationOfIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		permutation("", "abcd");
		System.out.println(getPermutation(3,2));
	}
	
	private static void permutation(String perm, String word) { 
		
		if (word.isEmpty()) { 
			System.out.println(perm + word); 
			} 
		else { 
			for (int i = 0; i < word.length(); i++) { 
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length())); 
				} 
			} 
	}

	
	public static String getPermutation(int n, int k) {
		 
		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}
		
		// change k to be index
		k--;
 
		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}
 
		String result = "";
 
		// find sequence
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			System.out.println("mode in loop" + mod);
			// find the right number(curIndex) of
			int curIndex = k / mod;
			System.out.println("index" + curIndex);
			// update k
			k = k % mod;
			System.out.println("new k:" + k);
			// get number according to curIndex
			result += numberList.get(curIndex);
			// remove from list
			numberList.remove(curIndex);
		}
 
		return result.toString();
	}
}

package Practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * You are given a String S of length N. Now, a good subsequence is one that can be represented in the form (a raised to the power i) (b raised to the power j) (c raised to the power k) where i>=1, j>=1 and k>=1. 
 * For example ,if i=2, j=1, k=3, it represents the string aabccc. In short, a good subsequence is a subsequence that first consist of i 'a' characters, followed by j 'b' characters, followed by k'c' characters, where i>=1, j>=1 and k>=1 
	
 *	Now, you need to find the number of good subsequences of String S. As the number of such subsequences could be rather large, print the answer Modulo 
 *	(10 raised to the power 9) + 7. 
	
	Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different. 
	
	Input : abcabc 
	Output : 7 
	Explanation: Valid sub sequences are(1-based indexing): 
	{1,2,3} {1,2,6} {1,5,6} {4,5,6} {1,2,5,6} {1,4,5,6} {1,2,3,6}
	

	Hint: To get the Numbers :
	  
	    if(input[i]=='a')
		{
			DP[0]=(2*DP[0] + 1);
		}
		else if(input[i]=='b')
		{
			DP[1]=(DP[0]+2*DP[1]);
		}
		else
		{
			DP[2]=(DP[1]+2*DP[2]);
		}
		
		__|	a |	a |	b |	c |	a |	b |	c
		a |	1 |	3 |	0 |	0 |	7 | 0 | 0 
		b |	0 |	0 |	3 |	0 |	0 | 13| 0
		c | 0 |	0 |	0 |	3 |	0 |	0 |	19

 */
public class FindNumberOfSequence_Valid {

	public static void main(String[] args) {
		String str = "aabcabc";
		
		List<String> sequences = getAllSequences(str.toCharArray(), 3);	
		for(String aa : sequences) {
			System.out.println(aa);
		}
		
		System.out.println();
		TotalNumOfValidSequences(str.toCharArray(), new char[] {'a','b','c'});
	}
	
	private static void TotalNumOfValidSequences(char[] str, char[] uniqueChars) {
		
		int[][] dp = new int[uniqueChars.length][str.length];
		for(int i=0; i<uniqueChars.length ; i++) {
			for(int j=0; j<str.length; j++) {
				dp[i][j] = 0;
			}
		}
		
		int[] valRecorder = new int[uniqueChars.length];
		Arrays.fill(valRecorder, 0);
		
		for(int col = 0; col < str.length ; col++) {
			for(int row = 0; row < uniqueChars.length ; row++) {
				
				int prev = 1;
				if(row > 0) prev = valRecorder[row-1];
				if(uniqueChars[row] == str[col]) {
					valRecorder[row] = prev + (valRecorder[row]*2);
					dp[row][col] = valRecorder[row];
				}
			}
		}
		
		// col = str(e.g: abcabc ) and row = a,b,c,.. all unique characters
		for(int i=0; i<uniqueChars.length ; i++) {
			for(int j=0; j<str.length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("Final count using dp-lastRow lastCol : " + dp[uniqueChars.length-1][str.length-1] + " OR using single array : " + valRecorder[uniqueChars.length-1]);
	}
	
	private static List<String> getAllSequences(char[] str, int numOfUniqueChars) {
		List<String> sequences  = new ArrayList<String>();
		double num = Math.pow(2, str.length)- 1;
		
		for(int i =0; i<= num ; i++) {
			
			String aSequence = "";
			String seqVal = "";
			
			// get the binary number
			String binary = Integer.toBinaryString(i);
			while(binary.length() < str.length)
				binary = "0" + binary;
			
			for(int j =0; j<binary.length() ; j++) {
				if(binary.charAt(j) == '1') {
					aSequence = aSequence + ":" + j;
					seqVal = seqVal + str[j];
				}
			}
			
			if(isValid(seqVal, numOfUniqueChars) && seqVal.contains("a") && seqVal.contains("b") && seqVal.contains("c"))
				sequences.add(aSequence + " -> " + seqVal);
		}
		
		
		return sequences;
	}
	
	private static boolean isValid(String s, int numOfUniqueChars) {
		
		if (s.length() < numOfUniqueChars) return false;
		char[] arr = s.toCharArray();
		int curr = arr[0];
		for(int i=1; i< arr.length ; i++) {
			if(arr[i] > curr ) curr = arr[i];
			if(arr[i] < curr ) return false;
		}
		return true;
	}

}

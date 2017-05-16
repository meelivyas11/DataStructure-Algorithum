package InPerson;

import java.util.Arrays;

/*
 *  A = {1,2,4,-6,5,7,9,....} 
	B = {3, 6, 3, 4, 0 .......} 
	n = 5 -> pairs whose sum is n 

	Output = (1,4), (5,0)....(A's element, B's element)
 */
public class PairSumTarget {

	public static void main(String[] args) {
		int[] A = {1,2,4,-6,5,7,9};
		int[] B = {3, 6, 3, 4, 0 };
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int ai = 0, bj = B.length-1, target = 5;
		
		while(ai<=A.length && bj >= 0) {
			if(A[ai] + B[bj] == target) {
				System.out.println("(" + A[ai] + "," + B[bj] + ")");
				ai++; bj--;
			}
			else if(A[ai] + B[bj] > target) bj--;
			else ai++;
		}

	}

}

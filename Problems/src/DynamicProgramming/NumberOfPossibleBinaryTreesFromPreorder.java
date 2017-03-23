package DynamicProgramming;

// Number of nodes  		= 0		1		2		3		4		5
// Number of Binary Trees	= 1		1		2		5		14		42


/*
 *  T[2] = T[0]*T[1] + T[1]*T[0] = 2
 *  T[3] = T[0]*T[2] + T[1]*T[1] + T[2]*T[0]  = 5
 *  T[4] = T[0]*T[3] + T[1]*T[2] + T[2]*T[1] + T[3]*T[0]  = 14
 */

public class NumberOfPossibleBinaryTreesFromPreorder {

	public static void main(String[] args) {
		
		int n = 4;
		int[] T = new int[n+1];
		
		T[0] = 1;
		T[1] = 1;
		
		for(int i =2; i<=n ;i++) {
			for(int j =0; j<i ; j++) {
				T[i] = T[i] + T[j] * T[i-j-1];
			}
		}

		System.out.println(T[n]);
	}

}

package InPerson;

import java.util.Arrays;

/*
 * Given an mXn Sorted matrix and a value X. Every row is sorted and first number of every row is greater than last number of previous row Find the value X in most efficient way.
 */
public class FindXfromSortedMatrix_8 {

	public static void main(String[] args) {
		/*
		 * 322782641
  
  
  122234678...           ...,322782641, ?,                          ... 876432221
  
  
  123 -> 132    132->213
  
  1324 -> 1, 234 -> 2, 34              visitedlst = 2, 1, 3, 4
  324  -> 3, 134 -> 1, 34
  24 -> 2, 34 -> 3, 4
  
  
  322782641
  322782614 X
  
  3654321
  4653321
  
  4123356
  
  2641 -> 6421
		 */
		
		
		int[] input = { 3, 2, 2, 7, 8, 2, 6, 4, 1 };
		for (int i = input.length - 2; i >= 0; i--) {
			if (input[i] > input[i + 1]) { // 2>4 == false
				// do decending i=5 (2) to i=8 ------------------- i=6 (2)
				int temp = input[i + 1];
				input[i + 1] = input[i];
				input[i] = temp; // replace 2by6 hence 322786241 ----------
									// replace 2 and 4 hence 322786421
				i = input.length - 1; // repoint to 4 and repeat steps
										// ----------
			}
		}

		for (int x = 0; x < input.length; x++)
			System.out.print(input[x]);

		int i = input.length - 1;
		while (i > 0) {
			if (input[i] > input[i - 1]) {
				i--;
				break;
			}
		}
		// i= 5 -- input[5]= 2

		int[] temp = new int[input.length - i + 1];
		int y = 0;
		for (int x = i; x < input.length; x++) {

			temp[y] = input[x];
			y++;
		}

		Arrays.sort(temp); // 1,2,4,6

		y = temp.length-1;
		for (int z = i; z < input.length - 1; z++) {
			input[z] = temp[y];
			y--;
		}

		System.out.println();
		for (int x = 0; x < input.length; x++)
			System.out.print(input[x]);

	}

}

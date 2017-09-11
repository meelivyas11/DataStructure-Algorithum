package Practice1;

import java.util.Stack;

public class Get_Last_k_numbers_average {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		int k=6;
		float avg;
		int sum = 0;
		
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
		
		// Solution 1
		for(int i=0;i<arr.length; i++)
			s.push(arr[i]);
		
		for(int j=0;j<k; j++)
			sum += s.pop();
		
		avg = (float) sum/k;
		System.out.println("First sol average: " + avg);
		
		// Solution 2
		if(k>arr.length)
			System.out.println("K is too large");
		else
		{
			for(int m=arr.length-1; m<0 && k>=0; m--) {
				sum += arr[m];
				k--;
			}
		}
			
		avg = (float) sum/k;
		System.out.println("Second sol average: " + avg);
		
	}

}

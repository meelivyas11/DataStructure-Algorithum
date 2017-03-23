package OtherQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumZero {

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
		
		int[] numbers = {-1,-2,0,-3,1,2,5};
				
		List<String> result = sol1(numbers);
		System.out.println("Solution 1");
		for(String s : result) {
			System.out.println(s);
		}
		
		result = sol2(numbers);
		System.out.println("\nSolution 2");
		for(String s : result) {
			System.out.println(s);
		}
	}
	
	// Complexity O(n^3)
	private static List<String> sol1(int[] numbers) {
		
		List<String> result = new ArrayList<String>();
		
		for(int i=0; i<numbers.length-2; i++)
		{
			for(int j = i+1; j< numbers.length -1 ; j++) 
			{
				for (int k = j+1; k<numbers.length; k++)
				{
					if(numbers[i] + numbers[j] + numbers[k] == 0) 
						result.add(String.valueOf(numbers[i])+ ":" + String.valueOf(numbers[j]) + ":" + String.valueOf(numbers[k]));
				}
			}
		}
		
		return result;
	}
	
	
	  // O(Log n) + O(n^2) = O(n^2)  (answer is correct but doubtful about how)
	private static List<String> sol2(int[] numbers) {
		List<String> result = new ArrayList<String>();
		
		Arrays.sort(numbers); 
		int target = 0;
		for(int i=0 ; i< numbers.length-2 ; i++){
			int remainingTrg = target - numbers[i];
			
			int start = i+1;
			int end = numbers.length-1;
			while(start<end){
				if(numbers[start] + numbers[end] == remainingTrg) {
					result.add(String.valueOf(numbers[i])+ ":" + String.valueOf(numbers[start]) + ":" + String.valueOf(numbers[end]));
					start++; end--;
				}
				else if (numbers[start] + numbers[end] > remainingTrg) {
					end--;
				}
				else {
					start++;
				}
			}
		}
		
		return result;
	}
}

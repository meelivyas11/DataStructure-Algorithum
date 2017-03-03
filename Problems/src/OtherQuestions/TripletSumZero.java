package OtherQuestions;

import java.util.ArrayList;
import java.util.List;

public class TripletSumZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] numbers = {-1, 0, 1,2,-1,-4};
				
		for(int i=0; i<numbers.length; i++)
		{
			List<Integer> result = new ArrayList<Integer>();
			result.add(i);
			int target = 0 - numbers[i];
			
			getTriplet(result, target, numbers, i);
			System.out.println(result.get(0) + "+" + result.get(1) + "+" + result.get(2));
		}
		
	}
	
	public static void getTriplet(List<Integer> result, int target, int[] numbers, int index) {
		for(int j=0 ; j< numbers.length; j++)
		{
			//for(int )
		}
		
	}

}

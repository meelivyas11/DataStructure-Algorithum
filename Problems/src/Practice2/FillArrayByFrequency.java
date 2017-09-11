package Practice2;

public class FillArrayByFrequency {

	/*
	 *  Fill the array with elements from 0 to 9 based on their frequency. 
	 *	a[1]=3 means, 1 is repeated for 3 times(1 must present 3 times in that array) 
	 *	a[2]=4 means 2 is repeated for 4 times.(2 must present twice in that array)
	 */
	public static void main(String[] args) {
		
		int[] input = {1,3,4,6,5,4,2,8,4,3};
		
		// total number of elements in output array
		int totalCnt = 0;
		for(int i =0; i< input.length ; i++){
			totalCnt = totalCnt + input[i];
		}
		
		int [] output = new int[totalCnt];
		int outIndex = 0;
		for(int i=0; i<input.length; i++){
			for(int j =0; j< input[i] ; j++) {
				output[outIndex] = i;
				outIndex++;
			}
		}
		
		for(int i=0; i<output.length; i++){
			System.out.print(output[i] + "\t");
		}
	}
}

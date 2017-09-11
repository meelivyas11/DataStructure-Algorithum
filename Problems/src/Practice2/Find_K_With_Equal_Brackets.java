package Practice2;

public class Find_K_With_Equal_Brackets {

	/*
	 *  Find K which decides the number of open brackets are equal to the number of closed brackets. 

		input : (()) 
		output : 2 
		Reason : if we divide the string at 2nd position, we get two open brackets and two closing brackets, and they are same . 
		
		input : (())))( 
		output : 4 
		Reason : if we divide the string(not necessarily equally) at 4rth position, we have (()) on the left side and on the right side we have ))( , as you can see, on the left half, we have two opening brackets and on the right half we have two closing brackets and they are equal . 
		
		input : )) 
		output : 2 
		Reason : there is no open brackets , so if we divide taking the whole string's length, we have )) on the left half and nothing on the right half. Now you can see that on the left half there is no open brackets and on the right half there is no closed brackets. 
		
		This question should be clear by now and remember you have to find out that K .
		
	 */
	public static void main(String[] args) {
		String input = "))";
	
		int k = input.length();   // for last case
		
		for(int i=0; i<input.length(); i++){
			if(numberOfOccurance('(', input.substring(0, i)) == numberOfOccurance(')', input.substring(i))){
				k =i;
			}
		}
		System.out.println(" The K is : " + k);
	}
	
	private static int numberOfOccurance(char bracket, String str) {
		int cnt = 0;
		for (int i =0; i<str.length(); i++) {
			if(str.charAt(i) == bracket)
				cnt++;
		}
		return cnt;
	}
	
}

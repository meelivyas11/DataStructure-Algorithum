package InPerson;

public class MaxConsecutiveRepeatedCharacter {

	/*
	 * Find the max consecutive repetitive character 
	 * A = "ffgggtvshjsdhjfffffffhvjbjcharu" 
	 * Output : f -> 7
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "ffgggtvshjsdhjfffffffhvjbjcharu";
		char result = A.charAt(0); 
		int max =0;
		
		for(int i =0; i < A.length()-1; i++) {
			int count =1;
			char r = A.charAt(i);
			i++;
			
			while(A.charAt(i) == r) {
				count++;
				i++;
			}
			if(count > max) {
				max = count;
				result = r;
			}
		}
		
		System.out.println(result + "->" + max);
		
	}

}

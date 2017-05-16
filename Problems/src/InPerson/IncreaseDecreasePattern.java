package InPerson;

public class IncreaseDecreasePattern {

	/*
	 *  Given a pattern containing only Is and Ds. I for increasing and D for decreasing. Devise an algorithm to print the MINIMUM number following that pattern. Digits from 1-9 and digits can’t repeat. 

		Example: 
		1. Input: D Output: 21 
		2. Input: I Output: 12 
		3. Input: DD Output: 321 
		4. Input: II Output: 123 
		5. Input: DIDI Output: 21435 
		6. Input: IIDDD Output: 126543 
		7. Input: DDIDDIID Output: 321654798
		
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "DIDIDDI";
		char[] input = pattern.toCharArray();
        int current = 1;
        int curMax = 1;
        for (int a = 0; a < input.length; a++) {
            if (input[a] == 'I') {
                printNumbers(current, curMax);
                current++;
                curMax = current;
            } else if (input[a] == 'D') {
                current++;
            }
        }
        printNumbers(current, curMax);
	}

	public static void processInput(String pattern) {
        
     }

    public static void printNumbers(int from, int to) {
        for (int m = from; m >= to; m--)
            System.out.print(m);
    }
}

package Practice2;

import java.util.Stack;

/*
 * How to verify the string which contains alpha-bates,parenthesis and signglle/double quote 
	Ex: AB(CD{"GH"}) is valid 
	"A()B' is invalid
 */
public class IsStringValid {

	public static void main(String[] args) {
		String s1 ="AB(CD{\"GH\"})";
		String s2 ="\"A()B\'CCC";
		System.out.println("Given String is Valid? :" + isStringValid(s2));
	}

	private static boolean isStringValid(String str) {
		char[] start = {'(', '{', '['};
		char[] end = {')', '}', ']'};
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<str.length(); i++) {
			char current = str.charAt(i);
			if(Character.isAlphabetic(current)) continue;
			else if(isStartEnd(current,start)) { stack.push(current); continue; }
			else if(current == '\"' || current == '\'') {
				if(current == '\"' && !stack.isEmpty() && stack.peek().charValue() == '\"') {
					stack.pop();
				}
				else if(current == '\'' && !stack.isEmpty() && stack.peek() == '\'') {
					stack.pop();
				}
				else {
					stack.push(current);
				}
			}
			else if(isStartEnd(current,end)) {
				if(isStartMatchEnd(current,stack.peek().charValue())) {
					stack.pop();
				}
				else { return false;}
			}
		}
		
		if(stack.isEmpty()) return true;
		return false;
	}

	private static boolean isStartMatchEnd(char end, char start) {
		if(start=='(' & end == ')') return true;
		else if(start=='{' & end == '}') return true;
		else if(start=='[' & end == ']') return true;
		else return false;
	}

	private static boolean isStartEnd(char current, char[] arr) {
		for(int j=0; j<arr.length ; j++) {
			if(arr[j] == current) return true;
		}
		return false;
	}

}

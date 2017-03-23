package Array_String;

public class IsPalindrome {

	public static void main(String[] args) {
		String str = "badab";
		
		String reversedStr = (new StringBuffer(str)).reverse().toString();
		
		if(str.equalsIgnoreCase(reversedStr)) 
			System.out.println("Its Palindrome");
		else 
			System.out.println("Its not Palindrome");
	}
}

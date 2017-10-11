package Practice3;

public class CharacterClassMethods {
	
	public static void main(String[] args) {
		letter(); System.out.println();
		alphabet(); System.out.println();
		alphaNumeric(); System.out.println();
	}
	
	public static void letter() {
		String characters = "qE35 $0%-^";
		for(int i = 0; i < characters.length(); i++) {
			 if(Character.isLetter(characters.charAt(i))) {
				 System.out.println("Given character : " + characters.charAt(i) + " is a letter");
			 }
			 else {
				 System.out.println("Given character : " + characters.charAt(i) + " is not a letter");
			 }
		}
	}
	
	public static void alphabet() {
		String characters = "qE35 $0%-^";
		for(int i = 0; i < characters.length(); i++) {
			 if(Character.isAlphabetic(characters.charAt(i))) {
				 System.out.println("Given character : " + characters.charAt(i) + " is a alphabet");
			 }
			 else {
				 System.out.println("Given character : " + characters.charAt(i) + " is not a alphabet");
			 }
		}
	}
	
	
	public static void alphaNumeric() {
		String characters = "qE35 $0%-^";
		for(int i = 0; i < characters.length(); i++) {
			 if(Character.isAlphabetic(characters.charAt(i)) || Character.isDigit(characters.charAt(i)) ) {
				 System.out.println("Given character : " + characters.charAt(i) + " is a alphaNumeric");
			 }
			 else {
				 System.out.println("Given character : " + characters.charAt(i) + " is not a alphaNumeric");
			 }
		}
	}
}


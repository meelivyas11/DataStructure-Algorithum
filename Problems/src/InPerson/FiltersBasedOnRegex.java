package InPerson;

/*
 * If a string is matched to any filter, it is in the black list, otherwise not. 
	Design a data structure and implement following two functions. 
	
	addFilter(filter) 
	isInBlackList(string) 
	
	filters are in the form of 
	“a*b” 
	“abc” 
	“aa*b” 
	having at most one star, which matches 0 or more chars.
 */
public class FiltersBasedOnRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regx = "aa*b";
		String str = "aaaaaaaaaaaaaab";
		
		boolean flag = match(regx.toCharArray(), str.toCharArray());
		System.out.println("My function output : " +  flag);
		System.out.println("Built in funtion output : " + str.matches(regx));
	}
	
	private static boolean match(char[] filter, char[] str) {
		boolean flag = true;
		
		int f=0, s = 0;
		while(f < filter.length-1 || s <str.length-1) {
			if(filter[f] == str[s]) {
				if(f+1< filter.length)
					f++; 
				if(s+1 < str.length)
					s++;
			}
			else if(filter[f] == '*'){
				while(filter[f-1] == str[s] )
					s++;
				f++;
			}
			else {
				return false;
			}
		}
		
		return flag;
	}

}

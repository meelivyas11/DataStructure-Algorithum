package Practice2;

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
		String regx = "ab*c";
		//String str = "ac";
		String str = "abbbbbbbbc";
		
		boolean flag = match(regx.toCharArray(), str.toCharArray());
		
		System.out.println("My function output : " +  flag);
		System.out.println("Built in funtion output : " + str.matches(regx));
	}
	
	private static boolean match(char[] filter, char[] str) {
		int f = 0, s = 0, flen = filter.length, slen = str.length;
		
		while(f<flen && s<slen) {
			if(filter[f] == str[s]) {
				if(f<flen) f++;
				if(s<slen) s++;
			}
			else {
				if(filter[f] == '*') {
					if(f==0) {f++; continue;}
					while(str[s] == filter[f-1] && s<slen) {
						s++;
					}
					f++;
				}
				else if(f+2<flen && filter[f+1]=='*') {
					f +=2;
				}
				else {
					return false;
				}
			}
		}
		
		if(f!=flen || s!=slen) return false;
		return true;
	}
}

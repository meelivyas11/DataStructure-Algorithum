package Practice2;

import java.util.Map;
import java.util.TreeMap;

/*
 *  Write a program to compress a string and send it a over a network and uncompress it on the receivers end
 *  
 *  eg: compress "ABCBCEBCBCEBCBCE" to "A3[2[BC]E]"
 */
public class CompressDecompressString {
	
	static Map<Integer, String> result = new TreeMap<Integer, String>();

	public static void main(String[] args) {
		String res = "";
		String str = "abcbcbc";
		System.out.println("Original String is: " + str);
		for(int i=1; i<=str.length()/2; i++) {
			res = compress(str, i);
			result.put(res.length(), res);
		}
		
		for(int inx: result.keySet()) {
			System.out.println(inx + ":::" + result.get(inx));
		}
		
		System.out.println("Compressed String:" + result.get(7));
		System.out.println("DeCompressed String " + decompress(result.get(7)));
	}
	
	private static String compress(String str, int count)
	{
		int curr =0;
		StringBuffer res= new StringBuffer();
		while(curr+count < str.length()) {
			String aa = str.substring(curr, curr+count);
			int num =1;
			curr = curr+count;
			while(curr+count<str.length() && aa.equals(str.substring(curr, curr+count)) ) {
				curr= curr+count;
				num++;
			}
			res.append(aa + num);
			//i= i+count;
		}
		
		// adding the remaining characters 
		if(curr<str.length())
			res.append(str.substring(curr, str.length()));
		
		return res.toString();
	}
	
	private static String decompress(String str) {
		int i=0;
		StringBuffer res = new StringBuffer();
		while(i<str.length()) {
			String temp = String.valueOf(str.charAt(i)); i++;
			while(i<str.length() && !Character.isDigit(str.charAt(i))) {
				temp = temp + str.charAt(i);
				i++;
			}
			
			int n = 1;
			if(i<str.length()) {
				String num = String.valueOf(str.charAt(i)); i++;
				while(i<str.length() && Character.isDigit(str.charAt(i))) {
					num = num + str.charAt(i);
					i++;
				}
				n = Integer.valueOf(num);
			}
			
			for(int j=0; j<n; j++) {
				res.append(temp);
			}
		}
		return res.toString();
	}


	
}
 
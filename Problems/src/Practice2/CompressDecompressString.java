package Practice2;

/*
 *  Write a program to compress a string and send it a over a network and uncompress it on the receivers end
 *  
 *  eg: compress "ABCBCEBCBCEBCBCE" to "A3[2[BC]E]"
 */
public class CompressDecompressString {

	public static void main(String[] args) {
		String res = "";
		String str = "ababab";
		System.out.println("Original String is: " + str);
		for(int i=1; i<str.length()/2; i++) {
			res = compress(str, i);
			if(res.length() < str.length()) break;
		}
		System.out.println("Compressed String:" + res);
		
		System.out.println("DeCompressed String " + decompress(res));
	}
	

	private static String compress(String str, int count)
	{
		int i =0;
		StringBuffer res= new StringBuffer();
		while(i+count <= str.length()) {
			String aa = str.substring(i, i+count);
			int num =1;
			i = i+count;
			while(i+count<str.length() && aa.equals(str.substring(i, i+count)) ) {
				i= i+count;
				num++;
			}
			res.append(aa + num);
			//i= i+count;
		}
		
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
			String num = String.valueOf(str.charAt(i)); i++;
			while(i<str.length() && Character.isDigit(str.charAt(i))) {
				num = num + str.charAt(i);
				i++;
			}
			int n = Integer.valueOf(num);
			for(int j=0; j<n; j++) {
				res.append(temp);
			}
		}
		return res.toString();
	}


	
}
 
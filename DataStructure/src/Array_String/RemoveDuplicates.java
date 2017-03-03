package Array_String;

public class RemoveDuplicates {
	
	public static void main(String[] args)
	{
		String temp = "aaaabbbbzfsdfsdfsddgrtyrtyrtyryrtyrtyrytvbnvnvnvnbn";
		//removeDup(temp);
		removeDuplicates(temp.toCharArray());
	}
	
	public static void removeDuplicates(char[] str) {
		 if (str == null) return;
		 int len = str.length;
		 if (len < 2) return;
		
		 int tail = 1;
		
		 for (int i = 1; i < len; ++i) {
			 int j;
			 for (j = 0; j < tail; ++j) {
				 if (str[i] == str[j]) break;
			 }
			 if (j == tail) {
				 str[tail] = str[i];
				 ++tail;
			 }
		 }
		 str[tail] = 0;
		 
		 System.out.println(str);
	}
	
	public static void removeDup(String tempa)
	{
		String output = new String();
		char[] temp = tempa.toCharArray();
		
	    for (int i = 0; i < temp.length; i++) {
	    	if(temp[i] != '\0')
	    	{
		    	output = output + temp[i];
		        for (int j = i+1; j < temp.length; j++) {
		            if (temp[i] == temp[j]) {
		            	temp[j] = '\0';
		            }
		        }
	    	}
	    }
	    System.out.println(output);
	}
}

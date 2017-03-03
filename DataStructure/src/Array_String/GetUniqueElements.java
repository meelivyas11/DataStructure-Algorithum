package Array_String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class GetUniqueElements {
	public static void main(String[] arg) {
		int[] data = {1,2,3,1,2,3,1,2,4,5,6,6,4,2};
		//getUniqueArray(data);
		getUniqueArray2(data);
	}
		
	public static void getUniqueArray(int [] a1)
	 {
	    int countDup = 0;
	    Arrays.sort(a1);
	    
	    int prev = a1[0], k =0; 
	    for(int i=1 ; i< a1.length; i++)
	    {
	       if(prev == a1[i])
	       {
	          a1[i] = 'X'; 
	          countDup++;
	       }
	       else
	        {
	         prev = a1[i];
	        }  
	    }
	   
	    int b[] =  new int[a1.length-countDup];
	    for(int j=0; j<a1.length; j++)
	    {
	    if(a1[j] != 'X' )
	    {
	        b[k] = a1[j];
	        k++;
	    }
	   }
	    
	   for(int m=0;m<b.length;m++)
	    {
	    	System.out.print(b[m]);
	    }
	}
	
	public static void getUniqueArray2(int [] a1) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<a1.length-1; i++) {
			set.add(a1[i]);
		}
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		
	}
	
}

package Practice2;

import java.util.ArrayList;
import java.util.List;

/*
 * Given two sorted arrays A and B that may have repeated elements. 
 * Form a new sorted array C that contains the elements of A and B [Condition : You are not allowed to merge the two arrays and then sort. ]
 */
public class RemoveDuplicatesFrom2Lists {

	public static void main(String[] args) {
		int[] A = {1,2,3};
		int[] B = {3,4,5};
		
		List<Integer> res = new ArrayList<Integer>();
		
		int i=0, j=0;
		while(i<A.length && j<B.length) {
			if(A[i] < B[j]) { res.add(A[i]); i++;}
			else if(B[j] < A[i]) {res.add(B[j]); j++;}
			else if(A[i] == B[j]) { res.add(A[i]); i++;j++;}
			//else { res.add(A[i]); res.add(B[j]); i++;j++;}
		}
		
		while(i<A.length) {	res.add(A[i]); i++;	}
		while(j<B.length) {	res.add(B[j]); j++;	}
		
		
		/*
		 *  Instead of using two while loops above 
		 *  another way to achieve it:
		 *  
		 *  if(j<B.length)
		 *  {
		 *  	i =j;
		 *  	A = B;
		 *  }
		 *  while(i<A.length) {	res.add(A[i]); i++;	}
		 * 
		 */
		
		for(Integer aa : res) {
			System.out.print(aa + ",");
		}
	}

}

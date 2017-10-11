package Sorting;

public class ShellSorting {
	
	// this is similar to insertion sort with average complexity as O(n^2)
	public static void main(String[] args) {
		
		int [] a = {7,6,34,22,5,8,2,3};
		
		int interval = a.length/2; 
		
		while(interval > 0) {
			for(int i = 0+interval; i < a.length ; i++) {
			
				int temp = a[i];  
				int c = i;  
				
				while(c-interval >=0 && a[c-interval] > temp ){
					a[c] = a[c-interval];
					c = c - interval;
				}
				a[c] = temp;
			}
			interval = interval/2;   // same as 'interval /=2'
		}
		System.out.println();
		for(int j=0;j<a.length;j++)
			System.out.print(a[j] + "\t" );		
	}

}

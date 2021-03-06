package Sorting;

public class InsertionSorting {

	// average complexity as O(n^2)
	public static void main(String[] args) {
		int [] a = {7,6,3,29,5,8,22,34};
		
		for(int i=1;i<a.length; i++)
		{
			int temp = a[i];
			int c = i;
			
			while(c>0 && a[c-1] > temp)
			{
				a[c] = a[c-1];
				c--;
			}
			a[c] = temp;
		}
		
		for(int j=0;j<a.length;j++)
			System.out.print(a[j] + "\t" );
	}

}

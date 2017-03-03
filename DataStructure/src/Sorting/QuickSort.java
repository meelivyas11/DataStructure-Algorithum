package Sorting;

public class QuickSort {

	public static void main(String[] args) {
		
		int [] arr = {7,6,34,22,5,8,2,3,58,69,44,53,12,75};
		quicksort(arr, 0 , arr.length-1);
		
		for(int j=0;j<arr.length;j++)
			System.out.print(arr[j] + "\t" );		
	}
	
	public static void quicksort(int[] temp, int low, int high) {
		
		int mid = low + (high-low) /2 ;
		int pivotVal = temp[mid];
		
		int start = low;
		int end = high;
		
		while(start<=end) {
			while(start<mid && temp[start] < pivotVal)
				start++;
			while(end > mid && temp[end] > pivotVal)
				end--;
			if(temp[start] > temp[end]) {
				int xx = temp[start];
				temp[start] = temp[end];
				temp[end] = xx;
				start++;
				end--;
			}
			else{
				start++;
				end --;
			}
		}
		
		for(int j=0;j<temp.length;j++)
			System.out.print(temp[j] + "\t" );
		System.out.println();
		
		if (low < end)
			quicksort(temp, low, end);
 
		if (high > start)
			quicksort(temp, start, high);
	}

}

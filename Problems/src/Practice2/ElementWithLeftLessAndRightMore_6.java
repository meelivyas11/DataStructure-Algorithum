package Practice2;

/*
 *  Given an array , find the element (say X) that has all the elements less that it to its left side and all the elements greater to it on its right side. 
 *	The left and right elements of X need not be in sorted form.
 *	 
 *	e.g. arr[] = 5,4,3,7,4,1,2,8,10
 *	Output - 8 (all elements at left side are lesser than 8 and all elements at right side are greater than 8).
 */
public class ElementWithLeftLessAndRightMore_6 {

	public static void main(String[] args) {
		int[] arr = {5,4,3,7,4,1,2,8,10};
		for(int x =1; x<arr.length-1; x++) {
			boolean flag = true;
			for(int i=0; i<arr.length; i++) {
				if(i==x) continue;
				else if(i<x) {
					if(arr[i] > arr[x]) {flag = false; break;}
				}
				else if(i>x) {
					if(arr[i] < arr[x]) {flag = false; break; }
				}
			}
			if(flag) { System.out.println("The Value of X is: " + arr[x]); break; }
				
		}
	}
}

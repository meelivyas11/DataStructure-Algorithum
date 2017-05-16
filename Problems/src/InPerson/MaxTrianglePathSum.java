package InPerson;


/*
 *  
 *  Problem_1 :
 *  Maximum triangle path Sum : Starting from the top of a pyramid of numbers like below, you can walk down going one step on the right or on the left, until you reach the bottom row: 
	55 
	94 48 
	95 30 96 
	77 71 26 67 
	
	One of such walks is 55 -> 94 >- 30 -> 26. You can compute the total of the numbers you have seen in such walk, in this case it’s 205. 
	
	Your problem is to find the maximum total among all possible paths from the top to the bottom row of the triangle. In the little example above it’s 321.
	
	Problem2:
	Given a diamond shape matrix, find the minimum path sum from top to bottom. 
	Each step you may move to adjacent numbers on the row below.
	
	
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3],
	   [2,5,4],
	    [6,4],
		 [1]
	]
	
 */
public class MaxTrianglePathSum {

	public static void main(String[] args) {
		problem1(); problem2();
	}
	
	public static void problem1() {
		int[][] grid = { {55}, 
						 {94, 48},
						 {95, 30, 96}, 
						 {77, 71, 26, 67} };
		int sum = 0;
		for(int i =0; i<grid.length; i++) {
			int max = grid[i][0];
			for(int j=0; j< grid[i].length; j++){
				if(grid[i][j] > max)
					max = grid[i][j];
			}
			sum += max;
		}
		System.out.println("The sum of max path is: " + sum);
	}
	
	public static void problem2() {
		int[][] grid = { {2},
					    {3,4},
					   {6,5,7},
					  {4,1,8,3},
					   {2,5,4},
					    {6,4},
						 {1} };
		int sum = 0;
		for(int i =0; i<grid.length; i++) {
			int min = grid[i][0];
			for(int j=0; j< grid[i].length; j++){
				if(grid[i][j] < min)
					min = grid[i][j];
			}
			sum += min;
		}
		System.out.println("The sum of min path is: " + sum);
	}
}

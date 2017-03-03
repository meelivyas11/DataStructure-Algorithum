package Array_String;

public class RotateMatrix {
	
	public static void main(String[] args)
	{
		int[][] matrix = { {4,3,2,1},
						   {5,6,7,8},
						   {9,10,11,12},
						   {13,14,15,16}};
		
		rotate(matrix, 4);
	}
	
	public static void rotate(int[][] matrix, int n) {
	  /*  for (int layer = 0; layer < n / 2; ++layer) {
	     int first = layer;
	     int last = n - 1 - layer;
	     for(int i = first; i < last; ++i) {
	      int offset = i - first;
	      int top = matrix[first][i]; // save top
	     // left -> top
	      matrix[first][i] = matrix[last-offset][first];   
	
	      // bottom -> left
	      matrix[last-offset][first] = matrix[last][last - offset];
	
	      // right -> bottom
	      matrix[last][last - offset] = matrix[i][last];
	
	      // top -> right
	      matrix[i][last] = top; // right <- saved top
	     }
	    }*/
		
		int[][] target = new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				target[j][n-i-1] = matrix[i][j];
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}	
		
	    System.out.println("**************************");
		  
		for(int i=0; i<n ; i++)
		{
		  	for (int j=0 ; j<n; j++)
		   	{
		   		System.out.print(target[i][j] + " ");
		   	}
		   	System.out.println();
	    }
	}
}

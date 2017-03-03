package Array_String;
import java.util.ArrayList;

// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.

public class MatrixManipulation {
	
	public static void main(String[] args)
	{
		int[][] matrix = {  {1,2,0,4},
							{5,6,7,8},
							{9,10,11,0},
							{13,14,15,16}};
		
		createMatrix(matrix);
	}
	
	private static void createMatrix(int[][] m)
	{
		ArrayList<Integer> iList = new ArrayList<Integer>();
		ArrayList<Integer> jList = new ArrayList<Integer>();
		
		for(int i=0; i<m.length; i++)
		{
			for(int j=0; j<m[0].length ; j++)
			{
				if(m[i][j] == 0)
				{
					iList.add(i);
					jList.add(j);
				}
			}
		}
		
		finalcreate(iList, jList, m);
	}
	
	private static void finalcreate(ArrayList<Integer> iList, ArrayList<Integer> jList, int[][] m )
	{
		for(int i=0; i<m.length; i++)
		{
			for(int j=0; j<m[0].length ; j++)
			{
				if(iList.contains(i) || jList.contains(j))
					m[i][j] = 0;
			}
		}
		
		System.out.println("Answer :: ");
		
		for(int i=0; i<m.length; i++)
		{
			for(int j=0; j<m[0].length ; j++)
			{
				System.out.print(m[i][j] + " ");
	    	}
	    	System.out.println();
	    }
	  }

}

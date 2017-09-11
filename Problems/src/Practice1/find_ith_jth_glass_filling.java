package Practice1;

// Pyramid problem to find water contained by jth glass in ith row
public class find_ith_jth_glass_filling {

	
	public static void main(String[] args) {
		
		int ith = 5;
		int jth = 3;
		
		double val = find_value(ith, jth);
		System.out.println("Resultant ith jth val is  ::: " + val);

	}
	
	private  static double find_value(int i, int j)
	{
		int rowLength = i;
		int columnLength = (2*i) -1;
		int count = 1;
		double[] lastRowRecords = new double[i+1];
		
		double[][] pascalTringle = new double [rowLength+1][columnLength+1]; 
		// initialization of the 2D array
		for (int row=1; row <= rowLength; row++) {
		      for (int col=1; col <= columnLength; col++) {
		    	  pascalTringle[row][col] = 0;
		      }
		}
		
		//creating the Pascal's triangle
		for(int index_i = 1; index_i <= rowLength; index_i++)
		{
			for(int index_j = 1; index_j <= columnLength  ; index_j++)
			{
				if(index_i == 1 && index_j == i) {
					pascalTringle[index_i][index_j] = 1;
					}
				else if (index_j == 1)
					pascalTringle[index_i][index_j] = pascalTringle[index_i-1][index_j+1] / 2;
				else if (index_j == columnLength)
					pascalTringle[index_i][index_j] = pascalTringle[index_i-1][index_j-1] / 2;
				else
					pascalTringle[index_i][index_j] = (pascalTringle[index_i-1][index_j-1] / 2)  + (pascalTringle[index_i-1][index_j+1]/ 2);
				
				System.out.print("\t " + pascalTringle[index_i][index_j]);
				if(index_i == rowLength && pascalTringle[index_i][index_j]!=0.0)
				{
					lastRowRecords[count] = pascalTringle[index_i][index_j];
					count++;
				}
			}
			System.out.println("");
		}
		//lastRowRecords is the array which keeps the record of the all non-zero values of the ith row.
		return lastRowRecords[j];
	}
}

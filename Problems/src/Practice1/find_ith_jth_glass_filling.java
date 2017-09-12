package Practice1;

// Pyramid problem to find water contained by jth glass in ith row
public class find_ith_jth_glass_filling {

	
	public static void main(String[] args) {
		
		int ith = 5;
		int jth = 3;
		
		double val = find_value(ith, jth);  
		System.out.println("Resultant ith jth val is  ::: " + val);

		
		val = find_value2(ith, jth);
		System.out.println("\nResultant ith jth val from 2nd method ::: " + val);
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
	
	private  static double find_value2(int i, int j) {
		
		// suppose i=5 and j=3
		
		int totalR = i, totalC = (i*2)-1; // totalR = 5 and totalC=9
		double target[][] = new double[totalR][totalC];
		int countNotNullVals = 0;
		                         
		// starting the martix from zero
		for(int r=0; r<totalR; r++) {
			for(int c = 0; c<totalC; c++ ) {

				if(r==0 && c == i-1)   // doing c = i-1 as we are starting with zero
					target[r][c] = 1;
				else if (r==0)
					target[r][c] = 0;
				else if (c==0)
					target[r][c] = target[r-1][c+1]/2;
				else if (c== totalC-1)
					target[r][c] = target[r-1][c-1]/2;
				else
					target[r][c] = (target[r-1][c-1]/2) + (target[r-1][c+1]/2) ;
				
				System.out.print(target[r][c] + "\t");
				
				if(r==totalR-1 && target[r][c] != 0) {  //  r==totalR-1 is the last row
					countNotNullVals++;
					if(countNotNullVals==j)
						return target[r][c];
				}
			}
			System.out.println();
		}
		return -1;
	}
}

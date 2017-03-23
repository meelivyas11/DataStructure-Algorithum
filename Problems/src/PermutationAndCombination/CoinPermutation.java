package PermutationAndCombination;
public class CoinPermutation {
		public static int[] coins ={1,5,10,25,50,100};
		
		public static void main(String[] args){
			double target = 7;
			String tempSoln = new String();
			findAllCombinationsRecursive(tempSoln, 0, target);
		}
		
		private static void findAllCombinationsRecursive(String tsoln, int startIx, double remainingTarget) {
		    for(int i=startIx; i<coins.length ;i++) {
		        double temp = remainingTarget - coins[i];
		        String tempSoln =  tsoln + "" + coins[i]+ ","; 
		        if(temp < 0) {
		        	break;
		        }
		        if(temp == 0) {
		         System.out.println("meeli" + tempSoln);
		         break;
		        } 
		        else {
		         findAllCombinationsRecursive(tempSoln, i, temp);
		        }
		     }
		 }

	}



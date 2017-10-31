package Practice3;

public class BestTimeToBuySellStock {

	public static void main(String[] args) {

		int prices[] = {10,90,80,70,60,100};
	    sol1(prices);
	}
	
	
	public static void sol1(int[] arr) {
		int max =0, ith=0, jth=0;
		
		for(int i=0;i<arr.length-1; i++) {
			for(int j = 1; j<arr.length; j++) {
				if(arr[j] - arr[i] > max) {
					max = arr[j] - arr[i];
					ith = i;
					jth = j;
				}
			}
		}
		
		System.out.println("max is :" + max);
		System.out.println("ith is : " + ith + " :: jth is: " + jth);
	}
	
	
	public static void sol2(int[] prices) {
		if(prices==null||prices.length<=1)
	        System.out.println("0"); 
	 
	    int min=prices[0]; // min so far
	    int result=0;
	 
	    for(int i=1; i<prices.length; i++){
	        result = Math.max(result, prices[i]-min);
	        min = Math.min(min, prices[i]);
	    }
	 
	    System.out.println(result);
	}
}

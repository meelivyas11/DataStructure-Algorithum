package OtherQuestions;

public class FindOddString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strArr = {"a", "a", "b", "b", "b", "c", "c"};		
		String s = getOdd(strArr);
		System.out.println(s);
	}

private static String getOdd(String[] sortedArray)
	{
		System.out.println("meeli");
	    String oddStr = "";
	    for(int i=0;i<sortedArray.length-1;i++)
	    {
	        for(int j=i+1; j<sortedArray.length; j++)
	        {
	            if(sortedArray[i] == sortedArray[j]) {
	                i = i+1;
	                break;
	            }
	            else
	              {
	            	System.out.println("found");
	                  oddStr = sortedArray[i];      
	                  i++; 
	              }
	        }
	    }
	    return oddStr;
	}

}

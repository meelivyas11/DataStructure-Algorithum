package Array_String;

import java.util.Arrays;
import java.util.List;

public class Remove_C_element {
	
	public static void main(String[] args)
	{
		method_n3();
		//method_n2();
	}
	
	public static void method_n2()
	{
		List<Integer> A = Arrays.asList(1,2,4,6);
		List<Integer> B = Arrays.asList(1,3,5,8);
		List<Integer> C = Arrays.asList(2,3,5,8);
		
		for(int k = C.size()-1; k >=0 ; k--)
		{
			int i=0, j = B.size()-1;
			//System.out.println("the value of k " + C.get(k));
			while(i < A.size() && j >=0)
			{
				//System.out.println("a" +A.get(i));
				//System.out.println("b" + B.get(j));
				//System.out.println("c" + C.get(k));
				
				if(A.get(i) + B.get(j) == C.get(k))
				{
					System.out.println("counter values :: " + C.get(k));
					break;
				}
				else if(A.get(i) + B.get(j) < C.get(k))
					i++;
				else
					j--;
			}
		}
	}
	
	public static void method_n3()
	{
		List<Integer> A =Arrays.asList(1,2,4,6);
		List<Integer> B = Arrays.asList(1,3,5,8);
		List<Integer> C = Arrays.asList(2,3,5,8);
		
		for(int i=0 ; i< A.size(); i++)
		{
			for(int j= B.size()-1; j>=0; j--)
			{
				//System.out.println(A.get(i) + " + " + B.get(j) + " = " + C.get(counter));
				for (int k = C.size()- 1; k >= 0 ; k-- )
					if(A.get(i) + B.get(j) == C.get(k))
					{
						System.out.println("counter values :: " + C.get(k));
						//C.remove(counter);
					}
			}
		}
		
		for(int i= 0; i<C.size(); i++)
		{
			System.out.println(C.get(i));
		}
	}
}

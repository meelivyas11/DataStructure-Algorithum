package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueryMethod {

	public static void main(String args[]) {
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		
		q1.remove();
		q1.remove();
		
		System.out.println("Queue poll: " + q1.poll());
		
		int aa = ((LinkedList<Integer>) q1).get(0);
		if(aa==3)
			System.out.println(((LinkedList<Integer>) q1).get(0));
	}

}

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
		
		System.out.println("Queue poll: " + q1.poll());  // retrive's and removes
		
		System.out.println("get(0) : "+ ((LinkedList<Integer>) q1).get(0));  // retrive's
		
		System.out.println("q1.peek() : " + q1.peek()); // retrive's
	}
	// q.add(2) -- add element in Queue
	// q.poll() -- retrive's and removes element
	// q.peek() -- retrive's
}

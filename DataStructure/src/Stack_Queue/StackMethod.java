package Stack_Queue;

import java.util.Stack;

public class StackMethod {
	
	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<Integer>();
		System.out.println(s.capacity());
		System.out.println("capacity :: " + s.capacity());
		s.push(5);
		s.push(15);
		s.push(50);
		
		System.out.println("size :: " + s.size());
		System.out.println("Stack pop :" + s.pop());
		
	}
	
}

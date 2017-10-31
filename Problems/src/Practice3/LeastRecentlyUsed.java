package Practice3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class LeastRecentlyUsed {

	static class Node {
		int data;
		Node next;
		
		Node(int val) {
			data = val;
			next = null;
		}
	}
	
	static HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
	static Node head;
	final static int MAX_SIZE = 4;
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,1,2,3,6};
		for(int i =0; i< arr.length ;i++) {
			add(arr[i]);
		}
		
		for(int x : hm.keySet()) {
			System.out.print(x + "\t");
		}
		
		
		System.out.println("\nLinkedList usage");
		
		// LinkedList implementation can also be used
		List<Node> lst = new LinkedList<Node>();
		lst.add(new Node(1));   // at index 0
		lst.add(new Node(2));   // at index 1
		lst.add(new Node(3));   // at index 2
		lst.add(new Node(4));   // at index 3
		
		
		lst.remove(0);			// remove the first element which was inserted
		
		lst.add(new Node(5));	// add a new element again to the list.
		
		for(int i =0;i<lst.size();i++) {
			System.out.print(lst.get(i).data + "\t");
		}
		
		
		/*String a ="abc-123-5467";
		System.out.println(a.substring(0,4));
		System.out.println(a.substring(4,8));
		System.out.println(a.substring(8,12));
		*/
		
		String a ="abc1235467";
		System.out.println(a.substring(0,3));
		System.out.println(a.substring(3,6));
		System.out.println(a.substring(6,10));
		
	}

	public static void add (int val) {
		
		if (hm.containsKey(val)) {
			Node curr = head;
			if(curr.data == val) return;
			while(curr.next.data != val)
				curr = curr.next;
			
			curr.next = curr.next.next;
			
			hm.get(val).next = head;
			head = hm.get(val);
		}
		else {
			if (hm.size() == MAX_SIZE) {
				Node curr = head;
				while (curr.next.next != null)
					curr = curr.next;
				
				hm.remove(curr.next.data);
				curr.next = null;
			}
			
			Node n = new Node(val);
			n.next = head;
			head = n;
			hm.put(val, n);
			
		}
	}
}

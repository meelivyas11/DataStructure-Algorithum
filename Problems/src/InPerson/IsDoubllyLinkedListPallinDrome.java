package InPerson;

/*
 * Find the given doubly linked list is palindrome or not.
 */
public class IsDoubllyLinkedListPallinDrome {
	static Node start = null, tail = null;
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,2,1};
		for(int i =0; i<arr.length; i++) {
			createDoubllyLinkedList(arr[i]);
		}
		
		System.out.println(isPallinDrome());
	}
	
	private static boolean isPallinDrome() {
		while(start!=tail && start.next != tail) {
			if(start.val != tail.val) return false;
			start = start.next;
			tail = tail.prev;
		}
		
		if(start.val == tail.val) return true;
		else return false;
	}

	public static class Node {
		int val;
		Node next, prev;
		
		Node(int v) {
			val = v;
			next = prev = null;
		}
	}
	
	private static void createDoubllyLinkedList(int v) {
		Node nn = new Node(v);
		if(start == null && tail==null) {
			start = tail = nn;
		}
		else {
			tail.next = nn;
			tail.next.prev = tail;
			tail = tail.next;
		}
	}

}

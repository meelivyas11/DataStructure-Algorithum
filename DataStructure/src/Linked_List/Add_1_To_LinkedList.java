package Linked_List;

/* Number is represented in linked list such that each digit corresponds to a node in linked list. Add 1 to it. 
 * For example 1999 is represented as (1-> 9-> 9 -> 9) and adding 1 to it should change it to (2->0->0->0)
 * 
 * 
 * Solutions:
 * 1 - by reversing the Linked List
 * 2 - without reversing linked list using recursion
 */
public class Add_1_To_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list = {9,9,9,9}; // {9,9,9} => {1,0,0,0}
		Node head = AddElementsInLinkedList.createLinkedList(list);
		
		head = AddByReversing(head);
		 
		int addVal = AddByRecurssion(head, 1);
		if(addVal > 0) {
			Node newNode = new Node(addVal);
			newNode.next = head;
			head = newNode;
		}
		
		// print the LinkedList
		FindLength.viewLinkedList(head);
	}
	
	private static Node AddByReversing(Node head) {
		// Reversed the LinkedList
		head =  ReverseSinglyLinkedList.ReveseLinkedList(head);
		
		Node current = head;
		int addVal = 1;
		while(current!=null) {
			
			int total = current.data + addVal;
			current.data = total % 10;
			addVal = total / 10;
			
			
			if(current.next == null && addVal > 0){
				Node newNode = new Node(addVal % 10);
				addVal = addVal / 10;
				current.next = newNode;
				newNode.next = null;
			}
			current = current.next;
		}
		
		// re-reverse the linked list to get it back 
		head =  ReverseSinglyLinkedList.ReveseLinkedList(head);
		
		return head;
	}
	
	private static int AddByRecurssion(Node current, int addVal){
		
		if(current.next == null) {
			int total = current.data + addVal;
			current.data = total %10;
			addVal = total / 10;
			return addVal;
		} else {
			addVal = AddByRecurssion(current.next, addVal);
			int total = current.data + addVal;
			current.data = total %10;
			addVal = total / 10;
			return addVal;
		}
		
	}
}

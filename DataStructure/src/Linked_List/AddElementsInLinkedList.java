package Linked_List;

public class AddElementsInLinkedList {

	public static void main(String[] args) {
		int[] list = {1,2,3,4};
		AddElementsInLinkedList.createLinkedList(list);
	}
	
	public static Node createLinkedList(int[] list)
	{
		Node head = null;
		for(int i=0; i< list.length; i++)
		{
			head = addElementAtEnd(list[i], head);
		}
		return head;
	}
	
	private static Node addElementAtEnd(int d, Node head)
	{
		Node newNode = new Node(d);
		
		if(head == null) // for first Element
		{
			newNode.next = null;
			return newNode;
		}
		
		// for other elements
		Node currenthead = head;
		while(currenthead.next != null)
			currenthead = currenthead.next;
		
		currenthead.next = newNode;
		newNode.next = null;
		return head;
	}
	
}

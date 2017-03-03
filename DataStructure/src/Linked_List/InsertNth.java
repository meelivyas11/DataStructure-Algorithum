package Linked_List;

public class InsertNth {
	
	public static void insertAt_N()
	{
		int[] list = {};
		Node head  = AddElementsInLinkedList.createLinkedList(list);
		head = nthInsert(head, 5, 500);
		
		System.out.println("\nAfter insertion :: ");
		FindLength.viewLinkedList(head);
	}
	
	private static Node nthInsert(Node head, int index, int data)
	{
		Node newNode = new Node(data);
		int len = FindLength.viewLinkedList(head);
		
		if(head!= null &&  ((index > len+1) || index < 0 ))
			return head;
		
		else if(head == null || index == 0) // for initial position
		{
			newNode.next = head;
			return newNode;
		}
		else if(index == len +1) // end
		{
			Node current = head;
			while(current.next!=null)
			{
				current = current.next;
			}
			newNode.next = null;
			current.next = newNode;
			return head;
		}
	
		else // inbetween
		{
			Node current = head;
			for (int i = 0; i < index-1; i++)
			{
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			return head;
		}
	}
}

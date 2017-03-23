package Linked_List;

public class ReverseSinglyLinkedList {

	public static void revese()
	{
		int[] list = {1,2,3,4};
		Node head = AddElementsInLinkedList.createLinkedList(list);
		head = ReveseLinkedList(head);
		System.out.println("Reversed List");
		FindLength.viewLinkedList(head);
	}
	
	static Node ReveseLinkedList (Node head)
	{
		if(head==null)
			return null;
		else
		{
			Node pre = null;
			Node current = head;
			Node next;
			
			while (current!= null)
			{
				next = current.next;
				current.next = pre;
				pre = current;
				current = next;
			}
			return pre;
		}
	}
}

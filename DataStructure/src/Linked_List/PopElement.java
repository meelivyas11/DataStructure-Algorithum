package Linked_List;

public class PopElement {
	
	private Node head = null;
	
	public  void getElement()
	{
		int[] list = {1,2,3,4,5};
		head = AddElementsInLinkedList.createLinkedList(list);

		int val = pop(head);
		System.out.println("Poped value : " + val);

		val = pop(head);
		System.out.println("Poped value : " + val);
		
		val = pop(head);
		System.out.println("Poped value : " + val);
	}

	public int pop(Node head)
	{
		if(head == null)
			return -1;
		else
		{
			int val = head.data;
			head = head.next;
			return val;
		}
	}
}

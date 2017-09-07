package Linked_List;

public class SortedInsert {
	
	public static void main(String[] args)
	{
		Node head = null;
		head = addInSortingOrder(500,head);
		head = addInSortingOrder(100,head);
		head = addInSortingOrder(50,head);
		head = addInSortingOrder(1200,head);
		
		FindLength.viewLinkedList(head);
	}

	private static Node addInSortingOrder(int data, Node head)
	{
		Node newNode = new Node(data);
		if(head == null)
		{
			newNode.next = null;
			return newNode;
		}
		
		else if (data < head.data)
		{
			newNode.next = head;
			return newNode;
		}
		else
		{
			Node current = head;
			while(current.next!=null && current.next.data < data)
				current = current.next;
			
/*			if(current.next == null)
			{
				newNode.next = null;
				current.next = newNode;
			}
			
			else
			{*/
				newNode.next = current.next;
				current.next = newNode;
		//	}
			return head;
		}
	}
}

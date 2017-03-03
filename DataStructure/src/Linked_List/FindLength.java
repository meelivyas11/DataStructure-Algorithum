package Linked_List;

public class FindLength {
	
	public static void main(String[] args)
	{
		int[] list = {1,2,3,4};
		Node head = AddElementsInLinkedList.createLinkedList(list);
		int lengthofLinkedList = viewLinkedList(head);
		System.out.println("\nSize of Linked list : " + lengthofLinkedList);
	}
	
	public static int viewLinkedList(Node head)
	{
		int len = 0;
		System.out.print("Elements are :");
		while (head != null)
		{
			System.out.print(head.data + " ");
			head = head.next;
			len++;
		}
	    return len;	
	}

}


package Linked_List;

public class GetNthElement {

	public static void main(String[] args)
	{
		int[] list = {1,2,3,4,5,6,7,8,9};
		Node head = AddElementsInLinkedList.createLinkedList(list);
		int val = get_nth_val(head, 4);
		System.out.println("\nNthe Value is : " + val);
	}
	
	private static int get_nth_val(Node head, int index)
	{
		int lengthLinkedList = FindLength.viewLinkedList(head);
		if(index > lengthLinkedList) // 1. If index is proper 2. head is not null
			return -1;
		else
		{
			for(int i=0;i<index-1;i++)
				head = head.next;
			return head.data;
		}
	}
}


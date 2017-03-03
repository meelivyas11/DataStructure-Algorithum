package Linked_List;

public class DeleteList {

	public void delete_List()
	{
		int[] list = {1,2,3,4,5,6,7,8,9};
		Node head = AddElementsInLinkedList.createLinkedList(list);
		deleteList(head);
	}
	
	public void deleteList(Node head)
	{
		Node temp = null;
		while(head!=null)
		{
			temp = head.next;
			//free(head);
			head = temp;
		}
	}
}



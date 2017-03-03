package Linked_List;

public class CountDuplicates {
	
	public static void main(String[] args)
	{
		int[] list = {1,2,3,4,1,3,4};
		Node head = AddElementsInLinkedList.createLinkedList(list);
		int count = numDuplicates(head, 4);
		System.out.println("Number of Duplicates : " + count);
	}

	private static int numDuplicates(Node head, int num)
	{
		int count =0;
		if(head==null) return 0;
		while(head!=null)
		{
			if(head.data == num)
				count++;
			head=head.next;
		}
		
		return count;
	}
}

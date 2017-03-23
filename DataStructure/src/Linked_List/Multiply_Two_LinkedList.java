package Linked_List;

public class Multiply_Two_LinkedList {

	public static void main(String[] args) {

		int[] list = {1,2,3,4,5,6}; 
		Node head1 = AddElementsInLinkedList.createLinkedList(list);
		head1 = ReverseSinglyLinkedList.ReveseLinkedList(head1);
		
		int[] list2 = {5,4,3,2,1}; 
		Node head2 = AddElementsInLinkedList.createLinkedList(list2);
		
		//int len1 = FindLength.viewLinkedList(head1);
		int len2 = FindLength.viewLinkedList(head2);
		
		Node sumHead = null;
		Node current;
		int index = 0;
		
		while(head2 != null) {
			int addVal = 0;
			
			current = sumHead;
			for(int i=0; i<len2-index-1; i++){
				Node nn = new Node(0);
				nn.next = null; // re conforming
				if(current == null) {
					 current = nn;
					 sumHead = current;
				}
				else {
					if(current.next == null)
						current.next = nn;
					current = current.next;
				}
			}
			
			
			Node h1 = head1;
			while(h1!=null) {
				int mul = (h1.data * head2.data) + addVal;
				
				if(current.next == null)  {
					Node nn = new Node (mul%10);
					current.next = nn;
					nn.next = null;
					current = current.next;
					addVal = mul / 10;
				}
				else {
					int total = current.data + mul;
					current.data = total % 10;
					addVal = total / 10;
					current = current.next;
				}
			
				h1 = h1.next;
			}
			
			while(addVal > 0 && current!=null){
				int total = current.data + addVal;
				current.data = total % 10;
				addVal = total / 10;
				current = current.next;
			}
			
			head2 = head2.next;
			index++;
			
		}
		
		System.out.println("\n Multiply Result: ");
		ShowLinkedList(ReverseSinglyLinkedList.ReveseLinkedList(sumHead));
	}
	
	private static void ShowLinkedList(Node head) {
		while (head != null)
		{
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}

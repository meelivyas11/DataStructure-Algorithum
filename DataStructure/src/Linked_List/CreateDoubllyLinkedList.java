package Linked_List;


public class CreateDoubllyLinkedList {
	
	static doubllyNode start = null;
	static doubllyNode end = null;
	
	public static void main(String[] args) {
		
		System.out.println("Meeli Vyas");
		for(int i=1;i<5;i++)
			createDoubllyLinkedList(i);
	
		printListStart(start);
		System.out.println("");
		printListEnd(end);
	
		
		reverseDoublyLinkedList();
	}
	
	public static void	createDoubllyLinkedList(int d)
		{
			if(start== null && end==null)
			{
				doubllyNode temp = new doubllyNode();
				temp.data = d;
				start = temp;
				end = temp;
			}
			else
			{
				// add elements at the end
				/*doubllyNode start2 = start;
				doubllyNode temp = new doubllyNode();
				temp.data = d;
				while(start2.next != null)
					start2 = start2.next;
				start2.next = temp;
				temp.prev = end;
				end = temp;*/
				
				// add elements in the beginning
				doubllyNode temp = new doubllyNode();
				temp.data = d;
				temp.next = start;
				start.prev = temp;
				start = temp;
				
			}
		}

	public static void printListStart(doubllyNode start)
	{
		while(start!=null) {
			System.out.print("\t" + start.data);
			start = start.next;
		}
	}
	
	public static void printListEnd(doubllyNode end)
	{
		while(end!=null) {
			System.out.print("\t" + end.data);
			end = end.prev;
		}
	}
	
	public static void reverseDoublyLinkedList()
	{
		doubllyNode st = start;
		doubllyNode ed = end;
		
		if(st.next==null && ed.prev==null) // only 1 element
		{
			
		}  
		else if (st.next.next == null && ed.prev.prev==null) // only 2 element
		{
			int temp = st.data;
			st.data = ed.data;
			ed.data = temp;
		}
		else
		{
			while(st.next.prev != ed && st.prev != ed ) {
				int temp = st.data;
				st.data = ed.data;
				ed.data = temp;
				
				st = st.next;
				ed = ed.prev; 
			}
			
		}
		
		System.out.println("\n::::::::::::::::::::::::::::");
		printListStart(start);
		System.out.println("");
		//printListEnd(end);
	}
}

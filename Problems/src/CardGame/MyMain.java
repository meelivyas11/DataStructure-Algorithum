package CardGame;


public class MyMain {

	/**
	 * @param args
	 */
	static Node head = null;
	
	public static void main(String[] args) {
		//Create Cards
		String[] suitL = {"hearts", "clubs", "diamonds", "spades"};
		String[] numStrL = {"Ace", "2", "3", "4", "5", "6", "7","8", "9", "10", "Jack", "Queen", "King"};
		
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<13;j++)
			{
				Card newCard = new Card(suitL[i], numStrL[j]);
				head = addElementAtEnd(newCard, head);
			}
		}
		
		// head - starting point of list
		driver();
		
	}

	public static void driver()
	{
		Card val = Deal();
		System.out.println("Deal value is : " + val.suit4 + val.numStr);
		
		Card val2 = TurnOver();
		System.out.println("turn over value is : " + val2.suit4 + val2.numStr);
		
		int cutPoint = 24;
		cut(cutPoint);
		viewLinkedList(head);
		
		String suit4_Search= "diamonds";
		String numStr_Search = "2";
		int loc = search(suit4_Search, numStr_Search);
		System.out.println("\n card is at position : " + (loc+1) );
		
	}
	
	
	private static Node addElementAtEnd(Card d, Node head)
	{
		Node newNode = new Node(d);
		
		if(head == null) // for first Element
		{
			newNode.next = null;
			return newNode;
		}
		
		// for other elements
		Node currenthead = head;
		while(currenthead.next != null)
			currenthead = currenthead.next;
		
		currenthead.next = newNode;
		newNode.next = null;
		return head;
	}
	
	
	public static Card Deal()
	{
		if(head == null)
			return null;
		else
		{
			Card val = head.data;
			head = head.next;
			return val;
		}
	}
	
	
	public static Card TurnOver()
	{
		if(head == null)
			return null;
		else
		{
			Card val = head.data;
			return val;
		}
	}
	
	public static void cut(int cp)
	{
		Node nodeTemp = null;
		for(int i=0; i<cp;i++)
		{
			nodeTemp = addElementAtEnd(head.data, nodeTemp);
			Deal();
		}
		
		while(nodeTemp!= null)
		{
			addElementAtEnd(nodeTemp.data, head);
			nodeTemp = nodeTemp.next;
		}
	}
	
	public static int viewLinkedList(Node head)
	{
		int len = 0;
		System.out.print("Elements are :");
		while (head != null)
		{
			System.out.print(head.data.suit4 + head.data.numStr + " ");
			head = head.next;
			len++;
		}
	    return len;	
	}

	private static int search(String s, String n)
	{
		int count =0;
		if(head==null) return 0;
		while(head!=null)
		{
			if(head.data.suit4 == s && head.data.numStr ==n )
			{
				return count;
			}
			else
			{
				count++;
				head=head.next;
			}
		}
		return count;
		
	}
}

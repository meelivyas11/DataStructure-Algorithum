package Trees;

public class CreateTree {
	
	static TreeNode head = null;
	
	
	
	
	public static TreeNode creatTreeMain(int[] array)
	{
		//int [] array = new int[] {5,3,10,0,2,-6,-7}; //{42, 25, 65, 12, 37, 43, 87, 9, 13, 30, 99};
		for(int i=0;i<array.length;i++)
		{
			addNode(array[i], head);
		}
		return head;
	}
	
	public static void addNode(int d, TreeNode node)
	{
		TreeNode newNode = new TreeNode();
		newNode.data = d;
		if(head==null)
		{
			head = newNode;
		}
		else
		{
			if(d<node.data) {
				if(node.left!=null)
					addNode(d,node.left);
				else
					node.left = newNode;
			}
			else
			{
					if(node.right!=null)
						addNode(d,node.right);
					else
						node.right = newNode;
			}
				
		}
		
	}

}

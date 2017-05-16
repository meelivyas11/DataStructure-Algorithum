package InPerson;

/* Given a BST, replace each node with the sum of the values of all the nodes that are greater than that node. 
 * Only constraint being that I was not allowed to use any global or static variable.
 * 
 * 
 * When we do reverse inorder traverse of BST, that is right--root--left, the nodes visited before current node 
 * are those having greater value. By keeping a record of the sum of all nodes visited, we can easily fix the problem. 
 * 
 */
public class BST_ReplaceNodeWithGreaterSum {

	public static void main(String[] args) {

		TreeNode head = createTree();
		
		ViewTreeRevInOrder(head);
		SumTree(head , 0);
		System.out.println("\nAfter Sum: ");
		ViewTreeRevInOrder(head);
	}
	
	private static void ViewTreeRevInOrder(TreeNode current) {
		if(current.right!= null)
			ViewTreeRevInOrder(current.right);
		
		System.out.print(current.value + "\t");
		
		if(current.left!= null)
			ViewTreeRevInOrder(current.left);
	}
	
	private static int SumTree(TreeNode current, int sum) {
		if(current.right!= null)
			sum = SumTree(current.right, sum);
		
		int val = current.value;
		current.value = sum;
		sum = sum + val;
		
		if(current.left!= null)
			sum = SumTree(current.left, sum);
		
		return sum;
	}

	public static class TreeNode {

		public TreeNode left;
		public TreeNode right;
		public int value;
		
		public TreeNode(int d) {
			value =d;
			left = null;
			right = null;
		}
		
	}
	
	private static TreeNode createTree()
	{
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(7);
		head.left.left = new TreeNode(2);
		head.left.right = new TreeNode(9);
		
		head.right = new TreeNode(15);
		head.right.left = new TreeNode(12);
		head.right.right = new TreeNode(18);
		head.right.right.right = new TreeNode(20);
		
		return head;		
	}

}

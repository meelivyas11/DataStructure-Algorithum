package Trees;

public class ViewTree {
	
public static void main(String[] args) {
		
		System.out.println("Tree Main");
		TreeNode head = CreateTree.creatTreeMain(new int[] {42, 25, 65, 12, 37, 43, 87, 9, 13, 30, 99});
		
		preOrder(head);
		
		System.out.println("\n:::::::::::::::::");
		inOrder(head);
		
		System.out.println("\n:::::::::::::::::");
		postOrder(head);
	}
	
	public static void preOrder(TreeNode node)
	{
		if(node!=null) {
			System.out.print(node.data + "\t");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public static void inOrder(TreeNode node)
	{
		if(node!=null) {
			inOrder(node.left);
			System.out.print(node.data + "\t");
			inOrder(node.right);
		}
	}
	
	public static void postOrder(TreeNode node)
	{
		if(node!=null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + "\t");
		}
	}
	
}

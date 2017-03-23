package Trees;

public class SearchTreeNode {

	public static void main(String[] args) {
		
		TreeNode head = CreateTree.creatTreeMain(new int[] {42, 25, 65, 12, 37, 43, 87, 9, 13, 30, 99});
		System.out.println(searchNode2(12, head));
	}
	
	public static boolean searchNode(int element, TreeNode head)
	{
		if(head == null)
			return false;
		if(head.data == element)
			return true;
		else
			return searchNode(element, head.left) || searchNode(element, head.right);
	}
	
	public static boolean searchNode2(int element, TreeNode head) {
		
		if(head.data == element) {
			return true;
		}
		else if (head.data > element & head.left!= null) {
			return searchNode2(element, head.left);
		}
		else if (head.data < element & head.right!= null) {
			return searchNode2(element, head.right);
		}
		else {
			return false;
		}
	}
}

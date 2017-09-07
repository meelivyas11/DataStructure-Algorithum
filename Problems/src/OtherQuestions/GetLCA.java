package OtherQuestions;


/*Least Common Ancestor - BST
		  8
	3         10
1      6          24	
	5   
*/


/*
public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int value;
	
	TreeNode(int d) {
		value =d;
		left = null;
		right = null;
	}
}
*/

public class GetLCA {
	
	static TreeNode head = null;
	
	public static void main(String[] args) {
		int[] a = {10, 5,15,3,7,13,19,1,4,6,9,14,16,20,-1,2, 17,12}; //{8,3,10,1,6,24,5};
		
		
		for(int i=0; i<a.length; i++) {
			createTree(a[i], head);
		}
		
		ViewTreeInorder(head);
		System.out.println("\n LCA of 12 and 14 from first nethod is :" + getLCA(12, 14, head).value);
		System.out.println("\n LCA of 12 and 14 from second nethod is :" + getLCA2(12, 14, head).value);
	}
	
	public static TreeNode getLCA2(int a, int b, TreeNode head) //1  //5 //h
	{	TreeNode current = head;
		boolean flag = true;
		while(flag) {
			flag=false;
			
			if(current.left!=null && a<current.value && b<current.value) {
				flag=true;
				current = current.left;
			}
			
			if(current.right!=null && a>current.value && b>current.value) {
				flag=true;
				current = current.right;
			}
			
		}
		return current;
	}
	
	
	// This method breaks in a case when we need to traverse right first and then to left
	// input example {10, 5,15,3,7,13,19,1,4,6,9,14,16,20,-1,2, 17,12} with node 12 and 14
	public static TreeNode getLCA(int a, int b, TreeNode head) //1  //5 //h
	{
		if(head==null)
		return null;
		
		TreeNode current = head;
		
		while(a<=current.value && b<=current.value)
		current = current.left;
		
		while (a>=current.value && b>=current.value)
		current = current.right;
		
		return current;
	}
	
	public static void createTree(int d, TreeNode current) {
		TreeNode newNode = new TreeNode(d);
		
		if(head==null)
			head = newNode;
		
		else if (d < current.value) {
			if(current.left == null) {
				current.left = newNode;
			}
			else {
				createTree(d, current.left);
			}
		}
		else if (d > current.value) {
			if(current.right == null) {
				current.right = newNode;
			}
			else {
				createTree(d, current.right);
			}
		}
	}
	
	public static void ViewTreeInorder(TreeNode head) {
		if(head!=null)
		{
			ViewTreeInorder(head.left);
			System.out.print(head.value + "\t");
			ViewTreeInorder(head.right);
		}
	}
	
	
}









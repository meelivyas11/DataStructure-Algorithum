package InPerson;

import java.util.HashSet;
import java.util.Set;


public class NumberOfDistinctPaths {

	/*
	 * Find the Maximum number of distinct nodes in a binary tree path
	 */
	public static void main(String[] args) {
		TreeNode head = createTree();
		
		Set<String> set = new HashSet<String>();
		
		getDistinctPath(head, set, null);
		
		for(String treeList : set) {
			System.out.println(treeList);
		}
	}
	
	private static void getDistinctPath(TreeNode head, Set<String> set, TreeNode parent) {
		if(head == null) 
			return;
		
		if(parent == null) {
			set.add(String.valueOf(head.data));
		}
		else {
			Set<String> newSet = new HashSet<String>();
			for(String treeList : set) {
				String[] nodes = treeList.split("->");
				if(Integer.valueOf(nodes[nodes.length-1]) == parent.data) {
					newSet.add(treeList + "->" + head.data);
				}
			}
			set.addAll(newSet);
		}
		
		getDistinctPath(head.left, set, head);
		getDistinctPath(head.right, set, head);
	}

	private static TreeNode createTree()
	{
		TreeNode head = new TreeNode();
		head.left = new TreeNode();
		head.left.left = new TreeNode();
		head.left.right = new TreeNode();
		
		head.right = new TreeNode();
		head.right.left = new TreeNode();
		head.right.right = new TreeNode();
		
		head.data = 10;
		
		head.left.data = 5;
		head.left.left.data = 2;
		head.left.right.data = 7;
		
		head.right.data = 12;
		head.right.left.data = 11;
		head.right.right.data = 14;
		
		return head;		
	}
	
	public static class TreeNode{
		
		public int data;
		public TreeNode left;
		public TreeNode right;
		
		TreeNode()
		{
			left = null;
			right = null;
		}

	}


}

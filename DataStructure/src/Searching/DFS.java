package Searching;

import java.util.Stack;

import Trees.CreateTree;
import Trees.TreeNode;

public class DFS {

	public static void main(String[] args) {
		TreeNode head = CreateTree.creatTreeMain(new int[] {42, 25, 65, 12, 37, 43, 87, 9, 13, 30, 99});
		
		Stack<TreeNode> sk = new Stack<TreeNode>();
		sk.add(head);
		
		while(!sk.isEmpty()) {
			TreeNode current = sk.pop();
			
			System.out.print(current.data + "\t");
			if(current.right != null) sk.add(current.right);
			if(current.left != null) sk.add(current.left);
			
		}

	}

}

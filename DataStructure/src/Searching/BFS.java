package Searching;

import java.util.LinkedList;
import java.util.Queue;

import Trees.CreateTree;
import Trees.TreeNode;

public class BFS {

	public static void main(String[] args) {
		
		TreeNode head = CreateTree.creatTreeMain(new int[] {42, 25, 65, 12, 37, 43, 87, 9, 13, 30, 99});
		
		Queue<TreeNode> que= new LinkedList<TreeNode>();
		que.add(head);
		
		while(!que.isEmpty()){
			TreeNode current = que.poll();
			
			System.out.print(current.data + "\t");
			if(current.left != null)
				que.add(current.left);
			if(current.right != null)
				que.add(current.right);
		}

	}

}

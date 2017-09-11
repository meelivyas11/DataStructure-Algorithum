package Practice2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;


/*
 *  Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

           1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
               
			  
	The output of print this tree vertically will be:
	4
	2
	1 5 6
	3 8
	7
	9
	
	
	Algo: 
	1. To maintain a hash for the branch of each node.
	2. Traverse the tree in level order fashion.
	3. In level order traversal, maintain a queue
	   which holds, node and its vertical branch.
	    * pop from queue.
	    * add this node's data in vector corresponding
	      to its branch in the hash.
	    * if this node hash left child, insert in the 
	      queue, left with branch - 1.
	    * if this node hash right child, insert in the 
	      queue, right with branch + 1.
      
 */
public class PrintBinaryTreeInVerticalOrder {
	
	public static class TreeNodeVO {

		public TreeNodeVO left;
		public TreeNodeVO right;
		public int value;
		public int VO;
		
		public TreeNodeVO(int d) {
			value =d;
			left = null;
			right = null;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNodeVO root =  createTree();
		root.VO = 5;
		
		Queue<TreeNodeVO> que = new LinkedList<TreeNodeVO>();
		TreeMap<Integer, ArrayList<TreeNodeVO>> hm = new TreeMap<Integer, ArrayList<TreeNodeVO>>();
		
		que.add(root);
				
		while(!que.isEmpty()) {
			TreeNodeVO current = que.poll();
			
			if(!hm.containsKey(current.VO)){
				ArrayList<TreeNodeVO> lst = new ArrayList<TreeNodeVO>();
				lst.add(current);
				hm.put(current.VO, lst);
			} else {
				hm.get(current.VO).add(current);
			}
			
			if(current.left !=null) {
				current.left.VO = current.VO -1;
				que.add(current.left);
			}
			if(current.right !=null) {
				current.right.VO = current.VO +1;
				que.add(current.right);
			}
		}
		
		for(int i : hm.keySet()){
			System.out.print(i  + "->\t");
			for(TreeNodeVO n: hm.get(i)) {
				System.out.print(n.value + " ");
			}
			System.out.println();
		}

	}
	
	private static TreeNodeVO createTree()
	{
		TreeNodeVO head = new TreeNodeVO(1);
		head.left = new TreeNodeVO(2);
		head.left.left = new TreeNodeVO(4);
		head.left.right = new TreeNodeVO(5);
		
		head.right = new TreeNodeVO(3);
		head.right.left = new TreeNodeVO(6);
		head.right.left.right = new TreeNodeVO(8);
		head.right.right = new TreeNodeVO(7);
		head.right.right.right = new TreeNodeVO(9);
		
		return head;		
	}
}

package OtherQuestions;

import java.util.LinkedList;
import java.util.Queue;

/*Suppose you have a binary tree where each node has a reference to its left child, right child, and an uninitialized field for its right neighbor. 
  Also suppose this is a perfect tree that is evenly distributed and does not have incomplete rows. For each node, add a reference to its right neighbor.
 

Basically, turn this:

       A
    /     \
   B       C
  / \     / \
 D   E   F   G
 
 into:
 
        A
    /       \
   B    ->   C
  /  \     /  \
 D -> E -> F -> G

public class Node {
Node getLeftChild();
Node getRightChild();
}

puclic class TreeNode extends Node {
    int level;
    TreeNode neighbour;
    public static void addneighbour(TreeNode left, TreeNode right)
    {
        left.neighbour = right;
    }
    
    
}

//Implement following method
public Node addNeighbor(Node root){

    Queue<TreeNode> que= new LinkedList<TreeNode>();
    int currentIndex = 0;
    TreeNode current = (TreeNode) root;
    current.level = 0;
    que.add(current);
    
    
    while(!que.isEmpty) {
        
        TreeNode queHead = que.remove();
        
        TreeNode left = queHead.getLeftChid();
        TreeNode right= queHead.getRightChid();
        if(left!=null) {
            left.level = que.level + 1;
            que.add(left);
         }
        if(right!=null) {  
            right.level = que.level + 1;
            que.add(right);
         }
        
        if(currentIndex == 0 && left!=null && right!=null)
        {
            addneighbour(left, right);
        }
        else if (queHead.level == ((LinkedList<TreeNode>)que).get(0).level)
        {
            addneighbour(queHead, ((LinkedList<TreeNode>)que).get(0));
        }
        currentIndex++;
    }
    
} */


public class ReferenceRightNeighbor{
	
	public static class TreeN {
		int data;
		TreeN left;
		TreeN right;
		int level;
		public TreeN(int d) {
			data = d;
			left = right = null;
		}
	}
	
	public static void main(String[] args) {
		TreeN head = new TreeN(10);
		
		head.left = new TreeN(5);
		head.left.left = new TreeN(3);
		head.left.right = new TreeN(7);
		
		head.right = new TreeN(15);
		head.right.left = new TreeN(13);
		head.right.right = new TreeN(17);
		
		createNeighbor(head);
	}
	
	public static void createNeighbor(TreeN head) {
		Queue<TreeN> q = new LinkedList<TreeN>();
		head.level = 0;
		q.add(head);
		
		while(!q.isEmpty()){
			TreeN current = q.poll();
			if(current.left!=null) {
				current.left.level = current.level + 1;
				q.add(current.left);
			}
			if(current.right!=null) {
				current.right.level = current.level + 1;
				q.add(current.right);
			}
			
			if(q.peek()!=null && current.level == q.peek().level)
				System.out.println("Neighbors are: " + current.data + "->" + q.peek().data);
		}
	}
}
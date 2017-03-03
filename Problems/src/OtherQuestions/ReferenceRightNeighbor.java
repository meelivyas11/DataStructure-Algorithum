package OtherQuestions;

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
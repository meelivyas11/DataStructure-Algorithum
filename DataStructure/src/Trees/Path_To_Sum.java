package Trees;

import java.util.ArrayList;
import java.util.List;

public class Path_To_Sum {

	/*
	                5
	            3       10
	        0     2  -6    -7
	        
	k = 8
	5->3
	5->3->0
	5->10->-7
	
*/
	
	public static void main(String[] args)  {

		TreeNode head = createTree();
		
	    List<String> res = new ArrayList<String>();
	    findPathsWhichSumTok(head, 8, "", res); 
	    
	    for(String s : res) {
	    	System.out.println(s);
	    }
	}
	
	

	private static void findPathsWhichSumTok(TreeNode root, int k, String str, List<String> res)
	{
	    
	   if(root==null) { return; }
	   
	   int t = k - root.data;
	   if(t==0)
	   {
	      res.add(str + root.data);
	      
	   }
	   str = str + root.data + "->" ; 
	  
	   findPathsWhichSumTok(root.left, t, str, res) ;
	   findPathsWhichSumTok(root.right, t, str, res);
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
		
		head.data = 5;
		head.left.data = 3;
		head.left.left.data = 0;
		head.left.right.data = 2;
		head.right.data = 10;
		head.right.left.data = -6;
		head.right.right.data = -7;
		
		return head;		
	}
	    
}


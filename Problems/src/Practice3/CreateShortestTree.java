package Practice3;

/*
 * Ques)Given a sorted (increasing order) array, write an algorithm to create a binary tree with

minimal height.

123456


  3
 2  \5
1   4  6

    1) arr = {};
    2) arr = {1};  // s=0,end=1, len =1
    3) arr = {1,2,3,4}  // s =2, en = 3, m= 2(val =3)
    4) arr = {1,2,3}


 */
public class CreateShortestTree {

	public static TN head = null;
	   
    static class TN {
        int val;
        TN left;
        TN right;
        
        public TN(int d) {
            val = d;
            left = right = null;
        }
    }
    
    public static void main(String[] args) {
    
        int[] arr= {1,2,3,4,5,6};
        //createTree(arr, 0, arr.length);
        
        // better solution
        head = createTreebetter(arr, 0, arr.length);
       
        //print Tree
        inOrder(head);
        
    }
    
    // below solution makes only one recursive
    public static TN createTreebetter(int[] arr, int start, int end) {
    	
    	if(arr.length < 1 || start > end) return null;
    	
    	if(arr.length == 1)
    		return new TN(arr[0]);
    	
    	int mid = start + ((end-start)/2);
    	TN node = new TN(mid);
    	if(mid-1 > 0 )
    		node.left = createTreebetter(arr, start, mid-1);
    	if(mid+1 <= arr.length)
    		node.right = createTreebetter(arr, mid+1, end);
    	return node;
    }
    
    
    
    // below solution makes two recursive call
	public static void createTree(int[] arr, int start, int end) {
    
    if(arr.length == 1)
        {addNode(arr[0],head); return;}
        
    if(start!=end && start < end ) {
        int mid = start + ((end-start)/2);
        addNode(arr[mid], head);
        if(mid-1 >= 0 )
        createTree(arr, start, mid-1);
        if(mid+1 < arr.length)
        	createTree(arr, mid+1, end);
    }
    else if(start==end && arr.length > 1) {
        addNode(arr[start], head);
    }
    
  }
  
  public static void addNode(int data, TN node){
     
      if(head==null)
      	{ 
    	  head = new TN(data);
    	}
      else {
            
            if(data <node.val) {
                if(node.left !=null)
                    addNode(data, node.left);
                else
                    node.left = new TN(data);      
            }  
            else {
               if(node.right!=null)
                    addNode(data, node.right);
                else
                    node.right= new TN(data);  
            }
      }    
  }
  
  public static void inOrder(TN node)
	{
		if(node!=null) {
			inOrder(node.left);
			System.out.print(node.val + "\t");
			inOrder(node.right);
		}
	}

}

package InPerson;

/*
 * Give a large multi MB byte file in memory, a system handles delete requests for segments typically of the order of bytes. 
 * The system has a constraint that individual purge requests of byte segments are expensive, so that the no. of purges are a minimum. 
 * 
 * Eg. a 5 MB file receives delete requests for offsets (1, 100), (250, 550),(1000, 1200), (400, 600), (800, 900), (1100, 1150) 
 * Effective delete requests - (1, 100) , (250, 600), (800, 900), (1000, 1200) 
 *
 * The users of the system always go by the absolute byte ordering of the file. Eg. if byte 1 is deleted, the users of the system will reference the actual byte 2 as byte 2. 
 *
 *  What data structure would you use to store these intervals such that the following operations are efficient 
 *  1. Looking up an interval 
 *  2. Inserting a new interval that has no overlap with existing ones 
 *  3. Inserting a new interval that has partial overlaps with existing intervals. 
 *  
 *  This would involve collapsing the existing intervals with the new interval to form a single large interval. 
 *  Eg. Interval cache: {(1, 100), (250, 550), (1000, 1200)} , new interval : (400, 700) -> Interval cache: {(1,100), (250, 700), (1000, 1200)}
 * 
 *  Hint: Interval Tree or Segment Tree
 *  
 *  Notes:
 *  - Using Interval Tree (mix Add and overlapping)
 *  - We either go left or right (not both)
 *  - Interval-max is useful to decide wheater to go left or right
 */

public class IntervalTreeProblem {

	static Interval root;
	public static void main(String[] args) {
		root = null;
		/*addInterval(1,100);
		addInterval(250, 550);
		addInterval(1000, 1200);
		addInterval(400, 700);*/
		
		addInterval(1,100);
		addInterval(250, 550);
		addInterval(1000, 1200);
		addInterval(400, 600);
		addInterval(800, 900);
		addInterval(1100, 1150);
		
		ViewIntervalTree(root);
	}
	
	private static void addInterval(int low, int high) {
		
		if(root==null) {
			root = new Interval(low, high, high);
			return;
		}
		
		Interval current = root;
		while(current!=null) {
			if(current.max < high) current.max = high;
			
			if(low>current.start && low<current.end) {	// check for intersection
				if(high > current.end) current.end = high;
				return;
			}
			else if(low <current.start && current.left == null) {current.left = new Interval(low, high, high); return;}   // insert on left if left is null and low is less than the current start
			else if(low> current.start && current.right == null) { current.right = new Interval(low, high, high); return;} // insert on right if right is null and low is greater than the current start
			else if(current.left!=null && current.left.max > low) {	current = current.left;	} // go left if the max of left is greater than low
			else { current = current.right;	} // else go right
		}
	 
		
	}
	
	private static void ViewIntervalTree(Interval root) {
		if(root ==null) return;
		
		ViewIntervalTree(root.left);
		
		System.out.println("["+ root.start + "," + root.end + "]");
		
		ViewIntervalTree(root.right);
	}

	static class Interval {
		int start, end, max;
		Interval left, right;
		Interval(int s, int e, int m) {
			start = s;
			end = e;
			max = m;
		}
	}

}

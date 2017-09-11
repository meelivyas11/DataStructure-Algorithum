package Practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* 
 * Given a descendants of nodes, write an algorithm to find whether it is a tree or a graph?
 * 
 * Tree:
 * 
 * 		10
 * 	   /  \
 *    7	   12
 *   /\    / \
 *  5  8  11 15
 *  
 *  Graph:
 *   	10-----------
 * 	   /  \			|	
 *    7	   12       |
 *   /\    / \      |
 *  5  8  11 15 ____|
 * 
 * Two Ways of doing this: 
 *  1) Traverse the nodes in a BFS manner while maintaining a set of visited nodes. If at any point we encounter a node that has already been visited, the tree is a graph.
 *  2) Assuming you are given all nodes and their immidate decendents, you can just keep track of the parent for each node and check if any node has more than one parent...
 */
public class GraphOrTree {

	public static void main(String[] args) {
		GraphNode head = createGraph();
		
		HashSet<GraphNode> visitedNodes = new HashSet<GraphNode>();
		
		// Way-1
		System.out.println("Is it a Tree: " + isTree(head, null, visitedNodes));
		
		// Way-2 -- using hashmap (child, parent) - if a child is repeated in HashMap, that means it has more than 1 parent
		System.out.println("Is it a Tree: " + isTree2(head, null, new HashMap<GraphNode, GraphNode>()));
	}
	
	private static boolean isTree2(GraphNode current, GraphNode parent, HashMap<GraphNode, GraphNode> childParent) {
		List<GraphNode> lst = current.connNodes;
		boolean flag = true;
		for(GraphNode n : lst) {
			if(!n.equals(parent)) {
				if(childParent.containsKey(n)) return false; 
				childParent.put(n,current);
				flag = flag && isTree2(n,current,childParent);
			}
		}
		return flag;
	}

	private static boolean isTree(GraphNode current, GraphNode parent, HashSet<GraphNode> visitedNodes) {
		
		if(visitedNodes.contains(current)) return false;
		
		visitedNodes.add(current);
		List<GraphNode> lst = current.connNodes;
		if(lst.size() ==1 && lst.get(0).equals(parent)) return true;
		else {
			boolean flag = true;
			for(GraphNode n : lst) {
				if(!n.equals(parent)){
					flag = flag && isTree(n,current,visitedNodes);
				}
			}
			return flag;
		}
	}


	public static GraphNode createGraph() {
		
		GraphNode head = new GraphNode(10);
		GraphNode headLeft = new GraphNode(7);
		GraphNode headRight = new GraphNode(12);
		
		GraphNode headLeftLeft = new GraphNode(5);
		GraphNode headLeftRight = new GraphNode(8);
		
		GraphNode headRightLeft = new GraphNode(11);
		GraphNode headRightRight = new GraphNode(15);
		
		head.connectNodes(headLeft);
		head.connectNodes(headRight);
		headLeft.connectNodes(headLeftLeft);
		headLeft.connectNodes(headLeftRight);
		
		headRight.connectNodes(headRightLeft);
		headRight.connectNodes(headRightRight);
		
		// add below for making tree a graph
		//headRight.connectNodes(headRightLeft);
		
		return head;
	}
	
	public static class GraphNode {
		int value;
		List<GraphNode> connNodes;
		
		GraphNode(int v) {
			value = v;
			connNodes = new ArrayList<GraphNode>();
		}
		
		public void connectNodes(GraphNode b){
			this.connNodes.add(b);
			b.connNodes.add(this);
		}
	}
}

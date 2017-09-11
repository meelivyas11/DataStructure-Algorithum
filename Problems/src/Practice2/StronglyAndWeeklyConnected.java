package Practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Title: Item Recommendations 
 *	Amazon wants to recommend items to a customer who has just made a purchase. Amazon's recommendation algorithm is based on item 'connection'. 
 *	Two items are 'strongly connected' if a single customer bought both of them. Two items are 'weakly connected' if they are both strongly and weakly connected to some other third item. 
 *	
 *	Your task is to determine the number of the items strongly and weakly connected to a given item. 
	
	You are provided the item id represented as a string, as well as the list of customer purchases represented as an array of strings. Each element in the array consists of a customer id(represented as a string) and an item id (also represented as a string). The two ids are separated by a colon. For example, if they element in the array is "ABJA:Z42G" then that means customer ABJA purchased item Z42G. 
	Your output consists of an array, where the first element in the array represents the number of items strongly connected to the provided item id and the second element represents the number of items weakly connected to the provided item id. 
	For example, if you were provided with the following input: 
	determineRecommendation("ABC",["first:ABC", "first:HIJ", "sec:HIJ", "sec:KLM", "third:NOP", "fourth:ABC", "fourth:QRS", "first"DEF", "fifth:KLM", "fifth:TUV"]) 
	
	You would return the following array: 
	[3, 2] 
	since ABC is strongly connected to 3 items: DEF, HIJ and QRS and is weakly connected to 2 items: KLM and TUV 
	
	
	Although the description is long, the problem is just asking for 'search (with either DFS or BFS) in a graph'.
 * 
 * 
 * 
 */

public class StronglyAndWeeklyConnected {

	public static void main(String[] args) {
		
		String target = "ABC";
		String[] history = {"first:ABC", "first:HIJ", "sec:HIJ", "sec:KLM", "third:NOP", "fourth:ABC", "fourth:QRS", "first:DEF", "fifth:KLM", "fifth:TUV"};
		List<String> his = new ArrayList<String>(Arrays.asList(history));
		
		GraphNode head = new GraphNode(target);
		createGraph(head, his);
		
		System.out.println("Strongly connected : " + head.neighbours.size());
		
		int count = 0;
		for(GraphNode child : head.neighbours) {
			
			Queue<GraphNode> que = new LinkedList<GraphNode>();
			que.add(child);
			count--;
			while(!que.isEmpty()){
				GraphNode c = que.poll();
				count ++;
				que.addAll(c.neighbours);
			
			}
		}
		
		System.out.println("Weekly connected are: " + count);
	}
	
	private static void createGraph(GraphNode head, List<String> history) {
	
		for(int i =0; i<history.size(); i++) {
			String[] temp = history.get(i).split(":");
			if(temp[1].equals(head.val)) {
				String user = temp[0];
				for(int j = i+1; j<history.size() ; j++) {
					String[] temp2 = history.get(j).split(":");
					if(temp2[0].equals(user) && !temp2[1].equals(head)) {
						
						head.neighbours.add(new GraphNode(temp2[1]));
						history.remove(history.get(j));
						
					}
				}
			}
		}
		
		for(GraphNode aa : head.neighbours) {
			createGraph(aa, history);
		}
		
	}

	public static class GraphNode{
		String val;
		List<GraphNode> neighbours;
		
		public GraphNode(String value) {
			val = value;
			neighbours = new LinkedList<GraphNode>();
		}
		
		public void connectNode(GraphNode a) {
			this.neighbours.add(a);
			//a.neighbours.add(this);
		}
	}

}

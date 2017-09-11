package Practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  You have been given a grid with some doors, walls and some empty spaces. 
 *	1st part : You have to tell the least no of moves to go from random position in the grid to the nearest door. You can move in four directions only, i.e, left, right, above, below. 
 *	2nd part : Least distance of every empty cell to the nearest door.
 *			You can just do BFS with multiple sources. 
 *			This works in exactly the same way as regular BFS, but instead of starting with just one node, you would put all your sources (doors) in the queue at the beginning. 
 *			That is, make an initial pass over the grid to find all doors and start your BFS queue with all of them at distance 0. Then proceed with BFS as normal. 
 *			This solution is O(grid size), which is optimal because you have to look at all the input.
 *
 * See: https://www.careercup.com/question?id=5664366808530944
 *
 */
public class MovesToDoorsAndWindows {

	public static void main(String[] args) {
	
		int[][] grid = { {222, 1, 1, 222, 222},
					     {222, 0, 0, 0, 222},
					     {222, 0, 0, 0, 222},
   					     {222, 222, 0, 0, 222},
					     {222, 222, 222, 222, 222} };
		
		System.out.println("Min moves: " + getSteps(grid,2,2, 0));
		LeastDistanceFromDoor(grid);
	}
	
	// part1
	private static int getSteps(int[][] grid, int x, int y, int steps) {
		
		if(x<0 || x>grid.length-1 || y < 0  || y > grid[x].length-1 ) return 9999999; // outside the matrix
		else if(grid[x][y] == 222) return 9999999;  // wall so we don't go to that step
		else if(grid[x][y] == -999) return 9999999; // already visited point
		else if(grid[x][y] == 1) return steps;   // door found
		else {
			grid[x][y] = -999;
			return Math.min(
						Math.min(getSteps(grid, x+1, y, steps+1), getSteps(grid, x-1, y, steps+1)),
						Math.min(getSteps(grid, x, y+1, steps+1), getSteps(grid, x, y-1, steps+1)));
		}
	}
	
	//part2
	private static void LeastDistanceFromDoor(int[][] grid) {
		
		class Point {
			public int x;
			public int y;
			
			Point(int xx, int yy){
				x = xx;
				y = yy;
			}
		}
		
		List<Point> doors = new ArrayList<Point>();
		for(int i=0; i< grid.length ; i++) {
			for(int j =0; j<grid[i].length; j++) {
				if(grid[i][j] == 1) {
					doors.add(new Point(i, j));
				}
			}
		}
		
		for(Point d : doors) {
			
			boolean[][] visited = new boolean[grid.length][grid[d.x].length];
			for(int i = 0; i<grid[d.x].length ; i++){
				Arrays.fill(visited[i], false);
			}
			
			grid = FillEmptyPoints(grid, d.x,d.y,0, visited);
		}
		
		System.out.println();
		for(int i=0; i< grid.length ; i++) {
			for(int j =0; j<grid[i].length; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static int[][] FillEmptyPoints(int[][] grid, int x, int y, int distance, boolean[][] visited) {
		
		/*visited[x][y] = true;
		
		
		if(grid[x][y] == 222) return grid; 
		
		if(grid[x][y] != 1  && (grid[x][y] == 0 || distance < grid[x][y])) {
			grid[x][y] = distance;
		}
	
		
		if(x+1 < grid.length-1 && (visited[x+1][y]==false || distance+1 < grid[x+1][y]))
			grid = FillEmptyPoints(grid, x+1 ,y, distance+1, visited);
		if(x-1 >= 0 && (visited[x-1][y]==false || distance+1 < grid[x-1][y]))
			grid = FillEmptyPoints(grid, x-1 ,y, distance+1, visited);
		if(y+1 < grid[x].length-1 && (visited[x][y+1]==false || distance+1 < grid[x][y+1]))
			grid = FillEmptyPoints(grid, x ,y+1, distance+1, visited);
		if(y-1 >= 0 && (visited[x][y-1]==false || distance+1 < grid[x][y-1]))
			grid = FillEmptyPoints(grid, x ,y-1, distance+1, visited);
		
		return grid;*/
		
	
		if(x<0 || x > grid.length-1 || y < 0 || y >  grid[x].length-1 ) return grid;  // out of grid
		if(grid[x][y] == 222) return grid;  // wall
		if(grid[x][y] != 1  && (grid[x][y] == 0 || distance < grid[x][y])) {   // not a door, but is empty or new distance is less than before
			grid[x][y] = distance;
		}
		
		if(visited[x][y]==true || grid[x][y] < distance) return grid;   // if the point is already visited and new distance is more than existing one
		
		grid = FillEmptyPoints(grid, x+1 ,y, distance+1, visited);
		grid = FillEmptyPoints(grid, x-1 ,y, distance+1, visited);
		grid = FillEmptyPoints(grid, x ,y+1, distance+1, visited);
		grid = FillEmptyPoints(grid, x ,y-1, distance+1, visited);
		
		visited[x][y] = true;
		return grid;
		
	}
}


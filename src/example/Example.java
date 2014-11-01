package example;

import java.util.ArrayList;
import java.util.List;

import core.AStar;
import core.Integer2;

/**
 * @author fridenmf
 * 
 * Example file with an implementation of Path, and an example with an very big
 * board, to point out the superiority of an heuristic based approached over a
 * naive one. 
 */
public class Example {

	public static void main(String[] args) {

		/* Here we will navigate through a 18x500 grid, consisting of 0's and 1's where:
		 * 1's are walls 
		 * 0's are walkable tiles
		 */

		int[][] board = getBoard();

		List<PathImpl> startPaths = new ArrayList<>();
		startPaths.add(new PathImpl(board, new Integer2(0, 0), new Integer2(board[0].length-1, board.length-1)));

		AStar<Integer, PathImpl> astar = new AStar<>(startPaths);

		long start = System.currentTimeMillis();
		System.out.println("Result: "+astar.plan());
		long end = System.currentTimeMillis();

		System.out.println("Solved in: "+(end-start)+" ms");

	}

	/**
	 * And here comes our really nice and long board to demonstrate how AStar easily 
	 * finds the correct way by following the path with the lowest heuristic value, 
	 * compared to other naive approaches like width first, depth first, Dijkstra etc, 
	 * which would get brain damage after solving this.
	 * 
	 * I moved the actual board here to let you read the main method before seeing this.
	 * I know I could have generated this by adding using List<int[]>.toArray(new Array[]),
	 * but I'm doing it this way to illustrate the point that it is long
	 */
	public static int[][] getBoard(){
		return new int[][]{
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}, //From here all lines are identical until i say its not anymore
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
				{1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}, // <-- This is the last row thats identical to the one above it
				{1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, // <-- Note this walls of 1's blocks each path except from the 
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1}, //     broad one to the farthest left
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0}, // <-- Btw, this the 500th row 
		};
	}

}

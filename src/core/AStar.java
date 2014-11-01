package core;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author fridenmf
 * 
 * Generic AStar runner
 *
 * @param <T> Type that the heuristic is measured in
 * @param <N> Type of the implementation of Path
 */
public class AStar<T extends Comparable<T>, N extends Path<T, ?, N>> {
	
	/* This is a queue of all paths in the current planning */
	private Queue<N> paths = null;

	/**
	 * @param startPaths List of all paths that is used from the start
	 */
	public AStar(Collection<N> startPaths){
		
		/* We use a priority queue to sort them on their heuristic value */
		paths = new PriorityQueue<>(startPaths);
	}
	
	public N plan(){
		
		/* As long as we don't have a result */
		while(!paths.isEmpty()){
			
			/* We take the path with the lowest heuristic */
			N currP = paths.poll();
			
			/* If it's done, we return it as the result */
			if(currP.isDone()){
				return currP;
			}else{
				/* Otherwise we fork this path into all possible choices of step, and add all variations to the queue */
				paths.addAll(currP.step());
			}
		}
		
		/* If we get here, it means that it was impossible to find a solution */
		return null;
	}
}
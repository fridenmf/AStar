package core;

import java.util.Collection;
import java.util.Set;

/**
 * @author friden
 *
 * @param <T> The type that the heuristic is measured in
 * @param <D> The type that the steps is measured in
 * @param <N> The type of the implementation of Path
 */
public abstract class Path<T extends Comparable<T>, D, N extends Path<T, D, N>> implements Comparable<Path<T, D, N>> {
	
	/**
	 * A heuristic is a value that is an estimation of the cost for this path.
	 * Typically, its the sum of two components: the cost of the actions taken so far
	 * added to the cost of the actions that we estimate is left.
	 * It's important that this heuristic is ALWAYS lower or equal to the actual
	 * cost when this path is done.
	 */
	public abstract T getHeuristic();
	
	/**
	 * This function should, from a path, return all paths that contains the same steps, but with one more,
	 * where each new step is a legal step.
	 */
	public abstract Set<N> step();
	
	public abstract void step(D d);
	
	public abstract Collection<D> getSteps();
	
	public abstract N copy();
	
	public abstract boolean isDone();
	
	/**
	 * A path will be sorted on its heuristic value to work nicely with PriorityQueues
	 */
	@Override
	public int compareTo(Path<T, D, N> p2) {
		return getHeuristic().compareTo(p2.getHeuristic());
	}

}

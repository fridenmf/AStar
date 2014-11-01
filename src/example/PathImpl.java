package example;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import core.Integer2;
import core.Path;

public class PathImpl extends Path<Integer, Dir, PathImpl> {
	
	private Collection<Dir> steps = null;
	
	private int[][] board = null;
	private boolean[][] visited = null;
	
	private boolean isDone = false;
	
	private Integer2 pos = null;
	private Integer2 target = null;
	
	/* This is a storage of unused paths, to be use this to recycle */
	private static Queue<PathImpl> trash = new LinkedList<>();
	
	public PathImpl(PathImpl pathImpl) {
		this.board = pathImpl.board;
		this.visited = new boolean[board.length][board[0].length];
		this.pos = pathImpl.pos.copy();
		this.target = pathImpl.target.copy();
		this.steps = new LinkedList<>(pathImpl.steps);
		for (int y = 0; y < visited.length; y++) {
			for (int x = 0; x < visited[0].length; x++) {
				visited[y][x] = pathImpl.visited[y][x];
			}
		}
	}
	
	public PathImpl(int[][] board, Integer2 pos, Integer2 target) {
		this.board = board;
		this.visited = new boolean[board.length][board[0].length];
		this.pos = pos;
		this.target = target;
		this.steps = new LinkedList<>();
	}
	
	/**
	 * This is used when recycling objects, to set properties of an already created Path 
	 */
	public PathImpl set(PathImpl other){
		this.pos.set(other.pos);
		this.target.set(other.target);
		this.steps.clear();
		this.steps.addAll(other.steps);
		for (int y = 0; y < visited.length; y++) {
			for (int x = 0; x < visited[0].length; x++) {
				visited[y][x] = other.visited[y][x];
			}
		}
		return this;
	}

	/**
	 * Read the documentation for this in the abstract class
	 */
	@Override
	public Integer getHeuristic() {
		
		/* The amount of steps we have taken so far added to the under estimated number of steps that is left */
		return steps.size() + pos.dist(target);
	}

	@Override
	public Set<PathImpl> step() {
		
		/* Here we will put all forks possible from this path */
		Set<PathImpl> result = new HashSet<>();
		
		/* We try each direction */
		for (Dir dir : Dir.getAll()) {
			
			/* This is the new position if we would take direction d */
			Integer2 tmpPos = pos.copy().add(dir);
			
			/* If it's within the bounds of our board */
			if(tmpPos.x >= 0 && tmpPos.y >= 0 && tmpPos.x < board[0].length && tmpPos.y < board.length){
				
				/* And not visited before */
				if(!visited[tmpPos.y][tmpPos.x]){
					
					/* And its not a wall */
					if(board[tmpPos.y][tmpPos.x] != 1){
					
						/* We can add a forked version of this path to the collection of new paths */
						PathImpl newPath = copy();
						newPath.step(dir);
						result.add(newPath);
					}
				}
			}
		}
		
		/* We add this path to the trash, to be recycled */
		trash.add(this);
		
		/* Finally we return a list of all forks that were possible this step */
		return result;
	}
	
	@Override
	public void step(Dir dir) {
		
		/* We add the direction to the Collection of steps */
		steps.add(dir);
		
		/* Move our position */
		pos.add(dir);
		
		/* And mark the tile as visited */
		visited[pos.y][pos.x] = true;
		
		/* If we have reached our target, we are done */
		isDone = pos.equals(target);
	}

	/**
	 * This method is mostly used when we fork paths.
	 * We reuse trashed paths to save some allocation and garbage collection time.
	 */
	@Override
	public PathImpl copy() {
		if(!trash.isEmpty()){
			return trash.remove().set(this);
		}else{
			return new PathImpl(this);
		}
	}
	
	@Override
	public Collection<Dir> getSteps() {
		return steps;
	}

	@Override
	public boolean isDone() {
		return isDone;
	}
	
	/**
	 * Two paths should be considered equals if their steps are the same
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PathImpl)){
			return false;
		}
		PathImpl other = (PathImpl)obj;
		return steps.equals(other.equals(obj));
	}
	
	@Override
	public String toString() {
		return "Steps{"+steps.toString()+"}";
	}

}

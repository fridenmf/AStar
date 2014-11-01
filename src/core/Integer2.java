package core;

import example.Dir;

public class Integer2 {
	
	public int x, y;

	public Integer2() {}
	
	public Integer2(Integer2 other){
		this(other.x, other.y);
	}
	
	public Integer2(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Integer2 sub(Dir dir){
		return sub(dir.toInteger2());
	}

	public Integer2 sub(Integer2 p) {
		x -= p.x;
		y -= p.y;
		return this;
	}

	public int dist(Integer2 pos) {
		return Math.abs(x-pos.x) + Math.abs(y-pos.y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Integer2){
			Integer2 other = (Integer2)obj;
			return x == other.x && y == other.y;
		}else{
			return false;
		}
	}

	public Integer2 set(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public Integer2 add(Integer2 d) {
		this.x += d.x;
		this.y += d.y;
		return this;
	}

	public Integer2 copy() {
		return new Integer2(x, y);
	}
	
	public Integer2 set(Integer2 pos) {
		set(pos.x, pos.y);
		return this;
	}

	public Integer2 add(Dir dir) {
		add(dir.toInteger2());
		return this;
	}
	
	@Override
	public String toString() {
		return "Pos{x: "+x+", y: "+y+"}";
	}
	
}

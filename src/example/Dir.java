package example;

import core.Integer2;


public enum Dir {
	
	RIGHT("right", 1, 0),
	UP("up", 0, -1),
	LEFT("left", -1, 0),
	DOWN("down", 0, 1);
	
	private static Dir[] all = new Dir[]{RIGHT, UP, LEFT, DOWN};
	
	private String stringRep;
	private Integer2 i2;
	
	private Dir(String str, int dx, int dy){
		this.stringRep = str;
		this.i2 = new Integer2(dx, dy);
	}
	
	public Integer2 toInteger2(){
		return i2;
	}
	
	public int getDx(){
		return this.i2.x;
	}
	
	public int getDy(){
		return this.i2.y;
	}
	public static Dir[] getAll(){
		return all;
	}

	@Override
	public String toString() {
		return stringRep;
	}
	
};

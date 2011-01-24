package org.laby.client.laby;

public class GWTPoint {

	public int x;
	public int y;
	
	
	public GWTPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public void setLocation(GWTPoint pos) {
		this.x = pos.x;
		this.y = pos.y;
	}
	
	@Override
	public boolean equals(Object pos) {
		if(pos instanceof GWTPoint){
			return this.x == ((GWTPoint)pos).x && this.y==((GWTPoint)pos).y;
		}
		return false;
		
	}
	

}

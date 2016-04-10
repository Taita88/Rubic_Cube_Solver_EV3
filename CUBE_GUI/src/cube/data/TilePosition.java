package cube.data;

public class TilePosition {
	
	private int x;
	private int y;
	private int side;
	
	public TilePosition(int side, int x, int y){
		this.x = x;
		this.y = y;
		this.side = side;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
	

}

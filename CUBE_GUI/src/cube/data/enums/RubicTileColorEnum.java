package cube.data.enums;

public enum RubicTileColorEnum {
	RED(1.000f, 0.000f, 0.000f), 
	GREEN(0.000f, 1.000f, 0.000f), 
	BLUE(0.000f, 0.000f, 1.000f), 
	YELLOW(1.000f, 1.000f, 0.000f), 
	WHITE(1.000f, 1.000f, 1.000f), 
	BROWN(0.500f, 0.250f, 0.000f);
	
	private float r;
	private float g;
	private float b;
	
	RubicTileColorEnum(float r, float g, float b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public float getRed(){
		return r;
	}
	
	public float getGreen(){
		return g;
	}
	
	public float getBlue(){
		return b;
	}
}

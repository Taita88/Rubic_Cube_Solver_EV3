package cube.data;

import cube.data.enums.RubicTileColorEnum;

public class EdgeTile {
	
	RubicTileColorEnum colorA;
	RubicTileColorEnum colorB;
	
	TilePosition tilePositionA;
	TilePosition tilePositionB;
	
	public EdgeTile(RubicTileColorEnum colorA, RubicTileColorEnum colorB, TilePosition tilePositionA, TilePosition tilePositionB){
		this.colorA = colorA;
		this.colorB = colorB;
		
		this.tilePositionA = tilePositionA;
		this.tilePositionB = tilePositionB;
	}
	
	public EdgeTile(Cube cube, TilePosition tilePositionA, TilePosition tilePositionB){
		this.colorA = cube.getColorByTilePosition(tilePositionA);
		this.colorB = cube.getColorByTilePosition(tilePositionB);
		
		this.tilePositionA = tilePositionA;
		this.tilePositionB = tilePositionB;
	}
	
	@Override
	public String toString(){
		//TODO napisat reprezentaciu EdgeTile
		return "";
	}
	
}

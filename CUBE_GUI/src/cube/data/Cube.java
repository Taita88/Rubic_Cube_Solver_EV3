package cube.data;
import java.util.ArrayList;
import java.util.List;

import cube.data.enums.*;
import static cube.data.enums.RubicSideEnum.*;

public class Cube {		
	
	private RubicTileColorEnum[][][] rubicCube; 
	private List<EdgeTile> edgeTiles;
	
	public Cube(RubicTileColorEnum[][][] colorLayout){
		rubicCube = new RubicTileColorEnum[6][3][3];
		rubicCube = colorLayout.clone();
		
		edgeTiles = new ArrayList<EdgeTile>();
		initEdgeTiles();
	}			

	public void rotate(RotationEnum rotationType){
		switch(rotationType){
		case U: rotate(UP);
				break;
		case L: rotate(LEFT);
				break;
		case F: rotate(FRONT);
				break;
		case R: rotate(RIGHT);
				break;
		case B: rotate(BOTTOM);
				break;
		case D: rotate(DOWN);
				break;
		default:
				break;
		}
	}
	
	private void rotate(int side){
		RubicTileColorEnum[][] sideColors = rubicCube[side];
		RubicTileColorEnum[][] sideColorsTmp = clone2dArray(sideColors);
		
		sideColors[0][2] = sideColorsTmp[0][0];
		sideColors[1][2] = sideColorsTmp[0][1];
		sideColors[2][2] = sideColorsTmp[0][2];
		
		sideColors[0][1] = sideColorsTmp[1][0];
		sideColors[1][1] = sideColorsTmp[1][1];	
		sideColors[2][1] = sideColorsTmp[1][2];
		
		sideColors[0][0] = sideColorsTmp[2][0];
		sideColors[1][0] = sideColorsTmp[2][1];	
		sideColors[2][0] = sideColorsTmp[2][2];
		
		switch (side) {
		case UP:    rotateUpperSide();			
				    break;
		case LEFT:  rotateLeftSide();
					break;
		case RIGHT: rotateRightSide();
					break;
		case FRONT: rotateFrontSide();
					break;
		case BOTTOM:rotateBottomSide();
					break;
		case DOWN:  rotateDownSide();
					break;
		default:
			break;
		}
		
		
	}
	
	public RubicTileColorEnum[][][] getColorLayout(){
		return rubicCube;
	}
	
	public RubicTileColorEnum getColorByTilePosition(TilePosition position){
		return rubicCube[position.getSide()][position.getX()][position.getY()];
	}
	
	private RubicTileColorEnum[][] clone2dArray(RubicTileColorEnum[][] oldArray){
		RubicTileColorEnum[][] newArray = new RubicTileColorEnum[oldArray.length][];
		for(int i = 0; i < oldArray.length; i++){
			newArray[i] = oldArray[i].clone();
		}
		
		return newArray;
	}
	
	private void rotateUpperSide(){
		RubicTileColorEnum[][] bottomTmp = clone2dArray(rubicCube[BOTTOM]);
		
		rubicCube[BOTTOM][2][0] = rubicCube[LEFT][2][2];
		rubicCube[BOTTOM][2][1] = rubicCube[LEFT][1][2];
		rubicCube[BOTTOM][2][2] = rubicCube[LEFT][0][2];
		
		rubicCube[LEFT][0][2] = rubicCube[FRONT][0][0];
		rubicCube[LEFT][1][2] = rubicCube[FRONT][0][1];
		rubicCube[LEFT][2][2] = rubicCube[FRONT][0][2];	
				
		rubicCube[FRONT][0][0] = rubicCube[RIGHT][2][0];
		rubicCube[FRONT][0][1] = rubicCube[RIGHT][1][0];
		rubicCube[FRONT][0][2] = rubicCube[RIGHT][0][0];
				
		rubicCube[RIGHT][0][0] = bottomTmp[2][0];
		rubicCube[RIGHT][1][0] = bottomTmp[2][1];
		rubicCube[RIGHT][2][0] = bottomTmp[2][2];	
	}
	
	private void rotateLeftSide(){
		RubicTileColorEnum[][] upperTmp = clone2dArray(rubicCube[UP]);
		
		rubicCube[UP][0][0] = rubicCube[BOTTOM][0][0];
		rubicCube[UP][1][0] = rubicCube[BOTTOM][1][0];
		rubicCube[UP][2][0] = rubicCube[BOTTOM][2][0];
		
		rubicCube[BOTTOM][0][0] = rubicCube[DOWN][0][0];
		rubicCube[BOTTOM][1][0] = rubicCube[DOWN][1][0];
		rubicCube[BOTTOM][2][0] = rubicCube[DOWN][2][0];
		
		rubicCube[DOWN][0][0] = rubicCube[FRONT][0][0];
		rubicCube[DOWN][1][0] = rubicCube[FRONT][1][0];
		rubicCube[DOWN][2][0] = rubicCube[FRONT][2][0];
		
		rubicCube[FRONT][0][0] = upperTmp[0][0];
		rubicCube[FRONT][1][0] = upperTmp[1][0];
		rubicCube[FRONT][2][0] = upperTmp[2][0];		
	}
	
	private void rotateBottomSide(){
		RubicTileColorEnum[][] upperTmp = clone2dArray(rubicCube[UP]);
		
		rubicCube[UP][0][0] = rubicCube[RIGHT][0][0];
		rubicCube[UP][0][1] = rubicCube[RIGHT][0][1];
		rubicCube[UP][0][2] = rubicCube[RIGHT][0][2];
		
		rubicCube[RIGHT][0][0] = rubicCube[DOWN][2][2];
		rubicCube[RIGHT][0][1] = rubicCube[DOWN][2][1];
		rubicCube[RIGHT][0][2] = rubicCube[DOWN][2][0];
		
		rubicCube[DOWN][2][0] = rubicCube[LEFT][0][2];
		rubicCube[DOWN][2][1] = rubicCube[LEFT][0][1];
		rubicCube[DOWN][2][2] = rubicCube[LEFT][0][0];
		
		rubicCube[LEFT][0][0] = upperTmp[0][0];
		rubicCube[LEFT][0][1] = upperTmp[0][1];
		rubicCube[LEFT][0][2] = upperTmp[0][2];
		
	}
	
	private void rotateRightSide(){
		RubicTileColorEnum[][] upperTmp = clone2dArray(rubicCube[UP]);
		
		rubicCube[UP][0][2] = rubicCube[FRONT][0][2];
		rubicCube[UP][1][2] = rubicCube[FRONT][1][2];
		rubicCube[UP][2][2] = rubicCube[FRONT][2][2];
		
		rubicCube[FRONT][0][2] = rubicCube[DOWN][0][2];
		rubicCube[FRONT][1][2] = rubicCube[DOWN][1][2];
		rubicCube[FRONT][2][2] = rubicCube[DOWN][2][2];
		
		rubicCube[DOWN][0][2] = rubicCube[BOTTOM][0][2];
		rubicCube[DOWN][1][2] = rubicCube[BOTTOM][1][2];
		rubicCube[DOWN][2][2] = rubicCube[BOTTOM][2][2];
		
		rubicCube[BOTTOM][0][2] = upperTmp[0][2];
		rubicCube[BOTTOM][1][2] = upperTmp[1][2];
		rubicCube[BOTTOM][2][2] = upperTmp[2][2];
	}
	
	private void rotateFrontSide(){
		RubicTileColorEnum[][] upperTmp = clone2dArray(rubicCube[UP]);
		
		rubicCube[UP][2][0] = rubicCube[LEFT][2][0];
		rubicCube[UP][2][1] = rubicCube[LEFT][2][1];
		rubicCube[UP][2][2] = rubicCube[LEFT][2][2];
		
		rubicCube[LEFT][2][0] = rubicCube[DOWN][0][2];
		rubicCube[LEFT][2][1] = rubicCube[DOWN][0][1];
		rubicCube[LEFT][2][2] = rubicCube[DOWN][0][0];
				
		rubicCube[DOWN][0][2] = rubicCube[RIGHT][2][0];
		rubicCube[DOWN][0][1] = rubicCube[RIGHT][2][1];
		rubicCube[DOWN][0][0] = rubicCube[RIGHT][2][2];
		
		rubicCube[RIGHT][2][0] = upperTmp[2][0];
		rubicCube[RIGHT][2][1] = upperTmp[2][1];
		rubicCube[RIGHT][2][2] = upperTmp[2][2];		
	}
	
	private void rotateDownSide(){
		RubicTileColorEnum[][] frontTmp = clone2dArray(rubicCube[FRONT]);
		
		rubicCube[FRONT][2][0] = rubicCube[LEFT][0][0];
		rubicCube[FRONT][2][1] = rubicCube[LEFT][1][0];
		rubicCube[FRONT][2][2] = rubicCube[LEFT][2][0];
		
		rubicCube[LEFT][2][0] = rubicCube[BOTTOM][0][0];
		rubicCube[LEFT][1][0] = rubicCube[BOTTOM][0][1];
		rubicCube[LEFT][0][0] = rubicCube[BOTTOM][0][2];
		
		rubicCube[BOTTOM][0][0] = rubicCube[RIGHT][0][2];
		rubicCube[BOTTOM][0][1] = rubicCube[RIGHT][1][2];
		rubicCube[BOTTOM][0][2] = rubicCube[RIGHT][2][2];
		
		rubicCube[RIGHT][0][2] = frontTmp[2][2];
		rubicCube[RIGHT][1][2] = frontTmp[2][1];
		rubicCube[RIGHT][2][2] = frontTmp[2][0];
	}
	
	private void initEdgeTiles() {
		TilePosition tilePositionA, tilePositionB;
		EdgeTile edgeTile;
		
		//UP
		tilePositionA = new TilePosition(UP, 0,1);
		tilePositionB = new TilePosition(BOTTOM, 2,1);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		tilePositionA = new TilePosition(UP, 1,0);
		tilePositionB = new TilePosition(LEFT, 1,2);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		tilePositionA = new TilePosition(UP, 1,2);
		tilePositionB = new TilePosition(RIGHT, 1,0);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		tilePositionA = new TilePosition(UP, 2,1);
		tilePositionB = new TilePosition(FRONT, 0,1);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		//DOWN
		tilePositionA = new TilePosition(DOWN, 0,1);
		tilePositionB = new TilePosition(FRONT, 2,1);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		tilePositionA = new TilePosition(DOWN, 1,0);
		tilePositionB = new TilePosition(LEFT, 2,1);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		tilePositionA = new TilePosition(DOWN, 1,2);
		tilePositionB = new TilePosition(RIGHT, 2,1);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		tilePositionA = new TilePosition(DOWN, 2,1);
		tilePositionB = new TilePosition(BOTTOM, 0,1);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		//LEFT
		tilePositionA = new TilePosition(LEFT, 1,0);
		tilePositionB = new TilePosition(BOTTOM, 1,0);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		tilePositionA = new TilePosition(LEFT, 1,2);
		tilePositionB = new TilePosition(FRONT, 0,1);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile); 
		
		//RIGHT
		tilePositionA = new TilePosition(RIGHT, 1,0);
		tilePositionB = new TilePosition(FRONT, 1,2);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile);
		
		tilePositionA = new TilePosition(RIGHT, 1,2);
		tilePositionB = new TilePosition(FRONT, 1,2);
		edgeTile = new EdgeTile(this, tilePositionA, tilePositionB);
		edgeTiles.add(edgeTile); 
		

		
	}

}

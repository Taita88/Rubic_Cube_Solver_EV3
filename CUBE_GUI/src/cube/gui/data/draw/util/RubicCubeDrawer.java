package cube.gui.data.draw.util;

import static org.lwjgl.opengl.GL11.*;

import java.util.Properties;

import cube.data.enums.RubicTileColorEnum;
import cube.gui.common.DefaultProperties;

public class RubicCubeDrawer {
	
		

	private Properties properties = DefaultProperties.getDefaultProperties().getProperties();
	int tileSize = Integer.parseInt(properties.getProperty("cube.tile.size"));
	int tileBorder = Integer.parseInt(properties.getProperty("cube.tile.border"));	
	int rubicPositionX = Integer.parseInt(properties.getProperty("cube.position.x"));
	int rubicPositionY = Integer.parseInt(properties.getProperty("cube.position.y"));
	
	int rubicSideSize = 3 * (tileSize + tileBorder);
	
	private void drawSquare(float x, float y, float tileSize, RubicTileColorEnum color){
//		System.out.println("Drawing square ["+x+","+y+"]");
		glColor3f(color.getRed(), color.getGreen(), color.getBlue());
		glBegin(GL_QUADS);
		glVertex2f(x  ,y  );
		glVertex2f(x  ,y+tileSize);
		glVertex2f(x+tileSize,y+tileSize);
		glVertex2f(x+tileSize,y  );			
		glEnd();
	}
	
	private void drawRubicTile(float x, float y, RubicTileColorEnum color){
		drawSquare(x, y, tileSize, color);
	}
	
	private void drawRubicSide(float x, float y, RubicTileColorEnum[][] color){	
		int currentX = 0;
		int currentY = 0;
		for(int i = 0; i<color.length; i++){
			for(int j = 0; j<color[i].length; j++){
				drawRubicTile(x + rubicPositionX + currentX,y + rubicPositionY + currentY,color[i][j]);
				currentX += tileSize + tileBorder;
			}
			currentX = 0;
			currentY += tileSize + tileBorder;
		}				
	}
	
	public void drawRubicCube2d(RubicTileColorEnum[][][] color){		
		drawRubicSide(rubicPositionX + rubicSideSize, rubicPositionY, color[0]);
		
		drawRubicSide(rubicPositionX, rubicPositionY + rubicSideSize, color[1]);
		drawRubicSide(rubicPositionX + rubicSideSize, rubicPositionY + rubicSideSize, color[2]);
		drawRubicSide(rubicPositionX + (2 * rubicSideSize), rubicPositionY + rubicSideSize, color[3]);
		
		drawRubicSide(rubicPositionX + rubicSideSize, rubicPositionY + (2 * rubicSideSize), color[4]);
		drawRubicSide(rubicPositionX + rubicSideSize, rubicPositionY + (3 * rubicSideSize), color[5]);
	}

}

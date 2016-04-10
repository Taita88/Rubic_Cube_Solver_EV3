package cube.gui.data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import cube.data.Cube;
import cube.data.enums.*;

import static cube.data.enums.RubicTileColorEnum.*;

import static org.lwjgl.opengl.GL11.*;

public class Starter {			

	public static void main(String[] args) {
		
		RubicCubeGUI rubicCubeGUI = RubicCubeGUI.getInstance();
		
		RubicTileColorEnum[][][] colorLayout = { 
				{{YELLOW,RED,RED},
				{YELLOW,GREEN,BROWN},
				{RED,BLUE,GREEN}},
				
				{{BLUE,RED,WHITE},
				{YELLOW,WHITE,YELLOW},
				{BROWN,BLUE,WHITE}},
				
				{{BLUE,WHITE,WHITE},
				{BLUE,RED,GREEN},
				{BROWN,RED,BROWN}},
				
				{{RED,WHITE,YELLOW},
				{BROWN,YELLOW,BROWN},
				{BLUE,GREEN,BROWN}},
				
				{{GREEN,WHITE,YELLOW},
				{BROWN,BLUE,WHITE},
				{WHITE,GREEN,GREEN}},
				
				{{BLUE,RED,YELLOW},
				{GREEN,BROWN,YELLOW},
				{RED,BLUE,GREEN}}
			};
		
		Cube cube = new Cube(colorLayout);
//		cube.rotate(RotationEnum.D);
//		cube.rotate(RotationEnum.U);
//		cube.rotate(RotationEnum.L);
//		cube.rotate(RotationEnum.R);
//		cube.rotate(RotationEnum.B);
//		cube.rotate(RotationEnum.F);
		
		Display.setTitle("Rubic Cube Solver");
		
		try {
			Display.setDisplayMode(new DisplayMode(800, 700));	
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 700, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		//TODO cyklus vlozit do threadu
		while(!Display.isCloseRequested()){
			
			rubicCubeGUI.setColorLayout(cube.getColorLayout());			
			rubicCubeGUI.draw();
				
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		
	}

}

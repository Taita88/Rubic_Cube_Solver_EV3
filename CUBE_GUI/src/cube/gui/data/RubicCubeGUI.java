package cube.gui.data;

import static cube.data.enums.RubicTileColorEnum.*;
import cube.data.enums.RubicTileColorEnum;
import cube.gui.data.draw.util.RubicCubeDrawer;

public class RubicCubeGUI {
	
	private static RubicCubeGUI rubicCubeGUIInstance;
	private RubicTileColorEnum[][][] colorLayout;
	private RubicTileColorEnum[][][] defaultColorLayout = { 
													{{BLUE,BLUE,BLUE},
													{BLUE,BLUE,BLUE},
													{BLUE,BLUE,BLUE}},
													
													{{RED,RED,RED},
													{RED,RED,RED},
													{RED,RED,RED}},
													
													{{GREEN,GREEN,GREEN},
													{GREEN,GREEN,GREEN},
													{GREEN,GREEN,GREEN}},
													
													{{BROWN,BROWN,BROWN},
													{BROWN,BROWN,BROWN},
													{BROWN,BROWN,BROWN}},
													
													{{WHITE,WHITE,WHITE},
													{WHITE,WHITE,WHITE},
													{WHITE,WHITE,WHITE}},
													
													{{YELLOW,YELLOW,YELLOW},
													{YELLOW,YELLOW,YELLOW},
													{YELLOW,YELLOW,YELLOW}}
												};
	
	RubicCubeDrawer cubeDrawer = new RubicCubeDrawer();
	
	private RubicCubeGUI(){
		
	}
	
	public static RubicCubeGUI getInstance(){
		if(rubicCubeGUIInstance != null){
			return rubicCubeGUIInstance;
		}else{
			return new RubicCubeGUI();
		}
	}
	
	
	public void setColorLayout(RubicTileColorEnum[][][] colorLayout){
		this.colorLayout = colorLayout;
	}
	
	/**
	 * Callable only from OpenGL context
	 */
	public void draw(){
		if(colorLayout != null){
			cubeDrawer.drawRubicCube2d(colorLayout);
		}else{
			cubeDrawer.drawRubicCube2d(defaultColorLayout);
		}
	}

}

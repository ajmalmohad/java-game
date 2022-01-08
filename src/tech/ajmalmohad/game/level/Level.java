package tech.ajmalmohad.game.level;

import tech.ajmalmohad.game.graphics.Screen;
import tech.ajmalmohad.game.level.tile.Tile;

public class Level {
	protected int width;
	protected int height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height= height;
		tiles = new int[width*height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	//Load Level From Image
	private void loadLevel(String path) {
		
	}
	
	//Generate Random Level
	protected void generateLevel() {
		
	}
	
	//Updates The Level like Moving Components
	public void update() {
		
	}
	
	//Render Level
	//XScroll and YScroll will be Position of Player
	//Level Offsets According to Player Movements
	public void render(int xScroll, int yScroll,Screen screen) {
		screen.setOffsets(xScroll, yScroll);
		int x0 = xScroll / 16;
		int y0 = yScroll/16;
		int x1 = (xScroll + screen.width)/16;
		int y1 = (yScroll + screen.height)/16;
		
	}
	
	public Tile getTile(int x, int y) {
		if(tiles[x+y*width]==0) {
			return Tile.grassTile;
		}else {
			return Tile.voidTile;
		}
	}
	
	//Manages Time
	private void time() {
		
	}
	
}

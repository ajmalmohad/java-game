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
	//Abstract
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
		int x0 = xScroll >> 4;
		int y0 = yScroll >> 4;
		// +16 is to Expand Render Zone to Make it Close to Width and Height
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for(int y=y0; y<y1; y++) {
			for(int x=x0; x<x1; x++) {
				getTile(x,y).render(x, y, screen);
			}
		}
		
	}
	
	public Tile getTile(int x, int y) {
		if(x<0 || x>= width || y<0 || y>= height) return Tile.voidTile;
		if(tiles[x+y*width]==0) return Tile.grassTile;
		if(tiles[x+y*width]==1) return Tile.rockTile;
		return Tile.voidTile;
	}
	
	//Manages Time
	public void time() {
		
	}
	
}

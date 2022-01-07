package tech.ajmalmohad.game.level;

import tech.ajmalmohad.game.graphics.Screen;

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
	public void render(int xScroll, int yScroll,Screen screen) {
		
	}
	
	//Manages Time
	private void time() {
		
	}
	
}

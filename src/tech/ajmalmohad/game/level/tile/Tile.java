package tech.ajmalmohad.game.level.tile;

import tech.ajmalmohad.game.graphics.Screen;
import tech.ajmalmohad.game.graphics.Sprite;

public class Tile {
	public int x;
	public int y;
	public Sprite sprite;
	
	public static Tile grassTile = new GrassTile(Sprite.grass);
	public static Tile rockTile = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void render(int x,int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}
	
}

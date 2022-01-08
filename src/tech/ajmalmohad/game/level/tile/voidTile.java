package tech.ajmalmohad.game.level.tile;

import tech.ajmalmohad.game.graphics.Screen;
import tech.ajmalmohad.game.graphics.Sprite;

public class voidTile extends Tile {

	public voidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x,int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}

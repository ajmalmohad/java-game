package tech.ajmalmohad.game.level.tile;

import tech.ajmalmohad.game.graphics.Screen;
import tech.ajmalmohad.game.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x,int y, Screen screen) {
		screen.renderTile(x, y, this);
	}

}

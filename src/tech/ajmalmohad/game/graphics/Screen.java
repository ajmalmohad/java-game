package tech.ajmalmohad.game.graphics;

import java.util.Random;

import tech.ajmalmohad.game.level.tile.Tile;

//Fills Screen With Colors that We Specify for Each Pixel
public class Screen {
	
	//Private Variables
	public int width;
	public int height;
	
	//Random Number
	private Random random = new Random();
	
	//Public Variables
	public int xOffset, yOffset;
	
	//Contains Pixel Data
	public int[] pixels;
	
	//Map Size
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	//Contains Map/Tiles Data
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	
	//Constructor
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width*height];
		
		//Genertae Tiles
		for(int i=0; i<MAP_SIZE*MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
		
	}
	
	//Clear the Screen
	public void clear() {
		for(int i=0; i<pixels.length; i++) {
			pixels[i] = 0;
		 }
	}
	
	//Render Tile
	public void renderTile(int xp, int yp, Tile tile) {
		//Setting Offsets based on player Movement(Opposite Way for Map)
		xp -= xOffset;
		yp -= yOffset;
		for(int y=0; y<tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for(int x=0; x<tile.sprite.SIZE; x++) {
				int xa = x + xp;
				// -tile.sprite.size to Avoid Black Screen on Left Side
				if(xa<-tile.sprite.SIZE || xa>=width || ya<0 || ya>=height) break;
				if(xa<0) xa=0;
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	//Set Offsets
	public void setOffsets(int xOffset,int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	
}

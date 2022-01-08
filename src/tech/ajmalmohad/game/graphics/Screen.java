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
	
	//Render
	public void render(int xOffset, int yOffset) {
		 for(int y=0; y<height; y++) {
			 int yp = y+yOffset;
			 if(yp<0||yp>=height)continue;
			 for(int x=0; x<width; x++) {
				 int xp = x+xOffset;
				 if(xp<0||xp>=width)continue;
				 pixels[(xp)+(yp)*width] = Sprite.grass.pixels[(x&15)+(y&15)*Sprite.grass.SIZE]; 
			 }
		 }
	}
	
	//Render Tile
	public void renderTile(int xp, int yp, Tile tile) {
		for(int y=0; y<tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for(int x=0; x<tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if(xa<0 || xa>=width || ya<0 || ya>=height) break;
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
}

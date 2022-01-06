package tech.ajmalmohad.game.graphics;

import java.util.Random;

//Fills Screen With Colors that We Specify for Each Pixel
public class Screen {
	
	//Private Variables
	private int width;
	private int height;
	
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
			 int yy = y + yOffset;
			 
			 //Prevents Array Index Out of Bounds
			 //if(yy<0 || yy>=height) break; 
			 
			 for(int x=0; x<width; x++) {
				 int xx = x + xOffset;
				 
				//Prevents Array Index Out of Bounds
				//if(xx<0 || xx>=width) break; 
				 
				//Screen only Hold 18 Tiles at once (64-18) Remaining Tiles are Skipped
				//(xx >> 4) & 63) says if (xx >> 4) is Greater than 63 goto 0 like a Loop
				//Bitwise and Operator Here It Prevents Out of Bounds Error
				 int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK)*MAP_SIZE; 
				 pixels[x+y*width] = tiles[tileIndex];
				 
			 }
		 }
	}
	
	
}

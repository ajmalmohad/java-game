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
	
	//Contains Map/Tiles Data
	public int[] tiles = new int[64*64];
	
	//Constructor
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width*height];
		
		//Genertae Tiles
		for(int i=0; i<64*64; i++) {
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
	public void render() {
		 for(int y=0; y<height; y++) {
			 for(int x=0; x<width; x++) {
				 //int tileIndex = (x/16) + (y/16)*64;
				 int tileIndex = (x >> 4) + (y >> 4)*32;
				 pixels[x+y*width] = tiles[tileIndex];
			 }
		 }
	}
	
	
}

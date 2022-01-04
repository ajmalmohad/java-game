package tech.ajmalmohad.game.graphics;


//Fills Screen With Colors that We Specify for Each Pixel
public class Screen {
	
	//Private Variables
	private int width;
	private int height;
	
	//Public Variables
	
	//Contains Pixel Data
	public int[] pixels;
	
	//Constructor
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width*height];
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
				 pixels[x+y*width] = 0xff00ff;
			 }
		 }
	}
	
	
}

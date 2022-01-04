package tech.ajmalmohad.game.graphics;


//Fills Screen With Colors that We Specify for Each Pixel
public class Screen {
	
	//Private Variables
	private int width;
	private int height;
	
	//Public Variables
	
	public int time = 0;
	public int counter = 0;
	public boolean forward = true;
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
		counter++;
		if(forward && counter%50 == 0 && time<height-1) {
			time++;
		}else if(!forward && counter%50 == 0 && time>0) {
			time--;
		}else if(time == height-1) {
			forward=false;
		}else if(time == 0) {
			forward=true;
		}
		
		 for(int y=0; y<height; y++) {
			 for(int x=0; x<width; x++) {
				 pixels[x+time*width] = 0xff00ff;
			 }
		 }
	}
	
	
}

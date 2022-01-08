package tech.ajmalmohad.game.graphics;

public class Sprite {
	public final int SIZE;
	private int x;
	private int y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	//Grass
	public static Sprite grass = new Sprite(16,0,0,SpriteSheet.sheet);
	public static Sprite voidSprite = new Sprite(16,0x00ffff);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		pixels = new int[SIZE*SIZE];
		this.x = x*size;
		this.y = y*size;
		this.sheet = sheet;
		loadSprite();
	}
	
	public Sprite(int size, int color) {
		this.SIZE = size;
		pixels = new int[SIZE*SIZE];
		for(int y=0; y<SIZE; y++) {
			for(int x=0; x<SIZE; x++) {
				pixels[x+y*SIZE] = color;
			}
		}
	}
	
	private void loadSprite() {
		for(int y=0; y<SIZE; y++) {
			for(int x=0; x<SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[(x+this.x)+(y+this.y)*sheet.SIZE];
			}
		}
	}
}

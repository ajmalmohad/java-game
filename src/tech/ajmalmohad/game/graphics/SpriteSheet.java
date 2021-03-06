package tech.ajmalmohad.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	//SpriteSheet
	public static SpriteSheet sheet = new SpriteSheet("/textures/spriteSheet.png",256);
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE*SIZE];
		loadImage();
	}
	
	private void loadImage() {
		try {
			//Loads Image and Convert to Pixel Data
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

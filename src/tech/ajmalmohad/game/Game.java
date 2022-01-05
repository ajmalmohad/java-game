package tech.ajmalmohad.game;

//Java Imports
import java.awt.Canvas;
//import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

//Custom Imports
import tech.ajmalmohad.game.graphics.Screen;


public class Game extends Canvas implements Runnable {
	
	//Canvas Class is Serializeable
	private static final long serialVersionUID = 1L;
	
	//Public Variables
	public static int width = 300;
	public static int height = width*9/16; // 16:9 Ratio
	public static int scale  = 3;
	public static String title = "Rain";
	
	//Private Variables
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	//Screen Object
	private Screen screen;
	
	//Main Image Object/View/Final Rendered Image
	private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	
	//To Write Data to every Pixel of Image
	//DataBufferInt casts/convert to DataBufferInt class or Integers
	//getRaster() returns writeable Raster(Array of Pixels to which we can write Color Data)
	//getDataBuffer() returns Data Buffer of the Raster
	//Essentially We Convert the Image to an Array of Integers
	//We can Modify values of Array and Create an Image
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData() ;
	
	//Default Constructor
	public Game() {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		//Creates New Screen
		screen = new Screen(width,height);
		//Creates new JFrame
		frame = new JFrame();
	}
	
	//Start the Thread
	public synchronized void start() {
		running = true;
		thread = new Thread(this,"Display");
		thread.start();
	}
	
	//Stop the thread
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Thread.start() automatically invokes run()
	public void run() {
		
		//NanoTime for Frame Updates
		long lastTime = System.nanoTime();
		long now;
		final double ns = 1000000000.0 / 60.0;
		
		//Time Difference (Becomes 1 at every 1/60th of a second)
		double delta = 0;
		
		//MilliSeconds Timer
		long timer = System.currentTimeMillis();
		
		//FPS Counter Helpers
		int frames = 0;
		int updates = 0;
		
		//The Game Loop
		while(running) {
			
			//Current Time and Delta
			now = System.nanoTime();
			//Becomes 1 at Every 1/60th of a Second
			delta += (now - lastTime)/ns;
			//Updates the LastTime
			lastTime = now;
			
			//Execute at Specified FPS and Update Delta
			while(delta >= 1) {
				update();
				updates++;
				delta--;
			}
			
			//Render Every Frame
			render();
			
			//Update Frame Count
			frames++;
			
			//Display UPS and FPS
			if(System.currentTimeMillis() - timer > 1000) {
				//Updates Timer
				timer = System.currentTimeMillis();
				//Displays FPS and UPS on Title
				frame.setTitle(title + " | " + updates + " UPS | " + frames +" FPS"); 
				//Reset Every Second
				frames = 0;
				updates = 0;
			}
			
		}
		//Game Loop End
		
	}
	
	//Update at Controlled FPS
	//Updates Movements,Controls etc..
	public void update() {
		
	}
	
	//Render at Max FPS 
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			//Triple Buffering - Stores 2 Image at Once to Display
			//We can get Speed Improvements by having a back buffer
			//We can calculate while one is being displayed
			createBufferStrategy(3);
			return;
		}
		
		//Clears Pixel Data
		screen.clear();
		
		//Filling Pixel Data
		screen.render();
		
		//Populate Pixels Array With Color Data from Pixels of Screen Class
		for(int i=0; i<pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		//Graphics object has state information needed for the basic rendering operations
		//Creates a Link between Graphics and Buffer Strategy
		Graphics g = bs.getDrawGraphics();
		
		//All The Graphics

		//Draw Image
		g.drawImage(image, 0, 0, getWidth(), getHeight(),null);
		
		//Disposes Current Graphics and Releases System Resources at end of each frame
		//Or Graphics from each frame will not be removed, it will crash the game
		g.dispose();
		
		//We need to do Buffer Swapping/Blitting
		//Copy bits from one part of a computer's graphical memory to another part
		//We Remove Previous Buffers and Calculate and Display New Buffer Strategy
		bs.show();
	}
	
	//Main Method
	public static void main(String[] args) {
		Game game  = new Game();
		
		//JFrame Configurations
		
		//Set Window as Non-Resizeable
		game.frame.setResizable(false);
		//Set Title
		game.frame.setTitle(Game.title); 
		//Add Component/Fills Window with instance of Game
		//Game is Subclass of Canvas, so it is a Component
		game.frame.add(game); 
		//Set Size of Frame to Size of Component
		game.frame.pack(); 
		//Terminate Application on Exit Button
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set Window Position to Center
		game.frame.setLocationRelativeTo(null);
		//Show the Window
		game.frame.setVisible(true);
		
		//Start Game
		game.start();
	}
	
}

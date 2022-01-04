package tech.ajmalmohad.game;

//Java Imports
import java.awt.Canvas;
import javax.swing.JFrame;
//import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

//Custom Class Imports
//import tech.ajmalmohad.helpers.Dimension;

public class Game extends Canvas implements Runnable {
	
	//Canvas Class is Serializeable
	private static final long serialVersionUID = 1L;
	
	//Public Variables
	public static int width = 300;
	public static int height = width*9/16; // 16:9 Ratio
	public static int scale  = 3;
	
	//Private Variables
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	//Default Constructor
	public Game() {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
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
		while(running) {
			update();
			render();
		}
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
	}
	
	//Main Method
	public static void main(String[] args) {
		Game game  = new Game();
		
		//JFrame Configurations
		
		//Set Window as Non-Resizeable
		game.frame.setResizable(false);
		//Set Title
		game.frame.setTitle("Rain"); 
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

package pc.petko.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

// this is the main class
// everything will  be drawn here
public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -7005128061037155743L;
	
	// parameters for the window
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 12 * 9;
	
	private boolean running = false;
	
	private Thread thread;  			//  run on a thread
	private Handler handler;
	private Random r;
	private HUD hud;
	private Spawn spawner;
	
	// Initialize all of the objects
	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler)); // handler determines which of the object's input
		
		new Window(WIDTH, HEIGHT, "Game title", this);  //x this refers to the game class
	
		hud = new HUD(); 
		spawner = new Spawn(handler, hud);
		r = new Random();
		
		
		handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player, handler));  // creates player object
		handler.addObject(new BasicEnemy(r.nextInt(Game.HEIGHT), r.nextInt(Game.WIDTH),ID.BasicEnemy, handler)); //creates start enemy
	}
	
	public synchronized void start() {  // synchronized because it's a thread
		thread = new Thread(this);  	// create thread game
		thread.start(); 				// start game on thread
		running = true;
	}
	
	public synchronized void stop() {  // synchronized because it's a thread
		try {
			thread.join(); 			   // stops the thread
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 * Game Loop Logic
	 * Popular game loop
	 * implemented method from Runnable interface
	 */
	public void run() {
		this.requestFocus(); // no more mouse click
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy(); // ????
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		// black screen
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g); // first handler (on top)
		hud.render(g); // second heads-up display
		
		g.dispose(); // flush
		bs.show(); // show and flush buffers
		
	}
	
	// Prohibits box to move out of canvas
	public static int clamp(int var, int min, int max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}
	}

	private void tick() {
		handler.tick();
		hud.tick();
		spawner.tick();
	}

	public static void main (String args[]) {
		new Game(); // creates a game
	}

	
	
	
	
}

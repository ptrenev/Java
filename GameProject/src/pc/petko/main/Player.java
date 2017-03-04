package pc.petko.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;		
	}

	@Override
	public void tick() {
		// very important updates every millisecond
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 38);
		y = Game.clamp(y, 0, Game.HEIGHT - 64);
		
		handler.object.add(new Trail(x,y, ID.Trail, handler, Color.WHITE, 32, 32, 0.1f));
		
		collision();
	}
	
	
	// handle object collision
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					HUD.HEALTH -= 2;   // why?
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);  // box size
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y, 32, 32); // width, height same as box size
	}
	
	

}
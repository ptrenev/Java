package pc.petko.main;

import java.awt.Graphics;
import java.awt.Rectangle;

/*
	All game objects
	- players
	- coins
	- enemies
*/
public abstract class GameObject {
	
	protected int x,y;		// only accessed by which object inherits the GameObject
	protected ID id;
	protected int velX, velY;  // speed x,y directions
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	// we are going to need it for the Players and Enemies class
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds(); // use rectangle class to handle collision
	
	
	// Getters and setters
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public ID getId() {
		return id;
	}
}
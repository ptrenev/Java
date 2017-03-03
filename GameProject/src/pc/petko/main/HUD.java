package pc.petko.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	
	private int greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	
	public HUD() {
		
	}
	
	public void tick() {
	
		HEALTH = Game.clamp(HEALTH, 0, 100);
		
		// transition from green to red
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH * 2;
		
		score++;
	}
	
	public void render(Graphics g) {
		
		// health bar customization
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 100, 20);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, HEALTH * 2, 20);
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, HEALTH * 2, 20); // border around health bar
		
		// draw a string on top
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
		
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}

}

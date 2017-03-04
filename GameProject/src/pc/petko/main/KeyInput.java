package pc.petko.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	 public void keyPressed(KeyEvent e){
		 int key = e.getKeyCode(); // press a key display number value ASCII

		 // we have a problem here how to understand which Player is which
		 for (int i = 0; i < handler.object.size(); i++) { // loop through all objects
			 GameObject tempObject = handler.object.get(i);
			 
			 // temp object each object in the game
			 if (tempObject.getId() == ID.Player) {
				 // all key events for Player
				 if (key == KeyEvent.VK_UP) tempObject.setVelY(-5); // moves on the y axis
				 if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-5); // moves left
				 if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(5); // moves right
				 if (key == KeyEvent.VK_DOWN) tempObject.setVelY(5); // moves down
			 }
		 } 
		 
		 if (key == KeyEvent.VK_ESCAPE) System.exit(1);
	 }
	 
	 public void keyReleased(KeyEvent e){ // stops the object from moving
		 int key = e.getKeyCode();
		 
		 for (int i = 0; i < handler.object.size(); i++) {
			 GameObject tempObject = handler.object.get(i);
			 
			 if (tempObject.getId() == ID.Player) {
				 if (key == KeyEvent.VK_UP) tempObject.setVelY(0);
				 if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
				 if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				 if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
			 }
			 
		 }
		 
	 }

}
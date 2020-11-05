package bouncyGame;

import java.awt.Color;
import java.awt.Graphics;

public class Plate {

	int widthRect = 60, heightRect = 10;

	
	
	public Plate() {
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) 
	{
		g.setColor(new Color(224, 102, 49));
		g.drawRect(Bouncy.WIDTH/2 - widthRect, Bouncy.HEIGHT - (Bouncy.HEIGHT - heightRect), widthRect, heightRect);
	}
	
	public void move()
	{
		
	}

}

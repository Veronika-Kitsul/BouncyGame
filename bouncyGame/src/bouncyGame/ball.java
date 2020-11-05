package bouncyGame;

import java.awt.Color;
import java.awt.Graphics;

public class ball {

	// passing width and height for the frame
	public ball(int x, int y, int width, int height) 
	{
		
	}
	
	public void draw(int x, int y, int width, int height, Graphics g) 
	{
		g.setColor(new Color(94, 184, 101));
		g.drawOval(x, y, width, width);
	}
	
	public void move()
	{
		
	}

}

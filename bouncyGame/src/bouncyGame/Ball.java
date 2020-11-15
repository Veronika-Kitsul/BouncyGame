package bouncyGame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	// setting ball radius to be constant
	int ballRadius = 38;
	int x = (Bouncy.WIDTH - ballRadius) / 2;
	int y = (Bouncy.HEIGHT - 100 - Plate.HEIGHTRECT - ballRadius);
	
	public Ball() 
	{
		
	}
	
	// draw a ball in the center 
	public void draw(Graphics g) 
	{
		g.setColor(new Color(94, 184, 101));
		g.fillOval(x, y, ballRadius,  ballRadius);
	}
	
	public void move()
	{
		x = x + 20;
		y = y - 20;
	}

}

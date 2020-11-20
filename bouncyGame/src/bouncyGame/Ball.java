package bouncyGame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	// setting ball radius to be constant
	public static final int ballRadius = 38;
	int x = (Bouncy.WIDTH - ballRadius) / 2;
	public static int Bally = (Bouncy.HEIGHT - 100 - Plate.HEIGHTRECT - ballRadius);
	public static int velocityX = 20;
	public static int velocityY = 20;
	
	public Ball() 
	{
		
	}
	
	// draw a ball in the center 
	public void draw(Graphics g) 
	{
		g.setColor(new Color(94, 184, 101));
		g.fillOval(x, Bally, ballRadius,  ballRadius);
	}
	
	public void move()
	{

		if ((x >= (Bouncy.WIDTH - ballRadius)) || (x <= 0) )
		{
			 velocityX = - velocityX;
		}
		
		// get rid of the second part!!!!!
		if (Bally <= 0 || Bally >= (Bouncy.HEIGHT - 100 - ballRadius))
		{
			velocityY = - velocityY;
		}
		
		x = x + velocityX;
		Bally = Bally - velocityY;
	}

}

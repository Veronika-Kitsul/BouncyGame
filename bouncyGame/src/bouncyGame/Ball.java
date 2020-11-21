package bouncyGame;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	// setting ball radius to be constant
	public static final int ballRadius = 38;
	public static int Ballx = (Bouncy.WIDTH - ballRadius) / 2;
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
		g.fillOval(Ballx, Bally, ballRadius,  ballRadius);
	}
	
	public void move()
	{

		if ((Ballx >= (Bouncy.WIDTH - ballRadius)) || (Ballx <= 0) )
		{
			 velocityX = - velocityX;
		}
		
		if (Bally <= 0)
		{
			velocityY = - velocityY;
		}
		
		Ballx = Ballx + velocityX;
		Bally = Bally - velocityY;
	}

}

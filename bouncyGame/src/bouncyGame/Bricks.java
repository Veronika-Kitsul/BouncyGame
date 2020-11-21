package bouncyGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bricks extends Rectangle {

	// number of bricks we have
	public static final int numberInX = 10;
	public static final int numberInY = 3;
	
	// height of each brick
	public static final int rectHeight = 40;
	
	public Bricks(int x, int y) {
		super(x,y,(Bouncy.WIDTH / numberInX), rectHeight);
	}


	public void draw(Graphics g)
	{
		g.setColor(Color.black);
		g.drawRect(x, y, (Bouncy.WIDTH / Bricks.numberInX), Bricks.rectHeight);
		g.setColor(new Color(247, 186, 72));
		g.fillRect(x, y, (Bouncy.WIDTH / Bricks.numberInX), Bricks.rectHeight);
		
	}

}
	



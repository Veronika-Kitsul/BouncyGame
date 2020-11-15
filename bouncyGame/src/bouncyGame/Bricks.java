package bouncyGame;

import java.awt.Color;
import java.awt.Graphics;

public class Bricks {

	// number of bricks we have
	public static final int numberInX = 10;
	public static final int numberInY = 3;
	
	// height of each brick
	public static final int rectHeight = 40;
	
	int x;
	int y;
	

	public Bricks(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public void draw(Graphics g)
	{
		g.setColor(Color.black);
		g.drawRect(x, y, (Bouncy.HEIGHT / Bricks.numberInX), Bricks.rectHeight);
		g.setColor(new Color(247, 186, 72));
		g.fillRect(x, y, (Bouncy.HEIGHT / Bricks.numberInX), Bricks.rectHeight);
		
	}

}

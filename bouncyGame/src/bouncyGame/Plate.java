package bouncyGame;

import java.awt.Color;
import java.awt.Graphics;

public class Plate {

	public static final int widthRect = 80, HEIGHTRECT = 25;
	int x = (Bouncy.WIDTH - widthRect)/2;
	public static int y = Bouncy.HEIGHT - 100 - HEIGHTRECT;
	
	public Plate() {
		
	}

	public void draw(Graphics g) 
	{
		g.setColor(new Color(224, 102, 49));
		g.fillRect(x, y, widthRect, HEIGHTRECT);
	}
	
	public void move(int x)
	{
		this.x = x;
	}

}

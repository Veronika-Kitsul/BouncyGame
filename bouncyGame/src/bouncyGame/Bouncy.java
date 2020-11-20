package bouncyGame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Bouncy 
{
	public static final int WIDTH = 700, HEIGHT = 700;
	int score = 0;
	int y = 0;
	int x = 0;
	Plate rect = new Plate();
	Ball ball = new Ball();
	boolean isStarted = false;
	int plateX;
	int plateY;
	JFrame frame = new JFrame();
	
	ArrayList<Bricks> bricksList = new ArrayList<Bricks>();
	
	public Bouncy() 
	{
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(Bouncy.WIDTH, Bouncy.HEIGHT));
		frame.add(panel);
		

		for (int i = 0; i < Bricks.numberInY; i++)
		{
			for (int j = 0; j < Bricks.numberInX; j++)
			{
				bricksList.add(new Bricks(x, y));
				x = x + (Bouncy.WIDTH / Bricks.numberInX);
			}
			x = 0;
			y = y + Bricks.rectHeight;
		}
		
		
		
		JPanel game = new JPanel() 
		{
			public void paintComponent(Graphics g)
			{
				// add background as a blue rectangle
				g.setColor(new Color(210, 200, 200));
				g.fillRect(0, 0, Bouncy.WIDTH, Bouncy.HEIGHT);
				
				// draw a plate calling class plate
				rect.draw(g);
				ball.draw(g);
				
				//
				for (int i = 0; i < bricksList.size(); i++)
				{
					bricksList.get(i).draw(g);
				}
			}
		};
		
		
		panel.add(game);
		game.setPreferredSize(new  Dimension (WIDTH, HEIGHT - 100));
	
		
		JPanel buttons = new JPanel();
		panel.add(buttons);
		
		// creating a start button and adding it to the panel
		JButton start = new JButton("Start");
		buttons.add(start);
		

		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				game.addMouseMotionListener(new MouseMotionListener()
				{
					public void mouseDragged(MouseEvent e) {
						
					}

					public void mouseMoved(MouseEvent e) {
						rect.move(e.getX());
						plateX = e.getX();
						plateY = e.getY();
						frame.getContentPane().repaint();
					}	
				});
				
				
				// here i change isStarted to true
				isStarted = true;
				
			}
		});
		
		
		JLabel scoreboard = new JLabel("Score: " + score);
		buttons.add(scoreboard);
		
		JButton endGame = new JButton("End The Game");
		buttons.add(endGame);
		
		
		
		endGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				isStarted = false;
			}
		});

	
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// this doesn't work when i have isStarted == true, but it works if i change the condition to just true
		while (true)
		{
			if (isStarted == true)
			{
				ball.move();
				checkIntersections();
				frame.getContentPane().repaint();
			}
			sleep(50);
		}
	}
	
	public void checkIntersections() 
	{		
		if (new Rectangle(plateX, plateY, Plate.widthRect, Plate.HEIGHTRECT).intersects(new Rectangle(ball.x, Ball.Bally, Ball.ballRadius,  Ball.ballRadius)) == true)
		{
			Ball.velocityY = - Ball.velocityY;
		}
		
		// problems here
		for (int i = 0; i < bricksList.size(); i++)
		{	
			if (new Rectangle(x, y, (Bouncy.HEIGHT / Bricks.numberInX), Bricks.rectHeight).intersects(new Rectangle(ball.x, Ball.Bally, Ball.ballRadius,  Ball.ballRadius)))
			{
				bricksList.remove(i);
				
				// how do i actually update it????
				score++;
				frame.getContentPane().repaint();
			}
		}
		

		// if the ball hits the lower bound, set score to 0
		// also need to stop it completely
		if (Ball.Bally >= (Bouncy.HEIGHT - 100))
		{
			
			score = 0;
			// OptionPane pane = new OptionPane();
			// pane.window();
		}
	}
	
	private static void sleep(int time) {
		try 
		{
			Thread.sleep(time);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	// when there is no bricks left - message about you won
	
	public static void main(String[] args) 
	{
		new Bouncy();

	}
}

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
	JLabel scoreboard = new JLabel("Score: " + score);
	
	ArrayList<Bricks> bricksList = new ArrayList<Bricks>();
	
	public Bouncy() 
	{
		// setting the overall panel and it's size, adding it to frame
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(Bouncy.WIDTH, Bouncy.HEIGHT));
		frame.add(panel);
		
		// creating the array list of bricks and their coordinates
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
		
		
		// panel for the game area
		JPanel game = new JPanel() 
		{
			public void paintComponent(Graphics g)
			{
				// add background as a rectangle
				g.setColor(new Color(210, 200, 200));
				g.fillRect(0, 0, Bouncy.WIDTH, Bouncy.HEIGHT);
				
				// draw a plate calling class plate
				rect.draw(g);
				ball.draw(g);
				
				// actually drawing the bricks from the list
				for (int i = 0; i < bricksList.size(); i++)
				{
					bricksList.get(i).draw(g);
				}
			}
		};
		
		// adding game area to the overall panel and setting it's size
		panel.add(game);
		game.setPreferredSize(new  Dimension (WIDTH, HEIGHT - 100));
	
		// setting up the buttons area and adding it to the panel
		JPanel buttons = new JPanel();
		panel.add(buttons);
		
		// creating a start button and adding it to the panel
		JButton start = new JButton("Start");
		buttons.add(start);
		
		// an action listener for the mouse movement so it can move the plate
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				game.addMouseMotionListener(new MouseMotionListener()
				{
					public void mouseDragged(MouseEvent e) {
						
					}

					public void mouseMoved(MouseEvent e) 
					{
						if (isStarted == true)
						{
							rect.move(e.getX());
							plateX = e.getX();
							frame.getContentPane().repaint();
						}
					}	
				});
				
				// here i change isStarted to true
				isStarted = true;
			}
		});
		
		// adding scoreboard to the buttons panel
		buttons.add(scoreboard);
		
		// creating end game button and adding it to the panel
		JButton endGame = new JButton("End The Game");
		buttons.add(endGame);
		
		// setting isStarted to false, so the ball stops moving
		endGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				isStarted = false;
				
			}
		});

	
		// necessary setup of the frame
		frame.setSize(WIDTH, HEIGHT);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// a loop to move the ball, and run the intersections check
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
	
	// a method to check intersections
	public void checkIntersections() 
	{	
		// intersections with the plate 
		if (new Rectangle(plateX, Plate.y, Plate.widthRect, Plate.HEIGHTRECT).intersects(new Rectangle(Ball.Ballx, Ball.Bally, Ball.ballRadius,  Ball.ballRadius)) == true)
		{
			Ball.velocityY = - Ball.velocityY;
		}
		
		// check for intersections with the bricks
		for (int i = 0; i < bricksList.size(); i++)
		{	
			Bricks curr= bricksList.get(i);
			if (curr.intersects(new Rectangle(Ball.Ballx, Ball.Bally, Ball.ballRadius,  Ball.ballRadius)))
			{
				// remove bricks we hit and bounce to the other side
				bricksList.remove(i);
				Ball.velocityY = - Ball.velocityY;
				
				// score update and repaint of the panel
				score++;
				scoreboard.setText("Score: " + score);
				frame.getContentPane().repaint();
			}
		}
		
		// if ball hits the lower pane, the game is over, call the pop up window class, stop the game
		if (Ball.Bally >= (Bouncy.HEIGHT - 100 - Ball.ballRadius))
		{
			OptionPane pane = new OptionPane();
			pane.window();
			isStarted = false;
		}
	}
	
	
	// sleep method for pauses in game
	private static void sleep(int time) 
	{
		try 
		{
			Thread.sleep(time);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) 
	{
		new Bouncy();
	}
}

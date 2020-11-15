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
	
	ArrayList<Bricks> bricksList = new ArrayList<Bricks>();
	
	public Bouncy() 
	{
		
		JFrame frame = new JFrame();
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
				
				isStarted = true;
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

						frame.getContentPane().repaint();
					}
						
				});
				isStarted = true;
				
			}
	
		});
		
		JLabel scoreboard = new JLabel("Score: " + score);
		buttons.add(scoreboard);
		
		JButton endGame = new JButton("End The Game");
		buttons.add(endGame);
		
		while(true)
		{
			ball.move();
			sleep(10);
		}
		
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
	
	
	public static void main(String[] args) 
	{
		new Bouncy();

	}
}

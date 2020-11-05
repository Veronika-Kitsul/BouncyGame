package bouncyGame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Bouncy 
{
	
	public static final int WIDTH = 700, HEIGHT = 700;

	public Bouncy() 
	{
		Plate rect = new Plate();
		
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(Bouncy.WIDTH, Bouncy.HEIGHT));
		
		JPanel game = new JPanel() 
		{
			public void paintComponent(Graphics g)
			{
				// add background as a blue rectangle
				g.setColor(new Color(137, 214, 245));
				g.drawRect(0, 0, Bouncy.WIDTH, Bouncy.HEIGHT);
				
				g.setColor(new Color(0, 0, 245));
				g.drawRect(100,100, 10, 10);
				
				// draw a plate calling class plate
				rect.draw(g);
				
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
				
				
			}
	
		});
	
					
		frame.setSize(WIDTH, HEIGHT);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.getContentPane().repaint();
	}
	

	
	public static void main(String[] args) 
	{
		new Bouncy();

	}
}

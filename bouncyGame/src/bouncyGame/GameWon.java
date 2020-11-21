package bouncyGame;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class GameWon {

	public GameWon() 
	{
		
	}	
			
	public void message()
	{
		JFrame frame = new JFrame();
		
		JButton quit = new JButton("You won! Close this window to quit.");
		frame.add(quit);
		
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setVisible(true);
	}
}

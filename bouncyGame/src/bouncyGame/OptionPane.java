package bouncyGame;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OptionPane {

	public OptionPane() {
		
	}
	
	public void window()
	{
		JFrame frame = new JFrame();
		
		
		JButton startOver = new JButton("Start over");
		frame.add(startOver);
		
		JButton quit = new JButton("Game over. Close this window to quit.");
		frame.add(quit);
		
		JLabel gameOver = new JLabel("Game over!");
		
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setVisible(true);
	}

}

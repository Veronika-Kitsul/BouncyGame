package bouncyGame;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OptionPane {

	public OptionPane() {
		
	}
	
	public void window()
	{
		JFrame frame = new JFrame();
		
		
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setVisible(true);
		
		JButton startOver = new JButton("Start over");
		frame.add(startOver);
	}

}

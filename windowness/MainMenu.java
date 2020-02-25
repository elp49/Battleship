package windowness;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MainMenu extends JPanel{
	
	JPanel myImage = new JPanel() {{
		setBackground(Color.BLACK);
	}};
	
	public MainMenu() {
		setLayout(new BorderLayout());
		add(myImage,BorderLayout.WEST);
	}
	
}

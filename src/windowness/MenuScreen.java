package windowness;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MenuScreen extends ScreenPanel{
	
	JPanel myImage = ImageAdd.getImage("mainMenuGraphic.png");
	
	JPanel myMenuOpts = new JPanel() {{
		add(new JButton("SinglePlayer") {{
			setFont(ScreenSizer.SmallestReadableFont);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					GameplayFunctions.NewGame();
				}
			});
		}});
		add(new JButton("MultiPlayer") {{
			setFont(ScreenSizer.SmallestReadableFont);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					GameplayFunctions.NewGame();
				}
			});
		}});
		add(new JButton("Exit") {{
			setFont(ScreenSizer.SmallestReadableFont);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					GameplayFunctions.Exit();
				}
			});
		}});
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	}};
	
	public MenuScreen() {
		setLayout(new BorderLayout());
		myMenuOpts.setLayout(new BoxLayout(myMenuOpts,BoxLayout.PAGE_AXIS));
		add(myImage,BorderLayout.WEST);
		add(myMenuOpts,BorderLayout.EAST);
	}
	
	public void setSizes() {
		setSize(new Dimension(super.getParent().getBounds().width,super.getParent().getBounds().height));
		myImage.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.8),super.getParent().getBounds().height));
		myMenuOpts.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.2),super.getParent().getBounds().height));
		validate();
		repaint();
	}
	
}

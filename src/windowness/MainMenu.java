package windowness;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainMenu extends JPanel{
	
	JPanel myImage = ImageAdd.getImage("Images" + System.getProperty("file.separator") + "mainMenuGraphic.png");
	
	JPanel myMenuOpts = new JPanel() {{
		add(new JButton("SinglePlayer") {{
			setFont(ScreenSizer.SmallestReadableFont);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					ShowWindow.beginBattle();
				}
			});
		}});
		add(new JButton("MultiPlayer") {{
			setFont(ScreenSizer.SmallestReadableFont);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					ShowWindow.beginBattle();
				}
			});
		}});
		add(new JButton("Exit") {{
			setFont(ScreenSizer.SmallestReadableFont);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					Frame[] windows = Frame.getFrames();
					for(int i = windows.length-1; i >= 0; i--) {
						windows[i].dispose();
					}
				}
			});
		}});
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	}};
	
	public MainMenu() {
		setLayout(new BorderLayout());
		myMenuOpts.setLayout(new BoxLayout(myMenuOpts,BoxLayout.PAGE_AXIS));
		add(myImage,BorderLayout.WEST);
		add(myMenuOpts,BorderLayout.EAST);
	}
	
}

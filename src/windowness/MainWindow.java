package windowness;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainWindow extends JFrame{
	public static double screenDefaultPortion = 0.8;
	
	public int screenHigh = (int) Math.floor(ScreenSizer.getScreenHeight()*screenDefaultPortion);
	public int screenWid = (int) Math.floor(ScreenSizer.getScreenWidth()*screenDefaultPortion);
	
	public ScreenPanel curScreen = ShowWindow.theMenuScreen;
	
	/*public JMenu Game_Menu = new JMenu("Game") {{
		setMnemonic(KeyEvent.VK_G);
		add(new JMenuItem("New Game") {{
			setFont(ScreenSizer.SmallestReadableFont);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					ShowWindow.beginBattle();
				}
			});
		}});
		add(new JMenuItem("Surrender") {{
			setFont(ScreenSizer.SmallestReadableFont);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					ShowWindow.returnToMainMenu();
				}
			});
		}});
		add(new JMenuItem("Exit") {{
			setFont(ScreenSizer.SmallestReadableFont);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					Frame[] windows = getFrames();
					for(int i = windows.length-1; i >= 0; i--) {
						windows[i].dispose();
					}
				}
			});
		}});
		setFont(ScreenSizer.SmallestReadableFont);
	}};
	
	public JMenu Settings_Menu = new JMenu("Settings") {{
		setMnemonic(KeyEvent.VK_S);
		add(new JMenu("Language") {{
			add(new JRadioButtonMenuItem("English") {{
				setFont(ScreenSizer.SmallestReadableFont);
			}});
			setFont(ScreenSizer.SmallestReadableFont);
		}});
		setFont(ScreenSizer.SmallestReadableFont);
	}};
	
	public JMenu Help_Menu = new JMenu("Help") {{
		setMnemonic(KeyEvent.VK_H);
		add(new JMenuItem("How to play") {{
			setFont(ScreenSizer.SmallestReadableFont);
		}});
		setFont(ScreenSizer.SmallestReadableFont);
	}};
	
	public JMenuBar myMenus = new JMenuBar() {{
		add(Game_Menu);
		add(Settings_Menu);
		add(Help_Menu);
	}};*/
	
	public MenuBar myMenuBar = new MenuBar();
	
	public MainWindow() {
		setTitle("BATTLESHIP");
		
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(myMenuBar,BorderLayout.PAGE_START);
		contentPane.add(curScreen,BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setBounds(0,0,screenWid,screenHigh);
		setVisible(true);
	}
	
	public void setScreen(ScreenPanel screen) {
		getContentPane().remove(curScreen);
		curScreen = screen;
		getContentPane().add(curScreen);
		curScreen.setSizes();
		validate();
		repaint();
	}
}

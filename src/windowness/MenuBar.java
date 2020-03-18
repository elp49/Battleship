package windowness;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuBar extends JMenuBar {
	
	private JMenuItem newGame = new JMenuItem("New Game") {{
		setFont(ScreenSizer.SmallestReadableFont);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GameplayFunctions.NewGame();
			}
		});
	}};
	
	private JMenuItem surrender = new JMenuItem("Surrender") {{
		setFont(ScreenSizer.SmallestReadableFont);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GameplayFunctions.Surrender();
			}
		});
	}};
	
	private JMenuItem exit = new JMenuItem("Exit") {{
		setFont(ScreenSizer.SmallestReadableFont);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GameplayFunctions.Exit();
			}
		});
	}};
	
	public JMenu Game_Menu = new JMenu("Game") {{
		setMnemonic(KeyEvent.VK_G);
		add(newGame);
		add(surrender);
		add(exit);
		setFont(ScreenSizer.SmallestReadableFont);
	}};
	
	public JMenuItem Audio_Settings = new JMenuItem("Audio Settings") {{
		setFont(ScreenSizer.SmallestReadableFont);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GameplayFunctions.openAudioSettings();
			}
		});
	}};
	
	public JMenu Settings_Menu = new JMenu("Settings") {{
		setMnemonic(KeyEvent.VK_S);
		add(new JMenu("Language") {{
			add(new JRadioButtonMenuItem("English") {{
				setFont(ScreenSizer.SmallestReadableFont);
			}});
			setFont(ScreenSizer.SmallestReadableFont);
		}});
		add(Audio_Settings);
		setFont(ScreenSizer.SmallestReadableFont);
	}};
	
	public JMenu Help_Menu = new JMenu("Help") {{
		setMnemonic(KeyEvent.VK_H);
		add(new JMenuItem("How to play") {{
			setFont(ScreenSizer.SmallestReadableFont);
		}});
		setFont(ScreenSizer.SmallestReadableFont);
	}};
	
	public MenuBar(){
		add(Game_Menu);
		add(Settings_Menu);
		add(Help_Menu);
	}
	
	public void setNewGameActive(boolean a) {
		newGame.setEnabled(a);
	}
	
	public void setSurrenderActive(boolean a) {
		surrender.setEnabled(a);
	}
	
	public void setExitActive(boolean a) {
		exit.setEnabled(a);
	}
	
}

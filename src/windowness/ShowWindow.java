package windowness;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ShowWindow {
	public static MainWindow theMainWindow = new MainWindow();
	public static BattleScreen theBattleScreen = new BattleScreen();
	public static MainMenu theMainMenu = new MainMenu();
	
	public static void main(String[] args) {
		showWindow();
	}
	
	public static void showWindow() {
		theMainWindow.setScreen(theMainMenu);
		theMainWindow.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				System.out.println("Resizing components");
				try {
					theBattleScreen.setSizes();
				}
				catch(NullPointerException f) {
					
				}
			}
		});
	}
	
	public static void returnToMainMenu() {
		theMainWindow.setScreen(theMainMenu);
	}
	
	public static void beginBattle() {
		theMainWindow.setScreen(theBattleScreen);
		theBattleScreen.reload();
		theBattleScreen.setSizes();
	}
}

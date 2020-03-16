package windowness;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ShowWindow {
	public static BattleScreen theBattleScreen = new BattleScreen();
	public static MenuScreen theMenuScreen = new MenuScreen();
	public static MainWindow theMainWindow = new MainWindow();
	
	public static void main(String[] args) {
		showWindow();
	}
	
	public static void showWindow() {
		theMainWindow.setScreen(theMenuScreen);
		theMainWindow.curScreen.setSizes();
		theMainWindow.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				theMainWindow.curScreen.setSizes();
			}
		});
		ShowWindow.theMainWindow.myMenuBar.setSurrenderActive(false);
	}
	
	public static void returnToMainMenu() {
		theMainWindow.setScreen(theMenuScreen);
	}
	
	public static void beginBattle() {
		theMainWindow.setScreen(theBattleScreen);
		theBattleScreen.reload();
		theBattleScreen.setSizes();
	}
}

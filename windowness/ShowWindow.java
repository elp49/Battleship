package windowness;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ShowWindow {
	public static MainWindow theMainWindow = new MainWindow();
	public static BattleScreen theBattleScreen = new BattleScreen();
	
	public static void main(String[] args) {
		showWindow();
	}
	
	public static void showWindow() {
		theMainWindow.setScreen(theBattleScreen);
		theMainWindow.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				System.out.println("blah");
				//theMainWindow.curScreen.resize();
			}
		});
	}
}

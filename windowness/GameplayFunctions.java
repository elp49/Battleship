package windowness;

import java.awt.Frame;

import javax.swing.JFrame;

public class GameplayFunctions {
	
	public static int numShipsPlaced = 0;

	public static void NewGame() {
		ShowWindow.beginBattle();
		ShowWindow.theMainWindow.myMenuBar.setNewGameActive(true);
		ShowWindow.theMainWindow.myMenuBar.setSurrenderActive(true);
		ShowWindow.theMainWindow.myMenuBar.setExitActive(true);
	}
	
	public static void Surrender() {
		ShowWindow.returnToMainMenu();
		ShowWindow.theMainWindow.myMenuBar.setNewGameActive(true);
		ShowWindow.theMainWindow.myMenuBar.setSurrenderActive(false);
		ShowWindow.theMainWindow.myMenuBar.setExitActive(true);
	}
	
	public static void Exit() {
		Frame[] windows = JFrame.getFrames();
		for(int i = windows.length-1; i >= 0; i--) {
			windows[i].dispose();
		}
	}
	
	public static void ReadyToPlay() {
		ShowWindow.theBattleScreen.myReady.setActive(false);
		numShipsPlaced = 0;
	}
	
	public static void CheckReady() {
		if(numShipsPlaced == ShowWindow.theBattleScreen.myHBP.myHBD.length) {
			ShowWindow.theBattleScreen.myReady.setActive(true);
		}
	}
	
}

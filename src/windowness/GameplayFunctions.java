package windowness;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import controllers.MoveShipButtonController;

public class GameplayFunctions {
	
	public static int numShipsPlaced = 0;
	
	private static Frame heldAudioWindow;
	private static Frame heldHelpWindow;

	public static void NewGame() {
		ShowWindow.beginBattle();
		ShowWindow.theMainWindow.myMenuBar.setNewGameActive(true);
		ShowWindow.theMainWindow.myMenuBar.setSurrenderActive(true);
		ShowWindow.theMainWindow.myMenuBar.setExitActive(true);
		ShowWindow.theBattleScreen.opponentBG.setActive(false);
		ShowWindow.theBattleScreen.myMoveShipButtons.setActive(true);
		MoveShipButtonController.isPlacingShips = true;
		ShowWindow.theBattleScreen.myReady.setActive(false);
		numShipsPlaced = 0;
	}
	
	public static void Surrender() {
		ShowWindow.returnToMainMenu();
		ShowWindow.theMainWindow.myMenuBar.setNewGameActive(true);
		ShowWindow.theMainWindow.myMenuBar.setSurrenderActive(false);
		ShowWindow.theMainWindow.myMenuBar.setExitActive(true);
		MoveShipButtonController.isPlacingShips = false;
	}
	
	public static void Exit() {
		Frame[] windows = JFrame.getFrames();
		for(int i = windows.length-1; i >= 0; i--) {
			windows[i].dispose();
		}
	}
	
	public static void ReadyToPlay() {
		// Randomly place opponent's ships on their board.
		ShowWindow.curBattle.getOpponentBoard().placeAllShipsRandomly();
				
		ShowWindow.theBattleScreen.myReady.setActive(false);
		ShowWindow.theBattleScreen.opponentBG.setActive(true);
		ShowWindow.theBattleScreen.myMoveShipButtons.setActive(false);
		MoveShipButtonController.isPlacingShips = false;
		numShipsPlaced = 0;
		ShowWindow.curBattle.determineTurnOrder();
	}
	
	public static void CheckReady() {
		if(numShipsPlaced == ShowWindow.theBattleScreen.myHBP.myHBD.length) {
			ShowWindow.theBattleScreen.myReady.setActive(true);
		}
	}
	
	public static void openAudioSettings() {
		if(heldAudioWindow == null) {
			heldAudioWindow = new AudioWindow();
			heldAudioWindow.addWindowListener(new WindowAdapter() {
				  @Override
				  public void windowClosing(WindowEvent e) {
					  heldAudioWindow = null;
				  }
				});
		}
		else {
			heldAudioWindow.requestFocus();
		}
	}
	
	public static void closeAudioSettings() {
		heldAudioWindow.dispose();
		heldAudioWindow = null;
	}
	
	public static void openHelpWindow() {
		if(heldHelpWindow == null) {
			heldHelpWindow = new HelpWindow();
			heldHelpWindow.addWindowListener(new WindowAdapter() {
				  @Override
				  public void windowClosing(WindowEvent e) {
					  heldHelpWindow = null;
				  }
				});
		}
		else {
			heldHelpWindow.requestFocus();
		}
	}
	
	public static void closeHelpWindow() {
		heldHelpWindow.dispose();
		heldHelpWindow = null;
	}
	
	public static void doWin() {
		//Stop turnToggling
		ShowWindow.theBattleScreen.log("YOU WIN!",Color.YELLOW);
	}
	
	public static void doLose() {
		//Stop turnToggling
		ShowWindow.theBattleScreen.log("YOU LOSE!",Color.RED);
	}
	
}

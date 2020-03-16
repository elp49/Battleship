package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import code.Ship;
import code.Board;

import windowness.HealthBarPanel;
import windowness.HealthBarData;
import windowness.HealthUnitVisual;
import windowness.ShowWindow;
import windowness.GameplayFunctions;

public class HealthBarPanelController {
	private HealthBarPanel myHBP;
	
	private class addButtonListener implements MouseListener{
		boolean isPlacingShips = true;
		boolean shipPlaced = false;
		Ship myShip;
		String ShipName;
		
		public addButtonListener(Ship ship) {
			ShipName = ship.getName();
			myShip = ship;
		}
		
		public void battleStarted() {
			isPlacingShips = false;
		}
		
		public void mouseClicked(MouseEvent e){
			if(shipPlaced) {
				return;
			}
			char[] myCols = new char[myShip.getSize()];
			char holdCol = 'A';
			for(int i = 0; i < myCols.length;i++) {
				myCols[i] = holdCol;
				holdCol++;
			}
			holdCol = 'A';
			int holdRow = 1;
			while(!shipPlaced) {
				try {
					//Board.placeShipOnBoardHorizontally(myShip,holdRow,myCols)
					shipPlaced = true;
				}
				catch(Exception f) {
					if(myCols[myCols.length-1] == 'J') {
						holdRow++;
						for(int i = 0; i < myCols.length; i++) {
							myCols[i] = holdCol;
							holdCol++;
						}
						holdCol = 'A';
					}
					else {
						for(int i = 0; i < myCols.length; i++) {
							myCols[i]++;
						}
					}
					shipPlaced = false;
				}
			}
			ShowWindow.theBattleScreen.log("Placed " + ShipName);
			GameplayFunctions.numShipsPlaced++;
			GameplayFunctions.CheckReady();
		}
		public void mouseEntered(MouseEvent e) {
			
		}
		public void mouseExited(MouseEvent e) {
			
		}
		public void mousePressed(MouseEvent e) {
			
		}
		public void mouseReleased(MouseEvent e) {
			
		}
	}
	
	public void refreshHBPDataMouseListeners() {
		for(int i = 0; i < myHBP.myHBD.length; i++) {
			myHBP.myHBD[i].myPicHolder.addMouseListener(new addButtonListener(myHBP.myShipInfo[i]));
		}
	}
	
	public void setHBPControl(HealthBarPanel toControl) {
		myHBP = toControl;
		
		refreshHBPDataMouseListeners();
	}
}

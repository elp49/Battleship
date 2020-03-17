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
		
		public void placeShipStartingAt(int row, int col, Board on) {
			int curCol = col;
			for(;curCol < col + myShip.getSize();curCol++) {
				on.getSquare(row, curCol).setShip(myShip);
				ShowWindow.theBattleScreen.playerBG.mySquares[row][curCol].DisplayShip(myShip.getName(), curCol-col+1);
			}
			shipPlaced = true;
		}
		
		public void mouseClicked(MouseEvent e){
			if(shipPlaced) {
				return;
			}
			Board playerBoard = ShowWindow.curBattle.getPlayerBoard();
			int squaresInARow = 0;
			for(int i = 0; i < playerBoard.getSquares().length && !shipPlaced; i++) {
				for(int j = 0; j < playerBoard.getSquares()[i].length && j + myShip.getSize() < playerBoard.getSquares()[i].length && !shipPlaced; j++) {
					for(int k = j; k < myShip.getSize(); k++) {
						if(playerBoard.getSquare(i, j).hasShip()) {
							break;
						}
						else {
							squaresInARow++;
						}
						if(squaresInARow == myShip.getSize()) {
							placeShipStartingAt(i,j,playerBoard);
						}
					}
				}
			}
			/*char[] myCols = new char[myShip.getSize()];
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
			}*/
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

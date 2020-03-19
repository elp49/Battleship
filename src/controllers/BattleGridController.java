package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import code.BattleSession;
import code.Ship;
import code.Square;
import windowness.BattleGrid;
import windowness.BattleScreen;
import windowness.GameplayFunctions;
import windowness.ShowWindow;

import code.Board;

public class BattleGridController {

	BattleGrid myBattleGrid;
	BattleGrid opponentGrid;

	
	private class addButtonListener implements MouseListener {
		
		int myRow,myCol;
		
		public addButtonListener(int i, int j) {
			myRow = i;
			myCol = j;
		}
		
		private char getColLetter(int x) {
			switch(x) {
			case 0:
				return 'A';
			case 1:
				return 'B';
			case 2:
				return 'C';
			case 3:
				return 'D';
			case 4:
				return 'E';
			case 5:
				return 'F';
			case 6:
				return 'G';
			case 7:
				return 'H';
			case 8:
				return 'I';
			case 9:
				return 'J';
			default:
				return 'x';
			}
		}
		
		public void mouseClicked(MouseEvent e){
			//Do Nothing
		}
		public void mouseEntered(MouseEvent e) {
			myBattleGrid.mySquares[myRow][myCol].highlightHover();
		}
		public void mouseExited(MouseEvent e) {
			myBattleGrid.mySquares[myRow][myCol].unhighlightHover();
		}
		public void mousePressed(MouseEvent e) {
			myBattleGrid.mySquares[myRow][myCol].press();
		}
		public void mouseReleased(MouseEvent e) {
			if(myBattleGrid.mySquares[myRow][myCol].isClicked) {
				return;
			}
			myBattleGrid.mySquares[myRow][myCol].release();
			ShowWindow.theBattleScreen.log("You Fired at " + getColLetter(myCol) + (myRow+1));
			Board toCheck;
			if(myBattleGrid.mySquares[0][0].isPlayer) {
				toCheck = ShowWindow.curBattle.getPlayerBoard();
			}
			else {
				toCheck = ShowWindow.curBattle.getOpponentBoard();
			}

			Square square = toCheck.getSquare(myRow, myCol);
			Ship ship;
			if(square.hasShip()) {
				ship = square.getShip();
				ship.hit();
				myBattleGrid.mySquares[myRow][myCol].MarkHit();
				ShowWindow.theBattleScreen.log("HIT",Color.RED);
				if(ship.isSunk()) {
					ShowWindow.theBattleScreen.log("Sank Enemy " + ship.getName() + "!",Color.YELLOW);
					/*Ship[] ships = toCheck.getShips();
					int sank = 0;
					for(sank = 0; sank < ships.length; sank++) {
						if(!toCheck.getShips()[sank].isSunk()) {
							break;
						}
					}
					if(sank == ships.length) {
						GameplayFunctions.doWin();
					}*/
					if (!toCheck.hasRemainingShips()) {
						// Notify with pop up
						GameplayFunctions.doWin();
					}
				}


			}
			else {
				myBattleGrid.mySquares[myRow][myCol].MarkMiss();
				ShowWindow.theBattleScreen.log("You Missed");
			}

			// Computer randomly fires at one of the player's squares.
			Board playerBoard = ShowWindow.curBattle.getPlayerBoard();
			Random rand = new Random();
			int numRows = playerBoard.getSquares().length;
			int numCols = playerBoard.getSquares()[0].length;
			Square randomSquare = null;
			int randRow, randCol;
			do {
				// Pick a random square.
				randRow = rand.nextInt(numRows);
				randCol = rand.nextInt(numCols);
				randomSquare = playerBoard.getSquare(randRow, randCol);
			} while (randomSquare.wasAlreadyHit());

			ShowWindow.theBattleScreen.log("Computer Fired at " + getColLetter(randCol) + (randRow + 1));

			Ship playersShip;
			if (randomSquare.hasShip()) {
				//square.markHit();
				playersShip = randomSquare.getShip();
				playersShip.hit();

				opponentGrid.mySquares[randRow][randCol].MarkHit();
				ShowWindow.theBattleScreen.log("HIT",Color.RED);
				if(playersShip.isSunk()) {
					ShowWindow.theBattleScreen.log("Computer Sank Your " + playersShip.getName() + "!",Color.YELLOW);
					/*Ship[] ships = toCheck.getShips();
					int sank = 0;
					for(sank = 0; sank < ships.length; sank++) {
						if(!toCheck.getShips()[sank].isSunk()) {
							break;
						}
					}
					if(sank == ships.length) {
						GameplayFunctions.doWin();
					}*/
					if (!playerBoard.hasRemainingShips()) {
						// Notify with pop up
						GameplayFunctions.doLose();
					}
				}
			} else {
				//square.markMiss();
				opponentGrid.mySquares[randRow][randCol].MarkMiss();
				ShowWindow.theBattleScreen.log("Computer Missed");
			}

			//ShowWindow.curBattle.fire(getColLetter(myCol), myRow);
			//if Board.getSquares()[myRow][myCol].hasShip(){
				//myBattleGrid.mySquares[myRow][myCol].MarkHit();
			//}
			//else{
			//	myBattleGrid.mySquares[myRow][myCol].MarkMiss();
			//}
		}
	}

	public void setBattleGridControl(BattleGrid toControl, BattleGrid opponentGrid) {
		this.opponentGrid = opponentGrid;
		myBattleGrid = toControl;

		//register listeners if this is not the player's battle grid
		if(!myBattleGrid.mySquares[0][0].isPlayer) {
			for(int i = 0; i < myBattleGrid.mySquares.length; i++) {
				for(int j = 0; j < myBattleGrid.mySquares[i].length; j++) {
					myBattleGrid.mySquares[i][j].addMouseListener(new addButtonListener(i,j));
				}
			}
		}
	}
	
}

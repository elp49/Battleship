package controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

import windowness.BattleGrid;
import windowness.GuessButton;
import windowness.ShowWindow;

import code.BattleSession;
import code.Board;

public class BattleGridController {
	
	private BattleGrid myBattleGrid;
	
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
			if(!myBattleGrid.mySquares[myRow][myCol].isClicked) {
				myBattleGrid.mySquares[myRow][myCol].release();
				ShowWindow.theBattleScreen.log("Fired at " + getColLetter(myCol) + (myRow+1));
				Board toCheck;
				if(myBattleGrid.mySquares[0][0].isPlayer) {
					toCheck = ShowWindow.curBattle.getPlayerBoard();
				}
				else {
					toCheck = ShowWindow.curBattle.getOpponentBoard();
				}
				
				if(toCheck.getSquare(myRow, myCol).hasShip()) {
					myBattleGrid.mySquares[myRow][myCol].MarkHit();
				}
				else {
					myBattleGrid.mySquares[myRow][myCol].MarkMiss();
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
	}
	
	public void setBattleGridControl(BattleGrid toControl) {
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

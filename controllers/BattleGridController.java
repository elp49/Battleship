package controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

import windowness.BattleGrid;
import windowness.GuessButton;

public class BattleGridController {
	
	private BattleGrid myBattleGrid;
	
	private class addButtonListener implements MouseListener {
		
		int myRow,myCol;
		
		public addButtonListener(int i, int j) {
			myRow = i;
			myCol = j;
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
			myBattleGrid.mySquares[myRow][myCol].release();
			//if Board.getSquares()[myRow][myCol].hasShip(){
				myBattleGrid.mySquares[myRow][myCol].MarkHit();
			//}
			//else{
			//	myBattleGrid.mySquares[myRow][myCol].MarkMiss();
			//}
		}
	}
	
	public void setBattleGridControl(BattleGrid toControl) {
		myBattleGrid = toControl;
		
		//register listeners if this is not the player's battle grid
		if(!myBattleGrid.mySquares[0][0].player) {
			for(int i = 0; i < myBattleGrid.mySquares.length; i++) {
				for(int j = 0; j < myBattleGrid.mySquares[i].length; j++) {
					myBattleGrid.mySquares[i][j].addMouseListener(new addButtonListener(i,j));
				}
			}
		}
	}
	
}

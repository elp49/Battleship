package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import code.Board;
import code.Ship;
import windowness.GameplayFunctions;
import windowness.ShowWindow;
import windowness.MoveShipButtons;

public class MoveShipButtonController{
	
	private MoveShipButtons myMSB;
	
	private static Ship prevShip = null;
	private static int[][] spacesFilled;
	private static boolean shipIsVertical;
	
	public static boolean isPlacingShips = false;
	
	public static void setPrevShip(Ship ship, int[][] spaces) {
		prevShip = ship;
		spacesFilled = spaces;
		shipIsVertical = false;
	}
	
	private static void MoveShipDown() {
		if(prevShip==null) {
			return;
		}
		int incrementAmount = 1;
		for(int i = 0; i < spacesFilled.length; i++) {
			while(spacesFilled[i][0] + incrementAmount < ShowWindow.curBattle.getPlayerBoard().getSquares().length && ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0]+incrementAmount, spacesFilled[i][1]).hasShip()
					&& !ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0]+incrementAmount, spacesFilled[i][1]).getShip().equals(prevShip)){
				incrementAmount++;
			}
		}
		if(shipIsVertical && incrementAmount > 1) {
			incrementAmount+=prevShip.getSize()-1;
		}
		//If we can't move this lower, then don't do anything.
		for(int i = 0; i < spacesFilled.length; i++) {
			if(spacesFilled[i][0]+incrementAmount > ShowWindow.curBattle.getPlayerBoard().getSquares().length-1) {
				return;
			}
		}
		for(int i = 0; i < spacesFilled.length; i++) {
			//Remove the ship from the board
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(null);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].RemoveShip();
			//increment the row in which the ship is located
			spacesFilled[i][0]+=incrementAmount;
		}
		//Place the ship on the board in the new row
		for(int i = 0; i < spacesFilled.length; i++) {
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(prevShip);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].DisplayShip(prevShip.getName(), i+1);
		}
	}
	
	private static void MoveShipUp() {
		if(prevShip==null) {
			return;
		}
		int decrementAmount = 1;
		for(int i = 0; i < spacesFilled.length; i++) {
			while(spacesFilled[i][0] - decrementAmount > 0 && ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0]-decrementAmount, spacesFilled[i][1]).hasShip()
					&& !ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0]-decrementAmount, spacesFilled[i][1]).getShip().equals(prevShip)){
				decrementAmount++;
			}
		}
		//If we can't move this higher, then don't do anything.
		for(int i = 0; i < spacesFilled.length; i++) {
			if(spacesFilled[i][0]-decrementAmount < 0) {
				return;
			}
		}
		for(int i = 0; i < spacesFilled.length; i++) {
			//Remove the ship from the board
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(null);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].RemoveShip();
			//decrement the row in which the ship is located
			spacesFilled[i][0]-=decrementAmount;	
		}
		//Place the ship on the board in the new row
		for(int i = 0; i < spacesFilled.length; i++) {
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(prevShip);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].DisplayShip(prevShip.getName(), i+1);
		}
	}
	
	private static void MoveShipRight() {
		if(prevShip==null) {
			return;
		}
		int incrementAmount = 1;
		for(int i = 0; i < spacesFilled.length; i++) {
			while(spacesFilled[i][1] + incrementAmount < ShowWindow.curBattle.getPlayerBoard().getSquares()[0].length && ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]+incrementAmount).hasShip()
					&& !ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]+incrementAmount).getShip().equals(prevShip)){
				incrementAmount++;
			}
		}
		if(!shipIsVertical && incrementAmount > 1) {
			incrementAmount+=prevShip.getSize()-1;
		}
		//If we can't move this further right, then don't do anything.
		for(int i = 0; i < spacesFilled.length; i++) {
			if(spacesFilled[i][1]+incrementAmount > ShowWindow.curBattle.getPlayerBoard().getSquares()[0].length-1) {
				return;
			}
		}
		for(int i = 0; i < spacesFilled.length; i++) {
			//Remove the ship from the board
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(null);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].RemoveShip();
			//increment the column in which the ship is located
			spacesFilled[i][1]+=incrementAmount;
		}
		//Place the ship on the board in the new row
		for(int i = 0; i < spacesFilled.length; i++) {
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(prevShip);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].DisplayShip(prevShip.getName(), i+1);
		}
	}
	
	private static void MoveShipLeft() {
		if(prevShip==null) {
			return;
		}
		int decrementAmount = 1;
		for(int i = 0; i < spacesFilled.length; i++) {
			while(spacesFilled[i][1] - decrementAmount > 0 && ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]-decrementAmount).hasShip()
					&& !ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]-decrementAmount).getShip().equals(prevShip)){
				decrementAmount++;
			}
		}
		//If we can't move this further right, then don't do anything.
		for(int i = 0; i < spacesFilled.length; i++) {
			if(spacesFilled[i][1]-decrementAmount < 0) {
				return;
			}
		}
		for(int i = 0; i < spacesFilled.length; i++) {
			//Remove the ship from the board
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(null);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].RemoveShip();
			//decrement the column in which the ship is located
			spacesFilled[i][1]-=decrementAmount;
		}
		//Place the ship on the board in the new row
		for(int i = 0; i < spacesFilled.length; i++) {
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(prevShip);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].DisplayShip(prevShip.getName(), i+1);
		}
	}
	
	private static void RotateShip(){
		if(prevShip==null) {
			return;
		}
		//Store this in case we find we can't rotate here later
		int[][] originalSpaces = new int[spacesFilled.length][spacesFilled[0].length];
		for(int i = 0; i < spacesFilled.length; i++) {
			for(int j = 0; j < spacesFilled[i].length; j++) {
				originalSpaces[i][j] = spacesFilled[i][j];
			}
		}
		
		for(int i = 0; i < spacesFilled.length; i++) {
			//Remove the ship from the board
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(null);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].RemoveShip();
		}
		//Set the pivot point to roughly the center point
		int pivotPoint = spacesFilled.length/2;
		//Rotate the ship around this pivot
		for(int i = 0; i < spacesFilled.length; i++) {
			if(i!=pivotPoint) {
				spacesFilled[i] = rotateAroundPivot(spacesFilled[i],i,pivotPoint);
			}
		}
		//If the first index is no longer on the board, push the ship down until it is
		while(spacesFilled[0][0] < 0) {
			for(int i = 0; i < spacesFilled.length; i++) {
				spacesFilled[i][0]++;
			}
		}
		//If the last index is no longer on the board, push the ship up until it is
		while(spacesFilled[spacesFilled.length-1][0] >= ShowWindow.curBattle.getPlayerBoard().getSquares().length) {
			for(int i = 0; i < spacesFilled.length; i++) {
				spacesFilled[i][0]--;
			}
		}
		
		//If the first index is no longer on the board, push the ship right until it is
		while(spacesFilled[0][1] < 0) {
		for(int i = 0; i < spacesFilled.length; i++) {
				spacesFilled[i][1]++;
			}
		}
		//If the last index is no longer on the board, push the ship left until it is
		while(spacesFilled[spacesFilled.length-1][1] >= ShowWindow.curBattle.getPlayerBoard().getSquares()[0].length) {
			for(int i = 0; i < spacesFilled.length; i++) {
				spacesFilled[i][1]--;
			}
		}
		
		//Check if the new location coincides with any existing ships
		for(int i = 0; i < spacesFilled.length; i++) {
			//if so, we can't rotate, so restore the original spaces
			if(ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).hasShip()) {
				for(int j = 0; j < spacesFilled.length; j++) {
					for(int k = 0; k < spacesFilled[j].length; k++) {
						spacesFilled[j][k] = originalSpaces[j][k];
					}
				}
				shipIsVertical = !shipIsVertical;
				break;
			}
		}
		
		//Place the ship on the board
		for(int i = 0; i < spacesFilled.length; i++) {
			ShowWindow.curBattle.getPlayerBoard().getSquare(spacesFilled[i][0], spacesFilled[i][1]).setShip(prevShip);
			ShowWindow.theBattleScreen.playerBG.mySquares[spacesFilled[i][0]][spacesFilled[i][1]].DisplayShip(prevShip.getName(), i+1);
		}
		shipIsVertical = !shipIsVertical;
	}
	
	private static int[] rotateAroundPivot(int[] myArr,int index,int pivot) {
		if(!shipIsVertical) {
			myArr[0] -= pivot - index;
			myArr[1] += pivot - index;
		}
		else {
			myArr[0] += pivot - index;
			myArr[1] -= pivot - index;
		}
		return myArr;
	}
	
	private class addDownListener implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			if(isPlacingShips) {
				MoveShipButtonController.MoveShipDown();
			}
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
	
	private class addUpListener implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			if(isPlacingShips) {
				MoveShipButtonController.MoveShipUp();
			}
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
	
	private class addRightListener implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			if(isPlacingShips) {
				MoveShipButtonController.MoveShipRight();
			}
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
	
	private class addLeftListener implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			if(isPlacingShips) {
				MoveShipButtonController.MoveShipLeft();
			}
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
	
	private class addRotateListener implements MouseListener{
		public void mouseClicked(MouseEvent e){
			if(isPlacingShips) {
				MoveShipButtonController.RotateShip();
			}
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
	
	public void setMSBControl(MoveShipButtons MSB) {
		prevShip = null;
		if(myMSB != null && myMSB.equals(MSB)) {
			return;
		}
		myMSB = MSB;
		myMSB.MoveDown.addMouseListener(new addDownListener());
		myMSB.MoveUp.addMouseListener(new addUpListener());
		myMSB.MoveRight.addMouseListener(new addRightListener());
		myMSB.MoveLeft.addMouseListener(new addLeftListener());
		myMSB.Rotate.addMouseListener(new addRotateListener());
	}
}

package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import code.Ship;
import code.Board;

import code.Square;
import windowness.HealthBarPanel;
import windowness.ShowWindow;
import windowness.GameplayFunctions;

public class HealthBarPanelController {
    private HealthBarPanel myHBP;

    private class addButtonListener implements MouseListener {
        boolean shipPlaced = false;
        Ship myShip;
        String ShipName;
        int[][] spaces;

        public addButtonListener(Ship ship) {
            ShipName = ship.getName();
            myShip = ship;
        }

        public void placeShipStartingAt(int row, int col, Board on) {
            int curCol = col;
            spaces = new int[myShip.getSize()][2];
            for (; curCol < col + myShip.getSize(); curCol++) {
                on.getSquare(row, curCol).setShip(myShip);
                ShowWindow.theBattleScreen.playerBG.mySquares[row][curCol].DisplayShip(myShip.getName(), curCol - col + 1);
                spaces[curCol - col] = new int[]{row, curCol};
            }
            shipPlaced = true;
        }

        public void mouseClicked(MouseEvent e) {
            if (shipPlaced) {
                return;
            }
            Board playerBoard = ShowWindow.curBattle.getPlayerBoard();
            int shipSize = myShip.getSize();
            Square[][] squares = playerBoard.getSquares();
            int columnLength = squares.length;
            int rowLength;
            spaces = new int[shipSize][2];
            for (int i = 0; i < columnLength && !shipPlaced; i++) {
                rowLength = squares[i].length;
                for (int j = 0; j < rowLength && j + shipSize < rowLength && !shipPlaced; j++) {
                    for (int k = 0; k < shipSize; k++) {
                        if (playerBoard.getSquare(i, j).hasShip()) {
                            shipPlaced = false;
                            break;
                        }
                        spaces[k] = new int[]{i, j};
                        shipPlaced = true;
                        j++;
                    }
                }
            }
            for (int k = 0; k < spaces.length; k++) {
                int row = spaces[k][0];
                int column = spaces[k][1];
                playerBoard.getSquare(row, column).setShip(myShip);
                ShowWindow.theBattleScreen.playerBG.mySquares[row][column].DisplayShip(myShip.getName(), k + 1);
            }
            MoveShipButtonController.setPrevShip(myShip, spaces);
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
        for (int i = 0; i < myHBP.myHBD.length; i++) {
            myHBP.myHBD[i].myPicHolder.addMouseListener(new addButtonListener(myHBP.myShipInfo[i]));
        }
    }

    public void setHBPControl(HealthBarPanel toControl) {
        myHBP = toControl;

        refreshHBPDataMouseListeners();
    }
}

package code;

import java.util.Random;

public class BattleSession {

    String playerName;
    String opponentName;
    Board playerBoard;
    Board opponentBoard;
    boolean isPlayerTurn;
    int setupTime;
    int moveTime;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public void setPlayerBoard(Board playerBoard) {
        this.playerBoard = playerBoard;
    }

    public Board getOpponentBoard() {
        return opponentBoard;
    }

    public void setOpponentBoard(Board opponentBoard) {
        this.opponentBoard = opponentBoard;
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    public int getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(int setupTime) {
        this.setupTime = setupTime;
    }

    public int getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(int moveTime) {
        this.moveTime = moveTime;
    }

    public BattleSession(String playerName, String opponentName, GameOptions gameOptions) {
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.playerBoard = new Board();
        this.opponentBoard = new Board();
        this.setupTime = gameOptions.setupTime;
        this.moveTime = gameOptions.moveTime;
    }

    public void determineTurnOrder() {
        int player1 = 0;
        int player2 = 1;
        int heads = 0;
        int tails = 1;
        int guesser, guess, result;
        Random rand = new Random();

        // Simulate who gets to guess coin flip.
        guesser = rand.nextInt(2);

        // Simulate player's guess.
        guess = rand.nextInt(2);

        // Simulate coin flip.
        result = rand.nextInt(2);

        if ((guess == result && guesser == player1) ||
                (guess != result && guesser == player2)) {
            this.isPlayerTurn = true;
        } else {
            this.isPlayerTurn = false;
        }
    }

    public void toggleTurn() {
        if (this.isPlayerTurn == true) {
            this.isPlayerTurn = false;
        } else {
            this.isPlayerTurn = true;
        }
    }

    public int fire(char column, int row) {
        Board board;
        int rowIndex;
        int columnIndex;
        Square square;

        if (isPlayerTurn) {
            board = playerBoard;
        } else {
            board = opponentBoard;
        }
        // Get square indices.
        rowIndex = board.getRowIndex(row);
        columnIndex = board.getColumnIndex(column);
        // Check indices are within range 0 to 9 inclusive.
        assert rowIndex >= 0 && rowIndex <= 9;
        assert columnIndex >= 0 && columnIndex <= 9;
        // Get square at row and column indices.
        square = board.getSquare(rowIndex, columnIndex);

        if (square.wasAlreadyHit()) {
            return -1;
        } else if (square.hasShip()) {
            square.markHit();
            return 1;
        } else {
            square.markMiss();
            return 0;
        }
    }

}

package code;

import java.util.Random;

public class Board {

    Square[][] squares;
    Ship[] ships;

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Ship[] getShips() {
        return ships;
    }

    public void setShips(Ship[] ships) {
        this.ships = ships;
    }

    public Board(Square[][] squares, Ship[] ships) {
        this.squares = squares;
        this.ships = ships;
    }

    public Board() {
        squares = new Square[10][10];
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                squares[i][j] = new Square();
            }
        }
        ships = new Ship[]{
                new Ship("Carrier", 5),
                new Ship("Battleship", 4),
                new Ship("Destroyer", 3),
                new Ship("Submarine", 3),
                new Ship("Patrol Boat", 2)
        };
    }

    public Square getSquare(int row, int column) {
        return squares[row][column];
    }

    public void placeAllShipsRandomly() {
        // Clear all squares of possible ships.
        clearAllSquares();
        // Place all ships on board randomly.
        for (Ship ship : this.ships) {
            placeShipRandomly(ship);
        }
    }

    public void clearAllSquares() {
        int numRows = squares.length;
        int numCols = squares[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                squares[i][j].removeShip();
            }
        }
    }

    public void placeShipRandomly(Ship ship) {
        assert ship != null;
        int size = ship.getSize();
        Square[] squares = getRandomEmptySquares(size);
        for (Square square : squares) {
            square.setShip(ship);
        }
    }

    public Square[] getRandomEmptySquares(int size) {
        Random rand = new Random();
        Square[] squares;
        Square square;
        int row, col, end;
        boolean isHorizontal;
        do {
            squares = null;
            // Pick a random square.
            row = rand.nextInt(this.squares.length);
            col = rand.nextInt(this.squares[0].length);
            square = getSquare(row, col);
            if (square.hasShip()) {
                continue;
            }
            // Get the index of the last column this ship would fill to the right.
            end = col + size - 1;
            if (end > this.squares[0].length) {
                // If endCol is out of bounds, then fill to the left.
                end = col;
                col = col - size + 1;
            }
            isHorizontal = rand.nextBoolean();
            if (isHorizontal) {
                squares = getHorizontalSquares(row, col, end);
            } else {
                squares = getVerticalSquares(col, row, end);
            }
        } while (!squaresAreEmpty(squares));

        return squares;
    }

    public Square[] getHorizontalSquares(int row, int startCol, int endCol) {
        assert endCol > startCol;
        int size = endCol - startCol + 1;
        Square[] squares = new Square[size];
        for (int i = 0; i + startCol <= endCol; i++) {
            squares[i] = getSquare(row, i);
        }
        return squares;
    }

    public Square[] getVerticalSquares(int col, int startRow, int endRow) {
        assert endRow > startRow;
        int size = endRow - startRow + 1;
        Square[] squares = new Square[size];
        for (int i = 0; i + startRow <= endRow; i++) {
            squares[i] = getSquare(i, col);
        }
        return squares;
    }

    public boolean squaresAreEmpty(Square[] squares) {
        if (squares == null) {
            return false;
        }
        for (Square square : squares) {
            if (square.hasShip()) {
                return false;
            }
        }
        // Return true if none of the given squares contain a ship.
        return true;
    }

    /*public void placeShipOnBoardVertically(Ship ship, int[] rows, char column) throws Exception {
        // Assert ship is not null.
        assert ship != null;
        // Get column index.
        int columnIndex = getColumnIndex(column);
        // Assert column index is within range 0 to 9 inclusive.
        assert columnIndex >= 0 && columnIndex <= 9;
        // Assert that number rows matches ship size.
        int numRows = rows.length;
        assert ship.getSize() == numRows;
        // Create array of row indices.
        int rowIndices[] = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            rowIndices[i] = getRowIndex(rows[i]);
        }
        // Set squares' ship values to the ship.
        for (int j = 0; j < numRows; j++) {
            // Check if square is already occupied by a ship.
            Square square = squares[rowIndices[j]][columnIndex];
            if (square.hasShip()) {
                throw new Exception(String.format("Attempted to write ship \'{0}\' to square [{1}][{2}], but square " +
                        "is occupied by ship \'{3}\'.", ship.getName(), rows[j], column, square.getShip().getName()));
            }
            square.setShip(ship);
        }
    }

    public void placeShipOnBoardHorizontally(Ship ship, int row, char[] columns) throws Exception {
        // Assert ship is not null.
        assert ship != null;
        // Get row index.
        int rowIndex = getRowIndex(row);
        // Assert row index is within range 0 to 9 inclusive.
        assert rowIndex >= 0 && rowIndex <= 9;
        // Assert that number columns matches ship size.
        int numColumns = columns.length;
        assert ship.getSize() == numColumns;
        // Create array of column indices.
        int columnIndices[] = new int[numColumns];
        for (int i = 0; i < numColumns; i++) {
            columnIndices[i] = getColumnIndex(columns[i]);
        }
        // Check if squares are already occupied by another ship.
        for (int i = 0; i < numColumns; i++) {
            Square square = squares[rowIndex][columnIndices[i]];
            if (square.hasShip()) {
                throw new Exception(String.format("Attempted to write ship \'%s\' to square [%d][%c], but square " +
                        "is occupied by ship \'%s\'.", ship.getName(), row, columns[i], square.getShip().getName()));
            }
        }
        // Set squares' ship values to the ship.
        for (int i = 0; i < numColumns; i++) {
            squares[rowIndex][columnIndices[i]].setShip(ship);
        }
    }*/

}

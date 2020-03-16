package code;

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

    public Board() {
        squares = new Square[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                squares[i][j] = new Square();
            }
        }
    }

    public Square getSquare(int row, int column) {
        return squares[row][column];
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

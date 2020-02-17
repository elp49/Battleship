package code;

public class Board {

    private Square[][] squares;
    private Ship[] ships;

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

    public int getRowIndex(int row) {
        // Assert row number is within range 1 to 10 inclusive.
        assert row >= 1 && row <= 10;
        // Return Y index. If row is 1, then returns 0 for first index.
        return row - 1;
    }

    public int getColumnIndex(char column) {
        // Convert column character to uppercase if not already.
        char c = Character.toUpperCase(column);
        // Retrieve ASCII value to test assertion.
        int ascii = (int) c;
        // Assert ASCII value is within range 65 - 74 inclusive (characters A through J).
        assert c >= 65 && c <= 74;
        // Return X index. If column is A, then returns 0 for first index.
        return c - 65;
    }

    public void placeShipOnBoardVertically(Ship ship, int[] rows, char column) throws Exception {
        // Assert ship is not null.
        assert ship != null;
        // Create array of row indices.
        int numRows = rows.length;
        int rowIndices[] = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            rowIndices[i] = getRowIndex(rows[i]);
        }
        // Get column index.
        int columnIndex = getColumnIndex(column);
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
        // Create array of column indices.
        int numColumns = columns.length;
        int columnIndices[] = new int[numColumns];
        for (int i = 0; i < numColumns; i++) {
            columnIndices[i] = getColumnIndex(columns[i]);
        }
        // Set squares' ship values to the ship.
        for (int j = 0; j < numColumns; j++) {
            // Check if square is already occupied by a ship.
            Square square = squares[rowIndex][columnIndices[j]];
            if (square.hasShip()) {
                throw new Exception(String.format("Attempted to write ship \'{0}\' to square [{1}][{2}], but square " +
                        "is occupied by ship \'{3}\'.", ship.getName(), row, columns[j], square.getShip().getName()));
            }
            square.setShip(ship);
        }
    }

}

import code.*;

public class ApplicationDriver {

    public static void main(String[] args) throws Exception {
        Board board1 = new Board();
        Board board2 = new Board();


        Ship ships[] = new Ship[5];
        ships[0] = new Ship("Carrier", 5);
        ships[1] = new Ship("Battleship", 4);
        ships[2] = new Ship("Cruiser", 3);
        ships[3] = new Ship("Submarine", 3);
        ships[4] = new Ship("Destroyer", 2);


        board1.placeShipOnBoardHorizontally(ships[0], 1, new char[]{'A', 'B', 'C', 'D', 'E'});
        board1.placeShipOnBoardHorizontally(ships[1], 2, new char[]{'A', 'B', 'C', 'D'});
        board1.placeShipOnBoardHorizontally(ships[2], 3, new char[]{'A', 'B', 'C'});
        board1.placeShipOnBoardHorizontally(ships[3], 4, new char[]{'A', 'B', 'C'});
        board1.placeShipOnBoardHorizontally(ships[4], 5, new char[]{'A', 'B'});


    }
}
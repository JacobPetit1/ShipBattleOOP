/* This class holds the interactions between the gameboard
 *  as well as the ship class.
 * 
 */

public class gameBoardShip extends gameBoard
{
    private gameBoard board;
    private ship shipMemory;
    /* TODO: make methods to envoke from ship to board
     *  place ship
     *  
     */

     public void setGameBoard(gameBoard boardToStore)
     {
        board = boardToStore;
     }
     public gameBoard getGameBoard()
     {
        return board;
     }


    // empty default constructor
    public gameBoardShip()
    {
        super(0,0);
    }
    // constructor builds a board with width and height
    public gameBoardShip(gameBoard gameBoard)
    {
        super(gameBoard.getArrWidth(),gameBoard.getArrHeight());
    }
    // default ship placement -- doesnt handle empty information
    public void placeShip(ship shipToInsert)
    {
        //places ship but does not handle missing information

    }
    public void placeShip(ship shipToInsert, int headXValue, int headYValue)
    {
        // places ship at x y cord

    }


}

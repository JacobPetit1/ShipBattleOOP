/* This class holds the interactions between the gameboard
 *  as well as the ship class.
 * 
 */

public class gameBoardShip extends gameBoard
{
    /* TODO: make methods to envoke from ship to board
     *  place ship
     *  
     */


    // empty constructor with an empty board (0,0)
    public gameBoardShip()
    {
        super(0,0);
    }
    // constructor builds a board with width and height
    public gameBoardShip(int width, int height)
    {
        super(width,height);
    }
}

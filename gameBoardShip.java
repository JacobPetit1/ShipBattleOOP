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
        super();
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
        try
        {
            int headXCord = shipToInsert.getHeadXIndex();
            int headYCord = shipToInsert.getHeadYIndex();

            // o vert 1 horz

            if(shipToInsert.getShipDirection()==0)
            {
                for(int i = 0; i < shipToInsert.getShipLength(); i++)
                {
                    board.insertInteger(headXCord, headYCord+i, shipToInsert.getShipIdentifier());
                }
            }
            else
            {
                for(int i = 0; i < shipToInsert.getShipLength(); i++)
                {
                    board.insertInteger(headXCord+i, headYCord, shipToInsert.getShipIdentifier());
                }
            }

        }
        catch(Exception e)
        {
            //throw exception or text handle
        }
    }
    public void placeShip(ship shipToInsert, int headXValue, int headYValue)
    {
        // places ship at x y cord
        shipToInsert.setHeadXIndex(headXValue);
        shipToInsert.setHeadYIndex(headYValue);
        try
        {
            // o vert 1 horz

            if(shipToInsert.getShipDirection()==0)
            {
                for(int i = 0; i < shipToInsert.getShipLength(); i++)
                {
                    board.insertInteger(shipToInsert.getHeadXIndex(), shipToInsert.getHeadYIndex()+i, shipToInsert.getShipIdentifier());
                }
            }
            else
            {
                for(int i = 0; i < shipToInsert.getShipLength(); i++)
                {
                    board.insertInteger(shipToInsert.getHeadXIndex()+i, shipToInsert.getHeadYIndex(), shipToInsert.getShipIdentifier());
                }
            }
        }
        catch(Exception e)
        {
            // throw error or text handle
        }
    }


}

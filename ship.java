/*  This ship class behaves as a skeleton/model for the game,
 *  use this for placing the ship to the board but this is not
 *  linked to the board itself. Will be extended to a ship and board controller.
 */

 // NOTE: this does not fully handle all errors
public class ship 
{
    //variables
    private int shipIdentifier;
    private int xHeadIndex, yHeadIndex;
    private int[] head = new int[2];
    private int shipLength; //  may be subject to change
    private int[] shipArray;
    private int direction;
    
    // getters and setters for the head of the ship
    // and for the index values, but all are private
    public void setHeadXIndex(int xIndexValue)
    {
        xHeadIndex = xIndexValue;
        head[0] = xHeadIndex;
    }
    public void setHeadYIndex(int yIndexValue)
    {
        yHeadIndex = yIndexValue;
        head[1] = yHeadIndex;
    }
    public int getHeadXIndex()
    {
        return head[0];
    }
    public int getHeadYIndex()
    {
        return head[1];
    }
    // getter and setter for the shipIdentifier value
    // shipIdentifier: literally an int value so you can tell the ships apart
    public void setShipIdentifier(int intShipIdentifier)
    {
        shipIdentifier = intShipIdentifier;
    }
    public int getShipIdentifier()
    {
        return shipIdentifier;
    }

    public void setShipLength(int length)
    {
        shipLength = length;
    }
    public int getShipLength()
    {
        return shipLength;
    }

    // direction: 0-vertical, 1-horizontal
    public void setShipDirection(int shipDirection)
    {
        direction = shipDirection;
    }
    public int getShipDirection()
    {
        return direction;
    }


    // ship constructors
    public ship()
    {
        // blank ship constructor
    }
    public ship(int shipNumber)
    {
        shipArray = new int[shipLength];

        // fills array with ship identifier value
        for(int i = 0; i<shipLength; i++)
        {
            shipArray[i] = shipIdentifier;
        }
    }
    public ship(int shipNumber, int shipLength, int shipDirection)
    {
        setShipIdentifier(shipNumber);setShipLength(shipLength);
        setShipDirection(shipDirection);

        shipArray = new int[shipLength];

        for(int i = 0; i<shipLength; i++)
        {
            shipArray[i] = shipIdentifier;
        }
    }

    


}

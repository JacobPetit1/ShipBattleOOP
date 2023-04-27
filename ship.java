/*  This ship class behaves as a skeleton/model for the game,
 *  use this for placing the ship to the board but this is not
 *  linked to the board itself. Will be extended to a ship and board controller.
 */

 // NOTE: this does not fully handle all errors
public class ship 
{
    /* TODO: ship integer identifier
     *      ship head
     *      ship direction
     *      ship constructor
     *      getters setters
     * 
     * 
     */

    //variables
    private int shipIdentifier;
    private int xHeadIndex, yHeadIndex;
    private int[] head = new int[2];
    
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

    public ship()
    {
        // initial ship constructor
    }

    


}

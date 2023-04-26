/*  This is the gameBoard object with methods to envoke
 *  console printing, back end memory, or visual calls
 *  as seen with "Model View Controllers"
 */
public class gameBoard 
{
    // declare local/private variables
    private int arrWidth;
    private int arrHeight;
    // create setter getter so no one can modify
    public void setArrWidth(int width)
    {
        arrWidth = width;
    }
    public void setArrHeight(int height)
    {
        arrHeight = height;
    }
    public gameBoard()
    {
        // maybe intentially leave blank because this is not expected
        // maybe throw error to handle for unexpected
        // initial Board call
    }
    public gameBoard(int width, int height)
    {
        private String[][] array = new String[arrWidth][arrHeight];
        // create array of size width and height
    }
    
    public String toString()
    {

    }

}

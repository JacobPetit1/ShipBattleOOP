/*  This is the gameBoard object with methods to envoke
 *  console printing, back end memory, or visual calls
 *  as seen with "Model View Controllers"
 */
public class gameBoard 
{
    // declare local/private variables
    private int arrWidth;
    private int arrHeight;
    int[][] array;

    // create setter getter so no one can modify
    public void setArrWidth(int width)
    {
        arrWidth = width;
    }
    public void setArrHeight(int height)
    {
        arrHeight = height;
    }

    /*
     *  gameBoard constructor
     */
    // creates empty array of size width, height
    public gameBoard(int width, int height)
    {
        setArrWidth(width);
        setArrHeight(height);
        array = new int[arrWidth][arrHeight];
    }

    // method inserts / sets int value at given index
    public void insertInteger(int xIndex, int yIndex, int element)
    {
        array[xIndex][yIndex] = element;
    }
    // add method to search index?

    // method looks at what the int value is at the given index
    public int getElementAtIndex(int xIndex, int yIndex)
    {
        return array[xIndex][yIndex];
    }


    //@override print method
    public String toString()
    {
        String arrayString = "";
        for(int i = 0; i < arrHeight;i++)
        {
            arrayString = arrayString + "\n";
            for(int j = 0; j < arrWidth; j++)
            {
                arrayString = arrayString + array[i][j] + " ";
            }
        }
        return arrayString;
    }
}

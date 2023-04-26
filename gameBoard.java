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
    // creates empty array of size arrWidth, arrHeight
    public gameBoard()
    {
        array = new int[arrWidth][arrHeight];
    }

    // add methods to place elements at an index
    public void insertInteger(int xIndex, int yIndex, int element)
    // add method to search index


    public String toString()
    {
        String arrayString = "";
        for(int i = 0; i < arrHeight;i++)
        {
            arrayString = arrayString + "\n";
            for(int j = 0; j < arrWidth; j++)
            {
                arrayString = arrayString + array[i][j];
            }
        }
        return arrayString;
    }

}

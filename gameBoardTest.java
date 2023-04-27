public class gameBoardTest extends gameBoard
{
    public gameBoardTest()
    {
        setArrWidth(5);
        setArrHeight(5);
        gameBoard board = new gameBoard();
        System.out.print(board);
    }
    public static void main(String[] args)
    {
        gameBoardTest test = new gameBoardTest();
    }
}

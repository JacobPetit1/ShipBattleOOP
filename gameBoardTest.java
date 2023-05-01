public class gameBoardTest
{
    public static void main(String[] args)
    {
        gameBoard board = new gameBoard(5,5);
        System.out.print(board);

        //manipulate board
        board.insertInteger(1, 1, 1);
        System.out.print(board);
        System.out.print(board.getElementAtIndex(1, 1));
    }
}

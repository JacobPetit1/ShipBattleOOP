/* Object Oriented Programming
 * Creators: Jake, Pablo, Matt <last names>
 * <MIT LICENSE>
 */
package src;
import java.util.*;
public class Bismarck 
{
	// copies one string and returns a copy
	public static String[][] copyBoard(String[][] arrBase, String[][] self)
	{
		for(int i=0;i<arrBase.length;i++)
		{
			for(int j=0;j<arrBase.length;j++)
			{
				self[i][j] = arrBase[i][j];
			}
		}
		return self;
	}
// prints/displays the displayBoard
	public static void printBoard(String[][] displayedBoard)
	{
		// format is based off 7 x 7 display with 5 x 5 playable 
		System.out.print("  ");
		for(int i=0; i<8; i++)	// rows
		{
			for(int j=0; j<8; j++)	// columns
			{
				if(i==1 || i==7)
				{
					if(j==0)
					{
						System.out.print(" ");
					}
					else 
					{
						System.out.print("*");
					}
				}
				else if(i==0)
				{
					switch (j-2)
					{
					case 0:
						System.out.print("1");
						break;
					case 1:
						System.out.print("2");
						break;
					case 2:
						System.out.print("3");
						break;
					case 3:
						System.out.print("4");
						break;
					case 4:
						System.out.print("5");
						break;
					default:
					}
				}
				else if(j==1 || j==7)
				{
					System.out.print("*");
				}
				else if(j==0)
				{
					switch (i-2)
					{
					case 0:
						System.out.print("1");
						break;
					case 1:
						System.out.print("2");
						break;
					case 2:
						System.out.print("3");
						break;
					case 3:
						System.out.print("4");
						break;
					case 4:
						System.out.print("5");
						break;
					default:
						throw new ArrayIndexOutOfBoundsException();
					}
				}
				else
				{
					System.out.print(displayedBoard[i-2][j-2]);
				}
			}
			System.out.println();
		}
	}
// print welcome message / assigment info
	public static void printHeadder() 
	{
		System.out.println("Programming Fundamentals");
		System.out.println("Name: Matthew Stankevicius");
		System.out.println("PROGRAMMING ASSIGNMENT 2");
		System.out.println();
		System.out.println("Welcome to Bismarck!");
		System.out.println();
	}
	// initalizes a hard coded bound 5 x 5 string array empty tokens " ";
	public static String[][] initBoard(String[][] initSelf)
	{
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				initSelf[i][j] = " "; 
			}
		}
		return initSelf;
	}
// method that inputs board with user ship ; outputs new board but does not show bismark
	public static String[][] declareBoard(String direction, int position, String[][] self, String marker)
	{
		int[] tokens = new int[2];
		for(int i = 0;i<2;i++)
		{
			tokens[i] = position % 10;
			position = position / 10;
		}
		// added for testing
		//System.out.println(tokens[0] + " " +tokens[1]);
		//
		if(direction.equals("v"))
		{
			// if vertical, starting at pos y x ; 3 chars going down
				for(int i = 0; i<3; i++)
				{
					if(self[(tokens[1]-1)+i][tokens[0]-1] == " ")
					{
						// empty ; checks if input is valid
					}
					else
					{
						throw new ArrayIndexOutOfBoundsException();
					}
				}
				for(int i = 0; i<3; i++)
				{
					// if input is valid
					self[(tokens[1]-1)+i][tokens[0]-1] = marker;
				}
		}
		else if(direction.equals("h"))
		{
			// if horizontal, starting at pos y x ; 3 char right
			for(int i = 0; i<3; i++)
			{
				if(self[tokens[1]-1][(tokens[0]-1)+i] == " ")
				{
					// empty ; checks if it is possible
				}
				else
				{
					throw new ArrayIndexOutOfBoundsException();
				}
			}
			for(int i = 0; i<3; i++)
			{
				self[tokens[1]-1][(tokens[0]-1)+i] =  marker;
			}
		}
		else
		{
			throw new InputMismatchException();
		}
		return self;
	}
	// declare the hidden board with bismarck
	public static String[][] declareHiddenBoard(String[][] self)
	{
		Random gen = new Random(17);
		// gen 0 - 1 either for v or h
		int orientation = gen.nextInt(2);
		String orien;
		Boolean hasValidInput = false;
		if(orientation==0)
		{
			orien = "v";
		}
		else
		{
			orien = "h";
		}
		// gen 00 value until Bismarck finds a valid range
		while(!hasValidInput)
		{
			int x = gen.nextInt(5)+1;
			int y = gen.nextInt(5)+1;
			int position = (x*10)+y;
			try 
			{
				declareBoard(orien,position,self,"$");
				hasValidInput = true;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				// intentionally left empty ; continues loop
			}
		}
		return self;		
	}
	// takes integer position ; compares hit ; updates both boards
	public static void playerMove(int position, String[][] displayBoard, String[][] hiddenBoard)
	{
		int x = (position / 10)-1;
		int y = (position % 10)-1;
		try 
		{
			if(hiddenBoard[x][y] == "#" || hiddenBoard[x][y] == "%")
			{
				// leaves empty so you can see the ship && shouldnt be guessing your ship
				System.out.println("You missed!");
			}
			else if(hiddenBoard[x][y] == "$")
			{
				hiddenBoard[x][y] = "H";
				displayBoard[x][y] = "H";
				// handle for hits
				System.out.println("You hit the Bismarck!");
			}
			else if(hiddenBoard[x][y] == " ")
			{
				hiddenBoard[x][y] = "#";
				displayBoard[x][y] = "#";
				System.out.println("You Missed!");
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Incorrect input! <Turn voided>");
		}
	}
	public static void cpuMove(String[][] displayBoard, String[][] hiddenBoard)
	{
		boolean positionValid = false;
		Random gen = new Random(17);
		while(!positionValid)
		{
			int x = gen.nextInt(5);
			int y = gen.nextInt(5);
			if(hiddenBoard[x][y] == "#" || hiddenBoard[x][y] == "$")
			{
				// leaves empty so you can see your ship && shouldnt be guessing your ship
				// empty so cpu keeps guessing
			}
			else if(hiddenBoard[x][y] == "%")
			{
				hiddenBoard[x][y] = "H";
				displayBoard[x][y] = "H";
				// handle for hits
				System.out.println("Bismarck aimed at " +(x+1)+" "+(y+1));
				System.out.println("Bismarck hit the Prince of Whales!");
			}
			else if(hiddenBoard[x][y] == " ")
			{
				// handle for misses
				hiddenBoard[x][y] = "#";
				displayBoard[x][y] = "#";
				positionValid = true;
				System.out.println("Bismarck aimed at " +(x+1)+" "+(y+1));
				System.out.println("Bismarck missed!");
			}
		}
	}
	public static int isSunk(String[][] playerBoard,String[][] cpuBoard)
	{
		int playerShipCount = 0;
		// loop through player board to find if prince of whales exsists
		for(int i=0;i<playerBoard.length;i++)
		{
			for(int j=0;j<playerBoard.length;j++)
			{
				if(playerBoard[i][j].equals("%"))
				{
					playerShipCount++;
				}
			}
		}
		if(playerShipCount==0)
		{
			// return 1 if prince of whales is sunk
			return 1;
		}
		else
		{
			int cpuShipCount = 0;
			// loops and counts through cpu board to find bismarck
			for(int i=0;i<cpuBoard.length;i++)
			{
				for(int j=0;j<cpuBoard.length;j++)
				{
					if(cpuBoard[i][j].equals("$"))
					{
						cpuShipCount++;
					}
				}
			}
			if(cpuShipCount==0)
			{
				// return int 2 for cpu ship is sunk ; ie bismark is sunk
				return 2;
			}
			else
			{
				// return 0 if no ships are sunk
				return 0;
			}
		}
	}
	public static void guessComputation(boolean playValue, String[][] playerBoard, String[][] cpuBoard)
	{
		if(isSunk(playerBoard,cpuBoard)==1)
		{
			playValue = false;
			System.out.println();
			System.out.println("Game Over! The Bismarck sank the Prince of Wales!");
			System.exit(0);
		}
		else if(isSunk(playerBoard,cpuBoard)==2)
		{
			playValue = false;
			System.out.println();
			System.out.println("Congradulations! You sank the Bismarck!");
			System.exit(0);
		}
		else if(isSunk(playerBoard,cpuBoard)==0)
		{
			// null so game can continue
		}
	}
	public static void main(String[] args) 
	{
		//create objects
		Scanner in = new Scanner(System.in);
		Random gen = new Random(17);
		/*
		 *  maybe create 2 boards one hidden and one shown 
		 *  so you can print the cpu guesses and show them
		 */
		String[][] displayBoard = new String[5][5];
		initBoard(displayBoard);
		String[][] hiddenBoard = new String[5][5];
		//init variables
		String orientation;
		int position;
		Boolean hasWinner = false;
		// print assignment info ; welcome message; and empty board
		printHeadder();
		printBoard(displayBoard);
		// ask user for user ship orientation ; 00 represents Row, Column ; handle for invalid input
		System.out.print("Choose the Prince of Wales' orientation (v or h): ");
		orientation = in.next();
		System.out.print("Enter the coordinates in integer format (00) for the head of the ship (xy): ");
		position = in.nextInt();
		// output updated board
		declareBoard(orientation,position, displayBoard, "%");
		copyBoard(displayBoard,hiddenBoard);
		// call bismarck random orientation ; update board ; display (displayBoard)
		printBoard(displayBoard);
		// random orientation and pos for bismark ; update board
		declareHiddenBoard(hiddenBoard);
		/* while(!won)
		 * 		enter use position x y ; no handling
		 * 		compare either hit or miss ; display
		 * 		if(!won)
		 * 			cpu random number guess x y ; print cpu guess to screen ; compare hit or miss
		 */
		while(!hasWinner)
		{
			int playerGuess = 0;
			System.out.print("Enter your guess (vh):");
			playerGuess = in.nextInt();
			playerMove(playerGuess,displayBoard,hiddenBoard);
			guessComputation(hasWinner,displayBoard,hiddenBoard);
			cpuMove(displayBoard,hiddenBoard);
			printBoard(displayBoard);
			guessComputation(hasWinner,displayBoard,hiddenBoard);
		}
		// print game winning message ; terminate
	}
}

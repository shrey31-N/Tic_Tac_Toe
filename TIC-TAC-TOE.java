package tic_tac_toe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class game {
	private static char[][] board=new char[3][3];
	private static char currentPlayer='X';

	public static void main(String[] args)
	{
		initializeBoard();
		playGame();
	}
	//Initialize the board with empty spaces
	public static void initializeBoard()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				board[i][j]=' ';
			} 
		}
	}
	//Display the current board
	public static void printBoard()
	{
		System.out.println("Board: ");
		System.out.println(" ");
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(board[i][j]);
				if(j<2)
				{
					System.out.print(" | ");
				}
			}
			System.out.println(" ");
			if(i<2)
			{
				System.out.println("----------");
			}
		}
	}
		//Main game loop
		public static void playGame()
		{
			boolean gameRunning=true;
			Scanner scan=new Scanner(System.in);
			
			 while (gameRunning) {
		            printBoard();
		            System.out.println("Player " + currentPlayer + "'s turn. Enter the row and column (0, 1, or 2):");

		            int row = -1;
		            int column = -1;

		            // Input validation loop
		            while (true) {
		                try {
		                    System.out.println("Enter the row and column separated by SPACE:");
		                    row = scan.nextInt();
		                    column = scan.nextInt();

		                    // Check if input is within valid range
		                    if (row >= 0 && row < 3 && column >= 0 && column < 3) {
		                    	 if(board[row][column]==' ')
		         				{
		         					board[row][column]=currentPlayer;
		         				}
		         				else
		         				{
		         					System.out.println("That spot is already taken.try again.");
		         				}
		                    	break; // Break out of the input loop if valid
		                    } 
		                    	 else {
		                        System.out.println("Invalid input. Please enter row and column between 0 and 2.");
		                    }
		                } catch (InputMismatchException e) {
		                    // Handle the exception
		                    System.out.println("Invalid input. Please enter integers only  and enter row and column between 0 and 2.");
		                    scan.nextLine(); // Clear the invalid input
		                }
		            }
				//check if the game is won or draw
				
				if(checkWin())
				{
					printBoard();
					System.out.println("Player  "+"'"+currentPlayer+"'"+"  wins..........!");
					gameRunning=false;
				}
				else if(isBoardFull())
				{
					printBoard();
					System.out.println("The game is a Draw...!");
					gameRunning=false;
				}
				//switch players
				currentPlayer=(currentPlayer=='X')?'O':'X';
			}
			scan.close();
		}
				//check if there is a winner
				
				public static boolean checkWin()
				{
					//Check rows, columns and diagonals
					
					for(int i=0;i<3;i++)
					{
						if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
						 return true;
						
						if(board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
						return true;
					}
					if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
					return true;
					
					if(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
						return true;
					
					return false;
				}
				//check if the board is full
				public static boolean isBoardFull()
				{
					for(int i=0;i<3;i++)
					{
						for(int j=0;j<3;j++)
						{
							if(board[i][j]==' ')
							{
								return false;
							}
						}
					}
					return true;
				}	
}

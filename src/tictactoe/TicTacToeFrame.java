package tictactoe;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * JFrame to hold TicTacToe board.
 */
public class TicTacToeFrame extends JFrame
{
	// Indicate whose turn it is, O's turn is first
	private char whosTurn = 'O';

	//ends the game, at default game is not over so set to false, only true if game is over
	private boolean gameOver = false;

	// Create cell grid , two dimensional array
	private Cell[][] cells = new Cell[3][3];

	// Create a JLabel for the game
	JLabel jlblStatus = new JLabel();


	/**
	 * No-argument Constructor
	 */
	public TicTacToeFrame()
	{               
		// Panel to hold cells, 3 rows and 3 columns
		//0 horizonal gap, 0 vertical gap(Space between cells)
		JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
		
		//fills grid panel with new cells, using cell constructor
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				
	   //adds the cells to the panel
				panel.add(cells[i][j] = new Cell());

		//Puts a red border around the frame on the board
		panel.setBorder(new LineBorder(Color.red, 5));


		//This code adds the actual panel to the tic tac toe frame
		add(panel, BorderLayout.CENTER);

	}


	/**
	 * Determine if game board is full.
	 * @return True, if game board is full 
	 * if not full, false
	 */

	//Goes through the whole grid,if one token empty return false
	//because board isn't full otherwise true.
	public boolean isFull()
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (cells[i][j].getToken() == ' ')
				{
					return false;
				}
		{
			return true;

		}
	}

	/**
	 * Determines if a given token has won.
	 * @param token Token to test for winning
	 * @return True, if the token has won.
	 *  if not won return  false.
	 */
	public boolean isWon(char token)
	{

		// check rows, all 3 have same token, token has won
		for (int i = 0; i < 3; i++)
			if ((cells[i][0].getToken() == token)
					&& (cells[i][1].getToken() == token)
					&& (cells[i][2].getToken() == token))
			{
				return true;
			}

		// check columns
		for (int j = 0; j < 3; j++)
			if ((cells[0][j].getToken() == token)
					&& (cells[1][j].getToken() == token)
					&& (cells[2][j].getToken() == token))
			{
				return true;
			}
		// check diagonal, top left cell, middle cell
		//and bottom right cell
		if ((cells[0][0].getToken() == token)
				&& (cells[1][1].getToken() == token)
				&& (cells[2][2].getToken() == token))
		{
			return true;
		}

		//top right cell, middle cell, bottom left
		if ((cells[0][2].getToken() == token)
				&& (cells[1][1].getToken() == token)
				&& (cells[2][0].getToken() == token))
		{
			return true;
		}

		else
			//token not won return false
			return false;
	}

	/**
	 * Defines a cell in a TicTacToe game board.
	 */
	
	public class Cell extends JPanel
	{
		// token of this cell, by default empty cell so  its equals to ' ' 
		private char token = ' ';

		/**
		 * Constructor for the actual board
		 */
		public Cell()
		{
			setBorder(new LineBorder(Color.black, 5));

			//listens for a mouse click on cell
			addMouseListener(new MyMouseListener());
		}

		/**
		 * Gets the token of the cell.
		 * @return The token value of the cell
		 * whichever character thats in each cell
		 */
		public char getToken()
		{
			return token;
		}

		/**
		 * Sets the token of the cell.
		 * @param c Character to use as token value.
		 */
		public void setToken(char c)
		{
			token = c;
			repaint(); //repaint cell updates the GUI so it will display the x's and o's (tokens)
		}



		//painting of the code located here
		public void paintComponent(Graphics g)
		{

			// without super x's and o's wont appear   
			//call the parent classes paint component method
			super.paintComponent(g);

			if (token == 'X')

			{

				g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
				g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
			}

			else if (token == 'O')
			{
				g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
			}
		}


		//Mouse events let you track when a mouse is 
		// pressed, released, clicked, moved, dragged,

		private class MyMouseListener extends MouseAdapter
		{

			public void mouseClicked(MouseEvent e)
			{
				if (gameOver)
					return;

				// if the cell is empty and the game is not over
				if (token == ' ' && whosTurn != ' ')
					setToken(whosTurn);

				// Check game status
				if (isWon(whosTurn))
				{
					JOptionPane.showMessageDialog(jlblStatus, whosTurn + " Won! Game Over!");
					whosTurn = ' ';
					gameOver = true;
				}
				else if (isFull())
				{
					JOptionPane.showMessageDialog(jlblStatus, "Tie Game! Game Over!");
					whosTurn = ' ';
					gameOver = true;
				}
				else
				{
					//if x's turn switch to o's turn
					//if o's turn switch to x's turn
					whosTurn = (whosTurn == 'X') ? 'O' : 'X';
					JOptionPane.showMessageDialog(jlblStatus, whosTurn + "'s Please Make Your Move!");
				}
			}
		} 
	} 
} 
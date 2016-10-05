package tictactoe;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * TIC TAC TOE GAME
 * This is the main code that will run the game
 */
public class TicTacToe extends JFrame{


	public static void main(String[] args)
	{
		JFrame frame2 = new JFrame ("Welcome to Tic Tac Toe");
		frame2.setVisible(true);
		frame2.setSize(300,200);
		JButton button = new JButton ("Start Game");
		frame2.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		button.addActionListener(new Action());
		frame2.add(panel);
		panel.add(button);
	}

	//actual tic tac toe board, action listener makes board recognise mouse click

	static class Action implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			JFrame ticTacToe = new TicTacToeFrame();
			ticTacToe.setTitle("The TicTacToe Game!");
			ticTacToe.setSize(700, 700);
			ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ticTacToe.setLocationRelativeTo(null);
			ticTacToe.setVisible(true);	        
		}
	}

} 
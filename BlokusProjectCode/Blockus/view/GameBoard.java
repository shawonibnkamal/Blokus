/**
 * This class creates a 20 by 20 grid inside a Jpanel where the main game will take place
 * @author Nelson Hernandez
 * 
 */
package Blockus.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;

public class GameBoard extends JPanel {

	// JButtons array for grid
	private JButton[][] board = new JButton[20][20];
	private int mouseX;
	private int mouseY;
	/**
	 * Create the panel.
	 */
	public GameBoard() {
		
		initComponents();
		createEvents();
	}
	private void initComponents() {
		// sets a grid layout for the board
		setLayout(new GridLayout(20, 20));
		createGrid();
	}
	
	private void createEvents()
	{
		
	}
	
	private void createGrid()
	{
		// loops through the board array and adds a new button to each index
		for(int i = 0; i < board.length; i++)
		{
				for(int j = 0; j < board.length; j++)
				{
				board[i][j] = new JButton("");
				
				// sets the buttons to be enabled
				board[i][j].setEnabled(true);
				board[i][j].setFocusable(false);
				
				// sets the buttons to be opaque
				board[i][j].setOpaque(true); // sets the opacity to true
				board[i][j].setFocusable(false);
				board[i][j].setRolloverEnabled(false);
				

				// adds the buttons to the jpanel
				add(board[i][j]);// adds the chocolate bar to the GamePane

				
				}
		}
		colorCorners();
	
	}
	
	private void colorCorners()
	{
		board[0][0].setBackground(Color.blue);
		board[0][board.length-1].setBackground(Color.red);
		board[board.length-1][0].setBackground(Color.green);		
		board[board.length-1][board.length-1].setBackground(Color.yellow);
	}
	
	public void setPiece(ArrayList<ArrayList<Integer>> currPiece, int index)
	{
		
		for(int x = 0; x < 20; x++)
		{
			for(int y = 0; y < 20; y++)
			{
				final int i = x;
				final int j = y;
				
		
				board[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						mouseX = i;
						mouseY = j;
						
						
						//JOptionPane.showMessageDialog(null, "X Y" + mouseX + "'" + mouseY);
						board[i][j].setOpaque(true);
						board[i][j].setIcon(new ImageIcon(RulesDialog.class.getResource("/Blockus/resources/pieceBlue.jpg")));
						JOptionPane.showMessageDialog(null,index);
					}
				});
			}
		}
	}
	
	public void rotatePieceCLockwise()
	{
		
	}
}
	
	
	


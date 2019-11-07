package Blockus.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Blockus.common.Pieces;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ObjectInputStream.GetField;
import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PlayerPieces extends JPanel {
	
	private Pieces pieces;
	private ArrayList<ArrayList<ArrayList<JButton>>> renderedPieces;
	private ArrayList<JPanel> piecesPanels;
	private JScrollPane scrollPane;
	private JPanel panel;
	private ArrayList<ArrayList<Integer>> currentPiece;
	private int currentPieceIndex;

	/**
	 * Create the panel.
	 */
	public PlayerPieces() {
		
		initComponents();	
		createEvents();
	}
	
	private void createEvents() {
		for(int i = 0; i < renderedPieces.size(); i++)
		{
			for(int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 5; k++)
				{
					final int x = i;
					
					renderedPieces.get(i).get(j).get(k).addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							setCurrentPiece(x);
							
							//used for debugging
							JOptionPane.showMessageDialog(null, "Current Piece: " + x);
							printCurrentPiece();
							currentPieceIndex = x;
							
						}

						private void setCurrentPiece(int currentPieceIndex) {
							currentPiece = new ArrayList<ArrayList<Integer>>();
							for(int i =0; i < 5; i++)
							{
								currentPiece.add(new ArrayList<Integer>());
								for(int j = 0; j < 5; j++)
								{
									currentPiece.get(i).add(pieces.getPieces()[x][i][j]);
								}
							}
						}
					});
				}
			}
		}
		
	}
	
	//used for debugging
	public void printCurrentPiece()
	{
		for(int i =0; i < 5; i++)
		{
			for(int j =0; j< 5; j++	)
			{
				System.out.print(currentPiece.get(i).get(j) + " ");
			}
			System.out.print("\n");
		}
	}

	private void initComponents()
	{
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
		);
		
		
		
		pieces = new Pieces();
		piecesPanels  = new ArrayList<JPanel>();
		renderedPieces = new ArrayList<ArrayList<ArrayList<JButton>>>();
	
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		currentPiece = new ArrayList<ArrayList<Integer>>();

		
		setLayout(groupLayout);
		//renderPieces();
		//addPieces();

		//renderPieces();
		addPieces();
	}
	

	
	private void addPieces()
	{
		for(int i = 0; i < pieces.getNumberOfPieces(); i++)
		{
			piecesPanels.add(new JPanel());
			piecesPanels.get(i).setLayout(new GridLayout(5,5));
			renderedPieces.add(new ArrayList<ArrayList<JButton>>());
			for(int j = 0; j < 5; j++)
			{
				renderedPieces.get(i).add(new ArrayList<JButton>());
				for(int k = 0; k < 5; k++)
				{
					System.out.println(i + " " + j + " "+ k);
					renderedPieces.get(i).get(j).add(new JButton());
					
					if(pieces.getPieces()[i][j][k] == 1)
					{
						renderedPieces.get(i).get(j).get(k).setOpaque(true);
						renderedPieces.get(i).get(j).get(k).setBackground(Color.blue);
						renderedPieces.get(i).get(j).get(k).setForeground(Color.red);
						
						
					}
					else {
						renderedPieces.get(i).get(j).get(k).setEnabled(false);
						}
					piecesPanels.get(i).add(renderedPieces.get(i).get(j).get(k));
					
				}
				
			}
			panel.add(piecesPanels.get(i));
		}
		
	}
	
	public ArrayList<ArrayList<Integer>> getCurrentPiece()
	{
		return currentPiece;
	}
	
	public int getCurrentPieceIndex()
	{
		return currentPieceIndex;
	}
	
	public void rotatePieceClockwise(int index)
	{
		ArrayList<ArrayList<JButton>> temp = new ArrayList<ArrayList<JButton>>();
		int size = 5;
		for(int i = 0; i < 5; i++)
		{
			temp.add(new ArrayList<JButton>());
			for(int j = 0; j < 5; j++)
			{
				temp.get(size - j).get(i).add(renderedPieces.get(index).get(i).get(j));
			}
		}
		renderedPieces.add(index, temp);
	}
	
}

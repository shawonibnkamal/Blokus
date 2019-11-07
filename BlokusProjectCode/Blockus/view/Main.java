/**
 * This class runs the main game and draws the different components
 * 
 * @author Nelson Hernandez
 * COMP2005 Blockus Project
 * Version 1.0
 * 
 * 
 */

package Blockus.view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;



import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.UIManager;


public class Main extends JFrame {
	// creates a new container
	private Container c;
	
	// card layout to change panes
	private CardLayout card;
	
	private StartPanel startPanel;
	private GameDisplayPanel displayPanel;
	private PauseDialog pauseDialog;

	private Game game;
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// sets the look and feel to system default
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}

					Main frame = new Main();
					frame.setVisible(true);
					frame.setTitle("Blockus Prototype");
					frame.setLocationRelativeTo(null);
	}

	/**
	 * Create the main window.
	 */
	public Main() {
		setTitle("Blockus Prototype");
		
		initComponents(); // creates components in JFrame
		createEvents(); // creates events
	}
	
	
	public void initComponents()
	{
		// gets content pane
		c = getContentPane();
		
		// creates a new card layout for different panes
		card = new CardLayout(0,0);
		c.setLayout(card);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 900);

		// creates a new start panel
		startPanel = new StartPanel();
		

		
		// creates a game display panel that allows user to choose settings for the game
		displayPanel = new GameDisplayPanel();
		
		
		// creates a game  panel
		game = new Game();
		// adds both panels to the main container object
		c.add(startPanel);
		c.add(displayPanel);
		c.add(game);

	
		pauseDialog = new PauseDialog();
		
		// creates  a menu bar to the game window
		MenuBar gameMenuBar = new MenuBar();
		
		
		setJMenuBar(gameMenuBar);
		
		
		
	}

	public void createEvents()
	{
		// waits for player to click on display panel
		// changes the pane to the gamedisplay pane 
		startPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				card.next(c);
				
			}
		});
		
		displayPanel.getbtnStart().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(c);
			}
		});
		
		game.getbtnPause().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				game.openPauseDialog();
			}
		});
		
	
	}
}

/**
 * This class displays a JDialog when the pause button is pressed. It gives the user 4 options.
 * 1. To resume the game
 * 2. To create a new game
 * 3. To go to the settings 
 * 4. To quit the game
 * 
 * @author Nelson Hernandez
 */
package Blockus.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class PauseDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	// button to resume the game
	private JButton btnResumeGame;

	// button to create a new game
	private JButton btnNewGame;
	
	// button to open the settings
	private JButton btnSettings;
	
	// button to quit the game
	private JButton btnQuit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PauseDialog dialog = new PauseDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PauseDialog() {
		initComponents();
		createEvents();
	}

	private void initComponents()
	{
		setBounds(100, 100, 218, 386);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		// initializes the buttons
		btnResumeGame = new JButton("Resume Game");
		btnResumeGame.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		btnSettings = new JButton("Settings ");
		btnSettings.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		
		
		// sets the layout
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnQuit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addComponent(btnSettings, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addComponent(btnNewGame, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addComponent(btnResumeGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(89))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(57)
					.addComponent(btnResumeGame)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewGame)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSettings)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnQuit)
					.addContainerGap(170, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	private void createEvents()
	{
		// called when the resume game button is pressed
		btnResumeGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		
		// called when the quit button is pressed
		btnQuit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
	
	// used in the Main class; will be used to get access to the card layout to change the Jpanel
	// TODO maybe use another JDialog for settings
	public JButton getbtnNewGame()
	{
		return btnNewGame;
	}
}

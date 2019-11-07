/**
 * This class is where the game grid is going to display, the pieces, and other buttons for the player to interact with.
 * @author Nelson Hernandez
 * 
 */

package Blockus.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Game extends JPanel {

	GameBoard board;
	private JButton btnPause;
	private JButton btnRotateLeft;
	private JButton btnRotateRight;
	private JButton btnFlipLeft;
	private JButton btnFlipRight;
	private PlayerPieces playerPieces;


	/**
	 * Create the panel.
	 */
	public Game()
	{
		setToolTipText("Rotate Left");
		initComponents();
		createEvents();
		
	}

	private void initComponents()
	{
		board = new GameBoard();
		board.setSize(500, 500);
	
		setSize(1107,892);
		
		// creates a new button to pause the game
		btnPause = new JButton("Pause");
		btnPause.setBackground(Color.WHITE);
		btnPause.setForeground(Color.BLACK);
		btnPause.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		
		JPanel panel = new JPanel();
		
		playerPieces = new PlayerPieces();
		


		
		// sets the layout of the game pane
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(btnPause)
							.addGap(212)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(232)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(playerPieces, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE))
								.addComponent(board, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(246, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addComponent(board, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playerPieces, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPause)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		
		JLabel lblRotateOrFlip = new JLabel("Rotate or Flip");
		lblRotateOrFlip.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRotateOrFlip.setHorizontalAlignment(SwingConstants.CENTER);
		lblRotateOrFlip.setFont(new Font("Gill Sans MT", Font.PLAIN, 36));
		
		
		// creates a button to rotate a piece to the left by 90 degrees
		btnRotateLeft = new JButton("");
		btnRotateLeft.setToolTipText("Rotate Left");
		btnRotateLeft.setIcon(new ImageIcon(Game.class.getResource("/Blockus/resources/rotateleft.png")));
		btnRotateLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				board.rotatePieceCLockwise();
				
			}
		});
		
		// creates a button to rotate a piece to the right by 90 degrees
		btnRotateRight = new JButton("");
		btnRotateRight.setToolTipText("Rotate Right");
		btnRotateRight.setIcon(new ImageIcon(Game.class.getResource("/Blockus/resources/rotateright.png")));
		
		// flips a piece to the right by 180 degrees
		btnFlipRight = new JButton("");
		btnFlipRight.setToolTipText("Flip Right");
		btnFlipRight.setIcon(new ImageIcon(Game.class.getResource("/Blockus/resources/arrowright.png")));
		
		// flips a piece to the left 180 degrees
		btnFlipLeft = new JButton("");
		btnFlipLeft.setToolTipText("Flip Left");
		btnFlipLeft.setIcon(new ImageIcon(Game.class.getResource("/Blockus/resources/arrowleft.png")));
		
		// sets layout
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addComponent(lblRotateOrFlip)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRotateLeft)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRotateRight)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFlipLeft)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFlipRight)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnFlipRight)
								.addComponent(btnFlipLeft)
								.addComponent(btnRotateRight)
								.addComponent(btnRotateLeft)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRotateOrFlip)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		

	}
	
	private void createEvents()
	{
		placePiece();
	}
	
	// returns the pause button; used in the main class to access the pause button
	// it's like this because when the new game feature is implemented, access to the cardlayout will be needed
	public JButton getbtnPause()
	{
		return btnPause;
	}
	
	
	// opens a pause dialog and pauses the game
	public void openPauseDialog()
	{
		PauseDialog d = new PauseDialog();
		d.setLocationRelativeTo(null);
		d.setModal(true);
		d.setVisible(true);
	}
	
	public boolean isCurrentPieceEmpty()
	{
		if(playerPieces.getCurrentPiece() == null)
			return true;
		else
			return false;
	}
	
	public void placePiece()
	{
		board.setPiece(playerPieces.getCurrentPiece(), playerPieces.getCurrentPieceIndex());
	}
}

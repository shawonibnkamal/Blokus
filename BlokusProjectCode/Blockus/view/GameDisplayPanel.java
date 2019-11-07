/**
 * This class allows the user to choose the settings for the game of blockus
 * 
 * @author Nelson Hernandez
 * COMP2005 Blockus Project
 * Version 1.0
 * 

 */
package Blockus.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameDisplayPanel extends JPanel {
	
	// radio button group to choose difficulty
	private ButtonGroup difficultyButtons;
	
	// togglebutton to turn colorblind mode on and off
	private JToggleButton tglbtnColorBlindMode;
	
	// radio buttons to choose difficulty
	private JRadioButton rdbtnEasy;
	private JRadioButton rdbtnMedium;
	private JRadioButton rdbtnHard;
	private JButton btnStart;

	private boolean isReady;
	public GameDisplayPanel() {
		
		initComponents();
		createEvents();
	}

	private void initComponents()
	{

		// initiates difficulty buttons group
		difficultyButtons = new ButtonGroup();
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setFont(new Font("Gill Sans MT", Font.PLAIN, 30));
		
		// radio buttons for difficulty
		
		rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		rdbtnEasy.setSelected(true);
		
		rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		
		rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		
		
		// adds radio buttons to difficultybuttons group
		difficultyButtons.add(rdbtnEasy);
		difficultyButtons.add(rdbtnMedium);
		difficultyButtons.add(rdbtnHard);
		
		
		JLabel lblNumberOfPlayers = new JLabel("Number of players");
		lblNumberOfPlayers.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		
		// JComboBox to select number of players
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 Player\t", "2 Players", "3 Players", "4 Players"}));
		
		
		// initiates colorblind button
		tglbtnColorBlindMode = new JToggleButton("Color Blind Mode Off");
		tglbtnColorBlindMode.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		
		// button to start game
		btnStart = new JButton("Start");
		
		btnStart.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStart)
						.addComponent(tglbtnColorBlindMode)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnEasy)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnMedium)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnHard))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNumberOfPlayers)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDifficulty))
					.addContainerGap(480, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblDifficulty)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnEasy)
						.addComponent(rdbtnMedium)
						.addComponent(rdbtnHard))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfPlayers)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(tglbtnColorBlindMode)
					.addPreferredGap(ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
					.addComponent(btnStart)
					.addGap(35))
		);
		setLayout(groupLayout);
	}
	
	private void createEvents()
	{
		// changes the color blind toggle button when it's pressed
		tglbtnColorBlindMode.addActionListener(e -> 
		{
			if(tglbtnColorBlindMode.isSelected())
				tglbtnColorBlindMode.setText("Color Blind Mode On");
			else
				tglbtnColorBlindMode.setText("Color Blind Mode Off");
		});
		
		
	}
	
	public JButton getbtnStart()
	{
		return btnStart;
	}
}

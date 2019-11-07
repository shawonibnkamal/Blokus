/**
 * This class creates a dialog to display the rules of the game of blockus
 * 
 * @author Nelson Hernandez
 * COMP2005 Blockus Project
 * Version 1.0
 */
package Blockus.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;

public class RulesDialog extends JDialog {
	
	

	private JButton btnNext;
	private int count = 1;
	private JLabel lblRules;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RulesDialog dialog = new RulesDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RulesDialog() {
		setBounds(100, 100, 751, 600);
		
		
		// creates new scroll panel to display images
		JScrollPane scrollPane = new JScrollPane();
		
		// sets the scroll speed of the scroll bar
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		
		// button to click on next page of instruction
		btnNext = new JButton("Next");
		
		lblRules = new JLabel("Rules 1/1" );
		
		// code that sets up layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 734, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRules)
					.addPreferredGap(ComponentPlacement.RELATED, 596, Short.MAX_VALUE)
					.addComponent(btnNext)
					.addGap(35))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNext)
						.addComponent(lblRules))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(RulesDialog.class.getResource("/Blockus/resources/r1.png")));
		scrollPane.setViewportView(lblNewLabel);
		getContentPane().setLayout(groupLayout);
		
		// when the next button is pressed, changes the picture to the next one
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				
				if(count == 1)
				{
					lblNewLabel.setIcon(new ImageIcon(RulesDialog.class.getResource("/Blockus/resources/r1.png")));
					lblRules.setText("Rules " + count + "/4");
					
				}
				else if(count == 2)
				{
					lblNewLabel.setIcon(new ImageIcon(RulesDialog.class.getResource("/Blockus/resources/r2.png")));
					lblRules.setText("Rules " + count + "/4");
				}
				else if(count == 3)
				{
					lblNewLabel.setIcon(new ImageIcon(RulesDialog.class.getResource("/Blockus/resources/r3.png")));
					lblRules.setText("Rules " + count + "/4");
				}
				else if(count == 4)
				{
					lblNewLabel.setIcon(new ImageIcon(RulesDialog.class.getResource("/Blockus/resources/r4.png")));
					lblRules.setText("Rules " + count + "/4");
					count = 0;
				}
				
			}
		});
		
	}
}

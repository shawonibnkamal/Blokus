
/**
 * This class displays the startup page
 * 
 * @author Nelson Hernandez
 * COMP2005 Blockus Project
 * Version 1.0
 * 
 * 
 */
package Blockus.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartPanel extends JPanel {
	

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		

		initComponents();
		createEvents();
	}
	
	public void initComponents()
	{
		setLayout(new BorderLayout(0, 0));
		
		// label showing blockus image		
		JLabel lblBlockusImage = new JLabel("");
		lblBlockusImage.setBackground(new Color(238, 232, 170));
		lblBlockusImage.setForeground(new Color(135, 206, 235));
		lblBlockusImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlockusImage.setIcon(new ImageIcon(StartPanel.class.getResource("/Blockus/resources/blockusGame.jpg")));
		add(lblBlockusImage, BorderLayout.CENTER);
		lblBlockusImage.setOpaque(true);
		
		// label showing blockus text
		JLabel lblBlockusTitle = new JLabel("Blockus Prototype");
		lblBlockusTitle.setBackground(new Color(255, 222, 173));
		
		lblBlockusTitle.setFont(new Font("Gill Sans MT Condensed", Font.PLAIN, 70));
		lblBlockusTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBlockusTitle, BorderLayout.NORTH);
		lblBlockusTitle.setOpaque(true);
		
		// label showing intro text instructions
		JLabel lblIntroText = new JLabel("Click anywhere in the window to start");
		lblIntroText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntroText.setBackground(new Color(238, 232, 170));
		lblIntroText.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblIntroText, BorderLayout.SOUTH);
		lblIntroText.setOpaque(true);
	}


	public void createEvents() 
	{
		
	}
}

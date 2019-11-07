/**
 * This class creates the menu bar for the game window, and it gives the user options to open a saved game, close the game, reset the game, a help menu containing rules and an about us page
 *
 *@author Nelson Hernandez
 * COMP2005 Blockus Project
 * Version 1.0
 */
package Blockus.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{

	public MenuBar()
	{
	
	// creates a new menu for file
	JMenu mnFileMenu = new JMenu("File");
	add(mnFileMenu);
	// creates menu items for the file menu
	JMenuItem mntmOpenSavedGame = new JMenuItem("Open saved game");
	mnFileMenu.add(mntmOpenSavedGame);
	
	JMenuItem mntmSaveGame = new JMenuItem("Save game");
	mnFileMenu.add(mntmSaveGame);
	
	JMenuItem mntmResetGame = new JMenuItem("Reset Game");
	mnFileMenu.add(mntmResetGame);
	
	// creates new menu for help
	JMenu mnHelpMenu = new JMenu("Help");
	add(mnHelpMenu);
	
	// creates new menu item for rules in help
	JMenuItem mntmRules = new JMenuItem("Rules");
	// adds an action listener to rules menu and opens jdialog with a rules window
	mntmRules.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			RulesDialog d = new RulesDialog();
			d.setLocationRelativeTo(null);
			d.setModal(true);
			d.setVisible(true);
		}
	});
	
	mnHelpMenu.add(mntmRules);
	
	
	// creates a new menu item for about in help
	JMenuItem mntmAbout = new JMenuItem("About");
	
	// opens a new about dialog
	mntmAbout.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AboutDialog d = new AboutDialog();
			d.setLocationRelativeTo(null);
			d.setModal(true);
			d.setVisible(true);
		}
	});
	mnHelpMenu.add(mntmAbout);

	}
	
	
}

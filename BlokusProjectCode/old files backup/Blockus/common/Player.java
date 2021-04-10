/**
 * This class will represent a player. Each player should have a number and the color that they will be playing with
 * @author Nelson Hernandez
 */

package Blockus.common;

public class Player {
	// player's number, going to be used to determine their turn
	private int playerNumber;
	
	// player's color will be the color they choose to play with
	private int playerColor;
	
	public Player()
	{
		
	}

	// getters and setters for class fields
	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public int getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(int playerColor) {
		this.playerColor = playerColor;
	}
	
	
}

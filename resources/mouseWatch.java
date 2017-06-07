package resources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseWatch implements MouseListener, ActionListener {
	
	private boolean clickWatchEnabled;
	private boolean buttonWatchEnabled;
	private static int elementIDReference = 0;
	private int elementID;
	
	public mouseWatch() {
		buttonWatchEnabled = true;
		clickWatchEnabled = true;
		elementID = elementIDReference + 1;
		elementIDReference++;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(clickWatchEnabled) {
			MainWindow.game.clickAt(e.getX(), e.getY());
			MainWindow.drawState();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void disableClicks() {
		clickWatchEnabled = false;
	}
	
	public void enableClicks() {
		clickWatchEnabled = true;
	}
	
	public void disableButtons() {
		buttonWatchEnabled = false;
	}
	
	public void enableButtons() {
		buttonWatchEnabled = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(buttonWatchEnabled) {
			MainWindow.game.buttonPressed(elementID);
		}
	}
	
	//for testing purposes, this is a bad method, will need refractoring
	public void setNewElementID(int ID) {
		elementID = ID;
	}
}
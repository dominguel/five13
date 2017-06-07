package resources;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Grid extends JPanel {

	private int w;
	private int l;

	//fuck off eclipse
	private static final long serialVersionUID = 4902128140090362398L;

	public Grid(int length, int width) {
		super();
		setBackground (Color.WHITE);
		setVisible(true);
		this.w = width;
		this.l = length;
		this.setSize(width, length);
		mouseWatch looker = new mouseWatch();
		looker.disableButtons();
		this.addMouseListener(looker);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		//always remember to set the color before you draw anything!
		
		//drawing grid
		g.setColor(Color.BLACK);
		for(int i = 1; i < 13; i++) {
			g.drawLine(0, this.l*i/13, this.w, this.l*i/13);
			g.drawLine(this.w*i/13, 0, this.w*i/13, this.l);
		}
		
		//drawing colors
		int[][] board = MainWindow.game.getBoard();
		for(int i = 0; i < 13; i++) {
			for(int j = 0; j < 13; j++) {
				
				if(board[i][j] == Game.PLAYER_1) {
					g.setColor(Color.CYAN);
					g.fillRect(this.w*j/13, this.l*i/13, this.w/13, this.l/13);
				} else if(board[i][j] == Game.PLAYER_2) {
					g.setColor(Color.MAGENTA);
					g.fillRect(this.w*j/13, this.l*i/13, this.w/13, this.l/13);
				}
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(w, l);
	}

	public int getL() {
		return l;
	}

	public int getW() {
		return w;
	}
}
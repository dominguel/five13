package resources;

import javax.swing.JFrame;

import games.*;

public class MainWindow {

	public static JFrame f;
	public static Grid p;
	public static Game game;

	public static void main(String[] args) {
		
		//init
		game = new TestConway();
		f = new JFrame(game.getName());

		//utile
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setResizable(false);

		//make p
		p = new Grid(520, 520);
		f.add(p);
		f.pack();

		//show
		f.setVisible(true);
		drawState();
	}

	public static void drawState() {
		p.repaint();
	}
}
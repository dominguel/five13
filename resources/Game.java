package resources;

public class Game {
	
	public static final int EMPTY = 0;
	public static final int PLAYER_1 = 1;
	public static final int PLAYER_2 = 2;
	public final String name;
	
	//true = p1; false = p2;
	protected boolean currentPlayer;
	protected int[][] board;
	
	public Game(String name) {
		board = new int[13][13];
		currentPlayer = true;
		this.name = name;
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public void turnEnd() {
		currentPlayer = !currentPlayer;
	}
	
	public String getName() {
		return name;
	}
	
	public void clickAt(int x, int y) {
		
		//conversion
		x = (int) (x*13/MainWindow.p.getL());
		y = (int) (y*13/MainWindow.p.getW());
		
		//outsource actions
		//flipped x and y because of i j compatibility
		actionPerformed(y, x); 
	}
	
	
	//used only as stand-in, must be overriden by child methods
	public void actionPerformed(int i, int j) {
	}
	
	//used only as stand-in, must be overriden by child methods
	public void buttonPressed(int buttonID) {
	}
}
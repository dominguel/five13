package games;

import resources.Game;

public class UT3 extends Game {

	public UT3() {
		super("Ultimate Tic-Tac-Toe");
	}
	
	@Override
	public void actionPerformed(int i, int j) {
		
		if(board[i][j] == Game.EMPTY) {
			if(currentPlayer) {
				board[i][j] = Game.PLAYER_1;
			} else {
				board[i][j] = Game.PLAYER_2;
			}
			currentPlayer = !currentPlayer;
		}
	}
}
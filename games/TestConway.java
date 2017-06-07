package games;

import javax.swing.JButton;

import resources.ControlWindow;
import resources.Game;
import resources.MainWindow;
import resources.mouseWatch;

public class TestConway extends Game {

	public TestConway() {
		super("TestConway");
		ControlWindow framedButton = new ControlWindow();

		JButton updateSignal = new JButton("Next generation.");
		mouseWatch btHandle1 = new mouseWatch();
		btHandle1.disableClicks();
		btHandle1.setNewElementID(16);
		updateSignal.addActionListener(btHandle1);

		framedButton.add(updateSignal);

		JButton constUpdate = new JButton("Do 20.");
		mouseWatch btHandle2 = new mouseWatch();
		btHandle2.disableClicks();
		btHandle2.setNewElementID(17);
		constUpdate.addActionListener(btHandle2);

		framedButton.add(constUpdate);
	}

	@Override
	public void actionPerformed(int i, int j) {

		if(board[i][j] == Game.EMPTY) {
			board[i][j] = Game.PLAYER_1;
		} else {
			board[i][j] = Game.EMPTY;
		}
	}

	@Override
	public void buttonPressed(int buttonID) {

		//next generation clicked
		if(buttonID == 16) {
			this.updateBoard();
			MainWindow.drawState();
		}

		//Do 20 clicked
		if(buttonID == 17) {

			for(int i = 0; i < 20; i++) {
				this.updateBoard();
				MainWindow.p.paintImmediately(0, 0, MainWindow.p.getW(), MainWindow.p.getL());
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void updateBoard() {

		int[][] newBoard = new int[13][13];
		int neighbours;

		//consider rules
		for(int i = 0; i < 13; i ++) {
			for(int j = 0; j < 13; j++) {

				neighbours = 0;
				//check for live neighbours

				for(int k = -1; k < 2; k++) {

					try {
						if(board[i-1][j+k] == Game.PLAYER_1) {
							neighbours++;
						}
					} catch(Exception e) {
					}

					try {
						if(board[i+1][j+k] == Game.PLAYER_1) {
							neighbours++;
						}
					} catch(Exception e) {
					}
				}

				try {
					if(board[i][j-1] == Game.PLAYER_1) {
						neighbours++;
					}
				} catch(Exception e) {
				}

				try {
					if(board[i][j+1] == Game.PLAYER_1) {
						neighbours++;
					}
				} catch(Exception e) {
				}

				//game of life rules
				if(neighbours < 2 || neighbours > 3) {
					//cell is dead on next board
					newBoard[i][j] = Game.EMPTY;
				} else if(neighbours == 2) {
					//nothing changes on next board
					newBoard[i][j] = board[i][j];
				} else if(neighbours == 3) {
					//cell is live on next board
					newBoard[i][j] = Game.PLAYER_1;
				}
			}
		}

		//transfer values
		for(int i = 0; i < 13; i ++) {
			for(int j = 0; j < 13; j++) {
				board[i][j] = newBoard[i][j];
			}
		}
	}
}
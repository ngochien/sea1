package a01;

public class Game {
	public static int NO_MOVE = -1;

	private StringBuffer board;

	public Game(String s) {
		board = new StringBuffer(s);
	}

	public Game(StringBuffer s, int position, char player) {
		board = new StringBuffer();
		board.append(s);
		board.setCharAt(position, player);
	}

	public int move(char player) {
		int defaultMove = NO_MOVE;

		for (int move = 0; move < 9; move++) {
			if (isFieldAvailable(move)) {
				defaultMove = move;
				Game game = play(move, player);
				if (game.winner() == player) {
					defaultMove = move;
					break;
				}
			}
		}
		return defaultMove;
	}

	public Game play(int move, char player) {
		return new Game(this.board, move, player);
	}

	public char winner() {
		for (int field = 0; field < 7; field += 3) {
			if (!isFieldAvailable(field)
					&& board.charAt(field) == board.charAt(field + 1)
					&& board.charAt(field + 1) == board.charAt(field + 2)) {
				return board.charAt(field);
			}
		}
		return '-';
	}

	private boolean isFieldAvailable(int field) {
		return board.charAt(field) == '-';
	}
}

package a01;

public class Game {
	public StringBuffer board;

	public Game(String s) {board = new StringBuffer(s);}

	public Game(StringBuffer s, int position, char player) {
		board = new StringBuffer();
		board.append(s);
		board.setCharAt(position, player);
	}

	public int move(char player) {
		for (int move = 0; move < 9; move++) {
			if (board.charAt(move) == '-') {
				Game game = play(move, player);
				if (game.winner() == player) 
					return move;
			}
		}

		for (int move = 0; move < 9; move++) {
			if (board.charAt(move) == '-') 
				return move;
		}	
		return -1;
	}

	public Game play(int move, char player) {
		return new Game(this.board, move, player);
	}

	public char winner() {
		if (board.charAt(0) != '-' 
            && board.charAt(0) == board.charAt(1) 
            && board.charAt(1) == board.charAt(2))
			return board.charAt(0);
		if (board.charAt(3) != '-' 
            && board.charAt(3) == board.charAt(4) 
            && board.charAt(4) == board.charAt(5))
			return board.charAt(3);
		if (board.charAt(6) != '-' 
            && board.charAt(6) == board.charAt(7) 
            && board.charAt(7) == board.charAt(8))
			return board.charAt(6);
		return '-';
	}
}

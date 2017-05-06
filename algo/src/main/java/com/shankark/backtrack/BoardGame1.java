package com.shankark.backtrack;

import java.util.ArrayList;
import java.util.List;

public class BoardGame1 {

	public List<Move> solve(int coinsPerColor) {
		List<Move> solution = new ArrayList<Move>();
		char[] board = buildBoard(coinsPerColor);
		solve(board.length, coinsPerColor, board, solution, -1);
		return solution;
	}

	private boolean isSolved(int n, int coinsPerColor, char[] board) {
		boolean solved = true;
		for (int i = 0; i < coinsPerColor; i++) {
			solved = (solved && board[i] == 'W');
		}
		for (int i = (n - 1); i > coinsPerColor; i--) {
			solved = (solved && board[i] == 'B');
		}
		return solved;
	}

	private char[] buildBoard(int coinsPerColor) {
		int n = (coinsPerColor * 2) + 1;
		char[] board = new char[n];
		board[coinsPerColor] = '0'; // empty position
		for (int i = 0; i < coinsPerColor; i++) {
			board[i] = 'B';
		}
		for (int i = (n - 1); i > coinsPerColor; i--) {
			board[i] = 'W';
		}
		return board;
	}

	public boolean solve(int n, int coinsPerColor, char[] board, List<Move> solution, int k) {
		if (isSolved(n, coinsPerColor, board)) {
			return true;
		} else {
			k++;
			List<Move> nextAvailableMoves = new ArrayList<Move>();
			for (int i = 0; i < n; i++) {
				if (board[i] == 'B') {
					if (i == (n - 1)) {
						// if in the last position
						continue;
					} else if (board[i + 1] == '0') {
						// if next position is empty or
						nextAvailableMoves.add(new Move(board[i], i, i + 1));
					} else if ((((i + 2) < n) && (board[i + 1] == 'W') && (board[i + 2]) == '0')) {
						// if next position contains opposite coin and next to
						// that is empty
						nextAvailableMoves.add(new Move(board[i], i, i + 2));
					}
				} else if (board[i] == 'W') {
					if (i == 0) {
						// if in the first position
						continue;
					} else if (board[i - 1] == '0') {
						// if previous position is empty or
						nextAvailableMoves.add(new Move(board[i], i, i - 1));
					} else if ((((i - 2) >= 0) && (board[i - 1] == 'B') && (board[i - 2]) == '0')) {
						// if previous position contains opposite coin and next
						// to that is empty
						nextAvailableMoves.add(new Move(board[i], i, i - 2));
					}
				}
			}

			for (int i = 0; i < nextAvailableMoves.size(); i++) {
				Move m = nextAvailableMoves.get(i);
				// make move
				char coin = board[m.from];
				board[m.from] = '0';
				board[m.to] = coin;
				solution.add(k, m);
				if (solve(n, coinsPerColor, board, solution, k)) {
					return true;
				} else {
					// revert move
					board[m.from] = coin;
					board[m.to] = '0';
					solution.remove(k);
				}
			}
			return false;
		}
	}

	private static class Move {
		char color;
		int from;
		int to;

		Move(char color, int from, int to) {
			this.color = color;
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Move " + color + ":" + from + "->" + to;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + color;
			result = prime * result + from;
			result = prime * result + to;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Move other = (Move) obj;
			if (color != other.color)
				return false;
			if (from != other.from)
				return false;
			if (to != other.to)
				return false;
			return true;
		}

	}

	public void printBoard(char[] board, List<Move> moves) {
		for (Move m : moves) {
			char coin = board[m.from];
			board[m.from] = '0';
			board[m.to] = coin;
			for (int i = 0; i < board.length; i++) {
				System.out.print(board[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BoardGame1 bGame = new BoardGame1();
		List<Move> solution = bGame.solve(3);
		if (solution == null || solution.size() == 0) {
			System.out.println("Not solveable");
		} else {
			System.out.println("Solved");
			char[] board = bGame.buildBoard(3);
			bGame.printBoard(board, solution);
		}
	}
}

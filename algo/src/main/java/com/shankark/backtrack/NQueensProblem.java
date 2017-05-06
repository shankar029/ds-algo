package com.shankark.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * N Queens problem.
 * 
 * @author shankarkumar
 *
 */
public class NQueensProblem {

	public static class Position {
		int row;
		int column;

		Position(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	private Position[] solve(int n) {
		Position[] positions = new Position[n];
		if (solve(n, positions, -1)) {
			return positions;
		}
		return null;
	}

	private boolean solve(int n, Position[] positions, int row) {
		if (row == (n - 1)) {
			return true; 
		}
		row++;
		List<Position> nextAvailablePositions = new ArrayList<Position>();
		// for each column of {row}
		for (int col = 0; col < n; col++) {
			// Check if previous queens cut this position
			boolean cut = false;
			for (int j = 0; j < row; j++) {
				Position p = positions[j];
				if ((p.column == col) || ((p.row + p.column) == (row + col))
						|| ((p.row - p.column) == (row - col))) {
					// if in same column or adjacent columns
					cut = true;
					break;
				}
			}
			if (!cut) {
				nextAvailablePositions.add(new Position(row, col));
			}
		}

		if (nextAvailablePositions.size() > 0) {
			for (int i = 0; i < nextAvailablePositions.size(); i++) {
				positions[row] = nextAvailablePositions.get(i);
				if (solve(n, positions, row)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		NQueensProblem nQueens = new NQueensProblem();
		Position[] positions = nQueens.solve(4);
		if (positions != null) {
			for (Position p : positions) {
				System.out.println("[" + p.row + "," + p.column + "]");
			}
		} else {
			System.out.println("Solution not found");
		}
	}
}

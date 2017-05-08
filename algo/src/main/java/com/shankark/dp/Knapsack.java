package com.shankark.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 0-1 Knapsack problem.
 * 
 * @author shankarkumar
 *
 */
public class Knapsack {

	private int[] weights;
	private int[] values;
	private int knapsackWeight;
	private int[][] table;

	public Knapsack(int[] weights, int[] values, int knapsackWeight) {
		this.weights = weights;
		this.values = values;
		this.knapsackWeight = knapsackWeight;
		this.table = new int[weights.length][knapsackWeight + 1];
	}

	public int knapsack() {
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j <= knapsackWeight; j++) {
				if (j == 0) {
					table[i][j] = 0;
				} else if (weights[i] > j) {
					// if nth item weight is greater the knapsack weight then
					// value is maximum value obtained by n-1 items for the
					// knapsack weight
					table[i][j] = table[i - 1][j];
				} else {
					if (i == 0) {
						table[i][j] = values[i];
					} else {
						// if the nth item weight is less then knapsack weight
						// then the maximum of value of: (nth item plus maximum
						// value obtained by n-1 items for knapsack weight minus
						// weight of nth item) or maximum value obtained by n-1
						// items for the knapsack value)
						table[i][j] = max((values[i] + table[i - 1][j - weights[i]]), table[i - 1][j]);
					}

				}
			}
		}
		return table[weights.length - 1][knapsackWeight];
	}

	public List<Integer> items() {
		List<Integer> items = new ArrayList<Integer>();
		int i = weights.length - 1;
		int j = knapsackWeight;
		while (j > 0) {
			// if the nth value is not equal to n-1th value for the knapsack
			// weight then pick the item and reduced the knapsack weight
			if (table[i][j] != table[i - 1][j]) {
				items.add(weights[i]);
				j = j - weights[i];
			}
			i = i - 1;
		}
		return items;
	}

	int max(int i, int j) {
		if (i > j) {
			return i;
		} else {
			return j;
		}
	}

	public static void main(String[] args) {
		Knapsack ks = new Knapsack(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 7);
		System.out.println("Maximum value of knapsack = " + ks.knapsack());
		System.out.println("Weights: " + ks.items());
	}
}

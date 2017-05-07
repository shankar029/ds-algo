package com.shankark.dp;

/**
 * Finds longest increasing subsequence numbers in an array
 * 
 * @author shankarkumar
 *
 */
public class LongestIncreasingSubSequence {

	public int[] find(int[] input) {
		int[] table = new int[input.length]; // array to hold max count of each element
		int[] previous = new int[input.length]; // array to hold previous elements of longest subsequence 
		for (int i = 0; i < table.length; i++) {
			table[i] = 1;
		}
		// calculate the increasing subsequence count for each of the element by
		// comparing with the all the previous elements count
		for (int i = 1; i < table.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((input[j] < input[i]) && (table[i] < table[j] + 1)) {
					table[i] = table[j] + 1;
					previous[i] = j;
				}
			}
		}
		// find the max increasing subsequence count and index
		int max = table[0];
		int maxIndex = 0;
		for (int i = 1; i < table.length; i++) {
			if (table[i] > max) {
				max = table[i];
				maxIndex = i;
			}
		}
		// traverse previous array backwards from max index.
		int[] solution = new int[max];
		int index = maxIndex;
		for (int i = (max - 1); i >= 0; i--) {
			solution[i] = input[index];
			index = previous[index];
		}
		return solution;
	}

	public static void main(String[] args) {
		LongestIncreasingSubSequence lis = new LongestIncreasingSubSequence();
		int[] solution = lis.find(new int[] { 10, 22, 9, 33, 21, 50, 41, 60 });
		for (int i : solution)
			System.out.print(i + " ");
	}
}

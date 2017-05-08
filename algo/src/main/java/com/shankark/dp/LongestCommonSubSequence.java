package com.shankark.dp;

/**
 * Longest common subsequence problem.
 * 
 * @author shankarkumar
 *
 */
public class LongestCommonSubSequence {

	public int find(char[] input1, char[] input2) {
		int[][] table = new int[input2.length][input1.length];
		for (int i = 0; i < input2.length; i++) {
			for (int j = 0; j < input1.length; j++) {
				table[i][j] = 0;
			}
		}
		for (int i = 0; i < input2.length; i++) {
			for (int j = 0; j < input1.length; j++) {
				if (input2[i] == input1[j]) {
					if (i == 0 || j == 0) {
						table[i][j] = 1;
					} else {
						table[i][j] = table[i - 1][j - 1] + 1;
					}
				} else {
					if (i == 0 || j == 0) {
						table[i][j] = 0;
					} else {
						table[i][j] = table[i - 1][j];
					}
				}
			}
		}

		for (int i = 0; i < input2.length; i++) {
			for (int j = 0; j < input1.length; j++) {

			}
		}
		return table[input2.length - 1][input1.length - 1];
	}

	public static void main(String[] args) {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		System.out.println(lcs.find("AGGTAB".toCharArray(), "GXTXAYB".toCharArray()));
	}
}

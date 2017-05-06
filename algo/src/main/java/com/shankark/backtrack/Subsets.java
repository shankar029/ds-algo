package com.shankark.backtrack;

/**
 * Prints all the subsets of input elements including null set.
 * 
 * @author shankarkumar
 *
 */
public class Subsets {

	public void printSubsets(String[] input) {
		printSubsets(input, -1, new boolean[input.length]);
	}

	private void printSubsets(String[] input, int k, boolean[] temp) {
		if (k == (input.length - 1)) { 
			StringBuilder buffer = new StringBuilder("{");
			for (int i = 0; i < input.length; i++) {
				if (temp[i]) {
					buffer.append(input[i]);
				}
			}
			buffer.append("}");
			System.out.println(buffer.toString());
		} else {
			k = k + 1;
			boolean[] statuses = new boolean[2];
			statuses[0] = true;
			statuses[1] = false;
			for (int i = 0; i < statuses.length; i++) {
				temp[k] = statuses[i];
				printSubsets(input, k, temp);
			}
		}
	}

	public static void main(String[] args) {
		String[] input = new String[] { "1", "2", "3" };
		Subsets subsets = new Subsets();
		subsets.printSubsets(input);
	}
}

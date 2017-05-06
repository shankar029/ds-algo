package com.shankark.backtrack;

/**
 * Prints all the permutations of the string.
 * 
 * @author shankarkumar
 *
 */
public class StringPermutation {

	public void printPermutation(String input) {
		printPermutation(input.toCharArray(), new char[input.length()], -1);
	}

	private void printPermutation(char[] input, char[] solution, int k) {
		if (k == (input.length - 1)) {
			System.out.println(new String(solution));
		} else {
			k = k + 1;
			int n = 0;
			char[] nextChars = new char[(input.length - k)];
			for (int i = 0; i < input.length; i++) {
				boolean present = false;
				for (int j = 0; j < k; j++) {
					if (input[i] == solution[j]) {
						present = true;
						break;
					}
				}
				if (!present)
					nextChars[n++] = input[i];
			}

			for (int i = 0; i < nextChars.length; i++) {
				solution[k] = nextChars[i];
				printPermutation(input, solution, k);
			}
		}
	}

	public static void main(String[] args) {
		StringPermutation perm = new StringPermutation();
		perm.printPermutation("ABC");
	}
}

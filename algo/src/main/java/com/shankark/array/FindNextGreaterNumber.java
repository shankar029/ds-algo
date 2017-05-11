package com.shankark.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Finds the next greater element right to each of the elements in array. If the
 * next greater element is not found for an element then -1 will be set.
 * 
 * @author shankarkumar
 *
 */
public class FindNextGreaterNumber {

	public Map<Integer, Integer> findNextGreaterNumber(int[] input) {
		Map<Integer, Integer> output = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(input[0]);
		for (int i = 1; i < input.length; i++) {
			while (!stack.isEmpty()) {
				int t = stack.peek();
				if (input[i] > t) {
					// if i'th element is greater then top element then i'th
					// element is the next greater element
					output.put(stack.pop(), input[i]);
				} else {
					// if i'th element is not greater then top element then it
					// will not be greater than any other element in the stack
					break;
				}
			}
			stack.push(input[i]);
		}

		while (!stack.isEmpty()) {
			output.put(stack.pop(), -1);
		}
		return output;
	}

	public static void main(String[] args) {
		FindNextGreaterNumber greaterNumber = new FindNextGreaterNumber();
		System.out.println(greaterNumber.findNextGreaterNumber(new int[] { 13, 4, 2, 5, 10 }));
	}

}

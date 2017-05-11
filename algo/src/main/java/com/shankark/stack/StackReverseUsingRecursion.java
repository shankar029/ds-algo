package com.shankark.stack;

import java.util.Stack;

/**
 * Reverses a stack using recursion without using any loops.
 * 
 * @author shankarkumar
 *
 * @param <K>
 */
public class StackReverseUsingRecursion<K> {

	public void reverse(Stack<K> stack) {
		reverse(stack, stack.pop());
	}

	private void reverse(Stack<K> stack, K item) {
		if (!stack.isEmpty()) {
			reverse(stack, stack.pop());
		}
		// insert the item at top bottom of the stack
		insertAtBottom(stack, item);
	}

	private void insertAtBottom(Stack<K> stack, K item) {
		K temp = null;
		if (stack.isEmpty()) {
			stack.push(item);
		} else {
			temp = stack.pop();
			insertAtBottom(stack, item);
			stack.push(temp);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> intStack = new Stack<Integer>();
		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(4);
		StackReverseUsingRecursion<Integer> reverseStack = new StackReverseUsingRecursion<Integer>();
		System.out.println("Before reversal: " + intStack);
		reverseStack.reverse(intStack);
		System.out.println("After reversal: " + intStack);
	}
}

package com.shankark.ds.impl;

import com.shankark.ds.Queue;

public class ArrayBasedQueueTest extends BaseQueueTest {

	@Override
	protected Queue createQueue() {
		return new ArrayBasedQueue();
	}

	@Override
	protected Queue createQueue(int size) {
		return new ArrayBasedQueue(size);
	}
}

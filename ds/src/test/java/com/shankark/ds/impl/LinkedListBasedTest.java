package com.shankark.ds.impl;

import com.shankark.ds.Queue;

public class LinkedListBasedTest extends BaseQueueTest {

	@Override
	protected Queue createQueue() {
		return new LinkedListBasedQueue();
	}

	@Override
	protected Queue createQueue(int size) {
		return new LinkedListBasedQueue(size);
	}

}

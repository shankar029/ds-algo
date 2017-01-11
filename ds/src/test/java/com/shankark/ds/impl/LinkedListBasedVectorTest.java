package com.shankark.ds.impl;

import com.shankark.ds.Vector;

public class LinkedListBasedVectorTest extends BaseVectorTest {

	@Override
	protected Vector createVector() {
		return new LinkedListBasedVector();
	}

}

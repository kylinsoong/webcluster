package com.kylin.web.failover;

import java.util.HashMap;
import java.util.Map;

public class CustomHashMap<K, V> extends HashMap<K, V> {

	private static final long serialVersionUID = -5443370279591737974L;

	public CustomHashMap() {
	}

	public CustomHashMap(int initialCapacity) {
		super(initialCapacity);
	}

	public CustomHashMap(Map<K, V> m) {
		super(m);
	}

	public CustomHashMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}
}

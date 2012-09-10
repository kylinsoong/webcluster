package com.kylin.webcluster.log;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {

	private static AtomicLong counter = new AtomicLong(1);
	
    public static long getCount() {
    	return counter.getAndIncrement();
    }
}

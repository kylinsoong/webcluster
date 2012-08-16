package com.kylin.webcluster.log;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {

	static AtomicLong counter = new AtomicLong(1);
	
    public static long getCount() {
    	return counter.getAndIncrement();
    }
}

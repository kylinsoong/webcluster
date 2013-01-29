package com.kylin.web.failover;

import java.util.ArrayList;

public class Buffer {

	static ArrayList list = new ArrayList();
	
	public static int size() {
		return list.size();
	}
	
	public static void add (Object obj){
		list.add(obj);
	}
	
	public static void remove() {
		if(list.size() > 0) {
			list.remove(0);
		}
	}
	
	public static void clear() {
		list.clear();
	}
}

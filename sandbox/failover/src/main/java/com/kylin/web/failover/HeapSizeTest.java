package com.kylin.web.failover;

import java.util.ArrayList;
import java.util.Map;

public class HeapSizeTest {
	

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		System.out.println("Current Heap Size: " + Runtime.getRuntime().totalMemory() + ", Max Heap Size: " + Runtime.getRuntime().maxMemory());
	
		Map map = new CustomHashMap();
		for (int i = 0; i < 50; i++) {
			map.put("name" + i, new byte[1000000]);
		}
		list.add(map);
		
		System.out.println("Current Heap Size: " + Runtime.getRuntime().totalMemory() + ", Max Heap Size: " + Runtime.getRuntime().maxMemory());
	
	}

}

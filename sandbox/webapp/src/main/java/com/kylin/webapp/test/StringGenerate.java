package com.kylin.webapp.test;

public class StringGenerate {

	public static void main(String[] args) {

		String str = "";
		for(int i = 0 ; i < 2000 ; i ++) {
			str += "a";
		}
		System.out.println(str);
	}

}

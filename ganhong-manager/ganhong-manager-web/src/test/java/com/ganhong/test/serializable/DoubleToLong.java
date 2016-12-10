package com.ganhong.test.serializable;

public class DoubleToLong {

	public static void main(String[] args) {
		double d = 12.89;
		long dd = new Double(d).longValue();
		System.out.println(dd);
	}
}

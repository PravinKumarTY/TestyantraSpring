package com.tyss;

public class Test1 {
	public long power(int n, int p) throws Exception {
		long res = 1;
		if (n < 0 || p < 0) {
			throw new Exception("n or p should not be negative");
		} else if (n == 0 || p == 0) {
			throw new Exception("n or p should not be zero");
		} else {
			for (int i = 0; i < p; i++) {
				res *= n;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		
		try {
			long p = new Test1().power(0, 3);
			System.out.println(p);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}

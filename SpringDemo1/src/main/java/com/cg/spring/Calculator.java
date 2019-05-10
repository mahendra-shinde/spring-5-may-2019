package com.cg.spring;

public class Calculator {
	
	private SimpleDAO dao;
	
	public Calculator(SimpleDAO dao) {
		super();
		this.dao = dao;
	}

	public void doSum(int n1,int n2) {
		int ans = n1+n2;
		System.out.println("Answer : "+ans);
		System.out.println("Answer in BINARY: "+ dao.toBinary(ans));
	}
}

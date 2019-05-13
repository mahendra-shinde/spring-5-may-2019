package com.cg.app.intro;

public class ExchangeServiceImpl implements ExchangeService {

	private double exchangeRate;
	
	public ExchangeServiceImpl(double exchangeRate) {
		System.out.println("ExchangeServiceImpl()");
		this.exchangeRate = exchangeRate;
	}
	public double getExchangeRate() {
		System.out.println("getExchangeRate()");
		return exchangeRate;
	}
}

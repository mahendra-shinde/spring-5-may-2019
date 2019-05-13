package com.cg.app.intro;
public class CurrencyConverterImpl implements CurrencyConverter {
	
	private ExchangeService exchangeService;
	
	public CurrencyConverterImpl() {
		System.out.println("CurrencyConverterImpl()");
	}

	

	public ExchangeService getExchangeService() {
		System.out.println("getExchangeService()");		
		return exchangeService;
	}

	public void setExchangeService(ExchangeService exchangeService) {
		System.out.println("setExchangeService()");		
		this.exchangeService = exchangeService;
	}

	public double dollarsToRupees(double dollars) {
		System.out.println("dollarsToRupees()");		
		return dollars * exchangeService.getExchangeRate();
	}
};
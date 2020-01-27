package com.pshaikh.exchange_rate_service.web;

import java.util.List;

import com.pshaikh.exchange_rate_service.history.ExchangeRateHistory;

public class ExchangeRateHistoryResponse {
	List<ExchangeRateHistory> rates;

	public ExchangeRateHistoryResponse(List<ExchangeRateHistory> rates) {
		this.rates = rates;
	}

	public List<ExchangeRateHistory> getRates() {
		return rates;
	}

	public void setRates(List<ExchangeRateHistory> rates) {
		this.rates = rates;
	}
	
	
}

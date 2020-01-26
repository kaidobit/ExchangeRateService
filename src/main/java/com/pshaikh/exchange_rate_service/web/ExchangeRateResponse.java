package com.pshaikh.exchange_rate_service.web;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;

public class ExchangeRateResponse {
	public enum Trend {
		DESCENDING,
		ASCENDING,
		CONSTANT,
		UNDEFINED;
	}
	
	private ExchangeRate exchangeRate;
	private float exchangeRateAverageLastDays;
	private Trend trend;

	public ExchangeRateResponse() {
	}

	public ExchangeRateResponse(ExchangeRate exchangeRate, float exchangeRateAverageLastFiveDays, float trend) {
		this.exchangeRate = exchangeRate;
		this.exchangeRateAverageLastDays = exchangeRateAverageLastFiveDays;
	}

	public ExchangeRate getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(ExchangeRate exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public float getExchangeRateAverageLastDays() {
		return exchangeRateAverageLastDays;
	}

	public void setExchangeRateAverageLastDays(float exchangeRateAverageLastDays) {
		this.exchangeRateAverageLastDays = exchangeRateAverageLastDays;
	}

	public Trend getTrend() {
		return trend;
	}

	public void setTrend(Trend trend) {
		this.trend = trend;
	}
}
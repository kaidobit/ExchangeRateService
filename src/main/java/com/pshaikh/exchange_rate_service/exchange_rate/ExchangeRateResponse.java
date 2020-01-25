package com.pshaikh.exchange_rate_service.exchange_rate;

public class ExchangeRateResponse {
	private ExchangeRate exchangeRate;
	private float exchangeRateAverageLastDays;
	private Object trend;

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

	public Object getTrend() {
		return trend;
	}

	public void setTrend(Object trend) {
		this.trend = trend;
	}
}
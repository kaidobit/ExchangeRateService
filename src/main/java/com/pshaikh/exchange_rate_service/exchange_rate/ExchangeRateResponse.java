package com.pshaikh.exchange_rate_service.exchange_rate;

public class ExchangeRateResponse {
	private ExchangeRate exchangeRate;
	private float exchangeRateAverageLastDays;
	private Object trend;

	public ExchangeRateResponse() {
	}

	public ExchangeRateResponse(ExchangeRate exchangeRateToday, float exchangeRateAverageLastFiveDays, float trend) {
		this.exchangeRate = exchangeRateToday;
		this.exchangeRateAverageLastDays = exchangeRateAverageLastFiveDays;
	}

	public ExchangeRate getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(ExchangeRate exchangeRateToday) {
		this.exchangeRate = exchangeRateToday;
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
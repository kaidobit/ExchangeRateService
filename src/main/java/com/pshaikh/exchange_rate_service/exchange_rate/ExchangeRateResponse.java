package com.pshaikh.exchange_rate_service.exchange_rate;

public class ExchangeRateResponse {
	private ExchangeRate exchangeRateToday;
	private float exchangeRateAverageLastDays;
	private Object trend;

	public ExchangeRateResponse() {
	}

	public ExchangeRateResponse(ExchangeRate exchangeRateToday, float exchangeRateAverageLastFiveDays, float trend) {
		this.exchangeRateToday = exchangeRateToday;
		this.exchangeRateAverageLastDays = exchangeRateAverageLastFiveDays;
	}

	public ExchangeRate getExchangeRateToday() {
		return exchangeRateToday;
	}

	public void setExchangeRateToday(ExchangeRate exchangeRateToday) {
		this.exchangeRateToday = exchangeRateToday;
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
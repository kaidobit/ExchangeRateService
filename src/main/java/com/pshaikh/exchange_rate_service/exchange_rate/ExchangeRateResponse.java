package com.pshaikh.exchange_rate_service.exchange_rate;

public class ExchangeRateResponse {
	private ExchangeRate exchangeRateToday;
	private float exchangeRateAverageLastFiveDays;
	private Object trend;

	public ExchangeRateResponse() {
	}

	public ExchangeRateResponse(ExchangeRate exchangeRateToday, float exchangeRateAverageLastFiveDays, float trend) {
		this.exchangeRateToday = exchangeRateToday;
		this.exchangeRateAverageLastFiveDays = exchangeRateAverageLastFiveDays;
	}

	public ExchangeRate getExchangeRateToday() {
		return exchangeRateToday;
	}

	public void setExchangeRateToday(ExchangeRate exchangeRateToday) {
		this.exchangeRateToday = exchangeRateToday;
	}

	public float getExchangeRateAverageLastFiveDays() {
		return exchangeRateAverageLastFiveDays;
	}

	public void setExchangeRateAverageLastFiveDays(float exchangeRateAverageLastFiveDays) {
		this.exchangeRateAverageLastFiveDays = exchangeRateAverageLastFiveDays;
	}

	public Object getTrend() {
		return trend;
	}

	public void setTrend(Object trend) {
		this.trend = trend;
	}
}
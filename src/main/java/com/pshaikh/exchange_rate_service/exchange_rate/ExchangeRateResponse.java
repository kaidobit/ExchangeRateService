package com.pshaikh.exchange_rate_service.exchange_rate;

public class ExchangeRateResponse {
	private String date;
	private float exchangeRateToday;
	private float exchangeRateAverageLastFiveDays;
	private float trend;

	public ExchangeRateResponse() {
	}

	public ExchangeRateResponse(String date, float exchangeRateToday, float exchangeRateAverageLastFiveDays,
			float trend) {
		this.date = date;
		this.exchangeRateToday = exchangeRateToday;
		this.exchangeRateAverageLastFiveDays = exchangeRateAverageLastFiveDays;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getExchangeRateToday() {
		return exchangeRateToday;
	}

	public void setExchangeRateToday(float exchangeRateToday) {
		this.exchangeRateToday = exchangeRateToday;
	}

	public float getExchangeRateAverageLastFiveDays() {
		return exchangeRateAverageLastFiveDays;
	}

	public void setExchangeRateAverageLastFiveDays(float exchangeRateAverageLastFiveDays) {
		this.exchangeRateAverageLastFiveDays = exchangeRateAverageLastFiveDays;
	}

	public float getTrend() {
		return trend;
	}

	public void setTrend(float trend) {
		this.trend = trend;
	}
}
package com.pshaikh.exchange_rate_service.exchange_rate;

import java.util.Date;

public class ExchangeRate {
	private Date date;
	private String baseCurrency;
	private String targetCurrency;
	private float rate;

	public ExchangeRate() {
	}

	public ExchangeRate(Date date, String baseCurrency, String targetCurrency) {
		this.date = date;
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
}
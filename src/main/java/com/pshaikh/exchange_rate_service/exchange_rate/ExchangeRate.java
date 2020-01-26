package com.pshaikh.exchange_rate_service.exchange_rate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExchangeRate {	
	public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	private Date date;
	private String baseCurrency;
	private String targetCurrency;
	private float rate;

	public ExchangeRate() {
	}

	public ExchangeRate(Date date, String baseCurrency, String targetCurrency, float rate) {
		this.date = date;
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
		this.rate = rate;
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
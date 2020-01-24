package com.pshaikh.exchange_rate_service.history;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExchangeRateHistory {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "EXCHANGE_RATE")
	private float exchangeRate;
	@Column(name = "BASE_CURRENCY", length = 5)
	private String baseCurrency;
	@Column(name = "TARGET_CURRENCY", length = 5)
	private String targetCurrency;

	public ExchangeRateHistory() {

	}

	public ExchangeRateHistory(Date date, float exchangeRate, String baseCurrency, String targetCurrency) {
		this.date = date;
		this.exchangeRate = exchangeRate;
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
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
}

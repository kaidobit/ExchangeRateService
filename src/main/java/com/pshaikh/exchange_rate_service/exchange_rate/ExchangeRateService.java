package com.pshaikh.exchange_rate_service.exchange_rate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import external_api.ExchangeRateApi;

@Service
public class ExchangeRateService {
	@Autowired
	@Qualifier("exchangeRatesApiDotIo")
	private ExchangeRateApi erApi;
	
	public List<ExchangeRate> requestTodaysExchangeRates(Date date, String baseCurrency) {
		return erApi.getByDateWithBaseCurrency(date, baseCurrency);
	}

}

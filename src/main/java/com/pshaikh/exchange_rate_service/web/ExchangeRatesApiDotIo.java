package com.pshaikh.exchange_rate_service.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;

import external_api.ExchangeRateApi;

@Component
public class ExchangeRatesApiDotIo implements ExchangeRateApi {

	@Override
	public List<ExchangeRate> getByDateWithBaseCurrency(Date date, String baseCurrency) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.pshaikh.exchange_rate_service.exchange_rate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pshaikh.exchange_rate_service.external_api.ExchangeRateApi;

/**
 * Businesslogic for ExchangeRate.
 * 
 * @author PSHAIKH
 */
@Service
public class ExchangeRateService {
	@Autowired
	@Qualifier("exchangeRatesApiDotIo")
	private ExchangeRateApi erApi;
	
	/**
	 * Requests the exchangeRate for a given date and baseCurrency from a external API.
	 * 
	 * @param date
	 * @param baseCurrency
	 * @return list of exchangeRates
	 */
	public List<ExchangeRate> requestExchangeRatesForDateAndCurrency(Date date, String baseCurrency) {
		return erApi.getByDateWithBaseCurrency(date, baseCurrency);
	}

}

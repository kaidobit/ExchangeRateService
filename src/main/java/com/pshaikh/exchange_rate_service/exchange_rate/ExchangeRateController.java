package com.pshaikh.exchange_rate_service.exchange_rate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pshaikh.exchange_rate_service.history.ExchangeRateHistoryController;

/**
 * Entrypoint for communication with ExchangeRate.
 * 
 * @author PSHAIKH
 */
@Controller
public class ExchangeRateController {
	@Autowired
	ExchangeRateService exchangeRateService;
	@Autowired
	ExchangeRateHistoryController exchangeRateHistoryController;

	/**
	 * Return the exchangeRate for given date, base- and target currency. 
	 * @param date
	 * @param baseCurrency
	 * @param targetCurrency
	 * @return the requested exchangeRate
	 */
	public ExchangeRate getExchangeRateForDateAndCurrency(Date date, String baseCurrency, String targetCurrency) {
		List<ExchangeRate> todaysExchangeRates = exchangeRateService.requestExchangeRatesForDateAndCurrency(date, baseCurrency);
		ExchangeRate result = null;

		if(todaysExchangeRates.size() > 0) {
			exchangeRateHistoryController.persist(todaysExchangeRates);
		}		
		
		for(ExchangeRate er : todaysExchangeRates) {
			if (er.getTargetCurrency().equals(targetCurrency)) {
				result = er;
			}
		}

		return result;
	}
}
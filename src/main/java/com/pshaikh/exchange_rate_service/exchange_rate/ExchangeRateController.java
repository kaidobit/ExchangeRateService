package com.pshaikh.exchange_rate_service.exchange_rate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pshaikh.exchange_rate_service.history.ExchangeRateHistoryController;

@Controller
public class ExchangeRateController {
	@Autowired
	ExchangeRateService exchangeRateService;
	@Autowired
	ExchangeRateHistoryController exchangeRateHistoryController;

	public ExchangeRate getTodaysExchangeRate(Date date, String baseCurrency, String targetCurrency) {
		List<ExchangeRate> todaysExchangeRates = exchangeRateService.requestTodaysExchangeRates(date, baseCurrency);
		ExchangeRate result = null;
		for(ExchangeRate er : todaysExchangeRates) {
			if (er.getTargetCurrency().equals(targetCurrency)) {
				result = er;
			}
		}
		
		//TODO save exchangerates to db

		return result;
	}
	

	public Object getTrend() {
		// TODO Auto-generated method stub
		return 0;
	}

}
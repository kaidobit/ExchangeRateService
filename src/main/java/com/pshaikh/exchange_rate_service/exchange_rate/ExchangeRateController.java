package com.pshaikh.exchange_rate_service.exchange_rate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ExchangeRateController {
	@Autowired
	ExchangeRateService exchangeRateService;
	
	public ExchangeRate getTodaysExchangeRate(Date date, String baseCurrency, String targetCurrency) {
		ExchangeRate exchangeRate = new ExchangeRate(date, baseCurrency, targetCurrency);
		
		exchangeRate.setRate(exchangeRateService.requestTodaysExchangeRate());
		
		return exchangeRate;
	}

	public float getAverageExchangeRateOfLastDays(int days) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getTrend() {
		// TODO Auto-generated method stub
		return 0;
	}

}
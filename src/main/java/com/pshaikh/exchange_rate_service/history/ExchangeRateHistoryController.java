package com.pshaikh.exchange_rate_service.history;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;

@Controller
public class ExchangeRateHistoryController {
	@Autowired
	ExchangeRateHistoryRepository erhRepo;

	public boolean persist(ExchangeRate exchangeRate) {
		if (erhRepo.save(new ExchangeRateHistory(exchangeRate.getDate(), exchangeRate.getRate(),
				exchangeRate.getBaseCurrency(), exchangeRate.getTargetCurrency())) != null) {
			return true;
		}
		return false;
	}

	public float getAverageExchangeRateOfLastDays(int days, String baseCurrency, String targetCurrency) {
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, -days);
		Date fromDate = cal.getTime();
		
		return erhRepo.calculateAverageRatesByDatesBetweenAndCurrencies(fromDate, today, baseCurrency, targetCurrency);
	}

}

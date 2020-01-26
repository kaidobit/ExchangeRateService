package com.pshaikh.exchange_rate_service.history;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;
import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRateResponse.Trend;

@Controller
public class ExchangeRateHistoryController {
	@Autowired
	ExchangeRateHistoryRepository erhRepo;
	
	public boolean persist(List<ExchangeRate> todaysExchangeRates) {
		boolean persisted = false;
		List<ExchangeRateHistory> exchangeRateHistories = new ArrayList<>();
		
		for(ExchangeRate er : todaysExchangeRates) {
			exchangeRateHistories.add(new ExchangeRateHistory(er.getDate(), er.getRate(), er.getBaseCurrency(), er.getTargetCurrency()));
		}
		
		if(erhRepo.saveAll(exchangeRateHistories) != null) {
			persisted = true;
		}
		
		return persisted;
		
	}

	public float getAverageExchangeRateOfLastDays(Date date, int days, String baseCurrency, String targetCurrency) {
		Date today = date;
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, -days);
		Date fromDate = cal.getTime();
		
		return erhRepo.calculateAverageRatesByDatesBetweenAndCurrencies(fromDate, today, baseCurrency, targetCurrency);
	}

	public Trend getTrend(Date dateParsed, int i, String baseCurrency, String targetCurrency) {
		// TODO Auto-generated method stub
		return null;
	}



}

package com.pshaikh.exchange_rate_service.history;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;
import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRateResponse.Trend;

/**
 * Entrypoint for internal communication with ExchangeRateHistory.
 * 
 * @author PSHAIKH
 */
@Controller
public class ExchangeRateHistoryController {
	@Autowired
	ExchangeRateHistoryRepository erhRepo;
	@Autowired
	ExchangeRateHistoryService erhService;
	
	/**
	 * Persists a list of exchangeRates as exchangeRateHistories into the database.
	 *  
	 * @param todaysExchangeRates
	 * @return true, if persisted
	 */
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

	/**
	 * Calculates the average of exchange rate by base- and target currency between a date and the date minus a given amount of days.
	 * @param date
	 * @param days
	 * @param baseCurrency
	 * @param targetCurrency
	 * @return the average exchange rate
	 */
	public float getAverageExchangeRateOfLastDays(Date date, int days, String baseCurrency, String targetCurrency) {		
		return erhRepo.calculateAverageRatesByDatesBetweenAndCurrencies(calculateFromDate(date, days), date, baseCurrency, targetCurrency);
	}

	public Trend getTrend(Date date, int days, String baseCurrency, String targetCurrency) {
		List<ExchangeRateHistory> exchangeRateHistories = erhRepo.findRatesByDatesBetweenAndCurrencies(calculateFromDate(date, days), date, baseCurrency, targetCurrency);
		
		return erhService.determineTrend(exchangeRateHistories);
	}
	
	/**
	 * Calculates a date by a given date minus a given amount of days.
	 * @param date
	 * @param days
	 * @return the calculated date
	 */
	private Date calculateFromDate(Date date, int days) {
		Date today = date;
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.DATE, -days);
		return cal.getTime();
	}



}

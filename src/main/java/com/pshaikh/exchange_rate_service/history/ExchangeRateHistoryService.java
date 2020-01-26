package com.pshaikh.exchange_rate_service.history;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pshaikh.exchange_rate_service.web.ExchangeRateResponse.Trend;

/**
 * Businesslogic for Exchange Rate History.
 * 
 * @author PSHAIKH
 */
@Service
public class ExchangeRateHistoryService {

	/**
	 * Determines the trend by given list of exchangeRateHistories.
	 * 
	 * @param exchangeRateHistories list of exchange rates
	 * @return the determined trend
	 */
	public Trend determineTrend(List<ExchangeRateHistory> exchangeRateHistories) {
		if(isConstant(exchangeRateHistories)) {
			return Trend.CONSTANT;
		} else if(isAscending(exchangeRateHistories)) {
			return Trend.ASCENDING;
		} else if( isDescending(exchangeRateHistories)){
			return Trend.DESCENDING;
		}
		
		return Trend.UNDEFINED;
	}
	
	/**
	 * Checks if given list of echangeRateHistories is ascending evaluated by exchange rate.
	 * 
	 * @param exchangeRateHistories list of echangeRateHistories to be checked
	 * @return true, if list is ascending
	 */
	private boolean isAscending(List<ExchangeRateHistory> exchangeRateHistories) {		
		ExchangeRateHistory previousErh = null;
		
		for(ExchangeRateHistory erh : exchangeRateHistories) {
		    if(previousErh != null && previousErh.getExchangeRate() > erh.getExchangeRate()) {
		        return false;
		    }
		    previousErh = erh;
		}
		return true;
	}

	/**
	 * Checks if given list of echangeRateHistories is descending evaluated by exchange rate.
	 * 
	 * @param exchangeRateHistories list of echangeRateHistories to be checked
	 * @return true, if list is descending
	 */	
	private boolean isDescending(List<ExchangeRateHistory> exchangeRateHistories) {
		ExchangeRateHistory previousErh = null;
		
		for(ExchangeRateHistory erh : exchangeRateHistories) {
		    if(previousErh != null && previousErh.getExchangeRate() < erh.getExchangeRate()) {
		        return false;
		    }
		    previousErh = erh;
		}
		return true;
	}
	
	/**
	 * Checks if given list of echangeRateHistories is constant evaluated by exchange rate.
	 * 
	 * @param exchangeRateHistories list of echangeRateHistories to be checked
	 * @return true, if list is constant
	 */	
	private boolean isConstant(List<ExchangeRateHistory> exchangeRateHistories) {
		ExchangeRateHistory previousErh = null;
		
		for(ExchangeRateHistory erh : exchangeRateHistories) {
		    if(previousErh != null && previousErh.getExchangeRate() != erh.getExchangeRate()) {
		        return false;
		    }
		    previousErh = erh;
		}
		return true;
	}
}

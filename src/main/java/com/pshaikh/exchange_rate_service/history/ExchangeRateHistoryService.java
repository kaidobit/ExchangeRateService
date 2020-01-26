package com.pshaikh.exchange_rate_service.history;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRateResponse.Trend;

@Service
public class ExchangeRateHistoryService {

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

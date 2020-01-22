package com.pshaikh.exchange_rate_service.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;

@Controller
public class ExchangeRateHistoryController {
	@Autowired
	ExchangeRateHistoryRepository erhRepo;

	public boolean persist(ExchangeRate exchangeRate) {

		return true;
	}

}
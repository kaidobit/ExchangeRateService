package com.pshaikh.exchange_rate_service.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRateResponse;

@RestController
@RequestMapping("/api/exchange-rate")
public class ExchangeRateApiController {
	@PostMapping("/{date}/{baseCurrency}/{targetCurrency}")
	@ResponseBody
	public ExchangeRateResponse getTodaysExchangeRate(@PathVariable("date") String date,
			@PathVariable("baseCurrency") String baseCurrency, @PathVariable("targetCurrency") String targetCurrency) {
		ExchangeRateResponse response = new ExchangeRateResponse();

		// TODO initialization of response properties

		return response;
	}
}
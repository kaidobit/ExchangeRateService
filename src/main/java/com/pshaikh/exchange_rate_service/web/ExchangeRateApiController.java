package com.pshaikh.exchange_rate_service.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRateController;
import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRateResponse;

@RestController
@RequestMapping("/api/exchange-rate")
public class ExchangeRateApiController {
	private final String DATE_FORMAT = "dd/MM/yyyy";
	@Autowired
	private ExchangeRateController erc;
	
	@PostMapping("/{date}/{baseCurrency}/{targetCurrency}")
	@ResponseBody
	public ExchangeRateResponse getTodaysExchangeRate(@PathVariable("date") String date,
			@PathVariable("baseCurrency") String baseCurrency, @PathVariable("targetCurrency") String targetCurrency) {
		ExchangeRateResponse response = new ExchangeRateResponse();
		
		response.setDate(date);
		try {
			response.setExchangeRateToday(erc.getTodaysExchangeRate(new SimpleDateFormat(DATE_FORMAT).parse(date), baseCurrency, targetCurrency).getExchangeRate());
		} catch (ParseException e) {
			// TODO set http error
			e.printStackTrace();
		}
		response.setExchangeRateAverageLastFiveDays(erc.getAverageExchangeRateOfLastDays(5));
		response.setTrend(erc.getTrend());

		return response;
	}
}
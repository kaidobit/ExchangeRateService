package com.pshaikh.exchange_rate_service.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;
import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRateController;
import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRateResponse;
import com.pshaikh.exchange_rate_service.history.ExchangeRateHistoryController;

@RestController
@RequestMapping("/api/exchange-rate")
public class ExchangeRateApiController {
	@Autowired
	private ExchangeRateController erc;
	@Autowired
	private ExchangeRateHistoryController erhc;

	@PostMapping("/{date}/{baseCurrency}/{targetCurrency}")
	@ResponseBody
	public ExchangeRateResponse getTodaysExchangeRate(@PathVariable("date") String date,
			@PathVariable("baseCurrency") String baseCurrency, @PathVariable("targetCurrency") String targetCurrency) {
		Date dateParsed = null;
		try {
			dateParsed = ExchangeRate.DATE_FORMAT.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ExchangeRateResponse response = new ExchangeRateResponse();

		response.setExchangeRate(erc.getExchangeRateForDateAndCurrency(dateParsed,
					"CAD", targetCurrency));
		response.setExchangeRateAverageLastDays(erhc.getAverageExchangeRateOfLastDays(dateParsed, 5, baseCurrency, targetCurrency));
		response.setTrend(erc.getTrend());

		return response;
	}
}
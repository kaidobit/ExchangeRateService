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
import com.pshaikh.exchange_rate_service.history.ExchangeRateHistoryController;

/**
 * Web API controller which provides rest endpoints to request data about exchange rates.
 * 
 * @author PSHAIKH
 */
@RestController
@RequestMapping("/api/exchange-rate")
public class ExchangeRateApiController {
	@Autowired
	private ExchangeRateController erc;
	@Autowired
	private ExchangeRateHistoryController erhc;

	/**
	 * REST - Endpoint providing:
	 *   - the exchange rate for the given date, base- and target currency
	 *   - the average exchange rate for the given date, 5 days into the past, base- and target currency
	 *   - a trend evaluating the exchange rate for the given date, 5 days into the past, base- and target currency
	 * @param date
	 * @param baseCurrency
	 * @param targetCurrency
	 * @return JSON format containing the response
	 */
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
		response.setTrend(erhc.getTrend(dateParsed, 5, baseCurrency, targetCurrency));

		return response;
	}
}
package com.pshaikh.exchange_rate_service.web;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;
import com.pshaikh.exchange_rate_service.history.ExchangeRateHistoryController;

@RestController
@RequestMapping("/api/exchange-rate/history")
public class ExchangeRateHistoryApiController {
	@Autowired
	ExchangeRateHistoryController erhc;
	
	/**
	 * Returns a list of histories for given date.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return list of histories
	 */
	@GetMapping("/daily/{yyyy}/{MM}/{dd}")
	@ResponseBody
	public ExchangeRateHistoryResponse getRatesForDay(@PathVariable("yyyy") String year,@PathVariable("MM") String month,@PathVariable("dd") String day) {
		Date date = null;
		
		try {
			date = ExchangeRate.DATE_FORMAT.parse(year + "-" + month + "-" + day);
		} catch (ParseException e) {
			// TODO http error
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String dateString = cal.get(Calendar.YEAR) + "-" + monthOfDateToString(cal.get(Calendar.MONTH)) + "-" + cal.get(Calendar.DATE);
		return new ExchangeRateHistoryResponse(erhc.getRatesForDay(date));
	}
	
	/**
	 * Returns a list of histories for given month.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return list of histories
	 */
	@GetMapping("/monthly/{yyyy}/{MM}")
	@ResponseBody
	public ExchangeRateHistoryResponse getRatesForMonth(@PathVariable("yyyy") String year,@PathVariable("MM") String month) {
		Date date = null;
		
		try {
			date = ExchangeRate.DATE_FORMAT.parse(year + "-" + month + "-01");
		} catch (ParseException e) {
			// TODO http error
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		ExchangeRateHistoryResponse exchangeRateHistoryResponse = new ExchangeRateHistoryResponse(erhc.getRatesForMonth(cal.get(Calendar.YEAR) + "-" + monthOfDateToString(cal.get(Calendar.MONTH))));
		return exchangeRateHistoryResponse;
	}
	
	private String monthOfDateToString(int month) {
		month = month + 1;
		
		if(month < 10) {
			return "0" + month;
		}
		
		return String.valueOf(month);
	}
}

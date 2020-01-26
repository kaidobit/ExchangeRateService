package com.pshaikh.exchange_rate_service.external_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;

@Component
public class ExchangeRatesApiDotIo implements ExchangeRateApi {
	private final String URL = "https://api.exchangeratesapi.io/";
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<ExchangeRate> getByDateWithBaseCurrency(Date date, String baseCurrency) {
		final String REQUEST_URL = URL + ExchangeRate.DATE_FORMAT.format(date) +  "?base=" + baseCurrency;
		List<ExchangeRate> exchangeRates = new ArrayList<>();
		
		ExchangeRatesApiDotIoResponse eradiResponse = restTemplate.getForObject(REQUEST_URL, ExchangeRatesApiDotIoResponse.class);		
		for(Map.Entry<String, Float> rate : eradiResponse.getRates().entrySet()) {
			try {
				exchangeRates.add(new ExchangeRate(ExchangeRate.DATE_FORMAT.parse(eradiResponse.getDate()), baseCurrency, rate.getKey(), rate.getValue()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return exchangeRates;	
	}

}

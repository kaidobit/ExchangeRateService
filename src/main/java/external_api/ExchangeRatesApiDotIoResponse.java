package external_api;

import java.util.LinkedHashMap;

public class ExchangeRatesApiDotIoResponse {
	private LinkedHashMap<String, Float> rates;
	private String base;
	private String date;
	
	public ExchangeRatesApiDotIoResponse(LinkedHashMap<String, Float> rates, String base, String date) {
		this.rates = rates;
		this.base = base;
		this.date = date;
	}

	public LinkedHashMap<String, Float> getRates() {
		return rates;
	}

	public void setRates(LinkedHashMap<String, Float> rates) {
		this.rates = rates;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}

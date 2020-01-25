package external_api;

import java.util.Date;
import java.util.List;

import com.pshaikh.exchange_rate_service.exchange_rate.ExchangeRate;

public interface ExchangeRateApi {
	List<ExchangeRate> getByDateWithBaseCurrency(Date date, String baseCurrency);
}

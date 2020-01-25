package com.pshaikh.exchange_rate_service.history;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateHistoryRepository extends CrudRepository<ExchangeRateHistory, Long> {

	@Query("SELECT AVG(erh.exchangeRate) FROM ExchangeRateHistory erh WHERE (erh.date BETWEEN :fromDate AND :toDate) AND erh.baseCurrency = :baseCurrency AND erh.targetCurrency = :targetCurrency")
	float calculateAverageRatesByDatesBetweenAndCurrencies(Date fromDate, Date toDate,
			String baseCurrency, String targetCurrency);

}

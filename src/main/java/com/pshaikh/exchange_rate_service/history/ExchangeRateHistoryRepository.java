package com.pshaikh.exchange_rate_service.history;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateHistoryRepository extends JpaRepository<ExchangeRateHistory, Long> {

	@Query("AVG(erh.exchangeRate) FROM ExchangeRateHistory erh WHERE (erh.date BETWEEN :fromDate AND :toDate) AND erh.baseCurrency = :baseCurrency AND erh.targetCurrency = :targetCurrency;")
	float calculateAverageRatesByDatesBetweenAndCurrencies(Date fromDate, Date toDate,
			String baseCurrency, String targetCurrency);

}

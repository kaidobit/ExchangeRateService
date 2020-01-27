package com.pshaikh.exchange_rate_service.history;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Databasecommunication with table: exchange_rate_history
 * 
 * @author PSHAIKH
 */
@Repository
public interface ExchangeRateHistoryRepository extends CrudRepository<ExchangeRateHistory, Long> {
	/**
	 * Calculates the average exchange rate between two dates by given base- and target currency.
	 * 
	 * @param fromDate
	 * @param toDate
	 * @param baseCurrency
	 * @param targetCurrency
	 * @return the average exchange rate
	 */
	@Query("SELECT AVG(erh.exchangeRate) FROM ExchangeRateHistory erh WHERE (erh.date BETWEEN :fromDate AND :toDate) AND erh.baseCurrency = :baseCurrency AND erh.targetCurrency = :targetCurrency")
	float calculateAverageRatesByDatesBetweenAndCurrencies(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate,
			@Param("baseCurrency") String baseCurrency, @Param("targetCurrency") String targetCurrency);

	/**
	 * Returns a list of exchangeRateHistories between two dates and by given base- and target currency.
	 * @param fromDate
	 * @param toDate
	 * @param baseCurrency
	 * @param targetCurrency
	 * @return list of exchangeRateHistories
	 */
	@Query("SELECT erh FROM ExchangeRateHistory erh WHERE (erh.date BETWEEN :fromDate AND :toDate) AND erh.baseCurrency = :baseCurrency AND erh.targetCurrency = :targetCurrency")
	List<ExchangeRateHistory> findRatesByDatesBetweenAndCurrencies(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate,
			@Param("baseCurrency") String baseCurrency, @Param("targetCurrency") String targetCurrency);

	/**
	 * select all histories between two dates
	 * @param date
	 * @return a list of found histories
	 */
	@Query("SELECT erh FROM ExchangeRateHistory erh WHERE erh.date BETWEEN :date AND :date")
	List<ExchangeRateHistory> findByDateStartingWith(Date date);

	/**
	 * select all histories for a month
	 * @param date
	 * @return a list of found histories
	 */
	@Query("SELECT erh FROM ExchangeRateHistory erh WHERE erh.date LIKE ':yearMonth%'")
	List<ExchangeRateHistory> findByMonth(@Param("yearMonth") String yearMonth);

}

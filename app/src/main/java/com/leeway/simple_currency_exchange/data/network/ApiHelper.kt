package com.leeway.simple_currency_exchange.data.network

import com.leeway.simple_currency_exchange.data.model.DailyExchageRate
import io.reactivex.Observable

/**
 * Created by Lee Lorz on 7/12/2017.
 */
interface ApiHelper {
    fun getDailyExchangeRate(base: String): Observable<DailyExchageRate>
}
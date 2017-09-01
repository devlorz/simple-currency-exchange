package com.leeway.simple_currency_exchange.data

import com.leeway.simple_currency_exchange.data.model.DailyExchageRate
import com.leeway.simple_currency_exchange.data.network.ApiHelper
import io.reactivex.Observable

/**
 * Created by Lee Lorz on 7/10/2017.
 */
interface DataManager: ApiHelper {
    override fun getDailyExchangeRate(): Observable<DailyExchageRate>
}
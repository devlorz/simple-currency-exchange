package com.leeway.simple_currency_exchange.data

import com.leeway.simple_currency_exchange.data.model.DailyExchageRate
import com.leeway.simple_currency_exchange.data.network.ApiHelper
import com.leeway.simple_currency_exchange.data.prefs.PreferencesHelper
import io.reactivex.Observable

/**
 * Created by Lee Lorz on 7/10/2017.
 */
interface DataManager: ApiHelper, PreferencesHelper {
    override fun getDailyExchangeRate(): Observable<DailyExchageRate>
    override fun getBaseCurrency(): String
    override fun setBaseCurrency(currency: String)
}
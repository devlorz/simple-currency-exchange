package com.leeway.simple_currency_exchange.data.prefs

/**
 * Created by Lee Lorz on 7/12/2017.
 */
interface PreferencesHelper {
    fun getBaseCurrency(): String
    fun setBaseCurrency(currency: String)
}
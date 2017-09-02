package com.leeway.simple_currency_exchange.data.model

import java.util.*

/**
 * Created by Lee Lorz on 9/1/2017.
 */

data class DailyExchageRate(
        var base: String,
        var date: String,
        var rates: CurrencyList
)
package com.leeway.simple_currency_exchange.data.network

import com.leeway.simple_currency_exchange.data.model.DailyExchageRate
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/12/2017.
 */

@Singleton
class AppApiHelper @Inject constructor(val apiHeader: ApiHeader) : ApiHelper {

    val exchangeService by lazy {
        ExchangeService.create()
    }

    var disposable: Disposable? = null

    override fun getDailyExchangeRate(): Observable<DailyExchageRate> {
        return exchangeService.getExchangeRate("THB")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}

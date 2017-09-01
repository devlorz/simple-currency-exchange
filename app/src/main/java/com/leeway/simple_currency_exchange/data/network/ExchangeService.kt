package com.leeway.simple_currency_exchange.data.network

import com.leeway.simple_currency_exchange.data.model.DailyExchageRate
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * Created by Lee Lorz on 9/1/2017.
 */
interface ExchangeService {
    @GET("latest")
    fun getExchangeRate(@Query("base") baseCurrency: String): Observable<DailyExchageRate>

    companion object {
        fun create(): ExchangeService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://api.fixer.io/")
                    .build()
            return retrofit.create(ExchangeService::class.java)
        }
    }
}
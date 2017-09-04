package com.leeway.simple_currency_exchange.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.leeway.simple_currency_exchange.di.ApplicationContext
import com.leeway.simple_currency_exchange.di.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/12/2017.
 */
@Singleton
class AppPreferencesHelper
@Inject
constructor(@ApplicationContext context: Context,
            @PreferenceInfo prefFileName: String) : PreferencesHelper {

    val PREF_KEY_BASE_CURRENCY = "PREF_KEY_BASE_CURRENCY"

    var pref: SharedPreferences = context
            .getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getBaseCurrency(): String {
        return pref.getString(PREF_KEY_BASE_CURRENCY, "")
    }

    override fun setBaseCurrency(currency: String) {
        pref.edit().putString(PREF_KEY_BASE_CURRENCY, currency).apply()
    }
}
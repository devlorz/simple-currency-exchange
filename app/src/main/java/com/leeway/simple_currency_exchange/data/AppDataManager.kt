package com.leeway.simple_currency_exchange.data

import android.content.Context
import com.leeway.simple_currency_exchange.data.db.DbHelper
import com.leeway.simple_currency_exchange.data.network.ApiHelper
import com.leeway.simple_currency_exchange.data.prefs.PreferencesHelper
import com.leeway.simple_currency_exchange.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/11/2017.
 */

@Singleton
class AppDataManager
@Inject
constructor(@ApplicationContext val context: Context,
            val dbHelper: DbHelper,
            val preferencesHelper: PreferencesHelper,
            val apiHelper: ApiHelper) : DataManager {

}
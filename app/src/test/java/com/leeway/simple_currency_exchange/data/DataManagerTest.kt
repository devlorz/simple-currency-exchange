package com.leeway.simple_currency_exchange.data

import android.content.Context
import com.leeway.simple_currency_exchange.BuildConfig
import com.leeway.simple_currency_exchange.data.db.AppDbHelper
import com.leeway.simple_currency_exchange.data.db.DbHelper
import com.leeway.simple_currency_exchange.data.network.ApiHeader
import com.leeway.simple_currency_exchange.data.network.ApiHelper
import com.leeway.simple_currency_exchange.data.network.AppApiHelper
import com.leeway.simple_currency_exchange.data.prefs.AppPreferencesHelper
import com.leeway.simple_currency_exchange.util.AppConstant
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue

/**
 * Created by Lee Lorz on 9/4/2017.
 */

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,
        sdk = intArrayOf(21))
class DataManagerTest {

    lateinit var context: Context
    lateinit var appPreferencesHelper: AppPreferencesHelper
    lateinit var dbHelper: DbHelper
    lateinit var apiHelper: ApiHelper
    lateinit var apiHeader: ApiHeader
    lateinit var dataManager: DataManager

    @Before
    @Throws(Exception::class)
    fun setup() {
        context = RuntimeEnvironment.application
        appPreferencesHelper = AppPreferencesHelper(context, AppConstant.PREF_NAME)
        dbHelper = AppDbHelper()
        apiHeader = ApiHeader()
        apiHelper = AppApiHelper(apiHeader)
        dataManager = AppDataManager(context, dbHelper, appPreferencesHelper, apiHelper)
    }

    @Test
    fun testDataManagerNotNull() {
        assertThat(dataManager, `is`(notNullValue()))
    }

}
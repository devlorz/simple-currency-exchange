package com.leeway.simple_currency_exchange.di.module

import android.app.Application
import android.content.Context
import com.leeway.simple_currency_exchange.data.AppDataManager
import com.leeway.simple_currency_exchange.data.DataManager
import com.leeway.simple_currency_exchange.data.db.AppDbHelper
import com.leeway.simple_currency_exchange.data.db.DbHelper
import com.leeway.simple_currency_exchange.data.network.ApiHelper
import com.leeway.simple_currency_exchange.data.network.AppApiHelper
import com.leeway.simple_currency_exchange.data.prefs.AppPreferencesHelper
import com.leeway.simple_currency_exchange.data.prefs.PreferencesHelper
import com.leeway.simple_currency_exchange.di.ApplicationContext
import com.leeway.simple_currency_exchange.di.PreferenceInfo
import com.leeway.simple_currency_exchange.util.AppConstant
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/11/2017.
 */

@Module
class ApplicationModule(val application: Application) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstant.PREF_NAME
    }
}
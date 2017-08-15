package com.leeway.simple_currency_exchange.di.component

import android.app.Application
import android.content.Context
import com.leeway.simple_currency_exchange.MainApplication
import com.leeway.simple_currency_exchange.data.DataManager
import com.leeway.simple_currency_exchange.di.ApplicationContext
import com.leeway.simple_currency_exchange.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Lee Lorz on 7/11/2017.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(app: MainApplication)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager
}
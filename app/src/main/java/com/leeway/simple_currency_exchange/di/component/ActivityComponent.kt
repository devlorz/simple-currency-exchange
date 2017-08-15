package com.leeway.simple_currency_exchange.di.component

import com.leeway.simple_currency_exchange.di.PerActivity
import com.leeway.simple_currency_exchange.di.module.ActivityModule
import com.leeway.simple_currency_exchange.ui.main.MainActivity
import dagger.Component

/**
 * Created by Lee Lorz on 7/14/2017.
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class),
            modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: MainActivity)
}
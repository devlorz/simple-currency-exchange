package com.leeway.simple_currency_exchange.di.module

import android.app.Activity
import android.content.Context
import com.leeway.simple_currency_exchange.di.ActivityContext
import com.leeway.simple_currency_exchange.di.PerActivity
import com.leeway.simple_currency_exchange.ui.main.MainContract
import com.leeway.simple_currency_exchange.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import org.mockito.Mockito

/**
 * Created by Lee Lorz on 8/18/2017.
 */

@Module
class ActivityModule(val activity: Activity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    @PerActivity
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @PerActivity
    fun provideMainPresenter(): MainContract.Presenter<MainContract.View> {
        return Mockito.mock(MainContract.Presenter::class.java) as MainContract.Presenter<MainContract.View>
    }
}
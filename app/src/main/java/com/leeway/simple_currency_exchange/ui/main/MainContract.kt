package com.leeway.simple_currency_exchange.ui.main

import com.leeway.simple_currency_exchange.ui.base.MvpPresenter
import com.leeway.simple_currency_exchange.ui.base.MvpView

/**
 * Created by Lee Lorz on 7/15/2017.
 */
interface MainContract {

    interface Presenter<V:MainContract.View>: MvpPresenter<V> {

    }

    interface View: MvpView {

    }
}
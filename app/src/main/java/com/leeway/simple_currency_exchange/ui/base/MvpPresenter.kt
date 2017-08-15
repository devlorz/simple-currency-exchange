package com.leeway.simple_currency_exchange.ui.base

/**
 * Created by Lee Lorz on 7/15/2017.
 */

interface MvpPresenter<V: MvpView> {
    fun onAttach(mvpView: V)
    fun onDetach()
}
package com.leeway.simple_currency_exchange.ui.main

import com.leeway.simple_currency_exchange.ui.base.MvpPresenter
import com.leeway.simple_currency_exchange.ui.base.MvpView

/**
 * Created by Lee Lorz on 7/15/2017.
 */
interface MainContract {

    interface Presenter<V:MainContract.View>: MvpPresenter<V> {
        fun onBtnZeroClick()
        fun onBtnOneClick()
        fun onBtnTwoClick()
        fun onBtnThreeClick()
        fun onBtnFourClick()
        fun onBtnFiveClick()
        fun onBtnSixClick()
        fun onBtnSevenClick()
        fun onBtnEightClick()
        fun onBtnNineClick()
        fun onBtnDotClick()
        fun onBtnDeleteClick()

    }

    interface View: MvpView {

    }
}
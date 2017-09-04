package com.leeway.simple_currency_exchange.ui.main

import com.leeway.simple_currency_exchange.ui.base.MvpPresenter
import com.leeway.simple_currency_exchange.ui.base.MvpView

/**
 * Created by Lee Lorz on 7/15/2017.
 */
interface MainContract {

    interface Presenter<V:MainContract.View>: MvpPresenter<V> {
        fun onBtnZeroClick(currentValue: String)
        fun onBtnOneClick(currentValue: String)
        fun onBtnTwoClick(currentValue: String)
        fun onBtnThreeClick(currentValue: String)
        fun onBtnFourClick(currentValue: String)
        fun onBtnFiveClick(currentValue: String)
        fun onBtnSixClick(currentValue: String)
        fun onBtnSevenClick(currentValue: String)
        fun onBtnEightClick(currentValue: String)
        fun onBtnNineClick(currentValue: String)
        fun onBtnDotClick(currentValue: String)
        fun onBtnDeleteClick(currentValue: String)
        fun getExchangeRate()
        fun getBaseCurrency()

    }

    interface View: MvpView {
        fun setValue(value: String)
        fun showMoreThanTenDigitToast()
        fun showMoreThanTwoDecimalToast()
        fun showError(errorMessage: String)
        fun  setExchangeValue(toString: String)

    }
}
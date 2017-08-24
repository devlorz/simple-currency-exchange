package com.leeway.simple_currency_exchange.ui.main

import com.leeway.simple_currency_exchange.data.DataManager
import com.leeway.simple_currency_exchange.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Lee Lorz on 7/15/2017.
 */
class MainPresenter<V: MainContract.View>
@Inject
constructor(dataManager: DataManager,
            compositeDisposable: CompositeDisposable) :
        BasePresenter<V>(dataManager, compositeDisposable), MainContract.Presenter<V> {

    override fun onBtnZeroClick(currentValue: String) {
        setValue(currentValue, "0")
    }

    override fun onBtnOneClick(currentValue: String) {
        setValue(currentValue, "1")
    }

    override fun onBtnTwoClick(currentValue: String) {
        setValue(currentValue, "2")
    }

    override fun onBtnThreeClick(currentValue: String) {
        setValue(currentValue, "3")
    }

    override fun onBtnFourClick(currentValue: String) {
        setValue(currentValue, "4")
    }

    override fun onBtnFiveClick(currentValue: String) {
        setValue(currentValue, "5")
    }

    override fun onBtnSixClick(currentValue: String) {
        setValue(currentValue, "6")
    }

    override fun onBtnSevenClick(currentValue: String) {
        setValue(currentValue, "7")
    }

    override fun onBtnEightClick(currentValue: String) {
        setValue(currentValue, "8")
    }

    override fun onBtnNineClick(currentValue: String) {
        setValue(currentValue, "9")
    }

    override fun onBtnDotClick(currentValue: String) {

    }

    override fun onBtnDeleteClick(currentValue: String) {

    }

    private fun setValue(currentAmount: String, setValue: String) {
        if (currentAmount == "0") {
            mvpView!!.setValue(setValue)
        } else {
            mvpView!!.setValue(currentAmount + setValue)
        }
    }
}

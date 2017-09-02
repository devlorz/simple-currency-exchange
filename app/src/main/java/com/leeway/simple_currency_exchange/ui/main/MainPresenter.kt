package com.leeway.simple_currency_exchange.ui.main

import com.leeway.simple_currency_exchange.data.DataManager
import com.leeway.simple_currency_exchange.data.model.DailyExchageRate
import com.leeway.simple_currency_exchange.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject

/**
 * Created by Lee Lorz on 7/15/2017.
 */

class MainPresenter<V: MainContract.View>
@Inject
constructor(dataManager: DataManager,
            compositeDisposable: CompositeDisposable) :
        BasePresenter<V>(dataManager, compositeDisposable), MainContract.Presenter<V> {

    var dailyExchangeRate: DailyExchageRate? = null

    override fun getExchangeRate() {
        compositeDisposable.add(dataManager
                .getDailyExchangeRate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    result -> dailyExchangeRate = result
//                    mvpView!!.showError(dailyExchangeRate.toString())
                },{
                    error -> mvpView!!.showError(error.message.toString())
                })
        )
    }

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
        if (currentValue.contains(".")) {
            mvpView!!.setValue(currentValue)
        } else {
            mvpView!!.setValue(currentValue + ".")
        }
    }

    override fun onBtnDeleteClick(currentValue: String) {
        if(currentValue.length > 1) {
            val newValue = currentValue.substring(0, currentValue.length - 1)
            mvpView!!.setValue(getNumberFormat(newValue.replace(",", "")))
        } else {
            mvpView!!.setValue("0")
        }
    }

    private fun isMoreThanTenDigit(value: String): Boolean {
        return value.replace(",", "").replace(".", "").length > 10
    }

    private fun validateAndSetValue(newValue: String) {
        if (isMoreThanTenDigit(newValue)) {
            mvpView!!.showMoreThanTenDigitToast()
        } else {
            mvpView!!.setValue(getNumberFormat(newValue.replace(",","")))
            calculateCurrencyExchange(newValue.replace(",",""))
        }
    }

    private fun setValue(currentAmount: String, setValue: String) {
        if (currentAmount == "0") {
            mvpView!!.setValue(setValue)
            calculateCurrencyExchange(setValue)
        } else {
            val newValue = currentAmount + setValue
            if (newValue.contains(".")) {
                val valueSplitByDot = newValue.split("(?<=[.])".toRegex())
                if (valueSplitByDot[1].length > 2) {
                    mvpView!!.showMoreThanTwoDecimalToast()
                } else {
                    validateAndSetValue(newValue)
                }
            } else {
                validateAndSetValue(newValue)
            }
        }
    }

    private fun calculateCurrencyExchange(value: String) {
        val baseValue = value.toDouble()
        if (dailyExchangeRate == null) {
            mvpView!!.setExchangeValue(value)
        } else {
            val rate = dailyExchangeRate!!.rates.JPY
            val calculatedValue = baseValue*rate
            mvpView!!.setExchangeValue(doubleToFormatString(calculatedValue))
        }
    }

    private fun getNumberFormat(value: String): String {
        var intValue = value
        var decValue = ""
        if (value.contains(".")) {
            val numValue = value.split("\\.".toRegex())
            intValue = numValue.first()
            if (numValue.size > 1) decValue = numValue[1]
        }

        val doubleValue = intValue.toDouble()
        val formatValue = if (value.contains(".") && decValue != "0") doubleToFormatString(doubleValue) + "." + decValue
        else doubleToFormatString(doubleValue)
        return formatValue
    }

    private fun doubleToFormatString(value: Double): String {
        val decimalFormat = DecimalFormat("#,###,###,###.##")
        decimalFormat.roundingMode = RoundingMode.CEILING
        return decimalFormat.format(value)
    }
}

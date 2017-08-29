package com.leeway.simple_currency_exchange.ui.main

import com.leeway.simple_currency_exchange.data.DataManager
import com.leeway.simple_currency_exchange.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
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

    }

    private fun setValue(currentAmount: String, setValue: String) {
        if (currentAmount == "0") {
            mvpView!!.setValue(setMoneyStringFormat(setValue))
        } else {
            mvpView!!.setValue(setMoneyStringFormat(currentAmount + setValue))
        }
    }

    private fun setMoneyStringFormat(value: String): String {
//        var numbers = value.split("(?<=[-+*/=])".toRegex()).toMutableList()
//        var lastNumber = numbers.last()
//        var lastIndex = numbers.lastIndex
//        if (lastNumber.isEmpty()) {
//            lastNumber = numbers[numbers.lastIndex-1]
//            lastIndex = numbers.lastIndex - 1
//        }
//        if (!lastNumber.matches(".*[-+*/=].*".toRegex())) {
//            numbers[lastIndex] = getNumberFormat(numbers[lastIndex].replace(",", ""))
//        }
//
//        var returnValue = ""
//        for (number in numbers) {
//            returnValue += number
//        }

        return getNumberFormat(value.replace(",", ""))
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
        val formatValue = if (value.contains(".")) doubleToFormatString(doubleValue) + "." + decValue
        else doubleToFormatString(doubleValue)
        return formatValue
    }

    private fun doubleToFormatString(value: Double): String {
        val decimalFormat = DecimalFormat("#,###,###,###.##")
        decimalFormat.roundingMode = RoundingMode.CEILING
        return decimalFormat.format(value)
    }
}

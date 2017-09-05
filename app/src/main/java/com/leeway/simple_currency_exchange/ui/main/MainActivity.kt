package com.leeway.simple_currency_exchange.ui.main

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.leeway.simple_currency_exchange.R
import com.leeway.simple_currency_exchange.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, View.OnClickListener {

    @Inject
    lateinit var mainPresenter: MainContract.Presenter<MainContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        mainPresenter.onAttach(this)
        setUp()
    }

    override fun onDestroy() {
        mainPresenter.onDetach()
        super.onDestroy()
    }

    override fun setUp() {
        btnZero.setOnClickListener(this)
        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnDot.setOnClickListener(this)
        btnDelete.setOnClickListener(this)

        mainPresenter.setBaseCurrency()
        mainPresenter.getBaseCurrency()
        mainPresenter.getExchangeRate()
    }

    override fun onClick(view: View?) {
        val currentValue = moneyFrom.text.toString()
        when(view) {
            btnZero -> mainPresenter.onBtnZeroClick(currentValue)
            btnOne -> mainPresenter.onBtnOneClick(currentValue)
            btnTwo -> mainPresenter.onBtnTwoClick(currentValue)
            btnThree -> mainPresenter.onBtnThreeClick(currentValue)
            btnFour -> mainPresenter.onBtnFourClick(currentValue)
            btnFive -> mainPresenter.onBtnFiveClick(currentValue)
            btnSix -> mainPresenter.onBtnSixClick(currentValue)
            btnSeven -> mainPresenter.onBtnSevenClick(currentValue)
            btnEight -> mainPresenter.onBtnEightClick(currentValue)
            btnNine -> mainPresenter.onBtnNineClick(currentValue)
            btnDot -> mainPresenter.onBtnDotClick(currentValue)
            btnDelete -> mainPresenter.onBtnDeleteClick(currentValue)
        }
    }

    override fun setValue(value: String) {
        moneyFrom.text = value
    }

    override fun showMoreThanTenDigitToast() {
        toast("Cannot input more than 10 digits")
    }

    override fun showMoreThanTwoDecimalToast() {
        toast("Cannot input more than 2 decimal point")
    }

    override fun showError(errorMessage: String) {
        toast(errorMessage)
    }

    override fun setExchangeValue(exchangeValue: String) {
        moneyTo.text = exchangeValue
    }

    override fun showSelectCurrencyDialog() {

    }
}


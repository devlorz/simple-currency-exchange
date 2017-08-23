package com.leeway.simple_currency_exchange.ui.main

import android.os.Bundle
import android.view.View
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
    }

    override fun onClick(view: View?) {
        when(view) {
            btnZero -> mainPresenter.onBtnZeroClick()
            btnOne -> mainPresenter.onBtnOneClick()
            btnTwo -> mainPresenter.onBtnTwoClick()
            btnThree -> mainPresenter.onBtnThreeClick()
            btnFour -> mainPresenter.onBtnFourClick()
            btnFive -> mainPresenter.onBtnFiveClick()
            btnSix -> mainPresenter.onBtnSixClick()
            btnSeven -> mainPresenter.onBtnSevenClick()
            btnEight -> mainPresenter.onBtnEightClick()
            btnNine -> mainPresenter.onBtnNineClick()
            btnDot -> mainPresenter.onBtnDotClick()
            btnDelete -> mainPresenter.onBtnDeleteClick()
        }
    }
}


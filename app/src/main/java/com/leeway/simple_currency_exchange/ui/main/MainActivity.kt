package com.leeway.simple_currency_exchange.ui.main

import android.os.Bundle
import com.leeway.simple_currency_exchange.R
import com.leeway.simple_currency_exchange.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

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

    }
}

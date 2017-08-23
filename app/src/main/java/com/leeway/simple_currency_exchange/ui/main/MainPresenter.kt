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

    override fun onBtnZeroClick() {

    }

    override fun onBtnOneClick() {

    }

    override fun onBtnTwoClick() {

    }

    override fun onBtnThreeClick() {

    }

    override fun onBtnFourClick() {

    }

    override fun onBtnFiveClick() {

    }

    override fun onBtnSixClick() {

    }

    override fun onBtnSevenClick() {

    }

    override fun onBtnEightClick() {

    }

    override fun onBtnNineClick() {

    }

    override fun onBtnDotClick() {

    }

    override fun onBtnDeleteClick() {

    }
}

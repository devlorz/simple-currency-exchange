package com.leeway.simple_currency_exchange.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.leeway.simple_currency_exchange.di.component.ActivityComponent
import com.leeway.simple_currency_exchange.ui.base.BaseActivity

/**
 * Created by Lee Lorz on 7/15/2017.
 */

abstract class BaseFragment: Fragment(), MvpView {
    var activity: BaseActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.activity = context
        }
    }

    override fun showLoading() {
        activity?.showLoading()
    }

    override fun hideLoading() {
        activity?.hideLoading()
    }

    override fun onError(message: String?) {
        activity?.onError(message)
    }

    override fun onError(resId: Int) {
        activity?.onError(resId)
    }

    override fun isNetworkConnected(): Boolean {
        if (activity != null) {
            return activity!!.isNetworkConnected()
        }
        return false
    }

    override fun onDetach() {
        activity = null
        super.onDetach()
    }

    override fun hideKeyBoard() {
        activity?.hideKeyBoard()
    }

    fun getActivityComponent(): ActivityComponent {
        return activity!!.activityComponent
    }

    fun getBaseActivity(): BaseActivity? {
        return activity
    }

    protected abstract fun setUp(view: View)
}
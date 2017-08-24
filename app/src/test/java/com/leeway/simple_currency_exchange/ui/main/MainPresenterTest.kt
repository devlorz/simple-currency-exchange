package com.leeway.simple_currency_exchange.ui.main

import com.leeway.simple_currency_exchange.data.DataManager
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.verify

/**
 * Created by Lee Lorz on 8/24/2017.
 */

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @Mock
    lateinit var mainView: MainContract.View

    @Mock
    lateinit var dataManager: DataManager

    lateinit var mainPresenter: MainPresenter<MainContract.View>

    val mockCurrentValue = "100"

    @Before
    @Throws(Exception::class)
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val compositeDisposable = CompositeDisposable()
        mainPresenter = MainPresenter(dataManager, compositeDisposable)
        mainPresenter.onAttach(mainView)

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun testButtonZeroClick() {
        mainPresenter.onBtnZeroClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "0")
    }

    @Test
    fun testButtonZeroClickOnZero() {
        mainPresenter.onBtnZeroClick("0")
        verify(mainView).setValue("0")
    }

    @Test
    fun testButtonOneClick() {
        mainPresenter.onBtnOneClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "1")
    }

    @Test
    fun testButtonTwoClick() {
        mainPresenter.onBtnTwoClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "2")
    }

    @Test
    fun testButtonThreeClick() {
        mainPresenter.onBtnThreeClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "3")
    }

    @Test
    fun testButtonFourClick() {
        mainPresenter.onBtnFourClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "4")
    }

    @Test
    fun testButtonFiveClick() {
        mainPresenter.onBtnFiveClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "5")
    }

    @Test
    fun testButtonSixClick() {
        mainPresenter.onBtnSixClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "6")
    }

    @Test
    fun testButtonSevenClick() {
        mainPresenter.onBtnSevenClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "7")
    }

    @Test
    fun testButtonEightClick() {
        mainPresenter.onBtnEightClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "8")
    }

    @Test
    fun testButtonNineClick() {
        mainPresenter.onBtnNineClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "9")
    }
}
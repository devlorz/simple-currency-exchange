package com.leeway.simple_currency_exchange.ui.main

import com.leeway.simple_currency_exchange.data.DataManager
import com.leeway.simple_currency_exchange.data.model.CurrencyList
import com.leeway.simple_currency_exchange.data.model.DailyExchageRate
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
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

    val mockCurrentValue = "10"
    val mockHundredValue = "100"

    @Before
    @Throws(Exception::class)
    fun setup() {
        MockitoAnnotations.initMocks(this)
        val compositeDisposable = CompositeDisposable()
        mainPresenter = MainPresenter(dataManager, compositeDisposable)
        mainPresenter.onAttach(mainView)
        var currecncyRate = CurrencyList(
                AUD = 2.0F,
                BGN = 2.0f,
                BRL = 2.0f,
                CAD = 2.0f,
                CHF = 2.0f,
                CNY = 2.0f,
                CZK = 2.0f,
                DKK = 2.0f,
                EUR = 2.0f,
                GBP = 2.0f,
                HKD = 2.0f,
                HRK = 2.0f,
                HUF = 2.0f,
                IDR = 2.0f,
                ILS = 2.0f,
                INR = 2.0f,
                JPY = 2.0f,
                KRW = 2.0f,
                MXN = 2.0f,
                MYR = 2.0f,
                NOK = 2.0f,
                NZD = 2.0f,
                PHP = 2.0f,
                PLN = 2.0f,
                RON = 2.0f,
                RUB = 2.0f,
                SEK = 2.0f,
                SGD = 2.0f,
                THB = 2.0f,
                TRY = 2.0f,
                USD = 2.0f,
                ZAR = 2.0f
        )
        var exchangeRate = DailyExchageRate(
                base = "THB",
                date = "test date",
                rates = currecncyRate)
        mainPresenter.dailyExchangeRate = exchangeRate

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
        verify(mainView).setExchangeValue("0")
    }

    @Test
    fun testButtonZeroClickOnHundredValue() {
        mainPresenter.onBtnZeroClick(mockHundredValue)
        verify(mainView).setValue("1,000")
    }

    @Test
    fun testButtonZeroClickOnDecimalValue() {
        mainPresenter.onBtnZeroClick("10.0")
        verify(mainView).setValue("10.00")
    }

    @Test
    fun testButtonOneClick() {
        mainPresenter.onBtnOneClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "1")
    }

    @Test
    fun testButtonOneClickOnHundredValue() {
        mainPresenter.onBtnOneClick(mockHundredValue)
        verify(mainView).setValue("1,001")
    }

    @Test
    fun testButtonTwoClick() {
        mainPresenter.onBtnTwoClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "2")
    }

    @Test
    fun testButtonTwoClickOnHundredValue() {
        mainPresenter.onBtnTwoClick(mockHundredValue)
        verify(mainView).setValue("1,002")
    }

    @Test
    fun testButtonThreeClick() {
        mainPresenter.onBtnThreeClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "3")
    }

    @Test
    fun testButtonThreeClickOnHundredValue() {
        mainPresenter.onBtnThreeClick(mockHundredValue)
        verify(mainView).setValue("1,003")
    }

    @Test
    fun testButtonFourClick() {
        mainPresenter.onBtnFourClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "4")
    }

    @Test
    fun testButtonFourClickOnHundredValue() {
        mainPresenter.onBtnFourClick(mockHundredValue)
        verify(mainView).setValue("1,004")
    }

    @Test
    fun testButtonFiveClick() {
        mainPresenter.onBtnFiveClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "5")
    }

    @Test
    fun testButtonFiveClickOnHundredValue() {
        mainPresenter.onBtnFiveClick(mockHundredValue)
        verify(mainView).setValue("1,005")
    }

    @Test
    fun testButtonSixClick() {
        mainPresenter.onBtnSixClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "6")
    }

    @Test
    fun testButtonSixClickOnHundredValue() {
        mainPresenter.onBtnSixClick(mockHundredValue)
        verify(mainView).setValue("1,006")
    }

    @Test
    fun testButtonSevenClick() {
        mainPresenter.onBtnSevenClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "7")
    }

    @Test
    fun testButtonSevenClickOnHundredValue() {
        mainPresenter.onBtnSevenClick(mockHundredValue)
        verify(mainView).setValue("1,007")
    }

    @Test
    fun testButtonEightClick() {
        mainPresenter.onBtnEightClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "8")
    }

    @Test
    fun testButtonEightClickOnHundredValue() {
        mainPresenter.onBtnEightClick(mockHundredValue)
        verify(mainView).setValue("1,008")
    }

    @Test
    fun testButtonNineClick() {
        mainPresenter.onBtnNineClick(mockCurrentValue)
        verify(mainView).setValue(mockCurrentValue + "9")
    }

    @Test
    fun testButtonNineClickOnHundredValue() {
        mainPresenter.onBtnNineClick(mockHundredValue)
        verify(mainView).setValue("1,009")
    }

    @Test
    fun testButtonDotClick() {
        mainPresenter.onBtnDotClick(mockCurrentValue)
        verify(mainView).setValue("10.")
    }

    @Test
    fun testButtonDotClickOnDotValue() {
        mainPresenter.onBtnDotClick("10.")
        verify(mainView).setValue("10.")
    }

    @Test
    fun testButtonDeleteClickOnNormalValue() {
        mainPresenter.onBtnDeleteClick("100")
        verify(mainView).setValue("10")
    }

    @Test
    fun testButtonDeleteClickOnDotValue() {
        mainPresenter.onBtnDeleteClick("10.0")
        verify(mainView).setValue("10.")
        mainPresenter.onBtnDeleteClick("1,000.0")
        verify(mainView).setValue("1,000.")
    }

    @Test
    fun testButtonDeleteClickOnThousandValue() {
        mainPresenter.onBtnDeleteClick("1,000,000")
        verify(mainView).setValue("100,000")
    }

    @Test
    fun testButtonDeleteClickOnSingleValue() {
        mainPresenter.onBtnDeleteClick("1")
        verify(mainView).setValue("0")
    }

    @Test
    fun testValidateNotMoreThanTenDigit() {
        mainPresenter.onBtnZeroClick("1,000,000,000")
        verify(mainView).showMoreThanTenDigitToast()
    }

    @Test
    fun testValidateNotMoreThanTenDigitOnDecimalValue() {
        mainPresenter.onBtnZeroClick("100,000,000.0")
        verify(mainView).showMoreThanTenDigitToast()
    }

    @Test
    fun testValidateNotMoreThanTwoDecimalPoint() {
        mainPresenter.onBtnZeroClick("10.00")
        verify(mainView).showMoreThanTwoDecimalToast()
    }

    @Test
    fun testOneClickOnZero() {
        mainPresenter.onBtnOneClick("0")
        verify(mainView).setValue("1")
        val newValue = 1 * mainPresenter.dailyExchangeRate!!.rates.JPY
        verify(mainView).setExchangeValue("2")
    }

    @Test
    fun testZeroClickOnHundredValue() {
        mainPresenter.onBtnZeroClick("100")
        verify(mainView).setValue("1,000")
        verify(mainView).setExchangeValue("2,000")
    }

    @Test
    fun testDeleteButtonClickOnThousandValue() {
        mainPresenter.onBtnDeleteClick("1,000")
        verify(mainView).setValue("100")
        verify(mainView).setExchangeValue("200")
    }

    @Test
    fun testDeleteButtonOnSingleValue() {
        mainPresenter.onBtnDeleteClick("1")
        verify(mainView).setValue("0")
        verify(mainView).setExchangeValue("0")
    }

    @Test
    fun testDotButtonClickOnThousandValue() {
        mainPresenter.onBtnDotClick("1,000")
        verify(mainView).setValue("1,000.")
        verify(mainView).setExchangeValue("2,000")
    }

    @Test
    fun testZeroButtonClickOnDotValue() {
        mainPresenter.onBtnZeroClick("1.")
        verify(mainView).setValue("1.0")
        verify(mainView).setExchangeValue("2")
    }

    @Test
    fun testFetchDataFromCurrencyExchangeAPI() {
//        val sampleDailyExchangeRate : DailyExchageRate
//        sampleDailyExchangeRate
//        doReturn(Observable.just())
//        mainPresenter.getExchangeRate()
    }

}
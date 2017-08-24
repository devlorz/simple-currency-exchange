package com.leeway.simple_currency_exchange.ui.main

import com.leeway.simple_currency_exchange.BuildConfig
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config
import org.junit.Assert.assertThat
import org.hamcrest.core.Is.`is`
import org.hamcrest.Matchers.notNullValue
import org.mockito.Mockito
import org.mockito.Mockito.verify

/**
 * Created by Lee Lorz on 8/23/2017.
 */

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,
        sdk = intArrayOf(21))
class MainActivityTest {

    lateinit var activityController: ActivityController<MainActivity>
    lateinit var activity: MainActivity

    lateinit var currentValue: String

    @Before
    @Throws(Exception::class)
    fun setup() {
        MockitoAnnotations.initMocks(this)
        activityController = Robolectric.buildActivity(MainActivity::class.java).create()
        activity = activityController.get()
        currentValue = activity.moneyFrom.text.toString()
    }

    @Test
    @Throws(Exception::class)
    fun testActivityIsNotNull() {
        assertThat(activity, `is`(notNullValue()))
    }

    @Test
    @Throws(Exception::class)
    fun testOnCreate() {
        assertThat(activity.mainPresenter, `is`(notNullValue()))
        Mockito.verify(activity.mainPresenter).onAttach(activity)
    }

    @Test
    @Throws(Exception::class)
    fun testHaveButtons() {
        assertThat(activity.btnZero, `is`(notNullValue()))
        assertThat(activity.btnOne, `is`(notNullValue()))
        assertThat(activity.btnTwo, `is`(notNullValue()))
        assertThat(activity.btnThree, `is`(notNullValue()))
        assertThat(activity.btnFour, `is`(notNullValue()))
        assertThat(activity.btnFive, `is`(notNullValue()))
        assertThat(activity.btnSix, `is`(notNullValue()))
        assertThat(activity.btnSeven, `is`(notNullValue()))
        assertThat(activity.btnEight, `is`(notNullValue()))
        assertThat(activity.btnNine, `is`(notNullValue()))
        assertThat(activity.btnDot, `is`(notNullValue()))
        assertThat(activity.btnDelete, `is`(notNullValue()))
    }

    @Test
    @Throws(Exception::class)
    fun testBtnZeroClick() {
        activity.btnZero.performClick()
        verify(activity.mainPresenter).onBtnZeroClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnOneClick() {
        activity.btnOne.performClick()
        verify(activity.mainPresenter).onBtnOneClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnTwoClick() {
        activity.btnTwo.performClick()
        verify(activity.mainPresenter).onBtnTwoClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnThreeClick() {
        activity.btnThree.performClick()
        verify(activity.mainPresenter).onBtnThreeClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnFourClick() {
        activity.btnFour.performClick()
        verify(activity.mainPresenter).onBtnFourClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnFiveClick() {
        activity.btnFive.performClick()
        verify(activity.mainPresenter).onBtnFiveClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnSixClick() {
        activity.btnSix.performClick()
        verify(activity.mainPresenter).onBtnSixClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnSevenClick() {
        activity.btnSeven.performClick()
        verify(activity.mainPresenter).onBtnSevenClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnEightClick() {
        activity.btnEight.performClick()
        verify(activity.mainPresenter).onBtnEightClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnNineClick() {
        activity.btnNine.performClick()
        verify(activity.mainPresenter).onBtnNineClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnDotClick() {
        activity.btnDot.performClick()
        verify(activity.mainPresenter).onBtnDotClick(currentValue)
    }

    @Test
    @Throws(Exception::class)
    fun testBtnDeleteClick() {
        activity.btnDelete.performClick()
        verify(activity.mainPresenter).onBtnDeleteClick(currentValue)
    }
}
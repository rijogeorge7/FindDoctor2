package com.rijogeorge.finddoctor2.ui.search

import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import com.rijogeorge.finddoctor2.MainActivity
import org.junit.Rule
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import com.rijogeorge.finddoctor2.R
import org.junit.Test


@RunWith(AndroidJUnit4::class)
@LargeTest
class SearchFragmentTest {

    @Rule
    @JvmField
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun screenLoadedAsIntended() {
        onView(withText(R.string.what_are_you_looking_for)).check(matches(isDisplayed()))
        onView(withText(R.string.enter_a_location)).check(matches(isDisplayed()))
        onView(withText(R.string.do_you_have_insurence)).check(matches(isDisplayed()))
        onView(withText(R.string.Find)).check(matches(isDisplayed()))
    }
}
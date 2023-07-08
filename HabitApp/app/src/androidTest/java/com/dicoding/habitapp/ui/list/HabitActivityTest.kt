package com.dicoding.habitapp.ui.list

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.dicoding.habitapp.R
import com.dicoding.habitapp.ui.add.AddHabitActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Habit (+), the AddHabitActivity displayed
@RunWith(AndroidJUnit4::class)
class HabitActivityTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(HabitListActivity::class.java)

    @Before
    fun setup() {
        Intents.init()
    }

    @Test
    fun testAddHabitButtonOpensAddHabitActivity() {
        onView(withId(R.id.fab)).perform(ViewActions.click())
        intended(hasComponent(AddHabitActivity::class.java.name))
        onView(withText("Add Habit")).check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
        Intents.release()
    }
}
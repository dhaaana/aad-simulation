package com.dicoding.todoapp.ui.list

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.add.AddTaskActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TaskActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(TaskActivity::class.java)

    @Before
    fun setup() {
        Intents.init()
    }


    @Test
    fun testAddTaskButtonOpensAddTaskActivity() {
        onView(withId(R.id.fab)).perform(click())
        intended(hasComponent(AddTaskActivity::class.java.name))
        onView(withText("Add Task")).check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
        Intents.release()
    }
}
package com.example.movieappv2.cucumber.espresso.mainactivity

import android.content.Intent
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.movieappv2.R
import com.example.movieappv2.ui.MainActivity
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anything


class MainActivityRobot {

    fun launchMainActitvity(testRule: ActivityTestRule<MainActivity>){
        testRule.launchActivity(Intent())
    }

    fun selectPopularGridViewElement(){
        Intents.init()
        onData(anything()).inAdapterView(withId(R.id.gvPopularFragment)).atPosition(0)
            .onChildView(withId(R.id.ivMovieImage)).perform(click())
        Intents.release()
    }

    fun selectTopRatedGridViewElement(){
        Intents.init()
        onData(anything()).inAdapterView(withId(R.id.gvTopRatedFragment)).atPosition(0)
            .onChildView(withId(R.id.ivMovieImage)).perform(click())
        Intents.release()
    }

    fun checkBottomNavigationView(){
        onView(withId(R.id.bottom_nav)).perform(click())
    }

    fun clickBottomNavigationView(){
        onData(allOf(withText(R.id.topRatedFragment), isDescendantOfA(withId(R.id.bottom_nav)), isDisplayed())).perform(
            click())
    }

}

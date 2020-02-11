package com.example.movieappv2.java.com.example.movieappv2.cucumber.steps

import androidx.test.rule.ActivityTestRule
import com.example.movieappv2.java.com.example.movieappv2.cucumber.espresso.mainactivity.MainActivityRobot
import com.example.movieappv2.ui.MainActivity
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then

class MainActivitySteps {

    private val robot = MainActivityRobot()

    private val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Given("^I am on the home screen$")
    fun i_am_on_the_home_screen() {
        robot.launchMainActitvity(activityRule)
    }

    @Then("^I see my navigation button and load all of the data$")
    fun bottom_nav_checker() {
        robot.checkBottomNavigationView()
    }

    @Then("^I tap on an item on the gridview and move into another page$")
    fun item_tapper() {
        robot.selectPopularGridViewElement()
    }

}


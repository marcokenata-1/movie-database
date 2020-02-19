package com.example.movieappv2.cucumber.steps

import androidx.test.rule.ActivityTestRule
import com.example.movieappv2.cucumber.espresso.mainactivity.MainActivityRobot
import com.example.movieappv2.ui.MainActivity
import com.example.movieappv2.utils.ActivityFinisher
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import org.junit.After

class MainActivitySteps : BaseSteps() {

    private val robot = MainActivityRobot()

    private val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        initMockWebServer()
        initializeMockWithDispatcher()
    }

    @After
    fun tearDown(){
        ActivityFinisher.finishOpenActivities()
    }

    @Given("^I am on the home screen$")
    fun i_am_on_the_home_screen() {
        robot.launchMainActitvity(activityRule)
        Thread.sleep(1000)
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


package com.example.movieappv2.java.com.example.movieappv2.test

import cucumber.api.CucumberOptions

@CucumberOptions(features = ["test.assets.features"],
    glue = ["test.java.com.sniper.movieappv2.cucumber.steps"],
    tags = ["@e2e", "@smoke"])
@SuppressWarnings("unused")
class CucumberTestCase

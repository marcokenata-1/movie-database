package com.example.movieappv2.test

import cucumber.api.CucumberOptions

@CucumberOptions(features = ["features"],
    glue = ["com.example.movieappv2.cucumber.steps"],
    tags = ["@e2e", "@smoke","@smok123"])
@Suppress("unused")
class CucumberTestCase

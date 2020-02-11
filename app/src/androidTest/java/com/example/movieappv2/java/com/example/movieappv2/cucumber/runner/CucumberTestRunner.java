package com.example.movieappv2.java.com.example.movieappv2.cucumber.runner;


import android.os.Bundle;

import androidx.test.runner.AndroidJUnitRunner;

import com.example.movieappv2.BuildConfig;

import cucumber.api.android.CucumberInstrumentationCore;

@SuppressWarnings("unused")
public class CucumberTestRunner extends AndroidJUnitRunner {

    private static final String CUCUMBER_TAGS_KEY = "tags";
    private static final String CUCUMBER_SCENARIO_KEY = "name";

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        String tags = BuildConfig.TEST_TAGS;
        if (!tags.isEmpty()) {
            bundle.putString(CUCUMBER_TAGS_KEY, tags.replaceAll("\\s", ""));
        }

        String scenario = BuildConfig.TEST_SCENARIO;
        if (!scenario.isEmpty()) {
            scenario = scenario.replaceAll(" ", "\\\\s");
            bundle.putString(CUCUMBER_SCENARIO_KEY, scenario);
        }
        instrumentationCore.create(bundle);
        super.onCreate(bundle);
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}

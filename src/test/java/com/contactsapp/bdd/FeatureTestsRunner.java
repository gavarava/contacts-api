package com.contactsapp.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    features = "features/health_check.feature",
    glue = "com.contactsapp.bdd"
)
public class FeatureTestsRunner {

}

package com.contactsapp.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    tags = {"~@ignore"},
    features = "features",
    glue = "com.contactsapp.bdd"
)
public class FeatureTestsRunner {

}

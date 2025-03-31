package com.qa.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="C:\\Users\\Dell\\eclipse-workspace1\\SauceLabsDemoApp\\Features\\Login_page.feature",
glue= {"com/qa/tests","hooks"},
plugin={"pretty","html:target/HtmlReports.html"}
)

public class Testrunner extends AbstractTestNGCucumberTests {

//	@DataProvider(parallel = true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
}

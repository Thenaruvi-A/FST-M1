package testRunner;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;

import io.cucumber.junit.platform.engine.Constants;

@Suite //to make the class a test suite
@IncludeEngines("cucumber")  // convert the suite j-unit to cucumber 
@SelectClasspathResource("Features") //where .feature is located
@ConfigurationParameter(  // property mentions where the step definitions are located
  key = Constants.GLUE_PROPERTY_NAME, //Constants is a class with all the constants // glue will always search in src test java file
  value = "stepDefinition") // match exactly the package name 
@ConfigurationParameter(     // from here  below are optional
  key = Constants.FILTER_TAGS_PROPERTY_NAME,
  value = "@activity6")     //tag which file or which all tags we wanna run

@ConfigurationParameter(  //reports - junit defaults ; json report bit  difficult to read, 
		//kinda permanent report
        key = Constants.PLUGIN_PROPERTY_NAME, // ACTICITY 7
        value = "pretty, html:Reports/HTML_Report.html, junit:Reports/XML_Report.xml, json:Reports/JSON_Report.json"
)
@ConfigurationParameter(    //temp report kind ,
        key = Constants.PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME,
        value = "true"
)

public class TestRunner {
	
}




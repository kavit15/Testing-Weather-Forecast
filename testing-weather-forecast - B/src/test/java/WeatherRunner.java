import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features="src/test/resources/ThreeHourForecast.feature",
	   // features="src/test/resources/Errormsg.feature",
		//features="src/test/resources/Forecastsummary.feature",
		//features="src/test/resources/FivedayForecast.feature",
		format={"pretty", "html:report/cucumber-html-report"}
		
		)

public class WeatherRunner {

}
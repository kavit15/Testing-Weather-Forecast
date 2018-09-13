import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WeatherSteps {
	
	WebDriver driver;

	@Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

  
    @Given("^the user is on weather forecast page$")
    public void OpenWeatherForecastPage() {
        driver.get("http://localhost:3000/");
    }
	
	
    @When("^user clicks on day1$")
    public void Day1() throws InterruptedException {
        driver.findElement(By.xpath("//span[@data-test='day-1']")).click();
       
        Thread.sleep(1000L);
    }

    
    @Then("^get three hourly forecast$")
    public void ThreeHourForecast() throws InterruptedException {
        Thread.sleep(200L);
        Assert.assertEquals(4, driver.findElements(By.xpath("//div[@id='root']/div/div[1]/div[@class='details']/div")).size());
    }
        

    @When("^user clicks on day1 again$")
    public void DayAgain() throws InterruptedException {
        driver.findElement(By.xpath("//span[@data-test='day-1']")).click();
        Thread.sleep(500L);
        driver.findElement(By.xpath("//span[@data-test='day-1']")).click();
    }
	
    @Then("^three hourly forecast should be hidden$")
    public void hidethreehourlyforecast() {

        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='root']/div/div[1]/div[@class='details']/div[@class='detail']")));

    }
	
    
    @When("^user input city name as: (.*)$")
    public void EnterCityName(String cityinput) {
        WebElement city = driver.findElement(By.name("city"));
        city.clear();
        city.sendKeys(cityinput, Keys.ENTER);
    }
    
	
    @Then("^summary should be displayed as follows$")
    public void displaysummary(DataTable hourlydata) {
        List<List<String>> dataList = hourlydata.raw();
        List<WebElement> detailRowList = driver.findElements(By.cssSelector(".details")).get(0).findElements(By.className("detail"));
        for (int rowIndex = 0; rowIndex < dataList.size(); rowIndex++) {
            List<String> expectedDataRow = dataList.get(rowIndex);
            WebElement detailRow = detailRowList.get(rowIndex);
            Assert.assertEquals(expectedDataRow.get(0), detailRow.findElement(By.className("hour")).getText());
            Assert.assertEquals(expectedDataRow.get(1), detailRow.findElement(By.cssSelector("svg[aria-label]")).getAttribute("aria-label"));
            Assert.assertTrue(detailRow.findElement(By.className("max")).getText().contains(expectedDataRow.get(2)));
            Assert.assertTrue(detailRow.findElement(By.className("min")).getText().contains(expectedDataRow.get(3)));
            Assert.assertEquals(expectedDataRow.get(4), detailRow.findElement(By.className("speed")).getText());
            Assert.assertEquals(expectedDataRow.get(5), detailRow.findElement(By.className("rainfall")).getText());
            Assert.assertEquals(expectedDataRow.get(6), detailRow.findElement(By.className("pressure")).getText());
        }
    }
	    
    
    @Then("^the forecast should have (.*)$")
    public void FiveDayForecast(String day) throws InterruptedException {
        Assert.assertEquals(5, driver.findElements(By.className("summary")).size());
        Assert.assertNotNull(driver.findElement(By.xpath("//div[@class='summary']/span/span[text()='" + day + "']")));
        Thread.sleep(1000L);
        driver.quit();
    }
    
    
    @Then("^error message is displayed")
    public void ErrorCase() throws InterruptedException{
        Assert.assertEquals("Error retrieving the forecast",
                driver.findElement(By.cssSelector("div[data-test='error']")).getText());
        Thread.sleep(1000L);
    }
    
    
    @When("^user clicks on next day$")
    public void NextDay() throws InterruptedException {
        driver.findElement(By.xpath("//span[@data-test='day-2']")).click();
        Thread.sleep(1500L);

    }

    
    @Then("^next day hourly forecast displayed$")
    public void NextDayForecast() {
        Assert.assertEquals(8, driver.findElements(By.xpath("//div[@id='root']/div/div[2]/div[@class='details']/div[@class='detail']")).size());
    }
    
    
    @After
    public void afterTest() {

        if (driver != null) {
            driver.quit();
        }
    }
    }
	
	


package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @Test
    public void testCase01() throws InterruptedException{
        System.out.println("TestCase Start");
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(2000);
        WebElement in=driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[1]"));
        in.click();
        in.sendKeys("Crio Learner");
        driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']")).sendKeys("I want to be the best QA Engineer!"+" "+Wrappers.getEpoch());
        driver.findElement(By.xpath("//div[@data-value='3 - 5']")).click();
        driver.findElement(By.xpath("//div[@id='i30']")).click();
        driver.findElement(By.xpath("//div[@id='i33']")).click();
        driver.findElement(By.xpath("//div[@id='i39']")).click();
        driver.findElement(By.xpath("(//div[@class='ry3kXd'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[text()='Mr'])[2]")).click();
        driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[2]")).sendKeys(Wrappers.getPastDate());
        driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[3]")).sendKeys("07");
        driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[4]")).sendKeys("30");
        driver.findElement(By.xpath("//div[@aria-label='Submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vHW8K']")));
        WebElement success=driver.findElement(By.xpath("//div[@class='vHW8K']"));
        System.out.println(success.getText());

    }
    
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    

    @AfterTest
    public void endTest()
    {
        
        driver.close();
        driver.quit();

    }
}
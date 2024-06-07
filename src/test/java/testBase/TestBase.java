package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class TestBase {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;


    @BeforeClass(groups = {"sanity", "master"})
    @Parameters({"os", "browser"})
    public void Setup(String os, String br) throws IOException {

        //Load Properties file
        FileReader file = new FileReader(".\\src\\test\\logResources\\config.properties");
        p = new Properties();
        p.load(file);

        //Loading log4j2 file
        logger = LogManager.getLogger(this.getClass());


        //For running Remotely

        if(p.getProperty("execution_env").equalsIgnoreCase("remote")){

            DesiredCapabilities capabilities = new DesiredCapabilities();

            if(os.equalsIgnoreCase("windows")){
                capabilities.setPlatform(Platform.WINDOWS);
            }
            else if(os.equalsIgnoreCase("mac")){
                capabilities.setPlatform(Platform.MAC);
            }
            else{
                System.out.println("No matching OS");
                return;
            }

            switch (br.toLowerCase()){
                case "chrome" :
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge" :
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                default:
                    System.out.println("NO matching browser");
                    return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        }
        else if(p.getProperty("execution_env").equalsIgnoreCase("local")){
                //For running locally
            switch (br.toLowerCase()){
                case "chrome" :
                    driver = new ChromeDriver();
                    WebDriverManager.chromedriver().setup();
                    break;
                case "edge" :
                    driver = new EdgeDriver();
                    WebDriverManager.edgedriver().setup();
                    break;
                default:
                    System.out.println("NO matching browser");
                    return;
            }

        }

        //WebDriverManager.chromedriver().setup();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @AfterClass(groups = {"sanity", "master"})
    public void closeBrowser() {
        driver.quit();
    }

    public String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(7);
        return generatedString;
    }

    public String randomNumber() {
        String generatedNumber = RandomStringUtils.randomNumeric(7);
        return generatedNumber;
    }

    public String randomAlphaNumeric() {
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        String generatedString = RandomStringUtils.randomAlphabetic(4);
        return generatedNumber + "@" + generatedString;
    }

    public void takeScreenShots(String imageLocation) throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("C:\\Users\\User1\\IdeaProjects\\SauceDemoProject\\Screenshots" + imageLocation);
        FileHandler.copy(src, target);

    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        //sourceFile.renameTo(targetFile);
        FileHandler.copy(sourceFile, targetFile);

        return targetFilePath;
    }


}

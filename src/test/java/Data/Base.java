package Data;

import com.google.common.io.Files;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public abstract class Base {

    protected WebDriver driver;

    @BeforeEach
    public void Iniciar() {

        System.setProperty("wedriver.chrome.driver", "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterEach
    public void Cerrar() {

        if (driver != null) {
            driver.quit();
        }
    }

    public void TomarScreenshot(WebDriver webDriver, String fileWithPath) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) webDriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        Files.copy(SrcFile, DestFile);

    }

}

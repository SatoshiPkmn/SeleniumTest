import com.google.common.io.Files;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class Prueba {

    private WebDriver driver;

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

    @Test

    public void Login() throws Exception {

        //Abrir Navegador
        driver.get("https://the-internet.herokuapp.com/login");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\SS\\Pass\\Paso 1 Abrir.png");

        //Igresar Usuario
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\SS\\Pass\\Paso 2 Insert User.png");

        //Ingresar Contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\SS\\Pass\\Paso 3 Insert Password.png");

        //Dar click al botón Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\SS\\Pass\\Paso 4 Log In.png");

        String msgLogin = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        String title = driver.findElement(By.xpath("//div//h2")).getText();
        String desc = driver.findElement(By.xpath("//div//h4")).getText();

        String msgExpected = "You logged into a secure area!";
        String msgTitle = "Secure Area";
        String msgDesc = "Welcome to the Secure Area. When you are done click logout below.";

        //Validar Pantalla
        Assertions.assertAll(
            () -> assertTrue(msgLogin.contains (msgExpected),"Se obtuvo: " + msgLogin + "-> Se esperaba: " + msgExpected),
            () -> assertTrue(title.contains (msgTitle),"Se obtuvo: " + title + "-> Se esperaba: " + msgTitle),
            () -> assertTrue(desc.contains (msgDesc),"Se obtuvo: " + desc + "-> Se esperaba: " + msgDesc)
        );
    }

    @Test

    public void LoginError() throws Exception {

        //Abrir Navegador
        driver.get("https://the-internet.herokuapp.com/login");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\SS\\Fail\\Paso 1 Abrir.png");

        //Igresar Usuario
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("User");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\SS\\Fail\\Paso 2 Insert User.png");

        //Ingresar Contraseña
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\SS\\Fail\\Paso 3 Insert Password.png");

        //Dar click al botón Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\SS\\Fail\\Paso 4 Log In.png");

        String msgError = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        String msgExpected = "Your username is invalid!";

        assertTrue(msgError.contains(msgExpected), "Se obtuvo: " + msgError + "-> Se esperaba: " + msgExpected);

    }
}

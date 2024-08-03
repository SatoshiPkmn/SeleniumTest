package Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebElements {

    private WebDriver driver;
    private Wait wait;

    @FindBy (id="username")
    private WebElement userLocator;

    @FindBy (id="password")
    private WebElement passLocator;

    @FindBy (xpath="//button[@type='submit']")
    private WebElement buttonLogin;

    @FindBy (id="flash")
    private WebElement msgLogin;

    public WebElements(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void writeUser(String userText){

        userLocator.sendKeys(userText);

    }

    public void writePass(String passText){

        passLocator.sendKeys(passText);

    }

    public void clickButton (){

        buttonLogin.click();

    }

    public void validateMsg(String msgExpected){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")));
        assertTrue(msgLogin.getText().contains(msgExpected), "Se obtuvo: " + msgLogin    + "-> Se esperaba: " + msgExpected);

    }

}

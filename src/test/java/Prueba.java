import Data.Base;
import Data.WebElements;
import org.junit.jupiter.api.Test;

public class Prueba extends Base {

        @Test

    public void Login() throws Exception {

        WebElements elements = new WebElements(driver);

        //Abrir Navegador
        driver.get("https://the-internet.herokuapp.com/login");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\Screenshots\\Pass\\Paso 1 Abrir.png");

        //Igresar Usuario
        elements.writeUser("tomsmith");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\Screenshots\\Pass\\Paso 2 Insert User.png");

        //Ingresar Contraseña
        elements.writePass("SuperSecretPassword!");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\Screenshots\\Pass\\Paso 3 Insert Password.png");

        //Dar click al botón Login
        elements.clickButton();
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\Screenshots\\Pass\\Paso 4 Log In.png");

        //Validar Mensaje
        elements.validateMsg("You logged into a secure area!");
    }

    @Test

    public void LoginError() throws Exception {

        WebElements elements = new WebElements(driver);

        //Abrir Navegador
        driver.get("https://the-internet.herokuapp.com/login");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\Screenshots\\Fail\\Paso 1 Abrir.png");

        //Igresar Usuario
        elements.writeUser("User");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\Screenshots\\Fail\\Paso 2 Insert User.png");

        //Ingresar Contraseña
        elements.writePass("Password");
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\Screenshots\\Fail\\Paso 3 Insert Password.png");

        //Dar click al botón Login
        elements.clickButton();
        this.TomarScreenshot(driver, "C:\\Users\\pavrp\\IdeaProjects\\Prueba\\src\\test\\Screenshots\\Fail\\Paso 4 Log In.png");

        //Validar Mensaje
        elements.validateMsg("Your username is invalid!");
    }
}

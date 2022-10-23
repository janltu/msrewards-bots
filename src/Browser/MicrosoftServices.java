package Browser;

import Accounts.User;
import Debug.ConsoleOut;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MicrosoftServices {
    public static void LogIn(WebDriver driver, User user){
        driver.get("https://login.live.com/");

        WebElement mailInputField = null;
        try{
            By searchParams = By.id("i0116");
            mailInputField = driver.findElement(searchParams);
        }catch(NoSuchElementException e){
            ConsoleOut.Error("Element [" + e + "] could not be found");
        }

        if(mailInputField == null)
            return;

        mailInputField.sendKeys(user.Mail);
    }
}

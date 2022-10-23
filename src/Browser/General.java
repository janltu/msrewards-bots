package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.File;

public class General {
    public static WebDriver StartDriver() {
        char sep = File.separatorChar;

        // Check for Operating System
        String driverFileName;
        if (sep == '/')
            driverFileName = "msedgedriver_linux";
        else
            driverFileName = "msedgedriver_windows.exe";

        // Add driver path and start
        System.setProperty("webdriver.edge.driver", "." + sep + "driver" + sep + driverFileName);
        WebDriver driver = new EdgeDriver();

        return driver;
    }
}

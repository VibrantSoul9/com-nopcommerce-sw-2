package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
        public class BaseTest {
        public static String browser = "Chrome";
        public static WebDriver driver;
        static String baseUrl = "https://demo.nopcommerce.com/";
        public  void openBrowser(String baseURl) {
        if (browser.equalsIgnoreCase("Chrome")) {
            //launch the Chrome browser
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
            // open the URl in browser
            driver.get(baseUrl);
            // Maximise the browser
            driver.manage().window().maximize();
            // give implicit wait to driver
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        public void closeBrowser() {
            driver.close();
            }
        }


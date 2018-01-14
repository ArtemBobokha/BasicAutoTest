import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.Assert;


public class JiraTests {
    public static WebDriver browser;

    @BeforeMethod
    public static void OpenPage(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Temskii\\Desktop\\test\\BasicAutoTest\\bin\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.get("http://jira.hillel.it:8080");
    }

    @AfterMethod
    public static void CloseBrowser() {
        browser.close();
    }

    @Test
    public static void IncorrectLogIn(){
        browser.findElement(By.cssSelector("input[name=os_username]")).sendKeys("abobokha");
        //Find  password input
        browser.findElement(By.cssSelector("input[name=os_password]")).sendKeys("4159692124");
        //Find login input
        browser.findElement(By.cssSelector("input[name='login']")).click();
        String ErrorMessage = browser.findElement(By.cssSelector("input[name=login]")).getText();
        System.out.println(ErrorMessage);
    }

    @Test
    public static void CorrectLogIn(){
        browser.findElement(By.cssSelector("input[name=os_username]")).sendKeys("abobokha");
        browser.findElement(By.cssSelector("input[name=os_password]")).sendKeys("4159692125");
        browser.findElement(By.cssSelector("input[name='login']")).click();
        //Check user name
        String Name = browser.findElement(By.cssSelector("a[id='header-details-user-fullname']")).getAttribute("data-displayname");
        Assert.assertEquals(Name, "Artem Bobokha");
    }

    @Test
    public static void CreateIssue() throws InterruptedException {
        browser.findElement(By.cssSelector("input[name=os_username]")).sendKeys("abobokha");
        browser.findElement(By.cssSelector("input[name=os_password]")).sendKeys("4159692125");
        browser.findElement(By.cssSelector("input[name='login']")).click();
        browser.findElement(By.id("create_link")).click();
        Thread.sleep(3000);
        browser.findElement(By.cssSelector("input[name=summary]")).sendKeys("Fatal error during enroll device");
        browser.findElement(By.cssSelector("input[id='create-issue-submit']")).click();
        Thread.sleep(7000);

    }

    @Test
    public static void LogOff() throws InterruptedException {
        browser.findElement(By.cssSelector("input[name=os_username]")).sendKeys("abobokha");
        browser.findElement(By.cssSelector("input[name=os_password]")).sendKeys("4159692125");
        browser.findElement(By.cssSelector("input[name='login']")).click();
        browser.findElement(By.id("header-details-user-fullname")).click();
        browser.findElement(By.id("log_out")).click();
        Thread.sleep(3000);
        String logoff = browser.findElement(By.id("user-options")).getText();
        Assert.assertEquals(logoff,"Log In");
    }
    }





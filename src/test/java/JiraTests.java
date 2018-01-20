import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.Assert;



public class JiraTests {
    private static WebDriver browser;

    @BeforeMethod
    public static void OpenPage(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Temskii\\Desktop\\test\\BasicAutoTest\\bin\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.get("http://jira.hillel.it:8080");
    }

    @AfterMethod
    public static void CloseBrowser() {
//        browser.close();
    }

    @Test
    public static void IncorrectLogIn(){
        LogIn("abobokha","4159692124");
        String ErrorMessage = browser.findElement(By.cssSelector("input[name=login]")).getText();
        System.out.println(ErrorMessage);

    }

    @Test
    public static void CorrectLogIn() throws InterruptedException {
        LogIn("abobokha","4159692125");
        Thread.sleep(3000);
//        Check user name
        String Name = browser.findElement(By.cssSelector("a[id='header-details-user-fullname']")).getAttribute("data-displayname");
        Assert.assertEquals(Name, "Artem Bobokha");
    }

    @Test
    public static void CreateIssue() throws InterruptedException {
        LogIn("abobokha","4159692125");
        browser.findElement(By.id("find_link")).click();
        Thread.sleep(1000);
        browser.findElement(By.id("filter_lnk_reported_lnk")).click();
        Thread.sleep(3000);
        String issueBefore = browser.findElement(By.className("results-count-total")).getText();
        Integer  countIssueBefore = Integer.parseInt(issueBefore);
        String title = "Fatal error during enroll device";
        browser.findElement(By.id("create_link")).click();
        Thread.sleep(3000);
        browser.findElement(By.cssSelector("input[name=summary]")).sendKeys(title);
        browser.findElement(By.cssSelector("input[id='create-issue-submit']")).click();
        Thread.sleep(4000);
        browser.findElement(By.className("aui-iconfont-refresh-small")).click();
        String issueAfter = browser.findElement(By.className("results-count-total")).getText();
        Integer  countIssueAfter = Integer.parseInt(issueAfter)-1;
        Assert.assertEquals(countIssueBefore  ,countIssueAfter);

    }

    @Test
    public static void LogOff() throws InterruptedException {
        LogIn("abobokha","4159692125");
        Thread.sleep(3000);
        ClickMenuItem(By.id("header-details-user-fullname"),By.id("log_out"));
        Thread.sleep(3000);
        String logoff = browser.findElement(By.id("user-options")).getText();
        Assert.assertEquals(logoff,"Log In");
    }
    private static void ClickMenuItem(By menuSelector, By itemSelector){
        browser.findElement(menuSelector).click();
        browser.findElement(itemSelector).click();
    }
    private static void LogIn(String userName, String password){

        browser.findElement(By.cssSelector("input[name=os_username]")).sendKeys(userName);
        browser.findElement(By.cssSelector("input[name=os_password]")).sendKeys(password);
        browser.findElement(By.cssSelector("input[name='login']")).click();
    }
    }





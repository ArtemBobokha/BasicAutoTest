import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.io.File;

public class BoxTest {
    private static WebDriver browser;

    @BeforeMethod
    public static void OpenPage() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Temskii\\Desktop\\test\\BasicAutoTest\\bin\\geckodriver.exe");
        browser = new FirefoxDriver();
        browser.get("https://account.box.com/login");
        EnterValue("temskii17@rambler.ru");
        Thread.sleep(2000);
        NextButton();

        EnterValue1("4159692125");
        Thread.sleep(2000);
        NextButton();
    }

    @AfterMethod
    public static void CloseBrowser() {
//        browser.close();
    }
    @Test
    public static void UploadFile() throws InterruptedException {


    }





    @Test
    public static void DownloadFile() throws InterruptedException {

        Thread.sleep(2000);
        browser.findElement(By.xpath("//*[contains(@class,'file-list-name')][1]")).click();
        Thread.sleep(2000);

        WebElement downloadButton = browser.findElement(By.xpath("//*[contains(@class,'download-btn')]"));
        downloadButton.click();
//        driver.switchTo().alert().accept();





    }
    private static void EnterValue(String value){
        browser.findElement(By.className("inp-full-width")).sendKeys("temskii17@rambler.ru");
    }
    private static void EnterValue1(String value) {
        browser.findElement(By.className("inp-full-width")).sendKeys("4159692125");
    }
    private static void NextButton(){
        WebElement next = browser.findElement(By.className("form-buttons"));
        next.click();
    }
//    private static void CheckFileLocation(){
//        String path, file;
//        path = "C:\\Downloads";
//        File f = new File(path+".");
//        file = "OK.jpg";
//        File[] files = f.listFiles();
//        for(int i = 0; i < files.length; i++) {
//            Assert.assertTrue(files[i].toString().equals(path+".\\"+file) && files[i].isFile());
//        }
//    }
    }


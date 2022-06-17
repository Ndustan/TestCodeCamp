//locate where the chromedriver is
        //1- Open your Chrome browser
        //2- Input the Konga Webapp URL
        //3- Maximize the browser
        //4- Get the page title
        //5- Click on the log-in/sign-up button
        //6- Input your username
        //7- Input your password in the password field
        //8- Click on the login button
        //9- Logout of the account
        //10- Quit the browser
package src.main.webapp.konga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Konga_Test {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test ()
    //Verify that user is able to launch Url successfully
    public void launch_correct_Url() throws InterruptedException {
        driver.get("https://konga.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test (priority = 1)
    //Verify that the user is able to log in by entering valid credentials and clicking on the ‘Login’ button
    public void successful_login() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).sendKeys("testifyproject@qa.team");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("testifyproject");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }
    @Test (priority = 2)
    //Verify that user can log out successfully on clicking the log-out button
    public void successful_logout() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        Thread.sleep(3000);
    }
    @Test (priority = 3)
    //Verify if a user will not be able to log in with an invalid username and invalid password
    public void invalid_credentials() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("username")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("testifyabc@qa.team");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("testify");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }
    @Test (priority = 4)
    //Verify if a user will not be able to log in with empty username/password fields
    public void empty_fields() throws InterruptedException {
        driver.findElement(By.id("username")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }
    @Test (priority = 5)
    //Verify if a user will not be able to log in with either of username/password field empty
    public void empty_username_field() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("testifyproject");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }
    @Test (priority = 6)
    //Verify if a user will not be able to log in with either of username/password field empty
    public void empty_password_field() throws InterruptedException {
        driver.findElement(By.id("username")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("testifyproject@qa.team");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    }
    @AfterTest
    public void close_browser(){
        driver.close();
    }
}
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Homework_28 {
    public static WebDriver driver;

    @Test
    public void login() throws InterruptedException {
        // Load chromedriver
        System.setProperty("webdriver.chrome.driver","c:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        //Open the webpage
        driver.manage().window().maximize();
        driver.get("http://users.bugred.ru/user/login/index.html");

        // Login with existing username
        driver.findElement(By.name("login")).sendKeys("ghost@ukr.net");
        driver.findElement(By.name("password")).sendKeys("12345");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input")).click();

        // Search for "Users" element on the opened page
        WebElement users = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        // Check "Users" page is opened.
        Assert.assertEquals(true, users.isDisplayed());

        // Find username of the logged in user in the user database.
        driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[4]/td/input")).sendKeys("ghost@ukr.net");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[5]/td[1]/button")).click();
        WebElement username = driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr/td[7]/a"));
        Assert.assertEquals(true, username.isDisplayed());
        Thread.sleep(3000);
        // Logout
        driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/ul/li[3]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a")).click();
        Thread.sleep(3000);

        // Register new user
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/input")).sendKeys("Superghost");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[2]/td[2]/input")).sendKeys("ghost22@ukr.net");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[3]/td[2]/input")).sendKeys("qwe123");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[4]/td[2]/input")).click();

        // Check created user exist
        driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[4]/td/input")).sendKeys("Superghost");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[5]/td[1]/button")).click();
        WebElement NewUsername = driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr/td[7]/a"));
        Assert.assertEquals(true, NewUsername.isDisplayed());

        // Open the personal account page
        driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/ul/li[1]/a")).click();
        Thread.sleep(3000);
        // Change personal information
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[2]/td[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[2]/td[2]/input")).sendKeys("Смекайло Иван Петрович");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[3]/td[2]/select")).sendKeys("Мужской");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[4]/td[2]/input")).sendKeys("21.02.1987");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[5]/td[2]/input")).sendKeys("15.01.2020");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[6]/td[2]/textarea")).sendKeys("Fishing");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[7]/td[2]/input")).sendKeys("807586952487");
        // Save personal information
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[2]/form/table/tbody/tr[8]/td[2]/input")).click();
        Thread.sleep(3000);
        // Check the user name is saved
        WebElement NewUsername2 = driver.findElement(By.linkText("Смекайло Иван Петрович"));
        Assert.assertEquals(true, NewUsername2.isDisplayed());
    }

}

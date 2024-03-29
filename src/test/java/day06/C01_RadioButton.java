package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_RadioButton {
    WebDriver driver;
//Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
//https://www.facebook.com adresine gidin
    @Test
    public void test(){
        driver.get("https://www.facebook.com");

//“Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
//“radio buttons” elementlerini locate edin
  WebElement femaleButtonWE= driver.findElement(By.xpath("//input[@value='1']"));
  WebElement maleButtonWE= driver.findElement(By.xpath("//input[@value='2']"));
  WebElement customButtonWE=driver.findElement(By.xpath("//input[@value='-1']"));
//Secili degilse cinsiyet butonundan size uygun olani secin
        if(!maleButtonWE.isSelected()){
            maleButtonWE.click();
        }


} }

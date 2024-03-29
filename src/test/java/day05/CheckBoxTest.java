package day05;

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

public class CheckBoxTest {
    /*
      1. Bir class oluşturun : CheckBoxTest
      2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
      a. Verilen web sayfasına gidin.
      https://the-internet.herokuapp.com/checkboxes
      b. Checkbox1 ve checkbox2 elementlerini locate edin.
      c. Checkbox1 seçili değilse onay kutusunu tıklayın
      d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test1(){
        driver.get(" https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 =driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 =driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }
        if(!checkBox2.isSelected()){
            checkBox2.click();
        }
    }
    @After
    public void tearDown(){
        driver.close();
    }
}

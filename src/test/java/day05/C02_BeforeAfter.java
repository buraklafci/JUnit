package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver;
    @Before
    //Before notasyonunu her testen onc calisir
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void method1(){
        //1 defa before methodu calisir
        driver.get("https://amazon.com");
        //1 defa da after methodu calisir
    }
    @Test
    public void method2(){

        driver.get("https://techproeducation.com");

    }
    @Test
    public void method3(){

        driver.get("https://hepsiburada.com");

    }
    @After
    //After notasyonu her testten sonra calisir
    public void tearDown(){
       driver.close();
    }
}

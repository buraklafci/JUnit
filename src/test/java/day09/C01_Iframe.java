package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_Iframe {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
        @Test
        public void test1() throws InterruptedException {
            //● https://the-internet.herokuapp.com/iframe adresine gidin.
            driver.get("https://the-internet.herokuapp.com/iframe");
            //       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
            WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
            Assert.assertTrue(iframeYazisi.isDisplayed());
            System.out.println(iframeYazisi.getText());
            //       ○ Text Box’a “Merhaba Dunya!” yazin.
            WebElement textBox = driver.findElement(By.id("mce_0_ifr")); // Frame'e geçiş yapmadan önce orayı id ile locate ederiz
            driver.switchTo().frame(textBox); // Locate ettiğimiz frame geçmek için bu methodu kullanırız
            WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
            textBoxFrame.clear(); // Clear methodu text box'ın içini temizler
            Thread.sleep(2000);
            textBoxFrame.sendKeys("Merhaba Dunya!");
            //       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
            driver.switchTo().defaultContent();//Iframe'den cikip ana sayfaya gecmek icin bu method kullanilir
        WebElement elemantal=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elemantal.isDisplayed());
            System.out.println(elemantal.getText());
            //         dogrulayin ve konsolda yazdirin
    }
    @After
    public void tearDown() {
        driver.close();
    }
    }


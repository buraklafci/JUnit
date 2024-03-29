package day09;

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
import java.util.List;

public class IframeTest02 {
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


//http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    driver.get("http://demo.guru99.com/test/guru99home/");
//sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayisi=driver.findElements(By.xpath("//iframe"));
        System.out.println(iframeSayisi.size());
//ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframeGiris=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/RbSlW8jZFe8']"));
        driver.switchTo().frame(iframeGiris);  //Iframe taginin icine girerek mudahale edebiliriz
        WebElement iframe= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        iframe.click();
        Thread.sleep(5000);
//ilk iframe'den çıkıp ana sayfaya dönünüz
       driver.switchTo().defaultContent();
        driver.navigate().refresh();
//ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
//tıklayınız.
     //   WebElement iframeGiris2=driver.findElement(By.xpath("//iframe[@src='ads.html']"));
        driver.switchTo().frame("a077aa5e");  //id veya name ile giris

        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

     }
    @After
    public void tearDown() {
      //  driver.quit();
    }
}

package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04 {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void test1(){
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        /*
Bir web sitesine gittigimizde bir webelementi tikladigimizda yeni bir sekme ya da pencere acilirsa
buyeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() methodunu bir ArrayList'e
atip butun sayfalarin listesine ulasabiliriz. Ilk actigim pencerenin index'i 0'dır,ikinci acilan sekmenin index'i 1'dir
ve ikinci acilan pencere veya sekmede islem yapabilmek icin
driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
 */
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Window Handle Değerleri = "+ windowList);
        driver.switchTo().window(windowList.get(1));

    /*
    Set<String> windowHandleseti= driver.getWindowHandles();
    System.out.println(windowHandleseti);
    String ikinciSayfaWindowHandleDegeri="";
    for (String each: windowHandleseti) {
        if (!each.equals(ilkSayfaWindowHandleDegeri)){
            ikinciSayfaWindowHandleDegeri=each;
        }
    }
     */

    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals(driver.getTitle(),"New Window");
    //Sayfadaki textin “New Window” olduğunu doğrulayın.
       Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }
}
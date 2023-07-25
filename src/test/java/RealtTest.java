import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RealtTest {

    @Test
    public void testRealt() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://realt.by/");

        // тип жилья
        driver.findElement(By.name("tx_uedbmenu_pi1[s][table_id]")).click();
        driver.findElement(By.xpath("//option[@value='2001:daily']")).click();

        // кол-во комнат
        driver.findElement(By.id("rooms")).click();
        driver.findElement(By.xpath("//select[@id='rooms']/option[@value='1']")).click();

        // стоимость
        driver.findElement(By.className("dropdown-price")).click();
        driver.findElement(By.name("tx_uedbmenu_pi1[s][price][ge]")).sendKeys("100");
        driver.findElement(By.name("tx_uedbmenu_pi1[s][price][le]")).sendKeys("200");
        driver.findElement(By.className("dropdown-price")).click();

        // город
        driver.findElement(By.id("select2-selectRegionResidential-container")).click();
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Минск" + Keys.ENTER);

        // кнопка Найти
        driver.findElement(By.xpath("//a[@class='common-search-submit btn btn-primary']")).click();

        // цена карточки из спсика выдачи посика
        String actual = driver.findElement(By.xpath("//span[@class='text-title font-semibold md:mr-1 mr-2 md:mb-1 mb-0.5 text-basic-900 bg-primary-300 px-1.5 py-0.5 rounded-sm md:px-2']")).getText();
        System.out.println(actual);

        Assert.assertEquals(actual, "151 р./сут.");

        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }

        driver.quit();
    }
}

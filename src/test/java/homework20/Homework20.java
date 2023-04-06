package homework20;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework20 {
    private static WebDriver driver;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openTelemartPcConfigurator() throws InterruptedException {
        // Переход на сайт
        driver.get("https://telemart.ua/ua/");
        // Переход на страницу конфигуратора пк
        driver.findElement(By.xpath("//*[@id=\"index\"]/div[1]/div[1]/div/header/div[2]/div/div/div[1]/div[1]/div[3]/ul/li[1]/a")).click();
        Thread.sleep(1000);
        // Клик по началу сборки с нуля
        driver.findElement(By.xpath("//*[@id=\"assembly_start\"]/div[1]/div[1]/div/div[3]/div[1]/ul/li[1]/a")).click();
        Thread.sleep(1000);
        // Клик по полю выбора услуги сборки пк
        driver.findElement(By.xpath("//*[@id=\"assembly\"]/div[1]/div/div[1]/div[7]/div[1]/div[1]/div[2]/span")).click();
        Thread.sleep(1000);
        // Добавить услугу сборки
        driver.findElement(By.cssSelector("#serv-desc-a89819 > div > div.b-text > a")).click();
        Thread.sleep(1000);
        // Нажать купить сборку
        driver.findElement(By.cssSelector("#collapseLineContent > div > div > div.b-cfbl-btn-col > a")).click();
        Thread.sleep(1000);
        // Закрыть модалку
        driver.findElement(By.cssSelector("#popupBasketAddContent > button")).click();
    }

    @Test
    public void testCarouselCheck() throws InterruptedException {
        // Переход на сайт
        driver.get("https://telemart.ua/ua/");

        // Пролистать новости в карусели
        driver.findElement(By.cssSelector("#mnpCarousel > div.b-mnp-slider-nav > a.b-carousel-right")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#mnpCarousel > div.b-mnp-slider-nav > a.b-carousel-right")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#mnpCarousel > div.b-mnp-slider-nav > a.b-carousel-right")).click();
        Thread.sleep(1000);
        // Перейти на новость
        driver.findElement(By.cssSelector("#mnpCarousel > div.carousel-inner > div:nth-child(4) > div > a > img")).click();
        Thread.sleep(2000);
        // Вернуться на главную
        driver.findElement(By.cssSelector("#promo > div.b-wrap-all > div.b-wrap-all-tr > div > header > div.b-header-mid-side > div > div.col-lg-3.col-md-3 > div > a")).click();
        //driver.findElement(By.xpath("//*[@id=\"promo\"]/div[1]/div[1]/div/header/div[1]/div/div[1]/div/a")).click();
    }

}

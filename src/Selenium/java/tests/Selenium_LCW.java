package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Selenium_LCW {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();


        WebElement Login = driver.findElement(By.xpath("//div[@class='dropdown cart-dropdown']/a/span[@class='dropdown-label']"));
        Login.click();


        WebElement Email = driver.findElement(By.xpath("//div/input[@placeholder='E-Posta Adresiniz']"));
        Email.click();
        Email.sendKeys("enes.aksoy54@hotmail.com");

        WebElement Password = driver.findElement(By.xpath("//div/input[@placeholder='Şifreniz']"));
        Password.click();
        Password.sendKeys("Enes1234");

        WebElement LoginLink = driver.findElement(new By.ByCssSelector(".button[id='loginLink']"));
        LoginLink.click();

        WebElement searchBox = driver.findElement(new By.ByCssSelector(".searchBox[id='search_input']"));
        searchBox.click();
        searchBox.sendKeys("Pantolon");

        WebElement searchButton = driver.findElement(new By.ByCssSelector(".searchButton[type='button']"));
        searchButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,10000)", "");

        WebElement pageIndex = driver.findElement(new By.ByCssSelector(".lazy-load-current[id='pageIndex']"));
        pageIndex.click();


        WebElement randomChoose = driver.findElement(By.xpath("//div/a[starts-with(@id,'model')]"));
        randomChoose.click();

        WebElement size = driver.findElement(By.xpath("//div/a[@size='38']"));
        size.click();


        WebElement addtoCart = driver.findElement(By.id("pd_add_to_cart"));
        addtoCart.click();


        String listprice = driver.findElement(By.xpath("//div[@class='col-xs-12 price-area']/div/div/span[@class='price']")).getText();
        System.out.println("Ürünün liste fiyatı: " + listprice + "'dir.");

        WebDriverWait wait = new WebDriverWait(driver, 5);


        WebElement Cart = driver.findElement(By.xpath("//div[@class='col-sm-4 col-xs-4 header-cart-section']/a[@class='header-cart']"));
        Cart.click();

        String cartprice = driver.findElement(By.xpath("//div/span[@class='rd-cart-item-price mb-15']")).getText();
        System.out.println("Ürünün sepetteki fiyatı: " + cartprice + "'dir.");

        if(listprice.equals(cartprice)) {
            System.out.println("Ürünün liste fiyatı ile sepetteki tutarı aynıdır..");
        }
        else
            System.out.println("Ürünün liste fiyatı ile sepetteki tutarı aynı değildir..");

        WebElement AddQty = driver.findElement(By.xpath("//a[@class='oq-up plus']"));
        AddQty.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String value = driver.findElement(By.xpath("//div/input[@class='item-quantity-input ignored']")).getAttribute("Value");
        int LastQty = Integer.parseInt(value);
        LastQty++;
        System.out.println("Ürün " + LastQty + " tanedir.");

        if(LastQty == 2) {
            System.out.println("Sepetteki güncel adet 2'dir..");
        }
        else
            System.out.println("Sepetteki güncel adet 2 değildir..");



        WebElement Trash = driver.findElement(By.xpath("//a/i[@class='fa fa-trash-o'][@aria-hidden ='true']"));
        Trash.click();

        WebDriverWait wait2 = new WebDriverWait(driver, 5);

        driver.switchTo().activeElement().findElement(By.xpath("//div/a[@class='inverted-modal-button sc-delete ins-init-condition-tracking']")).click();

        String EmptyCart = driver.findElement(By.xpath("//div/p[@class='cart-empty-title']")).getText();
        System.out.println(EmptyCart);



    }

}

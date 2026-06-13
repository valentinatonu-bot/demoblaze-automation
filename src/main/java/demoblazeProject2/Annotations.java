package demoblazeProject2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

    ChromeDriver driver = new ChromeDriver();

    @Test(priority = 1)
    public void addToCart() throws InterruptedException {

        System.out.println("Adaug produsul in cos");

        // selectare produs
        driver.findElement(By.linkText("Samsung galaxy s6")).click();

        Thread.sleep(2000);

        // adaugare in cos
        driver.findElement(By.linkText("Add to cart")).click();

        Thread.sleep(2000);

        // accept alert
        driver.switchTo().alert().accept();

        System.out.println("Produsul a fost adaugat in cos cu succes");

        // intoarcere pe pagina principala
        driver.findElement(By.id("nava")).click();

        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void navigateToForm() throws InterruptedException {

        System.out.println("Navighez catre cos");

        driver.findElement(By.id("cartur")).click();

        Thread.sleep(2000);

        System.out.println("Navigarea catre cos s-a efectuat cu succes");
    }

    @Test(priority = 3)
    public void completeForm() throws InterruptedException {

        System.out.println("Completez formularul de comanda");

        // buton Place Order
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        Thread.sleep(2000);

        // completare formular
        driver.findElement(By.id("name")).sendKeys("Valentina");
        driver.findElement(By.id("country")).sendKeys("Ireland");
        driver.findElement(By.id("city")).sendKeys("Dublin");
        driver.findElement(By.id("card")).sendKeys("123456789");
        driver.findElement(By.id("month")).sendKeys("05");
        driver.findElement(By.id("year")).sendKeys("2026");

        Thread.sleep(2000);

        // click Purchase
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        Thread.sleep(3000);

        System.out.println("Comanda a fost plasata cu succes");

        // validare mesaj confirmare
        String mesajConfirmare =
                driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).getText();

        System.out.println("Mesajul primit este: " + mesajConfirmare);

        // click pe OK
        driver.findElement(By.xpath("//button[text()='OK']")).click();

        System.out.println("Comanda a fost confirmata");
    }

    @BeforeTest
    public void windowsMaximize() {

        System.out.println("maximizarea ferestrei");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("fereastra s-a maximizat cu succes");
    }

    @AfterTest
    public void waitingAWhile() throws InterruptedException {

        System.out.println("temporizare");

        Thread.sleep(4000);

        System.out.println("temporizarea s-a efectuat cu succes");
    }

    @BeforeMethod
    public void connectToDB() {

        System.out.println("conectare la baza de date");

        // cod conectare DB

        System.out.println("conectarea la baza de date s-a produs cu succes");
    }

    @AfterMethod
    public void disconnectFromDB() {

        System.out.println("deconectare la baza de date");

        // cod deconectare DB

        System.out.println("deconectarea la baza de date s-a produs cu succes");
    }

    @BeforeSuite
    public void openBrowser() {

        System.out.println("Deschid browser-ul");

        driver.get("https://demoblaze.com");

        System.out.println("Driverul s-a deschis cu succes");
    }

    @AfterSuite
    public void closeBrowser() {

        System.out.println("inchid browserul");

        driver.quit();

        System.out.println("browserul s-a inchis cu succes");
    }
}
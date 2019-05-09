package AutomatingRegistration;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

public class _main {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joshua\\IdeaProjects\\NaukriDotComSelenium\\Automation\\chromedriver_.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //getting the excel file
        File src = new File("C:\\Users\\Joshua\\IdeaProjects\\NaukriDotComSelenium\\Automation\\ProfileData.xls");
        FileInputStream fis = new FileInputStream(src);
        HSSFWorkbook wb = new HSSFWorkbook(fis);

        //getting Sheet 1
        HSSFSheet sheet1 = wb.getSheetAt(0);
        //setting data to the variable in myData class
        myData data = new myData();
        data.setData(sheet1);

        //printing out the values
        System.out.println("Name: " + data.getName() + "\n" +
                "Email: " + data.getEmail() + "\n" +
                "Mobile No: " + data.getMobile() + "\n" +
                "Password: " + data.getPassword() + "\n" +
                "Location: " + data.getLocation() + "\n" +
                "City: " + data.getCity());

        //get all xpaths and start automation
        xpaths path = new xpaths();

        driver.get("https://my.naukri.com/account/createaccount");
        //delay
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath(path._registrationType)).click();
        driver.findElement(By.xpath(path._name)).sendKeys(data.getName());
        driver.findElement(By.xpath(path._email)).sendKeys(data.getEmail());
        driver.findElement(By.xpath(path._password)).sendKeys(data.getPassword());
        driver.findElement(By.xpath(path._mobile)).sendKeys(data.getMobile());
        driver.findElement(By.xpath(path._location)).sendKeys(data.getLocation());
        driver.findElement(By.xpath(path._selectLocation)).click();
        driver.findElement(By.xpath(path._city)).sendKeys(data.getCity());
        driver.findElement(By.xpath(path._upload)).click();

        //delay
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //AutoIT script
        Runtime.getRuntime().exec("C:\\Users\\Joshua\\IdeaProjects\\NaukriDotComSelenium\\Automation\\scriptToUpload.exe");

        //register
        driver.findElement(By.xpath(path._registerBtn)).click();

        //delay
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //login
        driver.findElement(By.xpath(path._login)).click();
        driver.findElement(By.xpath(path._username)).sendKeys(data.getEmail());
        driver.findElement(By.xpath(path._pass)).sendKeys(data.getPassword());
        driver.findElement(By.xpath(path._loginBtn)).click();

        //driver.quit();
    }
}


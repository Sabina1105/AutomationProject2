package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sun.text.normalizer.Utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Main {

    public static <Faker, ArrayNode> void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sabinahuseynly/Documents/BrowserDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

//        public static int randNumber(int min, int max){
//            (int)((Math.random()* (max-min))+ min);}

//        3. Login using Tester as username and test as password
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

//        4. Click on Order link
        driver.findElement(By.xpath("//a[@href=\"Process.aspx\"]")).click();

//        5. Enter a random product quantity between 1 and 100
        int random = (int) ((int) 1 + (Math.random() * 100));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.CLEAR);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.chord("" + random));

//        6. Click on Calculate and verify that the Total value is correct.
        driver.findElement(By.xpath("//input[@value=\"Calculate\"]")).click();
        int unit = 100;
        double total = 0.0;
        if (random > 10)
            total = ((random * unit) - (random * unit * 0.08));
        else
            total = random * unit;
        System.out.println(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value"));

//        7. Generate and enter random first name and last name.
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String firstName = "";
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            char fName = letters.charAt(rnd.nextInt(letters.length()));
            firstName += fName;
        }
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);

        String letters2 = "abcdefghijklmnopqrstuvwxyz";
        String lastName = "";
        Random rnd2 = new Random();
        for (int i = 0; i < 5; i++) {
            char lName = letters2.charAt(rnd2.nextInt(letters2.length()));
            lastName += lName;
        }
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(Keys.chord(firstName + " " + lastName));

//        8. Generate and Enter random street address
        String nums = "0123456789";
        String streetN = "";
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            char num = nums.charAt(rand.nextInt(nums.length()));
            streetN += num;
        }

        String letters3 = "abcdefghijklmnopqrstuvwxyz";
        String streetName = "";
        Random rand2 = new Random();
        for (int i = 0; i < 6; i++) {
            char strN = letters3.charAt(rand2.nextInt(letters3.length()));
            streetName += strN;
        }
        streetName = streetName.substring(0, 1).toUpperCase() + streetName.substring(1);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(Keys.chord(streetN + " " + streetName));

//        9. Generate and Enter random city
//          String readFromCSV = "/Users/sabinahuseynly/Desktop/MOCK_DATA.csv";
         List<String> city = new ArrayList<>();
        city.add("New York");
        city.add("Boston");
        city.add("Chicago");
        city.add("Houston");
        city.add("Austin");
        city.add("Los Angeles");
        ArrayList newCity = new ArrayList();
        int a = (int) (1+(Math.random())*city.size());
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(Keys.chord(city.get(a)));


//        10. Generate and Enter random state
        List<String> state = new ArrayList<>();
        //city.add("/Users/sabinahuseynly/Desktop/MOCK_DATA.csv");
        city.add("New York");
        city.add("Washington");
        city.add("Texas");
        city.add("California");
        city.add("Florida");
        city.add("Nevada");
        ArrayList newState = new ArrayList();
        int b = (int) (1+(Math.random())*state.size());
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(Keys.chord(city.get(b)));

//        11. Generate and Enter a random 5 digit zip code
        String num = "0123456789";
        String zipN = "";
        Random rand4 = new Random();
        for (int i = 0; i < 5; i++) {
            char zip = num.charAt(rand4.nextInt(num.length()));
            zipN += zip;
        }
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(Keys.chord(zipN));
//        EXTRA: As an extra challenge, for steps 7-11 download 1000 row of corresponding realistic data from mockaroo.com in a csv format and load it to your program and use the random set of data from there each time.
//
//        12. Select the card type randomly. On each run your script should select a random type.
        WebElement visa = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        WebElement masterCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
        WebElement Amex = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2"));
        String cardType = "abc";
        char c = cardType.charAt(rand.nextInt(2));
        if(c == 'a')
            visa.click();
        if(c == 'b')
            masterCard.click();
        if(c == 'c')
            Amex.click();
//        13. Generate and enter the random card number:
//        If Visa is selected, the card number should start with 4.
//        If MasterCard is selected, card number should start with 5.
//        If American Express is selected, card number should start with 3.
//        Card numbers should be 16 digits for Visa and MasterCard, 15 for American Express.
           if(visa.isSelected()){
               long visaNum = 4000000000000000L+(long)(Math.random()*1000000000000000L);
               driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Keys.chord(""+visaNum));
           }
        if(masterCard.isSelected()){
            long masterNum = 5000000000000000L+(long)(Math.random()*100000000000000L);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Keys.chord(""+masterNum));
        }
        if(Amex.isSelected()){
            long amexNum = 3000000000000000L+(long)(Math.random()*100000000000000L);
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Keys.chord(""+amexNum));
        }
//        14. Enter a valid expiration date (newer than the current date)
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/27");
//        15. Click on Process
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
//        16. Verify that “New order has been successfully added” message appeared on the page.
        String expected = "New order has been successfully added.";
        String actual = driver.findElement(By.xpath("//strong")).getText();
        Assert.assertEquals(actual, expected);
        Thread.sleep(3000);
//        17. Log out of the application.
        driver.findElement((By.id("ctl00_logout"))).click();
        Thread.sleep(3000);
        driver.quit();
//
//                Push your code to GitHub, and share the repo link in the given repo.txt file


    }
}
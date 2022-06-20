public class AutoProject2 {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sabinahuseynly/Documents/BrowserDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
//
//        2. Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
//        3. Login using Tester as username and test as password
//        4. Click on Order link
//        5. Enter a random product quantity between 1 and 100
//        6. Click on Calculate and verify that the Total value is correct.
//                Price per unit is 100.  The discount of 8 % is applied to quantities of 10+.
//        So for example, if the quantity is 8, the Total should be 800.
//        If the quantity is 20, the Total should be 1840.
//        If the quantity is 77, the Total should be 7084. And so on.
//
//        7. Generate and enter random first name and last name.
//        8. Generate and Enter random street address
//        9. Generate and Enter random city
//        10. Generate and Enter random state
//        11. Generate and Enter a random 5 digit zip code
//
//        EXTRA: As an extra challenge, for steps 7-11 download 1000 row of corresponding realistic data from mockaroo.com in a csv format and load it to your program and use the random set of data from there each time.
//
//        12. Select the card type randomly. On each run your script should select a random type.
//        13. Generate and enter the random card number:
//        If Visa is selected, the card number should start with 4.
//        If MasterCard is selected, card number should start with 5.
//        If American Express is selected, card number should start with 3.
//        Card numbers should be 16 digits for Visa and MasterCard, 15 for American Express.
//        14. Enter a valid expiration date (newer than the current date)
//        15. Click on Process
//        16. Verify that “New order has been successfully added” message appeared on the page.
//        17. Log out of the application.
//
//                Push your code to GitHub, and share the repo link in the given repo.txt file
    }
}

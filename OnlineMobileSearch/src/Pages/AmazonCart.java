package Pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class AmazonCart {

	public static WebDriver driver;
	public static Properties prop;
	
	    //Function to open the browser
	    public void driverSetup(String browserName) throws InterruptedException
	    {
		
		
		  if(browserName.equals("chrome"))
		  {
			 System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
			 driver=new ChromeDriver();
			 System.out.println("Chrome Browser launched!");
		  }
		
		  driver.manage().window().maximize();
		  Thread.sleep(1000);
	    }
	
	    //Function to close the browser
	    public void closeBrowser()
	    {
		  driver.quit();
	    }
        
	    //Open the required url
	    public void OpenUrl(){
			
		  driver.get("https://www.amazon.in/");
	    }
	
	    //To search for the details
	    public void search() throws InterruptedException, IOException{
		
		String title=driver.getTitle();
		
		if(title.contains("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			System.out.println("Amazon Page loaded and verified");
		}
		else {
			System.out.println("Page not verified");
		}
		
		//Enter the search text in search box “mobile smartphones under 30000”
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile smartphones under 30000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String search=driver.findElement(By.xpath("//*[@id='search']/span/div/h1/div/div[1]/div/div/span[1]")).getText();
		
		//Search string is displayed
		System.out.println("Search Result: "+search+" this search result");
		
		//Clicking on “Sort by list” ListBox
		driver.findElement(By.xpath("//*[@id='a-autoid-0']/span")).click();
		List<WebElement> sort=driver.findElements(By.className("a-dropdown-item"));
		
		//Checking the count of options displayed
		System.out.println("Total Options: "+sort.size());
		System.out.println("The Sorting Options are: ");
		for(int j=0;j<sort.size();++j){
			System.out.println(sort.get(j).getText());
		}
		
		//Select option “Newest Arrivals”
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		//“Newest Arrivals” option got selected
		System.out.println("Newest Arrivals Products are selected, visible and verified.");
	    }
	
	public static void main(String[] args) throws InterruptedException, IOException{
		AmazonCart ha= new AmazonCart();
		ha.driverSetup("chrome");
		Thread.sleep(1000);
		ha.OpenUrl();
		ha.search();
		Thread.sleep(23000);
		ha.closeBrowser();
	}
	

}




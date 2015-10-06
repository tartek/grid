import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testSample 
{
	RemoteWebDriver driver = null;
	
	@Parameters("browser")
	@Test
	public void testLogin(String browser) throws MalformedURLException, InterruptedException
	{
		System.out.println(browser);
		
		DesiredCapabilities cap = null;
				
		if(browser.equals("firefox"))
		{
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
		}else if(browser.equals("chrome"))
		{
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
		}else if(browser.equals("iexplorer"))
		{
			cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("iexplore");
			cap.setPlatform(Platform.WINDOWS);
		}
		driver = new RemoteWebDriver(new URL("http://192.168.1.133:5555/wd/hub"), cap);
		//driver.manage().window().maximize();
		driver.get("http://gmail.com");
		driver.findElement(By.id("Email")).sendKeys("Hello");
		Thread.sleep(10000L);
	}
	
	@AfterMethod
	public void Closebrowser()
	{
		driver.quit();
	}
}

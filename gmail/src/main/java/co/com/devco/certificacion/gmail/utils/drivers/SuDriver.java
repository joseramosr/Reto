package co.com.devco.certificacion.gmail.utils.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SuDriver {
	
	private WebDriver chromeDriver;
	
	public SuDriver() {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--incognito");
		chromeOptions.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe" );
		chromeDriver = new ChromeDriver(chromeOptions);		
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static SuDriver Chrome() {
		return new SuDriver();
	}
	
	
	public WebDriver enGmail() {
		chromeDriver.get("https://accounts.google.com/signin/v2/identifier?service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		return chromeDriver;
	}

}


package com.softwaretestingboard.magento.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	public WebDriver setup(Properties prop) {
		
		String	browserName= prop.getProperty("browser");
		System.out.println("Browser is "+browserName);
	if(browserName.equalsIgnoreCase("chrome")) {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			
			options.addArguments("--headless");
		}
		// driver =new ChromeDriver(options);
		tlDriver.set(new ChromeDriver(options));
		
	}
	else if(browserName.equalsIgnoreCase("firefox")){
		
//		driver=new FirefoxDriver();
		tlDriver.set(new FirefoxDriver());
	}
else if(browserName.equalsIgnoreCase("safari")){
		
	//	driver=new SafariDriver();
		tlDriver.set(new SafariDriver());
	}
	else {
		System.out.println("Plese pass tight browser");
	}
	//	driver.manage().window().fullscreen();
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().get(prop.getProperty("Url"));
	
	return getDriver();
	}
	// getDriver() will return a thread local copy of the webdriver 
	// synchronized is the capability to control the access of multi threads to any shared resource
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
	}
	
	
	 public Properties set_Prop() {
		 
		 prop= new Properties();
		 FileInputStream FileIP=null;
		//./src/test/resource/ConfigProp/config.properties 
		// mvn clean install -Denv="qa"
			// mvn clean install

			String envName = System.getProperty("env");
			System.out.println("-----> Running test cases on environment----> " + envName);

			if (envName == null) {
				System.out.println("No env is given...hence running it on default QA env....");
				try {
					FileIP = new FileInputStream("./src/test/resource/ConfigProp/config.properties");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {

				try {
					switch (envName.toLowerCase()) {
					case "qa":
						FileIP = new FileInputStream("./src/test/resource/ConfigProp/qa.config.properties");
						break;
					case "dev":
						FileIP = new FileInputStream("./src/test/resource/ConfigProp/dev.config.properties");
						break;
					case "preview":
						FileIP = new FileInputStream("./src/test/resource/ConfigProp/preview.config.properties");
						break;
					
					case "prod":
						FileIP = new FileInputStream("./src/test/resource/ConfigProp/config.properties");
						break;

					default:
						System.out.println("Please pass the right env name...." + envName);
						break;
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}

			try {
				prop.load(FileIP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		 return prop;
	 }
	 public static String getScreenshot() {
			File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
			File destination = new File(path);
			try {
				FileHandler.copy(srcFile, destination);

			} catch (IOException e) {
				e.printStackTrace();
			}
			return path;

		}
}

package practiveclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	public Properties set_Prop() throws IOException {
		Properties prop;
		 
		 prop= new Properties();
		 FileInputStream FileIP = null;
		 
		 
		 String envName=System.getProperty("env");
		 envName="qa";
		 
		if (envName==null) {
		 System.out.println("Running in Prod Env...");
		 try {
			 FileIP = new FileInputStream("./src/test/resource/ConfigProp/config.properties");
		
			
			 
		 
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} }
		else {
			System.out.println("Running in " + envName+" Env...");
			try{
				switch(envName) {
			case "qa":
				FileIP= new FileInputStream("./src/test/resource/ConfigProp/qa.config.properties");
				break;
			
			case "dev":
				FileIP= new FileInputStream("./src/test/resource/ConfigProp/dev.config.properties");
				break;
			
			case "preview":
				FileIP= new FileInputStream("./src/test/resource/ConfigProp/preview.config.properties");
				break;
			default:
				System.out.println("Please give correct envName");
				
				break;
			}
		 } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			prop.load(FileIP);
			
			
		}
		
		 return prop;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver =new ChromeDriver(options);
		
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://magento.softwaretestingboard.com/");
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}
	
	
	// maven clean install -Denv="qa"

}

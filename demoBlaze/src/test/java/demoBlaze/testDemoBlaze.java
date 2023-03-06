package demoBlaze;
import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//2- Bibliotecas
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

// 3- Classe
public class testDemoBlaze {
	// 3.1 Atributos / Características
	String url;   //endereço do site alvo
	WebDriver driver;  //objeto do Selenium WebDriver
	
	//3.2 Métodos ou Funções
	@Before
	public void iniciar() {
		url = "https://www.demoblaze.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\iterasys-workspace\\siteIterasys\\drivers\\chrome\\110\\chromedriver.exe" //Para localizar o chrome e selecionar
				);
		driver = new ChromeDriver(); // Para referenciar o chrome ao selenium
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS); // dizer tempo de espera para pagina carregar
		driver.manage().window().maximize(); //Para maximizar a tela do navegador
	}
	
	
	@After
	public void finalizar() {
		driver.quit(); 
	}
	
	@Test
	public void consultarCurso() {
		driver.get(url);  // Abrir o navegador na página indicada na url
		driver.findElement(By.xpath("//a[3]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]/div/div//a")));
		driver.findElement(By.xpath("//div[6]/div/div//a")).click();
		driver.findElement(By.xpath("//div[2]//a")).click();
		driver.findElement(By.xpath("//li[4]/a")).click();
		driver.findElement(By.xpath("//div[2]/button")).click();
		driver.findElement(By.id("name")).sendKeys(Keys.chord("Igor Amaral"));
		driver.findElement(By.id("country")).sendKeys(Keys.chord("Brasil"));
		driver.findElement(By.id("city")).sendKeys(Keys.chord("Salvador"));
		driver.findElement(By.id("card")).sendKeys(Keys.chord("123456789"));
		driver.findElement(By.id("month")).sendKeys(Keys.chord("3"));
		driver.findElement(By.id("year")).sendKeys(Keys.chord("2023"));
		driver.findElement(By.xpath("//div[3]/div//button[2]")).click();
		
		
		
		//Resultados Esperados
		String titulo = "Thank you for your purchase!";
		
		
		//assertEquals(resultadoEsperado, resultadoAtual)
		assertEquals(titulo, driver.findElement(By.xpath("//div[10]/h2")).getText());
		
	}
	
	
}

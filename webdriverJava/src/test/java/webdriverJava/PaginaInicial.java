package webdriverJava;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class PaginaInicial {

	private WebDriver driver;
	
	public PaginaInicial (WebDriver driver) {
		this.driver = driver;
	}
	
	public void PreencherLogin (String usuario , String senha) {
		driver.findElement(By.id("menuUser")).click();
		driver.findElement(By.name("username")).sendKeys(usuario);
		driver.findElement(By.name("password")).sendKeys(senha);
		driver.findElement(By.id("sign_in_btnundefined")).click();
	}
	
	public String EsperarPorMensagemDeValidacao () {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "Incorrect user name or password."));
		return driver.findElement(By.id("signInResultMessage")).getText();
	}
	
}

package br.com.webdriverJava.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class PaginaInicial extends BasePage{

	public PaginaInicial(WebDriver driver) {
		super(driver);
	}
	
	public PaginaInicial PreencherLogin (String usuario , String senha) {
		ClicarJanelaDeLogin();
		driver.findElement(By.name("username")).sendKeys(usuario);
		driver.findElement(By.name("password")).sendKeys(senha);
		driver.findElement(By.id("sign_in_btnundefined")).click();
		return this;
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
	
	public PaginaPesquisaMouse PesquisaLupaMouse (String mouse) {
		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.id("autoComplete")).sendKeys(mouse);
		driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='autoCompleteCover']//div//img")).click();
		return new PaginaPesquisaMouse (driver);
	}

	
	
	public PaginaPesquisaMouse PesquisaTelaInicialMouse () {
		driver.findElement(By.id("miceTxt")).click();
		return new PaginaPesquisaMouse(driver);
	}
	
	public String ValidacaoLoginEfetuado () {
		return driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")).getText();
	}
	
	public PaginaInicial ClicarJanelaDeLogin () {
		driver.findElement(By.id("menuUser")).click();
		return this;
	}
	
	public PaginaDeCadastro ClicarCreateNewAccount () {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(20000, TimeUnit.MILLISECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']"))));
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();
		return new PaginaDeCadastro (driver);
	}
}

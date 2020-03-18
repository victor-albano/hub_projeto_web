package webdriverJava;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.webdriverJava.Suporte.GerenciandoChrome;
import br.com.webdriverJava.pages.PaginaInicial;

public class TesteLogin {
	
	private WebDriver driver;

	@Before
	public void SetUp () {
		driver = GerenciandoChrome.AbrirPaginaInicial("http://advantageonlineshopping.com/#/");
	}
	
	//@Test
	public void TesteLoginSEMSucesso () {
		String paginaInicial = new PaginaInicial(driver).PreencherLogin("victor", "1234").EsperarPorMensagemDeValidacao();
		assertEquals("Incorrect user name or password.", paginaInicial);
	}
	
	//@Test
	public void PesquisaPelaLupaCOMSucesso () {
		String pesquisa = new PaginaInicial(driver).PesquisaLupaMouse("Mouse").SelecionandoMouseEValidando();
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", pesquisa);
	}
	
	//@Test
	public void PesquisaPelaTelaInicialCOMSucesso () {
		String pesquisa = new PaginaInicial(driver).PesquisaTelaInicialMouse().SelecionandoMouseEValidando();
		assertEquals("HP USB 3 BUTTON OPTICAL MOUSE", pesquisa);
	}
	
	@Test
	public void PreencherCadastroCOMSucesso () throws InterruptedException {
		new PaginaInicial(driver).ClicarJanelaDeLogin().ClicarCreateNewAccount()
		.FazerCadastro("rodrigo", "Abc4", "rodrigo@gmail.com", "Rodrigo", "Morais",
				"11990909898", "Brazil", "Santo André", "Rua natal", "SP", "09030000");
		assertEquals("Rodrigo", new PaginaInicial(driver).ValidacaoLoginEfetuado());
	}
	
	//@Test
	public void LoginCOMSucesso () {
		assertEquals("Roger", new PaginaInicial(driver).PreencherLogin("Roger", "Abc4").ValidacaoLoginEfetuado());
	}
	
	//@After
	public void tearDown () {
		GerenciandoChrome.FecharChrome();
	}
	
}

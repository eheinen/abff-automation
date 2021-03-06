package com.abff.support.page_objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.abff.support.driver.AbstractDriver;

//Existem 3 tipos de Find no Selenium Support:
// FindBy -> Pesquisa o elemento na tela de acordo com o tipo e o valor passado.
// FindBys -> Pesquisa o elemento filho na tela de acordo com a estrutura passada de pai para filho.
// FindAll -> Pesquisa o elemento na tela de acordo com os FindBy passados e retorna o elemento caso haja match entre um deles.

public class LoginPage extends AbstractDriver {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	protected String title = "ABFF - Login";
	
	// PageFactory:
	
	// FindBy com parâmetros simplificados
	@FindBy(id = "txt-usuario") 
	private WebElement txtUsername;
	
	// FindAll retornará o elmento senha se o campo senha possuir o name senha ou id txt-senha
	@FindAll({
		@FindBy(name = "senha"), 
		@FindBy(id = "txt-senha")
	})
	private WebElement txtPassword;
	
	// FindBys retornará o elemento btn-entrar que esteja contido dentro do elemento container-login
	@FindBys({
		@FindBy(how=How.CLASS_NAME, using="container-login"),
		@FindBy(how=How.ID, using="btn-entrar")
	})
	private WebElement btnEntrar;
	
	// É possível utilizar os parâmetros simplificados ou mais detalhados, pela visibilidade é preferível utilizar o
	// modo simplificado.
	@FindBy(xpath = "//*[@id=\"btn-limpar\"]")
	private WebElement btnLimpar;
	
	// Dê preferência na utilização de elementos que possuam IDs, pois os elementos que possuem IDs diferente de outros atributos,
	// é único para cada elemento na tela. Caso o elemento não possua ID, procure usar a melhor combinação de Finds para encontrar
	// apenas o elemento que deseja.
	@FindBy(id = "lnk-cadastrar-usuario")
	private WebElement lnkCadastrar;
	
	@FindBy(id = "message-text")
	private WebElement lblMessage;
	
	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnEntrar() {
		return btnEntrar;
	}

	public WebElement getBtnLimpar() {
		return btnLimpar;
	}

	public WebElement getLnkCadastrar() {
		return lnkCadastrar;
	}

	public WebElement getLblMessage() {
		return lblMessage;
	}
	
	
	// PageObjects:

	protected HomePage authenticate(String username, String password){
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnEntrar.click();
		assertThat("Autenticação realizada com sucesso!", equalTo(waitForElementDisplayed(lblMessage).getText()));
		assertThat("ABFF", equalTo(waitForTitle("ABFF")));
		return new HomePage();
	}
	
	
}

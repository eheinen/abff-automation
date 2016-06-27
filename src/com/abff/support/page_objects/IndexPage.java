package com.abff.support.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.abff.support.driver.AbstractDriver;
import com.abff.support.driver.Driver;

//Existem 3 tipos de Find no Selenium Support:
// FindBy -> Pesquisa o elemento na tela de acordo com o tipo e o valor passado.
// FindBys -> Pesquisa o elemento filho na tela de acordo com a estrutura passada de pai para filho.
// FindAll -> Pesquisa o elemento na tela de acordo com os FindBy passados e retorna o elemento caso haja match entre um deles.

public class IndexPage extends AbstractDriver {

	public IndexPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}
	
	protected String title = "ABFF";
	
	// FindBy com parâmetros simplificados
	@FindBy(id = "txt-usuario") 
	protected WebElement txtUsername;
	
	// FindAll retornará o elmento senha se o campo senha possuir o name senha ou id txt-senha
	@FindAll({
		@FindBy(name = "senha"), 
		@FindBy(id = "txt-senha")
	})
	protected WebElement txtPassword;
	
	// FindBys retornará o elemento btn-entrar que esteja contido dentro do elemento container-login
	@FindBys({
		@FindBy(how=How.CLASS_NAME, using="container-login"),
		@FindBy(how=How.ID, using="btn-entrar")
	})
	protected WebElement btnEntrar;
	
	// É possível utilizar os parâmetros simplificados ou mais detalhados, pela visibilidade é preferível utilizar o
	// modo simplificado.
	@FindBy(xpath = "//*[@id=\"btn-limpar\"]")
	protected WebElement btnLimpar;
	
	// Dê preferência na utilização de elementos que possuam IDs, pois os elementos que possuem IDs diferente de outros atributos,
	// é único para cada elemento na tela. Caso o elemento não possua ID, procure usar a melhor combinação de Finds para encontrar
	// apenas o elemento que deseja.
	@FindBy(id = "lnk-cadastrar-usuario")
	protected WebElement lnkCadastrar;
	
	@FindBy(id = "message-text")
	protected WebElement lblMessage;
	
}

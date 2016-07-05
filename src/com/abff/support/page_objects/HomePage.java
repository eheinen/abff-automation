package com.abff.support.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.abff.support.driver.AbstractDriver;

//Existem 3 tipos de Find no Selenium Support:
// FindBy -> Pesquisa o elemento na tela de acordo com o tipo e o valor passado.
// FindBys -> Pesquisa o elemento filho na tela de acordo com a estrutura passada de pai para filho.
// FindAll -> Pesquisa o elemento na tela de acordo com os FindBy passados e retorna o elemento caso haja match entre um deles.

public class HomePage extends AbstractDriver {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	protected String title = "ABFF";
	
	@FindBy(xpath = "//*[@data-i18n='menu-animal']")
	protected WebElement mn_animals;
	
	@FindBy(id = "lnk-cadastrar-animais")
	protected WebElement mni_cadastrar_animais;
	
	@FindBy(id = "lnk-visualizar-animais")
	protected WebElement mni_visualizar_animais;
	
	
	
	/**
	 * Responsible for get the element by menu passed by parameter
	 * @param menu Element menu
	 * @return Element
	 */
	private WebElement getMenuElement(String menu){
		if(menu.toUpperCase().equals("ANIMALS"))
			return mn_animals;
		return null;
	}
	
	/**
	 * Responsible for simulate a hover mouse pointer over an element
	 * @param menu Element menu
	 * @return HomePage
	 */
	protected HomePage hoverMenu(String menu){
		Actions builder = new Actions(driver);
        builder.moveToElement(getMenuElement(menu)).build().perform();
        return this;
	}
	
	/**
	 * Responsible for check if all menu items are displayed on the page
	 * @param menu Menu parent element
	 * @param isDisplayed Flag to check if are displayed or not
	 * @return HomePage
	 */
	protected HomePage checkMenuItemIsDisplayed(String menu, boolean isDisplayed){
		if(menu.toUpperCase().equals("ANIMALS")){
			assertThat(mni_cadastrar_animais.isDisplayed(), equalTo(isDisplayed));
			assertThat(mni_visualizar_animais.isDisplayed(), equalTo(isDisplayed));
		}
		return this;
	}
	
}

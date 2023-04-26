package elementos;

import org.openqa.selenium.By;

public class ElementosGrocery {
	
	/**
	 * *********************************************************************************************************************************
	 * @see Utilizar os objetos By da interface WebBaseElements. Seguir um padrão na nomeclatura dos atributos. 					   *
	 * 					   																											   *		
	 * Input - Utilizar a abreviação (TXT)																							   *
	 * Button - Utilizar a abreviação (BTN)																							   *	
	 * Radio_Button - Utilizar a abreviação (RDB) 																					   *
	 * Check_Button - Utilizar a abreviação (CHK)																					   *	
	 * ComboBox/ListView - Utilizar a abreviação (CBX)																				   *
	 * Label - Utilizar a abreviação (LBL)																							   *
	 * Imagem - Utilizar a abreviação (IMG)																							   *
	 * Link/PartialLink - Utilizar a abreviação (LNK)																				   *
	 * Mensagem_do_sistema  - Utilizar a abreviação (MSG)  																			   *
	 * Modais - Utilizar a abreviação (MD)																							   *
	 * Frame/Iframe - Utilizar a abreviação (FRM)																					   *
	 * ********************************************************************************************************************************/
	
	public static final By CBXVERSAO = By.xpath("//select[@id='switch-version-select']");
	public static final By BTNADD = By.xpath("(//a[@class='btn btn-default btn-outline-dark'])[1]");
	public static final By BTNSAVE = By.xpath("//button[@id='form-button-save']");
	public static final By TXTNAME = By.xpath("//input[@id='field-customerName']");
	public static final By TXTLASTNAME = By.xpath("//input[@id='field-contactLastName']");
	public static final By TXTCONTACTFIRTNAME = By.xpath("//input[@id='field-contactFirstName']");
	public static final By TXTPHONE = By.xpath("//input[@id='field-phone']");
	public static final By TXTADRESSLINE1 = By.xpath("//input[@id='field-addressLine1']");
	public static final By TXTADRESSLINE2 = By.xpath("//input[@id='field-addressLine2']");
	public static final By TXTCITY = By.xpath("//input[@id='field-city']");
	public static final By TXTSTATE = By.xpath("//input[@id='field-state']");
	public static final By TXTPOSTALCODE = By.xpath("//input[@id='field-postalCode']");
	public static final By TXTCOUNTRY = By.xpath("//input[@id='field-country']");
	public static final By TXTCREDITLIMIT = By.xpath("//input[@id='field-creditLimit']");
	public static final By DIVFROMIMPLOYEER = By.xpath("//div[@id='field_salesRepEmployeeNumber_chosen']");
	public static final By TXTPESQUISAREMPLOYEER = By.xpath("//div[@class='chosen-search']//input");
	public static final By MSGSUCESSO = By.xpath("//div[@id='report-success']//p");
	public static final By BTNBACKTOLIST = By.xpath("//button[@id='save-and-go-back-button']");
	public static final By TXTPESQUISARNOME = By.xpath("//input[@name='customerName']");
	public static final By CHKTODOS = By.xpath("//input[@class='select-all-none']");
	public static final By BTNDELETE = By.xpath("(//a[@title='Delete'])[1]");
	public static final By MSGCONFIRMACAO = By.xpath("//p[@class='alert-delete-multiple-one']");
	public static final By BTNDELETEMODALCONF = By.xpath("//button[@class='btn btn-danger delete-multiple-confirmation-button']");
	public static final By MSGSUCESSODELETE = By.xpath("//span[@data-growl='message']//p");
	

}

package com.juaracoding.mobilesales.pages.master;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.mobilesales.driver.DriverSingleton;

public class MasterUserPage {
private WebDriver driver;
	
	public MasterUserPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
//	LIST SUB MENU
	
	@FindBy(css = "#left-panel > nav > ul > li.open > ul > li")
	private List<WebElement> listmaster;
	
//	HALAMAN DEPAN MASTER USER
	
	@FindBy(css = "#content > div > div.col-xs-12.col-sm-5.col-md-5.col-lg-8 > a")
	private WebElement btnAddNewUser;
	
	@FindBy(css = "#dt_basic_filter > label > input")
	private WebElement txtSearchTabel;
	
	@FindBy(css = "#dt_basic_length > label > select")
	private WebElement jumlahDataTabel;
	
	@FindBy(css = "#dt_basic > thead > tr > th.sorting_asc")
	private WebElement sortNo;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(2)")
	private WebElement sortUsername;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(3)")
	private WebElement sortName;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(4)")
	private WebElement sortEmail;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(5)")
	private WebElement sortPicture;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(6)")
	private WebElement sortPosition;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(7)")
	private WebElement sortStatus;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(8)")
	private WebElement sortCreated;
	
	@FindBy(css = "#dt_basic_paginate > ul > li:nth-child(3) > a")
	private WebElement pageDua;
	
	@FindBy(css = "#dt_basic_previous > a")
	private WebElement pagePrevious;
	
	@FindBy(css = "#dt_basic_next > a")
	private WebElement pageNext;
	
	@FindBy(id = "myBtn")
	private WebElement btnUP;
	
	@FindBy(css = "#dt_basic > tbody > tr:nth-child(2) > td:nth-child(9) > a.btn.btn-primary.btn-xs > i")
	private WebElement editPadaTabel;
	
	@FindBy(css = "#dt_basic > tbody > tr:nth-child(2) > td:nth-child(9) > a.btn.btn-danger.btn-xs > i")
	private WebElement hapusPadaTabel;
	
//	FORM NEW USER
	
	@FindBy(id = "nik")
	private WebElement txtNik;
			
	@FindBy(id = "name")
	private WebElement txtName;
	
	@FindBy(css = "#s2id_autogen9 > a")
	private WebElement kategori;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(5) > label.input > input")
	private WebElement txtuserName;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(6) > label.input > input")
	private WebElement txtPassword;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(7) > label.input > input")
	private WebElement txtEmail;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(8) > label.input > input")
	private WebElement BtnUploadPicture;
	
	@FindBy(css = "#s2id_autogen11 > a")
	private WebElement status;
	
	@FindBy(css = "#checkout-form > footer > button")
	private WebElement btnSubmit;
	
	@FindBy(css = "#checkout-form > footer > a")
	private WebElement btnBack;
	
	@FindBy(css = "#content > div.row > div.col-xs-12.col-sm-7.col-md-7.col-lg-4 > span > h1")
	private WebElement getTextMasterAkun;
	
//	POPUP FRAME
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(1) > label.input > a:nth-child(1)")
	private WebElement btnPopupOperation;
	
	@FindBy(css = "#datatable_fixed_column_filter > label > input")
	private WebElement txtSearchPopupOperation;
	
	@FindBy(css = "#datatable_fixed_column > tbody > tr > td:nth-child(8) > a")
	private WebElement btnPilihPopupOperation;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(1) > label.input > a:nth-child(2)")
	private WebElement btnPopupSales;
	
	@FindBy(css = "#datatable_fixed_column_filter > label > input")
	private WebElement txtSearchPopupSales;
	
	@FindBy(css = "#datatable_fixed_column > tbody > tr:nth-child(1) > td:nth-child(8) > a")
	private WebElement btnPilihPopupSales;
	
//	FORM EDIT
	
	@FindBy(css = "#s2id_autogen9 > a > span.select2-arrow > b")
	private WebElement kategoriEdit;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(2) > label.input > input")
	private WebElement txtUsernameEdit;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(3) > label.input > input")
	private WebElement txtNameEdit;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(4) > label.input > input")
	private WebElement txtEmailEdit;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(5) > label.input > input")
	private WebElement BtnUploadPictureEdit;
	
	@FindBy(css = "#s2id_autogen11 > a > span.select2-arrow > b")
	private WebElement statusEdit;
	
	@FindBy(css = "#checkout-form > footer > button")
	private WebElement btnSubmitEdit;
	
	@FindBy(css = "#checkout-form > footer > a > i")
	private WebElement btnBackEdit;
	
	@FindBy(css = "#widget-grid > header > h2 > b")
	private WebElement getEdit;
	
	
	
	public void intoMasterUser() {
		listmaster.get(0).click();
	}	
	
	public void MasterUser() {	
		btnAddNewUser.click();
	}
	
	public void tes() {
		
	}
	
	public void formMasterUser(String nikmasterUser, String namemasteruser, String usernamemasteruser, 
			String passwordmasteruser, String emailmasteruser, String picturemasteruser, String searchpopupmaster) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		
		btnPopupOperation.click();

		driver.switchTo().frame("GB_frame");
		driver.switchTo().frame("GB_frame");
		
		txtSearchPopupOperation.sendKeys(searchpopupmaster);
		btnPilihPopupOperation.click();
		
		driver.switchTo().defaultContent();
		
		btnPopupSales.click();
		
		driver.switchTo().frame("GB_frame");
		driver.switchTo().frame("GB_frame");
		
		txtSearchPopupSales.sendKeys(searchpopupmaster);
		btnPilihPopupSales.click();
		
		driver.switchTo().defaultContent();
		
		txtNik.clear();
		txtNik.sendKeys(nikmasterUser);
		txtName.clear();
		txtName.sendKeys(namemasteruser);
		Kategori(1);
		txtuserName.clear();
		txtuserName.sendKeys(usernamemasteruser);
		txtPassword.clear();
		txtPassword.sendKeys(passwordmasteruser);
		js.executeScript("arguments[0].scrollIntoView()", txtEmail);
		txtEmail.sendKeys(emailmasteruser);
		BtnUploadPicture.sendKeys(picturemasteruser);
		Status(1);
		btnSubmit.submit();
		
		btnAddNewUser.click();
		btnBack.click();
		
		JumlahData(1);

		sortNo.click();
		sortUsername.click();
		sortName.click();
		sortEmail.click();
		sortPicture.click();
		sortPosition.click();
		sortStatus.click();
		sortCreated.click();

	}
	
	public void editUser(String usernamedituser, String namaedituser, String emailedituser, String pictureedituser) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		editPadaTabel.click();
		Kategori(2);
		txtUsernameEdit.clear();
		txtUsernameEdit.sendKeys(usernamedituser);
		txtNameEdit.clear();
		txtNameEdit.sendKeys(namaedituser);
		js.executeScript("arguments[0].scrollIntoView()", txtNameEdit);
		txtEmailEdit.clear();
		txtEmailEdit.sendKeys(emailedituser);
		BtnUploadPictureEdit.sendKeys(pictureedituser);
		StatusEdit(1);
	}
	
public void editUserBug() {
		btnSubmitEdit.click();
//		harusnya berubah tapi nggak tuh
//		harusnya kembali ke menu master user
	}

public void lanjuteditUser() {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	editPadaTabel.click();
	js.executeScript("window.scrollBy(0,1000)");
	btnBackEdit.click();

}
	
	public void deleteUser(String searchuser) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		
		txtSearchTabel.sendKeys(searchuser);
		hapusPadaTabel.click();	
		Alert alerthapus = this.driver.switchTo().alert();
		alerthapus.accept();
			
		js.executeScript("window.scrollBy(0,3000)");
		
		pageDua.click();
		pagePrevious.click();
		pageNext.click();
		btnUP.click();
	}
	
	public String getDisplayMasterAkun() {
		return getTextMasterAkun.getText();
	}	
	
	public WebElement getDisplay() {
		return getTextMasterAkun;
	}	
	
	public WebElement getDisplayEdit() {
		return getEdit;
	}	
	
	
	
	
	
	public void Kategori (int selection) {			
		kategori.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void Status (int selection) {			
		status.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void JumlahData (int selection) {			
		jumlahDataTabel.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void KategoriEdit (int selection) {			
		kategoriEdit.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void StatusEdit (int selection) {			
		statusEdit.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}

}

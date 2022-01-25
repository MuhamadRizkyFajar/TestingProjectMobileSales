package com.juaracoding.mobilesales.pages.master;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.mobilesales.driver.DriverSingleton;

public class MasterParameterUploadPage {
private WebDriver driver;
	
	public MasterParameterUploadPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
//	LIST SUB MENU
	
	@FindBy(css = "#left-panel > nav > ul > li.open > ul > li")
	private List<WebElement> listmaster;
	
//	HALAMAN DEPAN
	
	@FindBy(css = "#content > div > div.col-xs-12.col-sm-5.col-md-5.col-lg-8 > a")
	private WebElement btnAddNewParameter;
	
	@FindBy(css = "#dt_basic_filter > label > input")
	private WebElement txtSearchTabel;
	
	@FindBy(css = "#dt_basic_length > label > select")
	private WebElement jumlahDataTabel;
	
	@FindBy(css = "#dt_basic > thead > tr > th.sorting_asc")
	private WebElement sortNo;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(2)")
	private WebElement sortNik;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(3)")
	private WebElement sortNama;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(4)")
	private WebElement sortEmail;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(5)")
	private WebElement sortPosition;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(6)")
	private WebElement sortBranch;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(7)")
	private WebElement sortArea;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(8)")
	private WebElement sortStatus;
	
	@FindBy(css = "#dt_basic_paginate > ul > li:nth-child(3) > a")
	private WebElement pageDua;
	
	@FindBy(css = "#dt_basic_previous > a")
	private WebElement pagePrevious;
	
	@FindBy(css = "#dt_basic_next > a")
	private WebElement pageNext;
	
	@FindBy(id = "myBtn")
	private WebElement btnUP;
	
	@FindBy(css = "#dt_basic > tbody > tr:nth-child(1) > td:nth-child(8) > a > i")
	private WebElement editPadaTabel;
	
//	FORM PARAMETER UPLOAD
	
	@FindBy(id = "nik")
	private WebElement txtNik;
	
	@FindBy(id = "name")
	private WebElement txtName;
	
	@FindBy(id = "position")
	private WebElement txtPosition;
	
	@FindBy(id = "branch")
	private WebElement txtBranch;
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(6) > label.input > input")
	private WebElement txtArea;
	
	@FindBy(css = "#checkout-form > footer > button > i")
	private WebElement btnSubmit;
	
	@FindBy(css = "#checkout-form > footer > a")
	private WebElement btnBack;
	
	@FindBy(css = "#content > div.row > div.col-xs-12.col-sm-7.col-md-7.col-lg-4 > span > h1")
	private WebElement getTextMasterParameter;

	@FindBy(css = "#content > div > div.col-xs-12.col-sm-7.col-md-7.col-lg-4 > span > h1")
	private WebElement getBack;
	
//	POPUP FRAME
	
	@FindBy(css = "#checkout-form > fieldset > section:nth-child(1) > label.input > a")
	private WebElement btnPopupSales;
	
	@FindBy(css = "#datatable_fixed_column_filter > label > input")
	private WebElement txtSearchPopupSales;
	
	@FindBy(css = "#datatable_fixed_column > tbody > tr:nth-child(1) > td:nth-child(8) > a")
	private WebElement btnPilihPopupSales;
	
//	FORM EDIT PARAMETER UPLOAD
	
	@FindBy(css = "#s2id_autogen5 > a > span.select2-arrow > b")
	private WebElement statusEdit;
	
	@FindBy(css = "#checkout-form > footer > button")
	private WebElement btnSubmitEdit;
	
	@FindBy(css = "#checkout-form > footer > a")
	private WebElement btnBackEdit;
	
	
	
	public void intoMasterParameterUpload() {
		listmaster.get(1).click();
	}
	
	public void MasterParameter() {	
		btnAddNewParameter.click();	
	}
	
	public void formMasterParameter(String nikMasterParameter, String nameMasterParameter, String positionMasterParameter, 
			String branchMasterParameter, String areaMasterParameter, String searchpopupmaster) {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		
		btnPopupSales.click();
		
		driver.switchTo().frame("GB_frame");
		driver.switchTo().frame("GB_frame");
		
		txtSearchPopupSales.sendKeys(searchpopupmaster);
		btnPilihPopupSales.click();
		
		driver.switchTo().defaultContent();
		
		js.executeScript("arguments[0].scrollIntoView()", txtNik);
		txtNik.clear();
		txtNik.sendKeys(nikMasterParameter);
		txtName.clear();
		txtName.sendKeys(nameMasterParameter);
		txtPosition.clear();
		txtPosition.sendKeys(positionMasterParameter);
		txtBranch.clear();
		txtBranch.sendKeys(branchMasterParameter);
		txtArea.sendKeys(areaMasterParameter);
		btnSubmit.submit();
		
	}
	
	public void erorFormNewbtnBack() {
		
		btnAddNewParameter.click();
		btnBack.click();
//		eror nyasar ke form user
	}
	
	public void formEditbtnBack() {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		
		editPadaTabel.click();
		js.executeScript("window.scrollBy(0,500)");
		StatusEdit(1);
		btnSubmitEdit.submit();

	}
	
	public void erorFormEditbtnBack() {
		
		editPadaTabel.click();
		btnBackEdit.click();
//		eror nyasar ke form user
	}
	
	public void lanjutParameter(String searchparameter) {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		
		sortNo.click();
		sortNik.click();
		sortNama.click();
		sortEmail.click();
		sortPosition.click();
		sortBranch.click();
		sortArea.click();
		sortStatus.click();
			
		txtSearchTabel.sendKeys(searchparameter);
		JumlahData(1);
		
		js.executeScript("window.scrollBy(0,3000)");
		pageDua.click();
		pagePrevious.click();
		pageNext.click();
		btnUP.click();
	}
	
	public WebElement getDisplayUser() {
		return getBack;
	}
	
	public String getDisplayMasterParameter() {
		return getTextMasterParameter.getText();
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
	
	
	
}

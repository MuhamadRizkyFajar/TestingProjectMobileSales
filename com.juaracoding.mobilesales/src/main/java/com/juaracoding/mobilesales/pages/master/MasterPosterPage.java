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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.mobilesales.driver.DriverSingleton;

public class MasterPosterPage {
private WebDriver driver;
	
	public MasterPosterPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
//	LIST SUB MENU
	
	@FindBy(css = "#left-panel > nav > ul > li.open > ul > li")
	private List<WebElement> listmaster;
	
//	HALAMAN DEPAN MASTER POSTER
	
	@FindBy(css = "#content > div.row > div.col-xs-12.col-sm-5.col-md-5.col-lg-8 > button")
	private WebElement btnUploadPoster;
	
	@FindBy(css = "#dt_basic > tbody > tr:nth-child(2) > td:nth-child(4) > button")
	private WebElement editPadaTabel;
	
	@FindBy(css = "#dt_basic > tbody > tr:nth-child(3) > td:nth-child(4) > a")
	private WebElement hapusPadaTabel;
	
	@FindBy(css = "#dt_basic_length > label > select")
	private WebElement jumlahDataTabel;
	
	@FindBy(css = "#dt_basic_filter > label > input")
	private WebElement txtSearchTabel;
	
	@FindBy(css = "#dt_basic_paginate > ul > li:nth-child(3) > a")
	private WebElement pageDua;
	
	@FindBy(css = "#dt_basic_previous > a")
	private WebElement pagePrevious;
	
	@FindBy(css = "#dt_basic_next > a")
	private WebElement pageNext;
	
	@FindBy(css = "#dt_basic > thead > tr > th.sorting_asc")
	private WebElement sortProgramName;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(2)")
	private WebElement sortPoster;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(3)")
	private WebElement sortStatus;
	
//	FORM NEW POSTER
	
	@FindBy(css = "#uploadimage > div.modal-body > div:nth-child(2) > input")
	private WebElement txtProgramName;
	
	@FindBy(id = "file")
	private WebElement BtnUploadPicture;
	
	@FindBy(css = "#uploadimage > div.modal-footer > input")
	private WebElement btnSubmit;
	
	@FindBy(css = "#uploadimage > div.modal-footer > button")
	private WebElement btnCancel;
	
	@FindBy(css = "#content > div.row > div.col-xs-12.col-sm-7.col-md-7.col-lg-4 > span > h1")
	private WebElement getTextMasterPoster;
	
//	FORM EDIT
	
	@FindBy(css = "#modalEdit > div > div > div.modal-body > div > select")
	private WebElement statusActiveEdit;
	
	@FindBy(css = "#modalEdit > div > div > div.modal-footer > button")
	private WebElement btnCancelEdit;
	
	@FindBy(css = "#modalEdit > div > div > div.modal-footer > input")
	private WebElement btnSubmitEdit;
	

	public void intoMasterPoster() {
		listmaster.get(2).click();
	}
	
	public void MasterPoster() {
		btnUploadPoster.click();
	}
	
	public void formMasterPoster(String programnameposter, String picturemasterposter) {
	
		txtProgramName.sendKeys(programnameposter);
		BtnUploadPicture.sendKeys(picturemasterposter);
		btnSubmit.submit();
		
		btnUploadPoster.click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(btnCancel));
		btnCancel.click();
	}
	
	public void formEditPoster() {
		
		editPadaTabel.click();
		StatusActive(1);
		btnSubmitEdit.click();
		
	}
	
	public void formEditBack() {	
		editPadaTabel.click();
		btnCancelEdit.click();
		
		JumlahData(1);
		
		sortProgramName.click();
		sortPoster.click();
		sortStatus.click();

	}
	
	public void formHapusPoster(String searchposter) {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
	
		txtSearchTabel.sendKeys(searchposter);
		hapusPadaTabel.click();
		Alert alerthapus = this.driver.switchTo().alert();
		alerthapus.accept();
		
		js.executeScript("window.scrollBy(0,3000)");
		pageDua.click();
		pagePrevious.click();
		pageNext.click();
		js.executeScript("window.scrollBy(0,-3000)");
	}
	
	public String getDisplayMasterPoster() {
		return getTextMasterPoster.getText();
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
	
	public void StatusActive (int selection) {			
		statusActiveEdit.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
}

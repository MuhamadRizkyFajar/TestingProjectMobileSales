package com.juaracoding.mobilesales.pages.completedlist;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.mobilesales.driver.DriverSingleton;

public class CompletedListPage {
	
	private WebDriver driver;
	
	public CompletedListPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void btnClosealert() {
		while(closealert.isDisplayed()) {
			try {
				closealert.click();
			} catch (Exception e) {
				break;
				
			}
		}
		
	}
	
	@FindBy(css = "#no_status_alert > div > div > div.modal-header > button")
	private WebElement closealert;
	
	@FindBy(css = "#data-completed_length > label > select")
	private WebElement jumlahDataTabel;

	public void pilihJumlahData(int pilih) {
		JumlahData(pilih);
		try {
			Thread.sleep(7500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void JumlahData(int selection) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(jumlahDataTabel));
		jumlahDataTabel.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	@FindBy(css = "#data-completed_paginate > ul > li.paginate_button.active > a")
	private List<WebElement> page;

	@FindBy(css = "#data-completed_previous > a")
	private WebElement pagePrevious;

	@FindBy(css = "#data-completed_next > a")
	private WebElement pageNext;

	public void buttonPage() {
		for (int i = 0; i < page.size(); i++) {
			page.get(i).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pagePrevious.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageNext.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(css = "#data-completed_filter > label > input")
	private WebElement inputsearch;
	
	@FindBy(css = "#btnSearch")
	private WebElement btnsearch;
	
	public void Searching(String search) {
		inputsearch.sendKeys(search);
		btnsearch.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(css = "#s2id_product > a > span.select2-arrow > b")
	private WebElement btnproduct;
	
	public void pilihProduct(int pilih) {
		Product(pilih);
	}
	
	public void Product(int selection) {
		btnproduct.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	@FindBy(xpath = "//input[@name='start_date']")
	private WebElement inputstartdate;
	
	@FindBy(xpath = "//input[@name='end_date']")
	private WebElement inputenddate;
	
	@FindBy(id = "btn-filter")
	private WebElement btnFilter;
	
	@FindBy(css = "#data-completed > tbody > tr:nth-child(1) > td:nth-child(4) > a.btn.btn-primary.btn-xs")
	private WebElement btndetail;
	
	public void Filter(String stardate, String enddate) {
		inputstartdate.sendKeys(Keys.CONTROL+"a",stardate);
		inputstartdate.sendKeys(stardate);
		inputenddate.sendKeys(Keys.CONTROL+"a",enddate);
		inputenddate.sendKeys(enddate);
		btnFilter.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewDetail() {
		btndetail.click();
	}
	
	@FindBy(css = "#data-completed > tbody > tr > td:nth-child(4) > a.btn.btn-success.btn-xs")
	private WebElement btnedit;
	
	public void EditDetail() {
		btnedit.click();
	}
	
	@FindBy(css = "#checkout-form > fieldset:nth-child(1) > div:nth-child(7) > section:nth-child(1) > div > div > label > a:nth-child(1) > span")
	private WebElement btnktp;
	
	@FindBy(id = "file")
	private WebElement input;
	
	@FindBy(id = "btnSave")
	private WebElement btnsave;
	
	@FindBy(css = "#modal_form > div > div > div.modal-footer > button.btn.btn-danger.pull-left")
	private WebElement btncancel;
	
	public void uploadKTP(String lokasiktp) {
		btnktp.click();
		input.sendKeys(lokasiktp);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(btnsave));
		btnsave.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancelUploadKTP() {
		btnktp.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(btncancel));
		btncancel.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(css = "#checkout-form > fieldset:nth-child(1) > div:nth-child(7) > section:nth-child(2) > div > div > label > a:nth-child(1) > span")
	private WebElement btnnpwp;
	
	public void uploadNPWP(String lokasinpwp) {
		btnnpwp.click();
		input.sendKeys(lokasinpwp);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(btnsave));
		btnsave.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancelUploadNPWP() {
		btnnpwp.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(btncancel));
		btncancel.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(css = "#checkout-form > fieldset:nth-child(1) > div:nth-child(8) > section > label.input > a:nth-child(1) > span")
	private WebElement btnbukti;
	
	public void uploadBukti(String lokasibukti) {
		btnbukti.click();
		input.sendKeys(lokasibukti);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(btnsave));
		btnsave.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancelUploadBukti() {
		btnbukti.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(btncancel));
		btncancel.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void errorAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void refreshBrowser() {
		driver.navigate().refresh();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(css = "#checkout-form > fieldset:nth-child(3) > footer > a")
	private WebElement btnbackfromedit;
	
	public void backfromEdit() {
		btnbackfromedit.click();
	}
	
	@FindBy(css = "#content > div.well > table > tbody > tr:nth-child(1) > td:nth-child(3)")
	private WebElement textAfterCompletedlist;
	
	public String getTextafterCompletedlist() {
		return textAfterCompletedlist.getText();
	}
	
	@FindBy(css = "#content > div.well > fieldset:nth-child(4) > footer > a")
	private WebElement btnbackfromviewdetail;
	
	public void backFromViewDetail() {
		btnbackfromviewdetail.click();
	}
	
	@FindBy(css = "#data-completed > tbody > tr:nth-child(1) > td:nth-child(2) > b:nth-child(1) > span")
	private WebElement textCustomerCompletedlist;
	
	public String getTextCustomerCompletedlist() {
		return textCustomerCompletedlist.getText();
	}
}

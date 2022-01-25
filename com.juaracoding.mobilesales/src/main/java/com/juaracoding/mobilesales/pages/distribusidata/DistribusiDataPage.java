package com.juaracoding.mobilesales.pages.distribusidata;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracoding.mobilesales.driver.DriverSingleton;

public class DistribusiDataPage {

	private WebDriver driver;

	public DistribusiDataPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#no_status_alert > div > div > div.modal-header > button")
	private WebElement closealert;
	
	@FindBy(css = "#s2id_status > a")
	private WebElement btnstatusdistribusi;
	
	@FindBy(css = "#widget-grid > div.row > div > a:nth-child(5)")
	private WebElement kategoridatabaru;
	
	@FindBy(css = "#widget-grid > div.row > div > a:nth-child(6)")
	private WebElement kategorijadwalulang;
	
	@FindBy(css = "#widget-grid > div.row > div > a:nth-child(7)")
	private WebElement kategorigagalpickup;
	
	@FindBy(css = "#widget-grid > div.row > div > a:nth-child(8)")
	private WebElement kategoribatal;
	
	@FindBy(css = "#widget-grid > div.row > div > a:nth-child(9)")
	private WebElement kategorirts;
	
	@FindBy(css = "#widget-grid > div.row > div > a:nth-child(10)")
	private WebElement kategoriuncoverage;
	
	@FindBy(css = "#widget-grid > div.row > div > a:nth-child(11)")
	private WebElement kategorinorespon;
	
	@FindBy(css = "#widget-grid > div.row > div > a:nth-child(12)")
	private WebElement kategorinostatus;
	
	@FindBy(css = "#widget-grid > div.row > div > a:nth-child(13)")
	private WebElement kategoriresignatauterminate;

	@FindBy(css = "#s2id_distribution_to > a")
	private WebElement selectMobileSales;

	@FindBy(css = "#s2id_is_reupload > a")
	private WebElement selectFilterData;

	@FindBy(xpath = "//label[@class='checkbox']//i")
	private List<WebElement> listcustomer;

	public void KategoriPilihan() {
		btnClosealert();
		kategorijadwalulang.click();
		btnClosealert();
		kategorigagalpickup.click();
		btnClosealert();
		kategoribatal.click();
		btnClosealert();
		kategorirts.click();
		btnClosealert();
		kategoriuncoverage.click();
		btnClosealert();
		kategorinorespon.click();
		btnClosealert();
		kategorinostatus.click();
		btnClosealert();
		kategoriresignatauterminate.click();
		btnClosealert();
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

	public void PickKategori() {
		kategoridatabaru.click();
		btnClosealert();
		StatusDistribusi(0);
		MobileSales(1);
	}
	
	public void StatusDistribusi(int selection) {
		btnstatusdistribusi.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(cs)).perform();
	}

	public void MobileSales(int selection) {
		selectMobileSales.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(cs)).perform();
	}

	public void SelectFilter() {
		FilterData(1);
	}

	public void pickCustomer() {
		listcustomer.get(0).click();
	}

	public void FilterData(int selection) {
		selectFilterData.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	@FindBy(css = "#data-distribusi_length > label > select")
	private WebElement jumlahDataTabel;

	public void pilihJumlahData(int pilih) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JumlahData(pilih);
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
	
	@FindBy(css = "#data-distribusi_paginate > ul > li > a")
	private List<WebElement> page;
	
	@FindBy(css = "#data-distribusi_previous > a")
	private WebElement pagePrevious;

	@FindBy(css = "#data-distribusi_next > a")
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
		pageNext.click();
	}
	
	@FindBy(css = "#data-distribusi_filter > label > input")
	private WebElement inputsearch;
	
	@FindBy(css = "#btnSearch")
	private WebElement btnsearch;
	
	public void Searching(String search) {
		inputsearch.sendKeys(search);
		btnsearch.click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(css = "#div_submit > button")
	private WebElement btnsubmit;

	public void SubmitData() {
		btnsubmit.click();
		btnClosealert();
	}
	
	@FindBy(css = "#in_proses")
	private WebElement textinproses;
	
	@FindBy(css = "#belum_pick_up")
	private WebElement textbelumpickup;
	
	@FindBy(css = "#jadwal_ulang")
	private WebElement textjadwalulang;
	
	public String getTextinproses() {
		return textinproses.getAttribute("value");
	}
	
	public String getTextbelumpickup() {
		return textbelumpickup.getAttribute("value");
	}
	
	public String getTextjadwalulang() {
		return textjadwalulang.getAttribute("value");
	}
}

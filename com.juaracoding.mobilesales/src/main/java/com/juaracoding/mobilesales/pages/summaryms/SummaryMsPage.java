package com.juaracoding.mobilesales.pages.summaryms;

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



public class SummaryMsPage {
	
	private WebDriver driver;
	
	public SummaryMsPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
//	INPUT SUMMARY MS
	
	@FindBy(css = "#s2id_cbo_kategori > a > span.select2-arrow > b")
	private WebElement kategori;
	
	@FindBy(xpath = "//input[@name='tanggal_dari']")
	private WebElement inputTanggalAwal;
	
	@FindBy(xpath = "//input[@name='tanggal_sampai']")
	private WebElement inputTanggalAkhir;
	
	@FindBy(css = "#checkout-form > table > tbody > tr:nth-child(3) > td > button")
	private WebElement btnGo;
	
//	HALAMAN DEPAN SUMMARY MS
	
	@FindBy(css = "#content > div.row > div.col-xs-12.col-sm-9.col-md-9.col-lg-9 > h1 > span > b")
	private WebElement errorBack;
	
	@FindBy(css = "#dt_basic_length > label > select")
	private WebElement jumlahDataTabel;
	
	@FindBy(css = "#dt_basic5_length > label > select")
	private WebElement jumlahDataTabelUncoverage;
	
	@FindBy(css = "#myTab1 > li:nth-child(2) > a")
	private WebElement unconverageTabel;
	
	@FindBy(css = "#dt_basic5 > thead > tr > th.sorting_asc")
	private WebElement sortNo;
	
	@FindBy(css = "#dt_basic5 > thead > tr > th:nth-child(2)")
	private WebElement sortKeterangan;
	
	@FindBy(css = "#myTab1 > li:nth-child(1) > a")
	private WebElement listTabel;
	
	@FindBy(css = "#dt_basic > thead > tr > th.sorting_asc")
	private WebElement sortNoList;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(2)")
	private WebElement sortPeruntukan;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(3)")
	private WebElement sortTotal;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(4)")
	private WebElement sortSuksesPU;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(5)")
	private WebElement sortGagalPU;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(6)")
	private WebElement sortCancelCS;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(7)")
	private WebElement sortJadwalUlang;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(8)")
	private WebElement sortNoStatus;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(9)")
	private WebElement sortPURate;
	
	@FindBy(css = "#dt_basic5_filter > label > input")
	private WebElement txtSearchUncoverage;
	
	@FindBy(css = "#dt_basic_filter > label > input")
	private WebElement txtSearch;
	
	@FindBy(css = "#content > div.row > div.col-xs-12.col-sm-3.col-md-3.col-lg-3.full-right > h1 > span > a")
	private WebElement btnBack;
	
	@FindBy(css = "#dt_basic > tbody > tr > td")
	private WebElement tabel;
	
	@FindBy(css = "#no_status_alert > div > div > div.modal-header > button")
	private WebElement alert;
	
//	HALAMAN DETAIL MS
	
	@FindBy(css = "#dt_basic > tbody > tr > td:nth-child(10) > a")
	private WebElement btnDetailTabel;
	
	@FindBy(css = "#dt_basic_length > label > select")
	private WebElement jumlahDataTabelDetail1;
	
	@FindBy(css = "#dt_basic_filter > label > input")
	private WebElement txtSearchDetail1;
	
	@FindBy(css = "#dt_basic > thead > tr > th.sorting_asc")
	private WebElement sortNoDetail1;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(2)")
	private WebElement sortNoDetail2;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(3)")
	private WebElement sortNoDetail3;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(4)")
	private WebElement sortNoDetail4;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(5)")
	private WebElement sortNoDetail5;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(6)")
	private WebElement sortNoDetail6;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(7)")
	private WebElement sortNoDetail7;
	
	@FindBy(css = "#dt_basic > thead > tr > th:nth-child(8)")
	private WebElement sortNoDetail8;
	
	@FindBy(css = "#myTab1 > li:nth-child(2) > a")
	private WebElement tabelDetail;

	@FindBy(css = "#dt_basic2_length > label > select")
	private WebElement jumlahDataTabelDetail2;
	
	@FindBy(css = "#dt_basic2_filter > label > input")
	private WebElement txtSearchDetail2;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(1)")
	private WebElement sortNoDetail21;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(2)")
	private WebElement sortNoDetail22;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(3)")
	private WebElement sortNoDetail23;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(4)")
	private WebElement sortNoDetail24;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(5)")
	private WebElement sortNoDetail25;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(6)")
	private WebElement sortNoDetail26;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(7)")
	private WebElement sortNoDetail27;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(8)")
	private WebElement sortNoDetail28;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(9)")
	private WebElement sortNoDetail29;
	
	@FindBy(css = "#dt_basic2 > thead > tr > th:nth-child(10)")
	private WebElement sortNoDetail30;
	
	@FindBy(css = "#myTab1 > li:nth-child(3) > a")
	private WebElement tabelDetail2;
	
	@FindBy(css = "#myTab1 > li:nth-child(4) > a")
	private WebElement tabelDetail3;
	
	@FindBy(css = "#myTab1 > li:nth-child(5) > a")
	private WebElement tabelDetail4;
	
	@FindBy(css = "#myTab1 > li:nth-child(6) > a")
	private WebElement tabelDetail5;

	@FindBy(css = "#wid-id-12 > div > div.row > div.col-xs-12.col-sm-3.col-md-3.col-lg-3.full-right > h1 > span > a")
	private WebElement btnBackDetail;
	
//	HALAMAN
	
	@FindBy(css = "#dt_basic5_previous > a")
	private WebElement previousUncoverage;
	
	@FindBy(css = "#dt_basic5_next > a")
	private WebElement nextUncoverage;
	
	@FindBy(css = "#dt_basic_previous > a")
	private WebElement previousList;
	
	@FindBy(css = "#dt_basic_next > a")
	private WebElement nextList;
	
	@FindBy(css = "#dt_basic_previous > a")
	private WebElement previousDetail;
	
	@FindBy(css = "#dt_basic_next > a")
	private WebElement nextDetail;
	
	@FindBy(css = "#dt_basic_paginate > ul > li.paginate_button.active > a")
	private WebElement page1Detail;
	
	
	
	public void errorBtnBack() {
		btnBack.click();
		btnClosealert();
	}
	
	public WebElement getDisplayBack() {
		return errorBack;
	}
	
	public void inputSummaryMSadmin(String tanggalawalsummaryms, String tanggalakhirsummaryms) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Kategori(0);
		
		inputTanggalAwal.sendKeys(Keys.CONTROL+"a",tanggalawalsummaryms);
		inputTanggalAwal.sendKeys(tanggalawalsummaryms);
		
		inputTanggalAkhir.sendKeys(Keys.CONTROL+"a",tanggalakhirsummaryms);
		inputTanggalAkhir.sendKeys(tanggalakhirsummaryms);
		
		btnGo.click();
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void viewSummaryMSAdmin(String searchsummaryms) {
		
		unconverageTabel.click();
		JumlahDataUnconverage(2);
		sortNo.click();
		sortKeterangan.click();
		nextUncoverage.click();
		previousUncoverage.click();
		txtSearchUncoverage.sendKeys(searchsummaryms);
		
		listTabel.click();
		JumlahData(2);
		sortNoList.click();
		sortPeruntukan.click();
		sortTotal.click();
		sortSuksesPU.click();
		sortGagalPU.click();
		sortCancelCS.click();
		sortJadwalUlang.click();
		sortNoStatus.click();
		sortPURate.click();
		nextList.click();
		previousList.click();
		txtSearch.sendKeys(searchsummaryms);
	}
	
	public void inputSummaryMSspv(String tanggalawalsummaryms, String tanggalakhirsummaryms) {
		JavascriptExecutor js = (JavascriptExecutor)driver;

		btnClosealert();
		Kategori(0);
		
		inputTanggalAwal.sendKeys(Keys.CONTROL+"a",tanggalawalsummaryms);
		inputTanggalAwal.sendKeys(tanggalawalsummaryms);
		
		inputTanggalAkhir.sendKeys(Keys.CONTROL+"a",tanggalakhirsummaryms);
		inputTanggalAkhir.sendKeys(tanggalakhirsummaryms);
		
		btnGo.click();
		btnClosealert();
		
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void viewSummaryMSSpv(String searchsummaryms) {
		unconverageTabel.click();
		JumlahDataUnconverage(2);
		sortNo.click();
		sortKeterangan.click();
		nextUncoverage.click();
		previousUncoverage.click();
		txtSearchUncoverage.sendKeys(searchsummaryms);
		
		listTabel.click();
		JumlahData(2);
		sortNoList.click();
		sortPeruntukan.click();
		sortTotal.click();
		sortSuksesPU.click();
		sortGagalPU.click();
		sortCancelCS.click();
		sortJadwalUlang.click();
		sortNoStatus.click();
		sortPURate.click();
		nextList.click();
		previousList.click();
		txtSearch.sendKeys(searchsummaryms);
		btnDetailTabel.click();
	}
	
	public void viewSummaryMSDetail(String searchsummarymsdetail, String searchsummarymsdetail2) {
		
		sortNoDetail1.click();
		sortNoDetail2.click();
		sortNoDetail3.click();
		sortNoDetail4.click();
		sortNoDetail5.click();
		sortNoDetail6.click();
		sortNoDetail7.click();
		sortNoDetail8.click();
		JumlahDataDetail(2);
		nextDetail.click();
		previousDetail.click();
		page1Detail.click();
		txtSearchDetail1.sendKeys(searchsummarymsdetail);
		
		tabelDetail.click();
		sortNoDetail21.click();
		sortNoDetail22.click();
		sortNoDetail23.click();
		sortNoDetail24.click();
		sortNoDetail25.click();
		sortNoDetail26.click();
		sortNoDetail27.click();
		sortNoDetail28.click();
		sortNoDetail29.click();
		sortNoDetail30.click();
		JumlahDataDetail2(2);
		txtSearchDetail2.sendKeys(searchsummarymsdetail2);
		
		tabelDetail2.click();
		tabelDetail3.click();
		tabelDetail4.click();
		tabelDetail5.click();
		btnBackDetail.click();
		btnClosealert();
	}
	
	public void alertSpv() {
		alert.click();
	}
	
	public WebElement getDisplayTabel() {
		return tabel;
	}
	
	
	@FindBy(css = "#dt_basic > tbody > tr.gradeX.odd > td:nth-child(2)")
	private WebElement textAfterSummarMS;
	
	public String getTextSummaryMS() {
		return textAfterSummarMS.getText();
	}
	
	@FindBy(css = "#dt_basic > tbody > tr > td")
	private WebElement textAfterSummarMSSuperAdmin;
	
	public String getTextSummaryMSSuperAdmin() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", textAfterSummarMSSuperAdmin);
		return textAfterSummarMSSuperAdmin.getText();
	}
	
	public void btnClosealert() {
		while(alert.isDisplayed()) {
			try {
				alert.click();
			} catch (Exception e) {
				break;
				
			}
		}
		
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
	
	public void JumlahDataUnconverage (int selection) {			
		jumlahDataTabelUncoverage.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void JumlahDataDetail (int selection) {			
		jumlahDataTabelDetail1.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void JumlahDataDetail2 (int selection) {			
		jumlahDataTabelDetail2.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
}

package com.juaracoding.mobilesales.pages.worklist;

import java.util.ArrayList;
import java.util.List;

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

public class WorklistPage {
	
	private WebDriver driver;
	
	public WorklistPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#data-worklist_length > label > select")
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
	
	@FindBy(css = "#data-worklist_paginate > ul > li > a")
	private List<WebElement> page;

	@FindBy(css = "#data-worklist_previous > a")
	private WebElement pagePrevious;

	@FindBy(css = "#data-worklist_next > a")
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
	
	@FindBy(css = "#data-worklist_filter > label > input")
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
	
	@FindBy(xpath = "//*[@id='data-worklist']//address//a[1]")
	private List<WebElement> listcustomer;
	
	@FindBy(xpath = "//*[@id='data-worklist']//address//a[2]")
	private List<WebElement> listmapcustomer;
	
	public void chooseCustomer() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(listcustomer.get(0)));
		listcustomer.get(0).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void chooseCustomerMap() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(listmapcustomer.get(0)));
		listmapcustomer.get(0).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(css = "#div_bukti_sukses > section:nth-child(1) > label.input > a:nth-child(1) > span")
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
	
	@FindBy(css = "#div_bukti_sukses > section:nth-child(2) > label.input > a:nth-child(1) > span")
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
	
	@FindBy(css = "#div_bukti > section > label.input > a:nth-child(1)")
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
	
	@FindBy(css = "#s2id_kode_pick_up > a > span.select2-arrow > b")
	private WebElement btnstatusPU;
	
	@FindBy(css = "#s2id_autogen20 > a")
	private WebElement btnkodepromo;
	
	@FindBy(id = "notes")
	private WebElement inputnotes;
	
	@FindBy(id = "note")
	private WebElement inputnote;
	
	@FindBy(css = "#div_sukses > section:nth-child(2) > input")
	private WebElement inputregid;
	
	@FindBy(css = "#s2id_autogen16 > a > span.select2-arrow > b")
	private WebElement btnReasonGagal;
	
	@FindBy(css = "#s2id_autogen18 > a > span.select2-arrow > b")
	private WebElement btnReasonBatal;
	
	public void fillWroklistSurveySuksesPU(String note) {
		StatusPickUp(1);
		KodePromo(1);
		inputregid.sendKeys("test1");
		inputnotes.sendKeys(note);
	}
	/*update terbaru belum kepake*/
	public void fillWroklistSurveyGagalPU(String note) {
		StatusPickUp(1);
		Gagal(1);
		inputnotes.sendKeys(note);
	}
	
	public void fillWroklistSurveyBatalPU(String note) {
		StatusPickUp(1);
		Batal(1);
		inputnotes.sendKeys(note);
	}
	
	@FindBy(xpath = "//input[@name='tanggal_reschedule']")
	private WebElement inputreschedule;

	public void fillWroklistSurveyReschedule(String note,String tanggalreschedule) {
		StatusPickUp(1);
		inputnote.sendKeys(note);
		inputreschedule.sendKeys(Keys.CONTROL + "a", tanggalreschedule);
		inputreschedule.sendKeys(tanggalreschedule);
	}
	
	public void fillWroklistSurveyNoRespon() {
		StatusPickUp(1);
	}
	
	public void StatusPickUp (int selection) {
		btnstatusPU.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void KodePromo (int selection) {
		btnkodepromo.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void Gagal (int selection) {
		btnReasonGagal.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void Batal (int selection) {
		btnReasonBatal.click();
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	@FindBy(css = "#checkout-form > fieldset:nth-child(3) > footer > button")
	private WebElement btnsubmit;
	
	public void submit() {
		btnsubmit.click();
	}
	
	@FindBy(css = "#checkout-form > fieldset:nth-child(3) > footer > a.btn.btn-danger")
	private WebElement btnbackfromupdatestatus;
	
	public void backfromupdatestatus() {
		btnbackfromupdatestatus.click();
	}
	
	@FindBy(css = "#checkout-form > fieldset:nth-child(3) > footer > a.btn.btn-success")
	private WebElement btnsurveyalamat;
	
	public void surveyAlamat() {
		btnsurveyalamat.click();
	}
	
	
	@FindBy(css = "#lokasi_terkini")
	private WebElement inputlokasiterkini;
	
	@FindBy(css = "#lokasi_tujuan")
	private WebElement inputlokasitujuan;
	
	@FindBy(css = "#lihat")
	private WebElement btnsubmitsurvey;
	
	public void fillSurveyAlamat(String lokasiterkini, String tujuan) {
		inputlokasiterkini.sendKeys(lokasiterkini);
		inputlokasitujuan.clear();
		inputlokasitujuan.sendKeys(tujuan);
	}
	
	public void submitSurvey() {
		btnsubmitsurvey.click();
	}
	
	@FindBy(css = "#content > div.well > footer > a.btn.btn-danger")
	private WebElement btnbackfromsurvey;
	
	public void backfromSurveyAlamat() {
		btnbackfromsurvey.click();
	}
	
	@FindBy(css = "#maps > div > div > div > div.gm-err-message")
	private WebElement texterrormap;
	
	public String getTexterrormap() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", texterrormap);
		return texterrormap.getText();
	}
	
	@FindBy(css = "#content > div.well > footer > a.btn.btn-danger")
	private WebElement btnbackfromsurveyalamat;
	
	public void backFromSurvey() {
		btnbackfromsurveyalamat.click();
	}
	
	@FindBy(css = "#content > div.well > footer > a.btn.btn-success")
	private WebElement btnpickup;
	
	public void goToPickUp() {
		btnpickup.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(css = "#ribbon > ol > span > b > h4")
	private WebElement textafterworklist;
	
	public String getTextafterWorklist() {
		return textafterworklist.getText();
	}
}

package com.juaracoding.mobilesales.glue;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.juaracoding.mobilesales.config.AutomationFrameworkConfiguration;
import com.juaracoding.mobilesales.driver.DriverSingleton;
import com.juaracoding.mobilesales.pages.HomePage;
import com.juaracoding.mobilesales.pages.LoginPage;
import com.juaracoding.mobilesales.pages.completedlist.CompletedListPage;
import com.juaracoding.mobilesales.pages.distribusidata.DistribusiDataPage;
import com.juaracoding.mobilesales.pages.master.MasterParameterUploadPage;
import com.juaracoding.mobilesales.pages.master.MasterPosterPage;
import com.juaracoding.mobilesales.pages.master.MasterUserPage;
import com.juaracoding.mobilesales.pages.summaryms.SummaryMsPage;
import com.juaracoding.mobilesales.pages.uploadfilems.UploadFileMSPage;
import com.juaracoding.mobilesales.pages.worklist.WorklistPage;
import com.juaracoding.mobilesales.utils.ConfigurationProperties;
import com.juaracoding.mobilesales.utils.Constants;
import com.juaracoding.mobilesales.utils.TestCase;
import com.juaracoding.mobilesales.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
	
	private static WebDriver driver;
	private LoginPage loginPage;
	private HomePage homepage;
	private MasterUserPage masteruserPage;
	private MasterParameterUploadPage masterparameterPage;
	private MasterPosterPage masterposterPage;
	private UploadFileMSPage uploadfilems;
	private DistribusiDataPage distribusidata;
	private WorklistPage worklist;
	private CompletedListPage completedlist;
	private SummaryMsPage summaryms;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports();
	static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("src/test/resources/reporttest.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void InitializeObject() {
		
		report.attachReporter(htmlreporter);
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		homepage = new HomePage();
		masteruserPage = new MasterUserPage();
		masterparameterPage = new MasterParameterUploadPage();
		masterposterPage = new MasterPosterPage();
		uploadfilems = new UploadFileMSPage();
		distribusidata = new DistribusiDataPage();
		worklist = new WorklistPage();
		completedlist = new CompletedListPage();
		summaryms = new SummaryMsPage();
		TestCase[] tests =TestCase.values();
		extentTest = report.createTest(tests[Utils.testcount].getTestname());
		Utils.testcount++;
		
	}
	
//	LOGIN
//	User Super Admin
	
	@Given("^User membuka url")
	public void user_membuka_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.pass("User berhasil membuka url " + Constants.URL);
	}

	@When("^Mengisi username dan password login user Super Admin")
	public void mengisi_username_dan_password_login_user_super_admin() {
		loginPage.fillFormLogin(configurationProperties.getName1(), configurationProperties.getPassword1());
		extentTest.pass("User berhasil klik username dan mengisi teks username");
		extentTest.pass("User berhasil klik password dan mengisi teks password");		
	}	
	
	@Then("^User super admin dapat login ke Website")
	public void user_super_admin_dapat_login_ke_Website() {
		loginPage.clickBtnLogin();
		loginPage.closeDisplayAlert();
		if(loginPage.getTextUserLogin().equalsIgnoreCase(configurationProperties.getTextafterlogin1())) {
			extentTest.pass("User SuperAdmin klik button Submit dan berhasil login ke Website");
		}else {
			try {
				Thread.sleep(1000);
				extentTest.fail("User berhasil Login user Super Admin tetapi ada kesalahan teknis", 
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(configurationProperties.getTextafterlogin1(), loginPage.getTextUserLogin());
	}
	
//	LOGIN
//	User Supervisor
	
	@Given("User keluar dari user Super Admin")
	public void user_keluar_dari_user_super_admin() {
		loginPage.Logout();
		extentTest.pass("User berhasil membuka url " + Constants.URL);
	}
			
	@When("Mengisi username dan password login user Supervisor")
	public void mengisi_username_dan_password_login_user_supervisor() {
		loginPage.fillFormLogin(configurationProperties.getName2(), configurationProperties.getPassword2());
		extentTest.pass("User berhasil klik username dan mengisi teks username");
		extentTest.pass("User berhasil klik password dan mengisi teks password");
	}
			
	@Then("User supervisor dapat login ke Website")
	public void user_supervisor_berhasil_login_user_supervisor() {
		loginPage.clickBtnLogin();
		loginPage.closeDisplayAlert();
		if(loginPage.getTextUserLogin().equalsIgnoreCase(configurationProperties.getTextafterlogin2())) {
			extentTest.pass("User Supervisor klik button Submit dan berhasil login ke Website");
		}else {
			try {
				Thread.sleep(1000);
				extentTest.fail("User berhasil Login user Supervisor tetapi ada kesalahan teknis", 
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (Exception e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(loginPage.getTextUserLogin(), configurationProperties.getTextafterlogin2());
	}
		
//	LOGIN
//	User Mobile Sales
		
		@Given("User keluar dari user Supervisor")
		public void user_keluar_dari_user_supervisor() {
			loginPage.Logout();
			extentTest.pass("User berhasil membuka url " + Constants.URL);
		}
			
		@When("Mengisi username dan password login user Mobile Sales")
		public void mengisi_username_dan_password_login_user_mobile_sales() {
			loginPage.fillFormLogin(configurationProperties.getName3(), configurationProperties.getPassword3());
			extentTest.pass("User berhasil klik username dan mengisi teks username");
			extentTest.pass("User berhasil klik password dan mengisi teks password");
		}
			
		@Then("User mobile sales dapat login ke Website")
		public void user_mobile_sales_berhasil_login_user_mobile_sales() {
			loginPage.clickBtnLogin();
			loginPage.closeDisplayAlert();
			if(loginPage.getTextUserLogin().equalsIgnoreCase(configurationProperties.getTextafterlogin3())) {
				extentTest.pass("User Mobile Sales klik button Submit dan berhasil login ke Website");
			}else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User berhasil Login user Supervisor tetapi ada kesalahan teknis", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(loginPage.getTextUserLogin(), configurationProperties.getTextafterlogin3());
		}
	
//		MASTER AKUN	
//		NEW
		@Given("User keluar dari user mobile sales dan login sebagai super admin")
		public void user_keluar_dari_user_mobile_sales_dan_login_sebagai_super_admin() {
			loginPage.Logout();
			loginPage.fillFormLogin(configurationProperties.getName1(), configurationProperties.getPassword1());
			loginPage.clickBtnLogin();
			loginPage.closeDisplayAlert();
		}
		
		@When("^User klik menu Master User lalu klik Add New User")
		public void user_klik_menu_master_user_lalu_klik_add_new_user() {
			homepage.toMaster();
			masteruserPage.intoMasterUser();
			masteruserPage.MasterUser();
			extentTest.pass("User berhasil klik Master dan menampilkan submenu di menu Master");
			extentTest.pass("User berhasil klik User dan menampilkan data User");
			extentTest.pass("User berhasil klik button Add New User dan menampilkan form tambah User");		
			extentTest.pass("User berhasil menampilkan User Name di master user");
			extentTest.pass("User berhasil menampilkan Name di master user");
			extentTest.pass("User berhasil menampilkan Email di master user");
			extentTest.pass("User berhasil menampilkan Picture di master user");
			extentTest.pass("User berhasil menampilkan Position di master user");
			extentTest.pass("User berhasil menampilkan Status di master user");
			extentTest.pass("User berhasil menampilkan Created By di master user");
		}
		
		@When("^User memasukan data di form add user dan klik Submit")
		public void user_memasukan_data_di_form_add_user_dan_klik_submit() {
			masteruserPage.formMasterUser(configurationProperties.getNikmasteruser(), configurationProperties.getNamemasteruser(), 
					configurationProperties.getUsernamemasteruser(), configurationProperties.getPasswordmasteruser(), 
					configurationProperties.getEmailmasteruser(), configurationProperties.getPicturemasteruser(), configurationProperties.getSearchpopupmaster());
			extentTest.pass("User berhasil klik button Operation dan menampilkan popup operation");
			extentTest.pass("User berhasil klik search dan mengisi teks pencarian");
			extentTest.pass("User berhasil klik button Pilih pada popup dan menampilkan data user operation");
			extentTest.pass("User berhasil klik button Sales dan menampilkan popup sales");
			extentTest.pass("User berhasil klik search dan mengisi teks pencarian");
			extentTest.pass("User berhasil klik button Pilih pada popup dan menampilkan data user sales");
			extentTest.pass("User berhasil klik nik / sales code dan mengisi nik / sales code");
			extentTest.pass("User berhasil mengisi name");
			extentTest.pass("User berhasil memilih kategori");
			extentTest.pass("User berhasil mengisi User name");
			extentTest.pass("User berhasil mengisi password");
			extentTest.pass("User berhasil mengisi email");
			extentTest.pass("User berhasil memilih direktori gambar");
			extentTest.pass("User berhasil memilih status");
			extentTest.pass("User berhasil klik button Back dan kembali ke halaman sebelumnya");
		}
		
		@When("^User berhasil membuat akun")
		public void user_berhasil_membuat_akun() {
			masteruserPage.getDisplayMasterAkun();
			assertEquals(configurationProperties.getGetaccountmasteruser(), masteruserPage.getDisplayMasterAkun());
			extentTest.pass("User berhasil klik button Submit dan berhasil membuat akun");
			extentTest.pass("User berhasil klik ikon jumlah data dan memilih jumlah data yang ditampilkan dalam satu halaman");
			extentTest.pass("User berhasil klik button Nomor pada judul tabel dan menampilkan data sesuai sort nomor");
			extentTest.pass("User berhasil klik button User name pada judul tabel dan menampilkan data sesuai sort User name");
			extentTest.pass("User berhasil klik button Name pada judul tabel dan menampilkan data sesuai sort name");
			extentTest.pass("User berhasil klik button Email pada judul tabel dan menampilkan data sesuai sort email");
			extentTest.pass("User berhasil klik button Picture pada judul tabel dan menampilkan data sesuai sort picture");
			extentTest.pass("User berhasil klik button Position pada judul tabel dan menampilkan data sesuai sort position");
			extentTest.pass("User berhasil klik button Status pada judul tabel dan menampilkan data sesuai sort status");
			extentTest.pass("User berhasil klik button Created By pada judul tabel dan menampilkan data sesuai sort created by");
		}
		
//		EDIT
		@When("^User klik ikon edit pada tabel user")
		public void user_klik_ikon_edit_pada_tabel_user() {
			masteruserPage.editUser(configurationProperties.getUsernamedituser(), configurationProperties.getNamaedituser(),
					configurationProperties.getEmailedituser(), configurationProperties.getPictureedituser());
			extentTest.pass("User berhasil klik button edit pada tabel dan menampilkan form edit Users");
			extentTest.pass("User berhasil klik kategori dan memilih kategori");
			extentTest.pass("User berhasil mengisi User name");
			extentTest.pass("User berhasil mengisi name");
			extentTest.pass("User berhasil mengisi email");
			extentTest.pass("User berhasil memilih direktori gambar");
			extentTest.pass("User berhasil memilih status");
		}
		
		@When("^User melakukan edit data user lalu klik Submit")
		public void user_melakukan_edit_data_lalu_klik_submit() {
			masteruserPage.editUserBug();
		}
		
		@When("^User berhasil melakukan edit akun user")
		public void user_berhasil_melakukan_edit_akun() {
		
			if(masteruserPage.getDisplayEdit().isDisplayed()) {
				
				try {
					Thread.sleep(1000);
					extentTest.fail("User gagal melakukan edit data setelah klik tombol Submit dengan screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				extentTest.pass("User berhasil melakukan edit akun");	
			}
			homepage.toMaster();
			masteruserPage.intoMasterUser();
			masteruserPage.lanjuteditUser();
			extentTest.pass("User berhasil klik button back dan kembali ke halaman sebelumnya");
			extentTest.pass("User berhasil mengisi teks pencarian");
		}
		
//		DELETE
		@When("^User klik ikon delete pada tabel user")
		public void user_klik_ikon_delete_pada_tabel() {
			masteruserPage.deleteUser(configurationProperties.getSearchuser());
			extentTest.pass("User berhasil klik button hapus pada tabel dan berhasil melakukan delete akun user");
		}
		@Then("^User berhasil melakukan delete akun")
		public void user_berhasil_melakukan_delete_akun() {
			masteruserPage.getDisplayMasterAkun();
			assertEquals(configurationProperties.getGetaccountmasteruser(), masteruserPage.getDisplayMasterAkun());
			extentTest.pass("User berhasil klik ikon Next dan menampilkan data User selanjutnya");
			extentTest.pass("User berhasil klik ikon Previous dan menampilkan data User sebelumnya");
			extentTest.pass("User berhasil klik ikon halaman dan memilih nomor halaman data user  sesuai nomor halaman");
			extentTest.pass("User berhasil klik button UP dan melakukan scroll ke bagian paling atas halaman");

		}
		
//		MASTER PARAMETER UPLOAD
//		NEW
		@When("^User klik menu Master Parameter Upload lalu klik Add New")
		public void user_klik_menu_master_parameter_upload_lalu_klik_add_new() {
			homepage.toMaster();
			masterparameterPage.intoMasterParameterUpload();
			masterparameterPage.MasterParameter();
			extentTest.pass("User berhasil klik Parameter Upload dan menampilkan data parameter upload");
			extentTest.pass("User berhasil klik button add new dan menampilkan form tambah parameter upload");
		}
		
		@When("^User memasukan data di form parameter dan klik Submit")
		public void user_memasukan_data_di_form_parameter_dan_klik_submit() {
			masterparameterPage.formMasterParameter(configurationProperties.getNikmasterparameter(), configurationProperties.getNamemasterparameter(), 
					configurationProperties.getPositionmasterparameter(), configurationProperties.getBranchmasterparameter(), 
					configurationProperties.getAreamasterparameter(), configurationProperties.getSearchpopupmaster());
			extentTest.pass("User berhasil klik button sales dan menampilkan popup sales");
			extentTest.pass("User berhasil mengisi teks pencarian");
			extentTest.pass("User berhasil klik button pilih pada popup dan menampilkan data User operation");
			extentTest.pass("User berhasil mengisi nik / sales code");
			extentTest.pass("User berhasil mengisi name");
			extentTest.pass("User berhasil mengisi position");
			extentTest.pass("User berhasil mengisi branch");
			extentTest.pass("User berhasil mengisi area");		
		}
		
		@When("^User berhasil membuat Data Pamameter Upload")
		public void user_berhasil_membuat_data_pamameter_upload() {
			masterparameterPage.getDisplayMasterParameter();
			assertEquals(configurationProperties.getGetaccountmasterparameter(), masterparameterPage.getDisplayMasterParameter());
			extentTest.pass("User berhasil klik button Submit dan berhasil membuat Data Pamameter Upload");
			extentTest.pass("User berhasil menampilkan Nik / Sales Code di master parameter upload");
			extentTest.pass("User berhasil menampilkan Nama di master parameter upload");
			extentTest.pass("User berhasil menampilkan Position di master parameter upload");
			extentTest.pass("User berhasil menampilkan Branch di master parameter upload");
			extentTest.pass("User berhasil menampilkan Area di master parameter upload");
			extentTest.pass("User berhasil menampilkan Status di master parameter upload");
			
			masterparameterPage.erorFormNewbtnBack();
			if(masterparameterPage.getDisplayUser().isDisplayed()) {
				
				try {
					Thread.sleep(1000);
					extentTest.fail("Tombol Back pada form Add Parameter Upload error karena direct ke halaman Master User dengan screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				extentTest.pass("User memasukan data di form parameter dan klik Submit");	
			}
			extentTest.pass("User berhasil klik ikon jumlah data dan memilih jumlah data yang ditampilkan dalam satu halaman");
			extentTest.pass("User berhasil klik button Nomor pada judul tabel dan menampilkan data sesuai sort nomor");
			extentTest.pass("User berhasil klik button Nik/sales code pada judul tabel dan menampilkan data sesuai sort nik/sales code");
			extentTest.pass("User berhasil klik button Nama pada judul tabel dan menampilkan data sesuai sort nama");
			extentTest.pass("User berhasil klik button Position pada judul tabel dan menampilkan data sesuai sort position");
			extentTest.pass("User berhasil klik button Branch pada judul tabel dan menampilkan data sesuai sort branch");
			extentTest.pass("User berhasil klik button Area pada judul tabel dan menampilkan data sesuai sort area");
			extentTest.pass("User berhasil klik button Status pada judul tabel dan menampilkan data sesuai sort status");

		}
		
//		EDIT
		@When("^User klik ikon edit pada tabel")
		public void user_klik_ikon_edit_pada_tabel() {
			homepage.toMaster();
			masterparameterPage.intoMasterParameterUpload();	
			extentTest.pass("User berhasil klik button edit pada tabel dan menampilkan form edit parameter upload");
			extentTest.pass("User berhasil menampilkan Nik / Sales Code di form edit parameter upload");
			extentTest.pass("User berhasil menampilkan Name di form edit parameter upload");
			extentTest.pass("User berhasil menampilkan Position di form edit parameter upload");
			extentTest.pass("User berhasil menampilkan Branch di form edit parameter upload");
			extentTest.pass("User berhasil menampilkan Area di form edit parameter upload");
			extentTest.pass("User berhasil klik status dan memilih status");
			
		}
		
		@When("^User melakukan edit data lalu klik Submit")
		public void user_melakukan_edit_data_parameter_lalu_klik_submit() {
			masterparameterPage.formEditbtnBack();		
			extentTest.pass("User berhasil klik button Submit dan menyimpan hasil edit");
			
			masterparameterPage.erorFormEditbtnBack();
			if(masterparameterPage.getDisplayUser().isDisplayed()) {
				
				try {
					Thread.sleep(1000);
					extentTest.fail("Tombol Back pada form Edit error karena direct ke halaman Master User dengan screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				extentTest.pass("User melakukan edit data lalu klik Submit");	
			}
		}
		
		@Then("^User berhasil melakukan edit akun")
		public void user_berhasil_melakukan_edit_akun_parameter() {
			homepage.toMaster();
			masterparameterPage.intoMasterParameterUpload();	
			masterparameterPage.lanjutParameter(configurationProperties.getSearchparameter());
			
			masterparameterPage.getDisplayMasterParameter();
			assertEquals(configurationProperties.getGetaccountmasterparameter(), masterparameterPage.getDisplayMasterParameter());		
			extentTest.pass("User berhasil klik ikon Next dan menampilkan data parameter upload selanjutnya");
			extentTest.pass("User berhasil klik ikon Previous dan menampilkan data parameter upload sebelumnya");
			extentTest.pass("User berhasil klik ikon halaman dan memilih nomor halaman data parameter upload sesuai nomor halaman");
			extentTest.pass("User berhasil klik button UP dan melakukan scroll ke bagian paling atas halaman");
		}
		
//		MASTER POSTER
//		NEW
		@When("^User klik menu Master Poster lalu klik Upload Poster")
		public void user_klik_menu_master_poster_lalu_klik_upload_poster() {
			homepage.toMaster();
			masterposterPage.intoMasterPoster();
			masterposterPage.MasterPoster();
			extentTest.pass("User berhasil klik Poster dan menampilkan data setup poster");
			extentTest.pass("User berhasil klik button upload poster dan menampilkan form upload poster");
		}
		
		@When("^User memasukan data di form upload poster dan klik Submit")
		public void user_memasukan_data_di_form_upload_dan_klik_submit() {
			masterposterPage.formMasterPoster(configurationProperties.getProgramnameposter(), 
					configurationProperties.getPicturemasterposter());
			extentTest.pass("User berhasil mengisi program name");
			extentTest.pass("User berhasil memilih direktori gambar");
		}
		
		@When("^User berhasil membuat Poster")
		public void user_berhasil_membuat_poster() {
			masterposterPage.getDisplayMasterPoster();
			assertEquals(configurationProperties.getGetaccountmasterposter(), masterposterPage.getDisplayMasterPoster());
			extentTest.pass("User berhasil klik button Submit dan berhasil membuat Poster");
			extentTest.pass("User berhasil klik button cancel dan kembali ke halaman sebelumnya");
			extentTest.pass("User berhasil menampilkan Program Name di master poster");
			extentTest.pass("User berhasil menampilkan Poster di master poster");
			extentTest.pass("User berhasil menampilkan Status di master poster");
		}
		
//		EDIT
		@When("^User klik ikon edit pada tabel poster")
		public void user_klik_ikon_edit_pada_tabel_poster() {
			masterposterPage.formEditPoster();
			extentTest.pass("User berhasil klik button edit poster pada tabel dan menampilkan form setup poster");
			extentTest.pass("User berhasil klik is active dan memilih status aktif atau tidaknya poster");
			
		}
		
		@When("^User melakukan edit status lalu klik Submit")
		public void user_melakukan_edit_status_lalu_klik_submit() {
			masterposterPage.formEditBack();
		}
		
		@When("^User berhasil melakukan edit poster")
		public void user_berhasil_melakukan_edit_poster() {
			masterposterPage.getDisplayMasterPoster();
			assertEquals(configurationProperties.getGetaccountmasterposter(), masterposterPage.getDisplayMasterPoster());
			extentTest.pass("User berhasil klik button submit dan berhasil melakukan edit poster");
			extentTest.pass("User berhasil klik button cancel dan kembali ke halaman sebelumnya");
		}
		
//		DELETE
		@When("^User klik ikon delete pada tabel poster")
		public void user_klik_ikon_delete_pada_tabel_poster() {
			masterposterPage.formHapusPoster(configurationProperties.getSearchposter());
			extentTest.pass("User berhasil klik ikon jumlah data dan memilih jumlah data yang ditampilkan dalam satu halaman");
			extentTest.pass("User berhasil mengisi teks pencarian");
		}
		
		@Then("^User berhasil melakukan delete poster")
		public void user_berhasil_melakukan_delete_poster() {
			masterposterPage.getDisplayMasterPoster();
			assertEquals(configurationProperties.getGetaccountmasterposter(), masterposterPage.getDisplayMasterPoster());
			extentTest.pass("User berhasil klik ikon Delete dan berhasil melakukan delete poster");
			extentTest.pass("User berhasil klik button Program Name pada judul tabel dan menampilkan data sesuai sort program name");
			extentTest.pass("User berhasil klik button Poster pada judul tabel dan menampilkan data sesuai sort poster");
			extentTest.pass("User berhasil klik button Status pada judul tabel dan menampilkan data sesuai sort status");
			extentTest.pass("User berhasil klik ikon Next dan menampilkan data poster selanjutnya");
			extentTest.pass("User berhasil klik ikon Previous dan menampilkan data poster sebelumnya");
			extentTest.pass("User berhasil klik ikon halaman dan memilih nomor halaman data poster sesuai nomor halaman");	
		}
	
		@When("Klik menu Upload File MS")
		public void intoUploadFileMS() {
			homepage.toUploadFileMS();
			extentTest.pass("User berhasil klik menu Upload File MS");
		}

		@When("Klik download template MS")
		public void Downloded() {
			uploadfilems.DownloadTemplateMS();
			extentTest.pass("User berhasil klik download template MS");
		}

		@When("Klik Upload MS dan memasukan data di form upload file")
		public void fillTheUploadFileMSForm() {
			uploadfilems.fillFormUploadFileMS(configurationProperties.getFilepath(),
					configurationProperties.getTextKeterangan());
			extentTest.pass("User berhasil klik Upload MS");
			extentTest.pass("User berhasil pilih product");
			extentTest.pass("User input direktori file path");
			extentTest.pass("User input keterangan");
		}

		@When("Klik Submit")
		public void SubmitedUploadFileMS() {
			uploadfilems.Submit();
			extentTest.pass("User berhasil klik submit");
		}

		@When("Klik Back dari upload file")
		public void BackFromUploadFile() {
			uploadfilems.fillFormUploadFileMS(configurationProperties.getFilepath(),
					configurationProperties.getTextKeterangan());
			uploadfilems.backFromUpload();
			extentTest.pass("User berhasil Klik Back dari form upload");
		}

		@When("Sorting data customer")
		public void Sort() {
			uploadfilems.sorting();
			extentTest.pass("User berhasil sorting data customer dari klik no.");
			extentTest.pass("User berhasil sorting data customer dari klik uploader");
			extentTest.pass("User berhasil sorting data customer dari klik tanggal");
			extentTest.pass("User berhasil sorting data customer dari klik product");
			extentTest.pass("User berhasil sorting data customer dari klik keterangan");
			extentTest.pass("User berhasil sorting data customer dari klik total data ms");
		}

		@When("Pilih Jumlah Data")
		public void JumlahDataPilihan() {
			uploadfilems.pilihJumlahData(2);
			extentTest.pass("User berhasil pilih Jumlah Data");
		}

		@When("Klik Pindah Page")
		public void TestPindahPage() {
			uploadfilems.buttonPage();
			extentTest.pass("User berhasil klik Previous Page");
			extentTest.pass("User berhasil klik Next Page");
			extentTest.pass("User berhasil klik Nomor Page");
		}

		@When("Scroll Page ke atas dengan button up")
		public void UpPage() {
			uploadfilems.goUp();
			extentTest.pass("User berhasil Scroll Page ke atas dengan button up");
		}

		@When("Mencari Data Upload File MS")
		public void searchingFile() {
			uploadfilems.Searching(configurationProperties.getTextUploader());
			extentTest.pass("User berhasil mencari Data Upload File MS");
		}

		@When("Klik Edit")
		public void ClickedEdit() {
			uploadfilems.EditFile();
			extentTest.pass("User berhasil Klik Edit");
		}
		
		@When("Pilih spv di menu pop up")
		public void menuPopUp() {
			uploadfilems.popup("wahyudi");
			extentTest.pass("User berhasil Klik peruntukan spv");
			extentTest.pass("User berhasil input search di menu pop up");
			extentTest.pass("User berhasil pilih spv di menu pop up");
		}

		@When("Isi form edit file")
		public void Edit() {
			uploadfilems.editUploadFile(configurationProperties.getTextNikPeruntukan(),
					configurationProperties.getTextNamaPeruntukan(), "File Telah Di Edit");
			extentTest.pass("User berhasil Edit NIK SPV yang di perentukan");
			extentTest.pass("User berhasil Edit nama SPV yang di perentukan");
			extentTest.pass("User berhasil Edit file product");
			extentTest.pass("User berhasil Edit file source");
			extentTest.pass("User berhasil Edit keterangan");
		}

		@When("Klik Submit Edit")
		public void SubmitEditFile() {
			uploadfilems.SubmitEdit();
			extentTest.pass("User berhasil Klik Submit Edit");
		}

		@When("Klik Back dari edit")
		public void BackFromEdit() {
			uploadfilems.EditFile();
			uploadfilems.BackFromEdit();
			extentTest.pass("User berhasil Klik Back dari edit");
		}

		@When("Klik Hapus File")
		public void Delete() {
			uploadfilems.DeletFile();
			extentTest.pass("User berhasil Klik Hapus File");
		}

		@When("Klik View")
		public void View() {
			uploadfilems.fillFormUploadFileMS(configurationProperties.getFilepath(),
					configurationProperties.getTextKeterangan());
			uploadfilems.Submit();
			uploadfilems.Searching(configurationProperties.getTextUploader());
			uploadfilems.ViewFile();
			extentTest.pass("User berhasil Klik View");
		}

		@When("Sorting data customer di view")
		public void SortView() {
			uploadfilems.sorting();
			extentTest.pass("User berhasil sorting data customer di view dengan klik no.");
			extentTest.pass("User berhasil sorting data customer di view dengan klik no Case");
			extentTest.pass("User berhasil sorting data customer di view dengan klik Cis");
			extentTest.pass("User berhasil sorting data customer di view dengan klik Name");
			extentTest.pass("User berhasil sorting data customer di view dengan klik DOB");
			extentTest.pass("User berhasil sorting data customer di view dengan klik Gender");
			extentTest.pass("User berhasil sorting data customer di view dengan klik Address");
			extentTest.pass("User berhasil sorting data customer di view dengan klik campaign");
			extentTest.pass("User berhasil sorting data customer di view dengan klik Aggree Date");		
		}

		@When("Pilih Jumlah Data di view")
		public void JumlahPilihan() {
			uploadfilems.pilihJumlahData(2);
			extentTest.pass("User berhasil pilih Jumlah Data di view");
		}

		@When("Klik Pindah Page di view")
		public void TestPindahPageView() {
			uploadfilems.buttonPage();
			extentTest.pass("User berhasil klik Previous Page di view");
			extentTest.pass("User berhasil klik Next Page di view");
			extentTest.pass("User berhasil klik Nomor Page di view");
		}

		@When("Mencari Data Customer")
		public void searchingCustomer() {
			uploadfilems.Searching(configurationProperties.getTextNamaCustomer());
			extentTest.pass("User berhasil mencari Data Customer di view");
		}

		@When("Klik back dari view")
		public void finnishuploadfilems() {
			uploadfilems.BackfromView();
			extentTest.pass("User berhasil Klik back dari view");
		}

		@Then("User berhasil melakukan upload data MS dengan bukti yang mengupload sesuai")
		public void finnishedUploadFileMS() {
			uploadfilems.Filter(configurationProperties.getTextStartDate(), configurationProperties.getTextEndDate());
			extentTest.pass("User berhasil product di halaman Upload File MS");
			extentTest.pass("User berhasil input tanggal mulai di halaman Upload File MS");
			extentTest.pass("User berhasil input tanggal akhir di halaman Upload File MS");
			extentTest.pass("User berhasil klik go di halaman Upload File MS");
			if (uploadfilems.buktiUpload(1).equals(configurationProperties.getTextUploader())) {
				extentTest.pass("User berhasil melakukan upload data MS dengan bukti yang mengupload sesuai");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail(
							"User berhasil melakukan upload data MS dengan bukti yang mengupload sesuai"
									+ " tetapi ada kesalahan teknis dan screenshot terlampir di bawah",
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextUploader(), uploadfilems.buktiUpload(1));
		}

		@Then("Tanggal Sesuai")
		public void cekTanggalUpload() {
			if (uploadfilems.buktiUpload(2).equals(configurationProperties.getTextEndDate())) {
				extentTest.pass("User berhasil melakukan upload data MS dengan bukti tanggal sesuai");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail(
							"User berhasil melakukan upload data MS dengan bukti tanggal sesuai"
									+ " tetapi ada kesalahan teknis dan screenshot terlampir di bawah",
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextEndDate(), uploadfilems.buktiUpload(2));
		}

		@Then("Product Sesuai")
		public void cekProductUpload() {
			if (uploadfilems.buktiUpload(3).equals(configurationProperties.getTextProduct())) {
				extentTest.pass("User berhasil melakukan upload data MS dengan Product Sesuai");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail(
							"User berhasil melakukan upload data MS dengan bukti Product Sesuai"
									+ " tetapi ada kesalahan teknis dan screenshot terlampir di bawah",
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextProduct(), uploadfilems.buktiUpload(3));
		}

		@Then("Keterangan Sesuai")
		public void cekketeranganUpload() {
			if (uploadfilems.buktiUpload(4).equals(configurationProperties.getTextKeterangan())) {
				extentTest.pass("User berhasil melakukan upload data MS dengan bukti Keterangan Sesuai");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail(
							"User berhasil melakukan upload data MS dengan bukti Keterangan Sesuai"
									+ " tetapi ada kesalahan teknis dan screenshot terlampir di bawah",
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextKeterangan(), uploadfilems.buktiUpload(4));
		}

		@Then("TotalMS Sesuai")
		public void cekTotalMSUpload() {
			if (uploadfilems.buktiUpload(5).equals(configurationProperties.getTextTotalms())) {
				extentTest.pass("User berhasil melakukan upload data MS dengan bukti upload total MS sesuai");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail(
							"User berhasil melakukan upload data MS dengan bukti total MS Sesuai"
									+ " tetapi ada kesalahan teknis dan screenshot terlampir di bawah",
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextTotalms(), uploadfilems.buktiUpload(5));
		}

		/* Distribusi Data */

		@Given("User login ke user Supervisor")
		public void loginSupervisor() {
			loginPage.Logout();
			loginPage.fillFormLogin(configurationProperties.getName2(), configurationProperties.getPassword2());
			loginPage.clickBtnLogin();
			loginPage.closeDisplayAlert();
		}

		@When("Klik menu Distribusi")
		public void intoDistribusi() {
			homepage.toDistribusiData();
			extentTest.pass("User berhasil klik menu Distribusi");
		}
		
		@When("Cek Kategori")
		public void CheckingKategori() {
			distribusidata.KategoriPilihan();
			extentTest.pass("User berhasil klik kategori Jadwal Ulang");
			extentTest.pass("User berhasil klik kategori Gagal Pick Up");
			extentTest.pass("User berhasil klik kategori Batal");
			extentTest.pass("User berhasil klik kategori Return to Sales");
			extentTest.pass("User berhasil klik kategori Uncoverage");
			extentTest.pass("User berhasil klik kategori No Status");
			extentTest.pass("User berhasil klik kategori No Respon");
			extentTest.pass("User berhasil klik kategori Resign, Terminate");
		}

		@When("Klik kategori yang dipilih dan pilih Sales yang akan di distribusi")
		public void fillFormDistribusiData() {
			distribusidata.PickKategori();
			extentTest.pass("User berhasil klik kategori Daftar Baru");
			extentTest.pass("User berhasil pilih status distribusi");
			extentTest.pass("User berhasil pilih Sales yang akan di distribusi");
		}
		
		@When("Pilih Filter data")
		public void chooseFilterdata() {
			distribusidata.SelectFilter();
			extentTest.pass("User berhasil Pilih Filter data");
		}
		
		@When("Pilih Tampilan Jumlah Data")
		public void PilihTampilanJumlahData() {
			distribusidata.pilihJumlahData(2);
			extentTest.pass("User berhasil Pilih Tampilan Jumlah Data");
		}
		
		@When("Pindah halaman tabel customer")
		public void PindahHalamanTabel() {
			distribusidata.buttonPage();
			extentTest.pass("User berhasil klik Previous Page");
			extentTest.pass("User berhasil klik Next Page");
			extentTest.pass("User berhasil klik Nomor Page");
		}
		
		@When("Mencari Data Customer yang ingin di pilih")
		public void SearchingDataCustomer() {
			distribusidata.Searching(configurationProperties.getTextNamaCustomer());
			extentTest.pass("User berhasil Mencari Data Customer yang ingin di pilih");
			extentTest.pass("User berhasil Menamppilkan list customer");
		}
		
		@When("Pilih Customer")
		public void PickCustomer() {
			distribusidata.pickCustomer();
			extentTest.pass("User berhasil Pilih Customer");
		}

		@When("Klik submit untuk distribusi data")
		public void submitedDistribusiData() {
			distribusidata.SubmitData();
			extentTest.pass("User berhasil Klik submit untuk distribusi data");
		}

		@Then("User berhasil mendistribusi data ke mobile sales dengan tampilan total in proses")
		public void ViewInProses() {
			distribusidata.PickKategori();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(distribusidata.getTextinproses().equals
					(configurationProperties.getTextinproses())) {
				extentTest.pass("User berhasil mendistribusi data ke mobile sales dengan tampilan total in proses");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User berhasil mendistribusi data ke mobile sales dengan tampilan \n"
							+ "total in proses tetapi ada kesalahan teknis \n dengan screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextinproses(), distribusidata.getTextinproses());
		}
		
		@Then("Tampilan Belum di pick up")
		public void ViewTampilanBelumPickUp() {
			if(distribusidata.getTextbelumpickup().equals
					(configurationProperties.getTextbelumdipickup())) {
				extentTest.pass("User berhasil mendistribusi data ke mobile sales dengan tampilan Belum di pick up");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User berhasil mendistribusi data ke mobile sales dengan \n"
							+ "tampilan Belum di pick up tetapi ada kesalahan teknis dengan screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextbelumdipickup(), distribusidata.getTextbelumpickup());
		}
		
		@Then("Tampilan Jadwal Ulang")
		public void finnishedDistribusiData() {
			if(distribusidata.getTextjadwalulang().equals
					(configurationProperties.getTextjadwalulang())) {
				extentTest.pass("User berhasil mendistribusi data ke mobile sales dengan tampilan Jadwal Ulang");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User berhasil mendistribusi data ke mobile sales dengan tampilan \n"
							+ "Jadwal Ulang tetapi ada kesalahan teknis dengan screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextjadwalulang(), distribusidata.getTextjadwalulang());
		}
		
		/*WorkList*/
		
		@Given("User masuk ke user Mobile Sales")
		public void loginMobileSales() {
			loginPage.Logout();
			loginPage.fillFormLogin(configurationProperties.getName3(), configurationProperties.getPassword3());
			loginPage.clickBtnLogin();
			loginPage.closeDisplayAlert();
		}
		
		@When("Klik menu Worklist")
		public void intoWorklist() {
			homepage.toWorklist();
			extentTest.pass("User berhasil klik menu Worklist");
		}
		
		@When("Pilih Tampilan Jumlah Data di Worklist")
		public void PilihTampilanJumlahDataWorkList() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			worklist.pilihJumlahData(0);
			extentTest.pass("User berhasil Pilih Tampilan Jumlah Data");
		}
		
		@When("Pindah halaman list customer")
		public void PindahHalamanList() {
			worklist.buttonPage();
			extentTest.pass("User berhasil klik Previous Page");
			extentTest.pass("User berhasil klik Next Page");
			extentTest.pass("User berhasil klik Nomor Page");
		}
		
		@When("Mencari Data Customer di Work List")
		public void searchingCustomerWorkList() {
			worklist.Searching(configurationProperties.getTextNamaCustomer());
			extentTest.pass("User berhasil mencari Data Customer");
		}
		
		@When("Klik customer yang ingin di survey")
		public void PickCustomerWorklist() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			worklist.chooseCustomer();
			extentTest.pass("User berhasil klik customer yang ingin di survey");
		}
		
		@When("Pilih status sukses pick up dan isi form dari status pick up sukses pick up")
		public void pickStatusSuksesPickup() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			worklist.fillWroklistSurveySuksesPU(configurationProperties.getTextnotes());
			extentTest.pass("User berhasil pilih status pickup Sukses Pick Up");
			extentTest.pass("User berhasil pilih kode promo");
			extentTest.pass("User berhasil isi reg id");
			extentTest.pass("User berhasil isi note");
		}
		
		@When("Pilih status gagal pick up dan isi form dari status pick up gagal pick up")
		public void pickStatusGagalPickup() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			worklist.fillWroklistSurveyGagalPU(configurationProperties.getTextnotes());
			extentTest.pass("User berhasil pilih status pickup Gagal Pick Up");
			extentTest.pass("User berhasil pilih reason dari Gagal Pick Up");
			extentTest.pass("User berhasil isi note");
		}
		
		@When("Pilih status batal dan isi form dari status pick up batal")
		public void pickStatusBatal() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			worklist.fillWroklistSurveyBatalPU(configurationProperties.getTextnotes());
			extentTest.pass("User berhasil pilih status pickup Batal");
			extentTest.pass("User berhasil pilih reason dari Batal");
			extentTest.pass("User berhasil isi note");
		}
		
		@When("Pilih status jadwal ulang dan isi form dari status pick up jadwal ulang")
		public void pickStatusJadwalUlang() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			worklist.fillWroklistSurveyReschedule(configurationProperties.getTextnotes(), 
					configurationProperties.getTanggalJadwalUlang());
			extentTest.pass("User berhasil pilih status pickup Jadwal Ulang");
			extentTest.pass("User berhasil isi note");
			extentTest.pass("User berhasil isi tanggal jadwal ulang");
		}
		
		@When("Pilih status No Respon dan isi form dari status pick up no respon")
		public void pickStatusNoRespon() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			worklist.fillWroklistSurveyNoRespon();
			extentTest.pass("User berhasil pilih status pickup No Respon");
		}
		
		@When("Klik back dari update status pick up")
		public void backFromStatusPickup() {
			worklist.backfromupdatestatus();
			extentTest.pass("User berhasil klik back dari update status pick up");
		}
		
		@When("Klik map customer yang ingin di tuju untuk survey")
		public void PickMapCustomerWorklist() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			worklist.chooseCustomerMap();
			extentTest.pass("User berhasil klik map customer yang ingin di tuju untuk survey");
		}
		
		@When("Isi form survey")
		public void fillFormSurvey() {
			worklist.fillSurveyAlamat(configurationProperties.getLokasiTerkini(), configurationProperties.getAlamatTujuan());
			extentTest.pass("User berhasil isi lokasi terkini");
			extentTest.pass("User berhasil isi alamat tujuan");
		}
		
		@When("Klik submit survey")
		public void submitedthWorklistForm() {
			worklist.submitSurvey();
			if(worklist.TextErrorMap().isDisplayed()) {
				try {
					extentTest.fail("User berhasil klik submit di survey tetapi ada kesalahan teknis dengan \n"
							+ "screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				extentTest.pass("User berhasil klik submit di survey");
			}
		}
		
		@When("Klik back dari survey alamat")
		public void backFromSurvey() {
			worklist.backfromSurveyAlamat();
			extentTest.pass("User berhasil klik back dari update status pick up");
		}
		
		@When("Klik survey alamat")
		public void SurveyAlamat() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			worklist.chooseCustomer();
			worklist.surveyAlamat();
			extentTest.pass("User berhasil klik survey alamat");
		}
		
		@When("Klik pick up")
		public void PickUp() {
			worklist.goToPickUp();
			extentTest.pass("User berhasil klik survey alamat");
		}
		
		@When("Klik cancel disetiap upload foto form update status worklist")
		public void fillFormUpdateStatusWithCancelFoto() {
			worklist.cancelUploadKTP();
			worklist.cancelUploadNPWP();
			worklist.cancelUploadBukti();
			extentTest.pass("User berhasil klik Upload KTP");
			extentTest.pass("User berhasil klik cancel Upload KTP");
			extentTest.pass("User berhasil klik Upload NPWP");
			extentTest.pass("User berhasil klik cancel Upload NPWP");
			extentTest.pass("User berhasil klik Upload Bukti");
			extentTest.pass("User berhasil klik cancel Upload Bukti");
		}
		
		@When("Isi form update status worklist")
		public void fillFormUpdateStatus() {
			worklist.uploadKTP(configurationProperties.getTextFotoKTP());
			worklist.uploadNPWP(configurationProperties.getTextFotoNPWP());
			worklist.uploadBukti(configurationProperties.getTextFotoBUKTI());
			worklist.fillWroklistSurveySuksesPU(configurationProperties.getTextnotes());
			extentTest.pass("User berhasil isi direktori foto KTP");
			extentTest.pass("User berhasil klik simpan Upload KTP");
			extentTest.pass("User berhasil isi direktori foto NPWP");
			extentTest.pass("User berhasil klik simpan Upload NPWP");
			extentTest.pass("User berhasil isi direktori foto Bukti");
			extentTest.pass("User berhasil klik simpan Upload Bukti");
		}
		
		
		@Then("User berhasil survey worklist")
		public void finnishedFormWorklist() {
			worklist.submit();
			if(worklist.getTextafterWorklist().equals
					(configurationProperties.getTextafterworklist())) {
				extentTest.pass("User berhasil survey worklist");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User berhasil survey worklist tetapi ada kesalahan teknis dengan "
							+ "screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextafterworklist(), worklist.getTextafterWorklist());		
		}
		
		/*Completed List*/
		
		// Mobile Sales
		
		@When("User klik completedlist di user Mobile Sales")
		public void intoCompletedListMobileSales() {
			homepage.toCompletedList();
			extentTest.pass("User berhasil klik menu completed list di user Mobile Sales");
		}
		
		@When("Pilih jumlah data tampilan di completed list user Mobile Sales")
		public void PilihTampilanJumlahDataCompletedlistMobileSales() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			completedlist.pilihJumlahData(2);
			extentTest.pass("User berhasil Pilih Tampilan Jumlah Data di completed list user Mobile Sales");
		}
		
		@When("Pindah halaman list customer di completed list user Mobile sales")
		public void PindahHalamanListCompletedListMobileSales() {
			completedlist.buttonPage();
			extentTest.pass("User berhasil klik Previous Page di completed list  user Mobile Sales");
			extentTest.pass("User berhasil klik Next Page di completed list  user Mobile Sales");
			extentTest.pass("User berhasil klik Nomor Page di completed list  user Mobile Sales");
		}
		
		@When("Mencari Data Customer di completed list uesr Mobile Sales")
		public void searchingCustomerCompletedListMobileSales() {
			completedlist.Searching(configurationProperties.getTextNamaCustomer());
			extentTest.pass("User berhasil mengisi nama customer untuk mencari Data Customer untuk di lihat di completed list user mobile sales");
			extentTest.pass("User berhasil klik search untuk mencari data customer untuk di lihat di completed list user mobile sales");
		}
		
		@When("Memilih product mengisi tanggal mulai dan memfilter pilih salah satu data customer "
				+ "untuk melihat detailnya di completed list user Mobile Sales")
		public void fillFormThCompletedListMobileSales() {
			completedlist.pilihProduct(3);
			completedlist.Filter(configurationProperties.getTextStartDate(), 
					configurationProperties.getTextEndDate());
			extentTest.pass("User berhasil pilih product di completed list user Mobile Sales");
			extentTest.pass("User berhasil Mengisi tanggal mulai di completed list user Mobile Sales");
			extentTest.pass("User berhasil Mengisi tanggal akhir di completed list user Mobile Sales");
			extentTest.pass("User berhasil klik filter di completed list user Mobile Sales");
		}
		
		@When("Klik Edit di completed list uesr Mobile Sales")
		public void EditcustomerDataMobileSales() {
			completedlist.EditDetail();
			extentTest.pass("User berhasil klik Edit di completed list uesr Mobile Sales");
		}
		
		@When("Klik cancel disetiap upload foto di completed list user Mobile Sales")
		public void fillFormEditWithCancelFotoMobileSales() {
			completedlist.cancelUploadKTP();
			completedlist.cancelUploadNPWP();
			completedlist.cancelUploadBukti();
			extentTest.pass("User berhasil klik Upload KTP di completed list uesr Mobile Sales");
			extentTest.pass("User berhasil klik cancel Upload KTP di completed list uesr Mobile Sales");
			extentTest.pass("User berhasil klik Upload NPWP di completed list uesr Mobile Sales");
			extentTest.pass("User berhasil klik cancel Upload NPWP di completed list uesr Mobile Sales");
			extentTest.pass("User berhasil klik Upload Bukti di completed list uesr Mobile Sales");
			extentTest.pass("User berhasil klik cancel Upload Bukti di completed list uesr Mobile Sales");
		}
		
		@When("Mengganti upload foto di completed list user Mobile Sales")
		public void ChangeFotoMobileSale() {
			completedlist.uploadKTP(configurationProperties.getTextFotoKTP2());
			extentTest.pass("User berhasil isi direktori foto KTP di completed list uesr Mobile Sales");
			extentTest.pass("User berhasil klik simpan Upload KTP di completed list uesr Mobile Sales");
			completedlist.uploadNPWP(configurationProperties.getTextFotoNPWP2());
			extentTest.pass("User berhasil isi direktori foto NPWP di completed list uesr Mobile Sales");
			try {
				completedlist.errorAlert();
				extentTest.fail("User berhasil klik simpan Upload NPWP di completed list uesr Mobile Sales tetapi ada error dan perlu refresh browser",
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			completedlist.refreshBrowser();
			completedlist.uploadBukti(configurationProperties.getTextFotoBUKTI2());
			extentTest.pass("User berhasil isi direktori foto Bukti di completed list uesr Mobile Sales");
			try {
				completedlist.errorAlert();
				extentTest.fail("User berhasil klik simpan Upload Bukti di completed list uesr Mobile Sales tetapi ada error dan perlu refresh browser",
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			completedlist.refreshBrowser();
		}
		
		@When("Klik kembali dari Edit di completed list user Mobile Sales")
		public void backFromEditMobileSales() {
			completedlist.backfromEdit();
			extentTest.pass("User berhasil klik kembali dari Edit di completed list user Mobile Sales");
		}
		
		@Then("User dapat melihat detail data customer yang dipilih di completed list user Mobile Sales")
		public void finnishedCompletedListMobileSales() {
			completedlist.Searching(configurationProperties.getTextNamaCustomer());
			completedlist.viewDetail();
			extentTest.pass("User berhasil klik view di completed list user Mobile Sales");
			if(completedlist.getTextafterCompletedlist().equals(configurationProperties.getTextaftercompletedlist())) {
				extentTest.pass("User berhasil menampilkan nama customer yang dipilih di completed list user Mobile Sales");
				extentTest.pass("User berhasil menampilkan kontak customer yang dipilih di completed list user Mobile Sales");
				extentTest.pass("User berhasil menampilkan address customer yang dipilih di completed list user Mobile Sales");
				extentTest.pass("User berhasil menampilkan status pick up customer yang dipilih di completed list user Mobile Sales");
				extentTest.pass("User berhasil menampilkan foto KTP customer yang dipilih di completed list user Mobile Sales");
				extentTest.pass("User berhasil menampilkan foto NPWP customer yang dipilih di completed list user Mobile Sales");
				extentTest.pass("User berhasil menampilkan foto bukti customer yang dipilih di completed list user Mobile Sales");
			}else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User bisa melihat detail data customer yang dipilih \n di user "
							+ "Mobile Sales tetapi ada kesalahan teknis dengan screenshot di bawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextaftercompletedlist(), completedlist.getTextafterCompletedlist());
		}
		
		@Then("Klik kembali setelah melihat detail di completed list user Mobile Sales")
		public void backFromDetailMobileSales() {
			completedlist.backFromViewDetail();
			extentTest.pass("User berhasil klik kembali yang ada di detail di completed list user Mobile Sales");
			if(completedlist.getTextCustomerCompletedlist().equals(configurationProperties.getTextaftercompletedlist1())) {
				extentTest.pass("User berhasil menampilkan nama, address customer yang ada di list di completed list user Mobile Sales");
				extentTest.pass("User berhasil menampilkan status customer yang ada di list di completed list user Mobile Sales");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User bisa melihat list data customer yang dipilih \n di completed list user "
							+ "Mobile Sales tetapi ada kesalahan teknis dengan screenshot di bawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// Supervisor
		
		@Given("User login dari user Mobile Sales ke user Supervisor")
		public void loginSupervisor2() {
			loginPage.Logout();
			loginPage.fillFormLogin(configurationProperties.getName2(), configurationProperties.getPassword2());
			loginPage.clickBtnLogin();
			loginPage.closeDisplayAlert();
		}
		
		@When("User klik completedlist di user Supervisor")
		public void intoCompletedListSupervisor() {
			homepage.toCompletedList();
			extentTest.pass("User berhasil klik menu completed list di user Supervisor");
		}
			
		@When("Pilih jumlah data tampilan di completed list user Supervisor")
		public void PilihTampilanJumlahDataCompletedlistSupervisor() {
			completedlist.btnClosealert();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			completedlist.pilihJumlahData(2);
			extentTest.pass("User berhasil Pilih Tampilan Jumlah Data di completed list user Supervisor");
		}
			
		@When("Pindah halaman list customer di completed list user Supervisor")
		public void PindahHalamanListCompletedListSupervisor() {
			completedlist.buttonPage();
			extentTest.pass("User berhasil klik Previous Page di completed list user Supervisor");
			extentTest.pass("User berhasil klik Next Page di completed list user Supervisor");
			extentTest.pass("User berhasil klik Nomor Page di completed list user Supervisor");
		}
			
		@When("Mencari Data Customer di completed list user Supervisor")
		public void searchingCustomerCompletedListSupervisor() {
			completedlist.Searching(configurationProperties.getTextNamaCustomer());
			extentTest.pass("User berhasil mengisi nama customer untuk mencari Data Customer untuk di lihat di completed list user Supervisor");
			extentTest.pass("User berhasil klik search untuk mencari data customer untuk di lihat di completed list user Supervisor");
		}
			
		@When("Memilih product mengisi tanggal mulai dan memfilter pilih salah satu data customer "
				+ "untuk melihat detailnya di completed list user Supervisor")
		public void fillFormThCompletedListSupervisor() {
			completedlist.pilihProduct(3);
			completedlist.Filter(configurationProperties.getTextStartDate(), 
				configurationProperties.getTextEndDate());
				extentTest.pass("User berhasil pilih product di completed list user Supervisor");
				extentTest.pass("User berhasil Mengisi tanggal mulai di completed list user Supervisor");
				extentTest.pass("User berhasil Mengisi tanggal akhir di completed list user Supervisor");
				extentTest.pass("User berhasil klik filter di completed list user Supervisor");
		}
			
		@Then("User dapat melihat detail data customer yang dipilih di completed list user Supervisor")
		public void finnishedCompletedListSupervisor() {
			completedlist.viewDetail();
			completedlist.btnClosealert();
			extentTest.pass("User berhasil klik view di completed list user Supervisor");
			if(completedlist.getTextafterCompletedlist().equals(configurationProperties.getTextaftercompletedlist())) {
				extentTest.pass("User berhasil menampilkan nama customer yang dipilih di completed list user Supervisor");
				extentTest.pass("User berhasil menampilkan kontak customer yang dipilih di completed list user Supervisor");
				extentTest.pass("User berhasil menampilkan address customer yang dipilih di completed list user Supervisor");
				extentTest.pass("User berhasil menampilkan status pick up customer yang dipilih di completed list user Supervisor");
				extentTest.pass("User berhasil menampilkan foto KTP customer yang dipilih di completed list user Supervisor");
				extentTest.pass("User berhasil menampilkan foto NPWP customer yang dipilih di completed list user Supervisor");
				extentTest.pass("User berhasil menampilkan foto bukti customer yang dipilih di completed list user Supervisor");
			}else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User bisa melihat detail data customer yang dipilih \n di user "
						+ "Supervisor tetapi ada kesalahan teknis dengan screenshot di bawah", 
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextaftercompletedlist(), completedlist.getTextafterCompletedlist());
		}
			
		@Then("Klik kembali setelah melihat detail di completed list user Supervisor")
		public void backFromDetailSupervisor() {
			completedlist.backFromViewDetail();
			completedlist.btnClosealert();
			extentTest.pass("User berhasil klik kembali yang ada di detail di completed list user Supervisor");
			if(completedlist.getTextCustomerCompletedlist().equals(configurationProperties.getTextaftercompletedlist1())) {
				extentTest.pass("User berhasil menampilkan nama, address customer yang ada di list di completed list user Supervisor");
				extentTest.pass("User berhasil menampilkan status customer yang ada di list di completed list user Supervisor");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User bisa melihat list data customer yang dipilih \n di completed list user "
							+ "Supervisor tetapi ada kesalahan teknis dengan screenshot di bawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// Super Admin
		
		@Given("User login dari user Supervisor ke user Super Admin")
		public void loginSuperAdmin() {
			loginPage.Logout();
			loginPage.fillFormLogin(configurationProperties.getName1(), configurationProperties.getPassword1());
			loginPage.clickBtnLogin();
			loginPage.closeDisplayAlert();
		}
			
		@When("User klik completedlist di user Super Admin")
		public void intoCompletedListSuperAdmin() {
			homepage.toCompletedList();
			extentTest.pass("User berhasil klik menu completed list di user Super Admin");
		}
				
		@When("Pilih jumlah data tampilan di completed list user Super Admin")
		public void PilihTampilanJumlahDataCompletedlistSuperAdmin() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
			completedlist.pilihJumlahData(2);
			extentTest.pass("User berhasil Pilih Tampilan Jumlah Data di completed list user Super Admin");
		}
			
		@When("Pindah halaman list customer di completed list user Super Admin")
		public void PindahHalamanListCompletedListSuperAdmin() {
			completedlist.buttonPage();
			extentTest.pass("User berhasil klik Previous Page di completed list user Super Admin");
			extentTest.pass("User berhasil klik Next Page di completed list user Super Admin");
			extentTest.pass("User berhasil klik Nomor Page di completed list user Super Admin");
		}
				
		@When("Mencari Data Customer di completed list user Super Admin")
		public void searchingCustomerCompletedListSuperAdmin() {
			completedlist.Searching(configurationProperties.getTextNamaCustomer());
			extentTest.pass("User berhasil mengisi nama customer untuk mencari Data Customer untuk di lihat di completed list user Super Admin");
			extentTest.pass("User berhasil klik search untuk mencari data customer untuk di lihat di completed list userSuper Admin");
		}
				
		@When("Memilih product mengisi tanggal mulai dan memfilter pilih salah satu data customer "
				+ "untuk melihat detailnya di completed list user Super Admin")
		public void fillFormThCompletedListSuperAdmin() {
			completedlist.pilihProduct(3);
			completedlist.Filter(configurationProperties.getTextStartDate(), 
				configurationProperties.getTextEndDate());
			extentTest.pass("User berhasil pilih product di completed list user Super Admin");
			extentTest.pass("User berhasil Mengisi tanggal mulai di completed list user Super Admin");
			extentTest.pass("User berhasil Mengisi tanggal akhir di completed list user Super Admin");
			extentTest.pass("User berhasil klik filter di completed list user Super Admin");
		}
			
		@Then("User dapat melihat detail data customer yang dipilih di completed list user Super Admin")
		public void finnishedCompletedListSuperAdmin() {
			completedlist.viewDetail();
			extentTest.pass("User berhasil klik view di completed list user Supervisor");
			if(completedlist.getTextafterCompletedlist().equals(configurationProperties.getTextaftercompletedlist())) {
				extentTest.pass("User berhasil menampilkan nama customer yang dipilih di completed list user Super Admin");
				extentTest.pass("User berhasil menampilkan kontak customer yang dipilih di completed list user Super Admin");
				extentTest.pass("User berhasil menampilkan address customer yang dipilih di completed list user Supervisor");
				extentTest.pass("User berhasil menampilkan status pick up customer yang dipilih di completed list user Super Admin");
				extentTest.pass("User berhasil menampilkan foto KTP customer yang dipilih di completed list user Super Admin");
				extentTest.pass("User berhasil menampilkan foto NPWP customer yang dipilih di completed list user Super Admin");
				extentTest.pass("User berhasil menampilkan foto bukti customer yang dipilih di completed list user Super Admin");
			}else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User bisa melihat detail data customer yang dipilih \n di user "
							+ "Super Admin tetapi ada kesalahan teknis dengan screenshot di bawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			assertEquals(configurationProperties.getTextaftercompletedlist(), completedlist.getTextafterCompletedlist());
		}
				
		@Then("Klik kembali setelah melihat detail di completed list user Super Admin")
		public void backFromDetailSuperAdmin() {
			completedlist.backFromViewDetail();
			extentTest.pass("User berhasil klik kembali yang ada di detail di completed list user Super Admin");
			if(completedlist.getTextCustomerCompletedlist().equals(configurationProperties.getTextaftercompletedlist1())) {
				extentTest.pass("User berhasil menampilkan nama, address customer yang ada di list di completed list user Super Admin");
				extentTest.pass("User berhasil menampilkan status customer yang ada di list di completed list user Super Admin");
			} else {
				try {
					Thread.sleep(1000);
					extentTest.fail("User bisa melihat list data customer yang dipilih \n di completed list user "
							+ "Super Admin tetapi ada kesalahan teknis dengan screenshot di bawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
//		SUMMARY MS
//		SUPER ADMIN
		@When("^User klik menu Summary MS lalu masukan data Summary MS")
		public void user_klik_menu_summary_ms_lalu_masukan_data_summary_ms() {
			extentTest.pass("User berhasil klik Summary MS dan menampilkan form Summary MS");
			homepage.toSummaryMS();
			summaryms.errorBtnBack();
			if(summaryms.getDisplayBack().isDisplayed()) {
				try {
					Thread.sleep(1000);
					extentTest.fail("Button Kembali error karena tidak kembali ke halaman sebelumnya dengan screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				extentTest.pass("User berhasil klik button kembali dan kembali ke halaman sebelumnya");
			}
		}	
		
		@Then("^User berhasil menampilkan data di form Summary MS")
		public void user_berhasil_menampilkan_data_di_form_summary_ms() {
			summaryms.inputSummaryMSadmin(configurationProperties.getTanggalawalsummaryms(),configurationProperties.getTanggalakhirsummaryms());
			extentTest.pass("User berhasil memilih kategori");
			extentTest.pass("User berhasil memilih periode awal (format date)");
			extentTest.pass("User berhasil memilih periode akhir (format date)");
			summaryms.viewSummaryMSAdmin(configurationProperties.getSearchsummaryms());
			if(summaryms.getDisplayTabel().isDisplayed()) {
				try {
					Thread.sleep(1000);
					extentTest.fail("User gagal menampilkan data di form Summary MS setelah klik button Go dengan screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				extentTest.pass("User berhasil menampilkan data di form Summary MS");	
			}
			extentTest.pass("User berhasil klik button uncoverage pada tabel dan menampilkan data customer di tabel uncoverage");
			extentTest.pass("User berhasil klik ikon jumlah data dan memilih jumlah data yang ditampilkan dalam satu halaman");
			extentTest.pass("User berhasil mengisi teks pencarian");		
			extentTest.pass("User berhasil klik button No pada judul tabel dan menampilkan data sesuai sort No");
			extentTest.pass("User berhasil klik button Keterangan pada judul tabel dan menampilkan data sesuai sort Keterangan");
			extentTest.pass("User berhasil klik ikon Next dan menampilkan data Summary MS selanjutnya");
			extentTest.pass("User berhasil klik ikon Previous dan menampilkan data Summary MS sebelumnya");
			extentTest.pass("User berhasil klik button list pada tabel dan menampilkan data customer di tabel list");
			extentTest.pass("User berhasil klik ikon jumlah data dan memilih jumlah data yang ditampilkan dalam satu halaman");
			extentTest.pass("User berhasil mengisi teks pencarian");		
			extentTest.pass("User berhasil klik button No pada judul tabel dan menampilkan data sesuai sort No");
			extentTest.pass("User berhasil klik button Peruntukan pada judul tabel dan menampilkan data sesuai sort Peruntukan");
			extentTest.pass("User berhasil klik button Total pada judul tabel dan menampilkan data sesuai sort Total");
			extentTest.pass("User berhasil klik button Sukses PU pada judul tabel dan menampilkan data sesuai sort Sukses PU");
			extentTest.pass("User berhasil klik button Gagal PU pada judul tabel dan menampilkan data sesuai sort Gagal PU");
			extentTest.pass("User berhasil klik button Cancel CS pada judul tabel dan menampilkan data sesuai sort Cancel CS");
			extentTest.pass("User berhasil klik button Jadwal Ulang pada judul tabel dan menampilkan data sesuai sort Jadwal Ulang");
			extentTest.pass("User berhasil klik button No Status pada judul tabel dan menampilkan data sesuai sort No Status");
			extentTest.pass("User berhasil klik button PU Rate pada judul tabel dan menampilkan data sesuai sort PU Rate");
			extentTest.pass("User berhasil klik ikon Next dan menampilkan data Summary MS selanjutnya");
			extentTest.pass("User berhasil klik ikon Previous dan menampilkan data Summary MS sebelumnya");
		}
		
//		SUMMARY MS
//		Supervisor
		
		@Given("User keluar dari user superadmin dan login sebagai supervisor")
		public void user_keluar_dari_user_superadmin_dan_login_sebagai_supervisor() {
			loginPage.Logout();
			loginPage.fillFormLogin(configurationProperties.getName2(), configurationProperties.getPassword2());
			loginPage.clickBtnLogin();
			loginPage.closeDisplayAlert();
		}
		
		@When("^User Supervisor klik menu Summary MS lalu masukan data Summary MS")
		public void user_supervisor_klik_menu_summary_ms_lalu_masukan_data_summary_ms() {
			homepage.toSummaryMS();
			summaryms.btnClosealert();
			extentTest.pass("User berhasil klik Summary MS dan menampilkan form Summary MS");
			summaryms.errorBtnBack();
			if(summaryms.getDisplayBack().isDisplayed()) {
				
				try {
					Thread.sleep(1000);
					extentTest.fail("Button Kembali error karena tidak kembali ke halaman sebelumnya dengan screenshot dibawah", 
							MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				extentTest.pass("User berhasil klik button kembali dan kembali ke halaman sebelumnya");
			}
			summaryms.inputSummaryMSspv(configurationProperties.getTanggalawalsummaryms(),configurationProperties.getTanggalakhirsummaryms());
			extentTest.pass("User berhasil memilih kategori");
			extentTest.pass("User berhasil memilih periode awal (format date)");
			extentTest.pass("User berhasil memilih periode akhir (format date)");
			extentTest.pass("User berhasil klik button Go dan menampilkan data Summary MS");
		}
		
		@Then("^User Supervisor berhasil menampilkan data di form Summary MS")
		public void user_supervisor_berhasil_menampilkan_data_di_form_summary_ms() {
			summaryms.viewSummaryMSSpv(configurationProperties.getSearchsummaryms());
			summaryms.viewSummaryMSDetail(configurationProperties.getSearchsummarymsdetail(), configurationProperties.getSearchsummarymsdetail2());
				extentTest.pass("User berhasil klik ikon jumlah data dan memilih jumlah data yang ditampilkan dalam satu halaman");
				extentTest.pass("User berhasil klik button Uncoverage pada tabel dan menampilkan data customer di tabel uncoverage");
				extentTest.pass("User berhasil menampilkan Keterangan di tabel unconverage");
				extentTest.pass("User berhasil klik button No pada judul tabel dan menampilkan data sesuai sort No");
				extentTest.pass("User berhasil klik button Keterangan pada judul tabel dan menampilkan data sesuai sort Keterangan");
				extentTest.pass("User berhasil klik ikon Next dan menampilkan data sales selanjutnya");
				extentTest.pass("User berhasil klik ikon Previous dan menampilkan data sales sebelumnya");
				extentTest.pass("User berhasil mengisi teks pencarian");
				extentTest.pass("User berhasil klik button List pada tabel dan menampilkan data sales di tabel List");
				extentTest.pass("User berhasil menampilkan Peruntukan di tabel list");
				extentTest.pass("User berhasil menampilkan Total di tabel list");
				extentTest.pass("User berhasil menampilkan Sukses PU di tabel list");
				extentTest.pass("User berhasil menampilkan Gagal PU di tabel list");
				extentTest.pass("User berhasil menampilkan Cancel CS di tabel list");
				extentTest.pass("User berhasil menampilkan Jadwal Ulang di tabel list");
				extentTest.pass("User berhasil menampilkan No Status di tabel list");
				extentTest.pass("User berhasil menampilkan PU Rate di tabel list");
				extentTest.pass("User berhasil klik button No pada judul tabel dan menampilkan data sesuai sort No");
				extentTest.pass("User berhasil klik button Peruntukan pada judul tabel dan menampilkan data sesuai sort Peruntukan");
				extentTest.pass("User berhasil klik button Total pada judul tabel dan menampilkan data sesuai sort Total");
				extentTest.pass("User berhasil klik button Sukses PU pada judul tabel dan menampilkan data sesuai sort Sukses PU");
				extentTest.pass("User berhasil klik button Gagal PU pada judul tabel dan menampilkan data sesuai sort Gagal PU");
				extentTest.pass("User berhasil klik button Cancel CS pada judul tabel dan menampilkan data sesuai sort Cancel CS");
				extentTest.pass("User berhasil klik button Jadwal Ulang pada judul tabel dan menampilkan data sesuai sort Jadwal Ulang");
				extentTest.pass("User berhasil klik button No Status pada judul tabel dan menampilkan data sesuai sort No Status");
				extentTest.pass("User berhasil klik button PU Rate pada judul tabel dan menampilkan data sesuai sort PU Rate");
				extentTest.pass("User berhasil klik ikon Next dan menampilkan data sales selanjutnya");
				extentTest.pass("User berhasil klik ikon Previous dan menampilkan data sales sebelumnya");
				extentTest.pass("User berhasil klik ikon Nomor Halaman dan menampilkan data sales sesuai nomor halaman");
				extentTest.pass("User berhasil mengisi teks pencarian");
				extentTest.pass("User berhasil klik button detail pada tabel dan menampilkan halaman detail Summary MS");
				extentTest.pass("User berhasil klik button List MS pada tabel dan menampilkan data customer di tabel List MS");
				extentTest.pass("User berhasil menampilkan Nocase di tabel list");
				extentTest.pass("User berhasil menampilkan Name di tabel list");
				extentTest.pass("User berhasil menampilkan Address di tabel list");
				extentTest.pass("User berhasil menampilkan City di tabel list");
				extentTest.pass("User berhasil menampilkan Campaign di tabel list");
				extentTest.pass("User berhasil menampilkan Status di tabel list");
				extentTest.pass("User berhasil menampilkan Type di tabel list");
				extentTest.pass("User berhasil klik button No pada judul tabel dan menampilkan data sesuai sort No");
				extentTest.pass("User berhasil klik button Nocase pada judul tabel dan menampilkan data sesuai sort Nocase");
				extentTest.pass("User berhasil klik button Name pada judul tabel dan menampilkan data sesuai sort Name");
				extentTest.pass("User berhasil klik button Address pada judul tabel dan menampilkan data sesuai sort Address");
				extentTest.pass("User berhasil klik button City pada judul tabel dan menampilkan data sesuai sort City");
				extentTest.pass("User berhasil klik button Campaign pada judul tabel dan menampilkan data sesuai sort Campaign");
				extentTest.pass("User berhasil klik button Status pada judul tabel dan menampilkan data sesuai sort Status");
				extentTest.pass("User berhasil klik button Type pada judul tabel dan menampilkan data sesuai sort Type");
				extentTest.pass("User berhasil klik ikon jumlah data dan memilih jumlah data yang ditampilkan dalam satu halaman");
				extentTest.pass("User berhasil klik ikon Next dan menampilkan data customer selanjutnya");
				extentTest.pass("User berhasil klik ikon Previous dan menampilkan data customer sebelumnya");
				extentTest.pass("User berhasil klik ikon Nomor Halaman dan menampilkan data sales sesuai nomor halaman");
				extentTest.pass("User berhasil klik search dan mengisi teks pencarian");
				extentTest.pass("User berhasil klik button Sukses pada tabel dan menampilkan data customer di tabel Sukses");				
				extentTest.pass("User berhasil menampilkan Nocase di tabel sukses");
				extentTest.pass("User berhasil menampilkan Name di tabel sukses");
				extentTest.pass("User berhasil menampilkan Address di tabel sukses");
				extentTest.pass("User berhasil menampilkan City di tabel sukses");
				extentTest.pass("User berhasil menampilkan Campaign di tabel sukses");
				extentTest.pass("User berhasil menampilkan Type di tabel sukses");
				extentTest.pass("User berhasil menampilkan Dist Date di tabel sukses");
				extentTest.pass("User berhasil menampilkan Close Date di tabel sukses");
				extentTest.pass("User berhasil menampilkan SLA di tabel sukses");
				extentTest.pass("User berhasil klik button No pada judul tabel dan menampilkan data sesuai sort No");
				extentTest.pass("User berhasil klik button Nocase pada judul tabel dan menampilkan data sesuai sort Nocase");
				extentTest.pass("User berhasil klik button Name pada judul tabel dan menampilkan data sesuai sort Name");
				extentTest.pass("User berhasil klik button Address pada judul tabel dan menampilkan data sesuai sort Address");
				extentTest.pass("User berhasil klik button City pada judul tabel dan menampilkan data sesuai sort City");
				extentTest.pass("User berhasil klik button Campaign pada judul tabel dan menampilkan data sesuai sort Campaign");
				extentTest.pass("User berhasil klik button Type pada judul tabel dan menampilkan data sesuai sort Type");
				extentTest.pass("User berhasil klik button Dist Date pada judul tabel dan menampilkan data sesuai sort Dist Date");
				extentTest.pass("User berhasil klik button Close Date pada judul tabel dan menampilkan data sesuai sort Close Date");
				extentTest.pass("User berhasil klik button SLA pada judul tabel dan menampilkan data sesuai sort SLA");
				extentTest.pass("User berhasil klik ikon jumlah data dan memilih jumlah data yang ditampilkan dalam satu halaman");
				extentTest.pass("User berhasil klik search dan mengisi teks pencarian");
				extentTest.pass("User berhasil klik button Gagal pada tabel dan menampilkan data customer di tabel Gagal");
				extentTest.pass("User berhasil menampilkan Nocase di tabel gagal");
				extentTest.pass("User berhasil menampilkan Name di tabel gagal");
				extentTest.pass("User berhasil menampilkan Address di tabel gagal");
				extentTest.pass("User berhasil menampilkan Status Gagal di tabel gagal");
				extentTest.pass("User berhasil menampilkan Pick Up Date di tabel gagal");
				extentTest.pass("User berhasil menampilkan Type di tabel gagal");
				extentTest.pass("User berhasil klik button Batal pada tabel dan menampilkan data customer di tabel Batal");
				extentTest.pass("User berhasil menampilkan Nocase di tabel batal");
				extentTest.pass("User berhasil menampilkan Name di tabel batal");
				extentTest.pass("User berhasil menampilkan Address di tabel batal");
				extentTest.pass("User berhasil menampilkan Status Gagal di tabel batal");
				extentTest.pass("User berhasil menampilkan Pick Up Date di tabel batal");
				extentTest.pass("User berhasil menampilkan Type di tabel batal");
				extentTest.pass("User berhasil klik button Reschedule pada tabel dan menampilkan data customer di tabel reschedule");
				extentTest.pass("User berhasil menampilkan Nocase di tabel reschedule");
				extentTest.pass("User berhasil menampilkan Name di tabel reschedule");
				extentTest.pass("User berhasil menampilkan Address di tabel reschedule");
				extentTest.pass("User berhasil menampilkan Post Code di tabel reschedule");
				extentTest.pass("User berhasil menampilkan City di tabel reschedule");
				extentTest.pass("User berhasil menampilkan Note di tabel reschedule");
				extentTest.pass("User berhasil menampilkan Type di tabel reschedule");
				extentTest.pass("User berhasil klik button No Status pada tabel dan menampilkan data customer di tabel no status");
				extentTest.pass("User berhasil menampilkan Nocase di tabel no status");
				extentTest.pass("User berhasil menampilkan Name di tabel no status");
				extentTest.pass("User berhasil menampilkan Address di tabel no status");
				extentTest.pass("User berhasil menampilkan Post Code di tabel no status");
				extentTest.pass("User berhasil menampilkan City di tabel no status");
				extentTest.pass("User berhasil menampilkan Note di tabel no status");
				extentTest.pass("User berhasil menampilkan Type di tabel no status");
				extentTest.pass("User berhasil klik button Kembali dan menampilkan halaman Summary MS");
		}
			

//		DOWNLOAD APK
//		Supervisor
			
		@When("Klik menu Download APK user Supervisor")
		public void klik_menu_download_apk_user_supervisor() {
			homepage.toDownloadAPK();
		}
			
		@Then("User berhasil download APK user Supervisor")
		public void finnishDownloadAPKSupervisor() {
			extentTest.pass("User berhasil klik menu Download APK dan berhasil mengunduh aplikasi");
		}
		
//		Super Admin
		
		@Given("User keluar dan login user Super Admin")
		public void user_keluar_dan_login_user_super_admin() {
		loginPage.Logout();
		loginPage.fillFormLogin(configurationProperties.getName1(), configurationProperties.getPassword1());
		loginPage.clickBtnLogin();
		loginPage.closeDisplayAlert();
		}
		
		@When("User klik menu Download APK user Super Admin")
		public void user_klik_menu_download_apk_user_super_admin() {
			homepage.toDownloadAPK();
		}
		
		@Then("User berhasil download APK user Super Admin")
		public void finnishDownloadAPKSuperAdmin() {
			extentTest.pass("User berhasil klik menu Download APK dan berhasil mengunduh aplikasi");
		}
		
		//Mobile Sales
		
		@Given("User keluar dan login user Mobile Sales")
		public void user_keluar_dan_login_user_mobile_sales() {
			loginPage.Logout();
			loginPage.fillFormLogin(configurationProperties.getName3(), configurationProperties.getPassword3());
			loginPage.clickBtnLogin();
			loginPage.closeDisplayAlert();
		}
		
		@When("Klik menu Download APK user Mobile Sales")
		public void downloadApkMobileSales() {
			homepage.toDownloadAPK();
		}
		
		@Then("User berhasil download APK user Mobile Sales")
		public void finnishDownloadAPKMobileSales() {
			extentTest.pass("User berhasil klik menu Download APK dan berhasil mengunduh aplikasi");
		}
	
	@After
	public void closeObject() {
		report.flush();
		
	}
	
	public static String captureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest ="D:\\SQA\\UpdateBaru\\com.juaracoding.mobilesales\\src\\test\\resources\\foto\\"
		+getcurrentdateandtime()+".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
		}
	
	public static String getcurrentdateandtime(){
		String str = null;
		try{
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str= dateFormat.format(date);
			str = str.replace(" ", "-").replaceAll("/", "_").replaceAll(":", "_");
		} catch (Exception e){
			e.printStackTrace(); 
		}
		return str;
	}
}

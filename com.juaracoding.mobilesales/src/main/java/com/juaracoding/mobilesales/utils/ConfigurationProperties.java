package com.juaracoding.mobilesales.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	
	@Value("${browser}")
	private String browser;
	
	@Value("${name1}")
	private String name1;
	
	@Value("${password1}")
	private String password1;
	
	@Value("${textafterlogin1}")
	private String textafterlogin1;
	
	@Value("${name2}")
	private String name2;
	
	@Value("${password2}")
	private String password2;
	
	@Value("${textafterlogin2}")
	private String textafterlogin2;
	
	@Value("${name3}")
	private String name3;
	
	@Value("${password3}")
	private String password3;
	
	@Value("${textafterlogin3}")
	private String textafterlogin3;
	
	@Value("${nikmasteruser}")
	private String nikmasteruser;
	
	@Value("${namemasteruser}")
	private String namemasteruser;
	
	@Value("${usernamemasteruser}")
	private String usernamemasteruser;
	
	@Value("${passwordmasteruser}")
	private String passwordmasteruser;
	
	@Value("${emailmasteruser}")
	private String emailmasteruser;
	
	@Value("${picturemasteruser}")
	private String picturemasteruser;
	
	@Value("${getaccountmasteruser}")
	private String getaccountmasteruser;
	
	@Value("${usernamedituser}")
	private String usernamedituser;

	@Value("${namaedituser}")
	private String namaedituser;
	
	@Value("${emailedituser}")
	private String emailedituser;
	
	@Value("${pictureedituser}")
	private String pictureedituser;
	
	@Value("${searchuser}")
	private String searchuser;
	
	@Value("${nikmasterparameter}")
	private String nikmasterparameter;
	
	@Value("${namemasterparameter}")
	private String namemasterparameter;
	
	@Value("${positionmasterparameter}")
	private String positionmasterparameter;
	
	@Value("${branchmasterparameter}")
	private String branchmasterparameter;
	
	@Value("${areamasterparameter}")
	private String areamasterparameter;
	
	@Value("${getaccountmasterparameter}")
	private String getaccountmasterparameter;
	
	@Value("${searchparameter}")
	private String searchparameter;
	
	@Value("${programnameposter}")
	private String programnameposter;
	
	@Value("${getaccountmasterposter}")
	private String getaccountmasterposter;
	
	@Value("${searchposter}")
	private String searchposter;
	
	@Value("${editusersucces}")
	private String editusersucces;
	
	@Value("${picturemasterposter}")
	private String picturemasterposter;
	
	@Value("${searchpopupmaster}")
	private String searchpopupmaster;
	
	@Value("${lokasifile}")
	private String filepath;
	
	@Value("${keterangan}")
	private String textKeterangan;
	
	@Value("${tanggalmulai}")
	private String textStartDate;
	
	@Value("${tanggalakhir}")
	private String textEndDate;
	
	@Value("${totalms}")
	private String textTotalms;
	
	@Value("${uploader}")
	private String textUploader;
	
	@Value("${productcard}")
	private String textProduct;
	
	@Value("${NIKPeruntukan}")
	private String textNikPeruntukan;
	
	@Value("${NamaPeruntukan}")
	private String textNamaPeruntukan;
	
	@Value("${NamaCustomer}")
	private String textNamaCustomer;
	
	@Value("${productcard2}")
	private String textProductView;
	
	@Value("${inproses}")
	private String textinproses;
	
	@Value("${belumdipickup}")
	private String textbelumdipickup;
	
	@Value("${jadwalulang}")
	private String textjadwalulang;
	
	@Value("${fotoktp}")
	private String textFotoKTP;
	
	@Value("${fotonpwp}")
	private String textFotoNPWP;
	
	@Value("${fotobukti}")
	private String textFotoBUKTI;
	
	@Value("${notes}")
	private String textnotes;
	
	@Value("${textafterworklist}")
	private String textafterworklist;
	
	@Value("${tanggaljadwalulang}")
	private String tanggalJadwalUlang;

	@Value("${lokasiterkini}")
	private String LokasiTerkini;

	@Value("${alamattujuan}")
	private String AlamatTujuan;
	
	@Value("${texterrormap}")
	private String textErrorMap;
	
	@Value("${fotoktp2}")
	private String textFotoKTP2;
	
	@Value("${fotonpwp2}")
	private String textFotoNPWP2;
	
	@Value("${fotobukti2}")
	private String textFotoBUKTI2;
	
	@Value("${textaftercompletedlist}")
	private String textaftercompletedlist;
	
	@Value("${textaftercompletedlist1}")
	private String textaftercompletedlist1;
	
	@Value("${tanggalawalsummaryms}")
	private String tanggalawalsummaryms;
	
	@Value("${tanggalakhirsummaryms}")
	private String tanggalakhirsummaryms;
	
	@Value("${searchsummaryms}")
	private String searchsummaryms;
	
	@Value("${searchsummarymsdetail}")
	private String searchsummarymsdetail;
	
	@Value("${searchsummarymsdetail2}")
	private String searchsummarymsdetail2;
}

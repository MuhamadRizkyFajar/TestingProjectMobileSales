package com.juaracoding.mobilesales.utils;

public enum TestCase {
	
	T1("Modul Login"),
	T2("Modul Login"),
	T3("Modul Login"),
	T4("Modul Master User"),
	T5("Modul Master Parameter Upload"),
	T6("Modul Master Poster"),
	T7("Modul Upload File MS"),
	T8("Modul Distribusi Data"),
	T9("Modul Worklist"),
	T10("Modul Completedlist Mobile Sales"),
	T11("Modul Completedlist Supervisor"),
	T12("Modul Completedlist Super Admin"),
	T13("Modul Summary MS Super Admin"),
	T14("Modul Summary MS Supervisor"),
	T15("Testing Fungsi Download APK user Supervisor"),
	T16("Testing Fungsi Download APK user Super Admin"),
	T17("Testing Fungsi Download APK user Mobile Sales");
	
	private String Testname;
	
	TestCase(String Value) {
		this.Testname=Value;
	}

	public String getTestname() {
		return Testname;
	}
	
}

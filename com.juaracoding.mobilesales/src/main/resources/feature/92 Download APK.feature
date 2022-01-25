Feature: Modul Download APK

	Scenario: Test Modul Download APK user Supervisor
    When Klik menu Download APK user Supervisor
		Then User berhasil download APK user Supervisor

  Scenario: Test Modul Download APK user Super Admin
  	Given User keluar dan login user Super Admin
    When User klik menu Download APK user Super Admin
		Then User berhasil download APK user Super Admin
				
	Scenario: Test Modul Download APK user Mobile Sales
		Given User keluar dan login user Mobile Sales
    When Klik menu Download APK user Mobile Sales
		Then User berhasil download APK user Mobile Sales

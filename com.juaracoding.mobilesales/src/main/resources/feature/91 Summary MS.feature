Feature: MobileSales Fungsi Summary MS

	Scenario: Testing fungsi Summary MS Super Admin
		When User klik menu Summary MS lalu masukan data Summary MS
		Then User berhasil menampilkan data di form Summary MS
		
	Scenario: Testing fungsi Summary MS Supervisor
	  Given User keluar dari user superadmin dan login sebagai supervisor
		When User Supervisor klik menu Summary MS lalu masukan data Summary MS
		Then User Supervisor berhasil menampilkan data di form Summary MS
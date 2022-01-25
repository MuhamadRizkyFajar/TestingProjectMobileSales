Feature: MobileSales Master User

	Scenario: Testing Fungsi New Master User
	  Given User keluar dari user mobile sales dan login sebagai super admin
		When User klik menu Master User lalu klik Add New User
		And User memasukan data di form add user dan klik Submit
		And User berhasil membuat akun
		
		And User klik ikon edit pada tabel user
		And User melakukan edit data user lalu klik Submit
		And User berhasil melakukan edit akun user
		
		And User klik ikon delete pada tabel user
		Then User berhasil melakukan delete akun
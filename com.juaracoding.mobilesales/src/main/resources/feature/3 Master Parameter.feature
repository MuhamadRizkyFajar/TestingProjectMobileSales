Feature: MobileSales Master Parameter Upload

	Scenario: Testing fungsi Master Parameter Upload
		When User klik menu Master Parameter Upload lalu klik Add New
		And User memasukan data di form parameter dan klik Submit
		And User berhasil membuat Data Pamameter Upload
		
		And User klik ikon edit pada tabel
		And User melakukan edit data lalu klik Submit
		Then User berhasil melakukan edit akun
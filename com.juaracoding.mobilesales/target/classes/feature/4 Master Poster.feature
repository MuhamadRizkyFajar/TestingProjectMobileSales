Feature: MobileSales Master Poster

	Scenario: Testing fungsi Master Poster
		When User klik menu Master Poster lalu klik Upload Poster
		And User memasukan data di form upload poster dan klik Submit
		And User berhasil membuat Poster
		
		And User klik ikon edit pada tabel poster
		And User melakukan edit status lalu klik Submit
		And User berhasil melakukan edit poster
			
		And User klik ikon delete pada tabel poster
		Then User berhasil melakukan delete poster
Feature: Upload Modul File Ms

  Scenario: Test Upload File Ms
    When Klik menu Upload File MS
    And Klik download template MS
		And Klik Upload MS dan memasukan data di form upload file
		And Klik Submit
		And Klik Back dari upload file
		And Sorting data customer
		And Pilih Jumlah Data
		And Klik Pindah Page
		And Scroll Page ke atas dengan button up
		And Mencari Data Upload File MS
		And Klik Edit
		And Pilih spv di menu pop up
		And Isi form edit file
		And Klik Submit Edit
		And Klik Back dari edit
		And Klik Hapus File
		And Klik View
		And Sorting data customer di view
		And Pilih Jumlah Data di view
		And Klik Pindah Page di view
		And Mencari Data Customer
		And Klik back dari view
		Then User berhasil melakukan upload data MS dengan bukti yang mengupload sesuai
		And Tanggal Sesuai
		And Product Sesuai
		And Keterangan Sesuai
		And TotalMS Sesuai
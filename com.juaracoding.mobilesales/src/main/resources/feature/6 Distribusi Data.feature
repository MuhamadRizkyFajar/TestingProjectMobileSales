Feature: Modul Distribusi Data

  Scenario: Test Modul Distribusi data
    Given User login ke user Supervisor
    When Klik menu Distribusi
    And Cek Kategori
    And Klik kategori yang dipilih dan pilih Sales yang akan di distribusi
    And Pilih Filter data
    And Pilih Tampilan Jumlah Data
    And Pindah halaman tabel customer
    And Mencari Data Customer yang ingin di pilih
    And Pilih Customer
    And Klik submit untuk distribusi data
    Then User berhasil mendistribusi data ke mobile sales dengan tampilan total in proses
    And Tampilan Belum di pick up
    And Tampilan Jadwal Ulang
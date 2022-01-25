Feature: Modul Worklist

  Scenario: Test Modul Worklist
    Given User masuk ke user Mobile Sales
    When Klik menu Worklist
    And Pilih Tampilan Jumlah Data di Worklist
    And Pindah halaman list customer
    And Mencari Data Customer di Work List
    And Klik customer yang ingin di survey
    And Pilih status sukses pick up dan isi form dari status pick up sukses pick up
    And Pilih status gagal pick up dan isi form dari status pick up gagal pick up
    And Pilih status batal dan isi form dari status pick up batal
    And Pilih status jadwal ulang dan isi form dari status pick up jadwal ulang
    And Pilih status No Respon dan isi form dari status pick up no respon
    And Klik back dari update status pick up
    And Klik map customer yang ingin di tuju untuk survey
    And Isi form survey
    And Klik submit survey
    And Klik back dari survey alamat
    And Klik survey alamat
    And Klik pick up
    And Klik cancel disetiap upload foto form update status worklist
    And Isi form update status worklist
    Then User berhasil survey worklist

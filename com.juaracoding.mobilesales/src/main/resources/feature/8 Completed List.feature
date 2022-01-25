Feature: Modul Completed list

  Scenario: Test Modul Completed List Mobile Sales
    When User klik completedlist di user Mobile Sales
    And Pilih jumlah data tampilan di completed list user Mobile Sales
    And Pindah halaman list customer di completed list user Mobile sales
    And Mencari Data Customer di completed list uesr Mobile Sales
    And Memilih product mengisi tanggal mulai dan memfilter pilih salah satu data customer untuk melihat detailnya di completed list user Mobile Sales
    And Klik Edit di completed list uesr Mobile Sales
    And Klik cancel disetiap upload foto di completed list user Mobile Sales
    And Mengganti upload foto di completed list user Mobile Sales
    And Klik kembali dari Edit di completed list user Mobile Sales
    Then User dapat melihat detail data customer yang dipilih di completed list user Mobile Sales
    And Klik kembali setelah melihat detail di completed list user Mobile Sales
    
   Scenario: Test Modul Completed List Supervisor
   	Given User login dari user Mobile Sales ke user Supervisor
    When User klik completedlist di user Supervisor
    And Pilih jumlah data tampilan di completed list user Supervisor
    And Pindah halaman list customer di completed list user Supervisor
    And Mencari Data Customer di completed list user Supervisor
    And Memilih product mengisi tanggal mulai dan memfilter pilih salah satu data customer untuk melihat detailnya di completed list user Supervisor
   	Then User dapat melihat detail data customer yang dipilih di completed list user Supervisor
   	And Klik kembali setelah melihat detail di completed list user Supervisor
    
   Scenario: Test Modul Completed List Super Admin
   	Given User login dari user Supervisor ke user Super Admin
    When User klik completedlist di user Super Admin
    And Pilih jumlah data tampilan di completed list user Super Admin
    And Pindah halaman list customer di completed list user Super Admin
    And Mencari Data Customer di completed list user Super Admin
    And Memilih product mengisi tanggal mulai dan memfilter pilih salah satu data customer untuk melihat detailnya di completed list user Super Admin
    Then User dapat melihat detail data customer yang dipilih di completed list user Super Admin
    And Klik kembali setelah melihat detail di completed list user Super Admin
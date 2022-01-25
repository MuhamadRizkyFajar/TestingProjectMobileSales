Feature: Modul Login

  Scenario: Test Login User Super Admin
    Given User membuka url
    When Mengisi username dan password login user Super Admin
    Then User super admin dapat login ke Website

  Scenario: Test Login User Supervisor
   	Given User keluar dari user Super Admin
    When Mengisi username dan password login user Supervisor
    Then User supervisor dapat login ke Website
    
    Scenario: Test Login User Mobile Sales
   	Given User keluar dari user Supervisor
    When Mengisi username dan password login user Mobile Sales
    Then User mobile sales dapat login ke Website

Feature: Hepsiburada Case File


  Scenario: Lokasyon Kontrolu
    Given "Pixel_3a_API_29" Isimli "10" Surumlu Cihaz ayaga kaldirilir
    And Konuma tiklanir
    And Il "İstanbul" secilir
    And Ilce "Beşiktaş" secilir
    And Mahalle "Yıldız" secilir
    When Konum Kaydet Butonuna Tiklanir
    And Konum Kaydedildi Popupi Kontrol Edilir
    And Kategoriler tabina tiklanir
    And Kategorilerden rastgele kategori secilir
    Then Kategori Konumu Dogru mu Kontrol Edilir
    And Cihaz kapatilir

  Scenario: Super Fiyat Favoriler
    Given "Pixel_3a_API_29" Isimli "10" Surumlu Cihaz ayaga kaldirilir
    And Super Fiyata Tiklanir
    And Birden Fazla Gorselli Urun Secilir
    And Urun Gorseline Tiklanir
    And Yana Dogru Scroll Edilir
    And Gorsel Ekrani Kapatilir
    When Urun Detayda Favori Butonuna Tiklanir
    And "marynaausiaikova@supermantutivie.com" ve "Deneme@123" ile login Olunur
    And Urun Detayda Geri Butonuna Tiklanir
    And Listelerim Butonuna Tiklanir
    And Begendiklerim Butonuna Tiklanir
    Then Urunun Favorilere Eklendigi Kontrol Edilir
    And Cihaz kapatilir



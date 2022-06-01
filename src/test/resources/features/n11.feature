@test
Feature: n11 automation case

  Scenario: Adding/deleting favourite product
    When user navigates to homepage
    Then verify that the page title is "n11.com - Hayat Sana Gelir"
    When user logs in with Facebook
    Then verify that username "Erva Ulker" is visible under My Account
    When user searches for "Iphone"
    Then verify that user sees the results for "Iphone"
    When when user navigates to results page number "2"
    Then verify that "Sayfa 2" is seen at the end of the page title
    When user adds the product number "3" on the page to Favourites
    And user navigates to "Favorilerim / Listelerim"
    Then verify that page title starts with "Favorilerim"
    When user deletes the product from the favorites
    Then verify that "Ürününüz listeden silindi." message is displayed
    #And user navigates to "Çıkış Yap"
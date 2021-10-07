Feature: Search for t-shirts
  Everybody wants to know if there is some t-shirts available

  Scenario: search for camiseta
    Given Im in the home page
    When I search for "camiseta"
    Then I should see no results for "camiseta"

  Scenario: Search for blouse
    Given Im in the home page
    When I search for "blouse"
    Then I should see results for "Blouse"

    Scenario: Close browser
      Given I close the browser

      Scenario: check activities available
        Given Im able to access "activities"
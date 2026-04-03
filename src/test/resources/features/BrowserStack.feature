Feature: BrowserStack Test

  Scenario: Launch Chrome and open BrowserStack URL
    Given I launch Chrome browser
    When I navigate to BrowserStack website
    Then I should see the BrowserStack page title
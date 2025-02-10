Feature: Automate web interactions using BDD

  Scenario: Verify the Title of the Homepage
    Given I launch the application
    Then I verify the title of the page

  Scenario: Verify A/B Testing Page Text
    Given I click on "A/B Testing"
    Then I verify the text on the page as "A/B Test Variation 1"

  Scenario: Select Dropdown Option
    Given I navigate back to Home Page
    When I click on "Dropdown"
    And I select "Option 1" from the dropdown
    Then I confirm "Option 1" is selected

  Scenario: Verify Frames Page Hyperlinks
    Given I navigate back to Home Page
    When I click on "Frames"
    Then I verify "Nested Frames" hyperlink is present
    And I verify "iFrame" hyperlink is present

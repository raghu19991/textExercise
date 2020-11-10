Feature: Charity Listings
  This feature verifies whether specific charity exists in the list of charities

  Scenario: Verify St Johns is included in the list of charities
  The charities API doesn't need any auth for access
    Given I am able to access Charity listings API
    When I view all the listings
    Then I verify that "St John" is included in the list






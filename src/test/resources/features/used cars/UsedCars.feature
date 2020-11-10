Feature: Verify User Car Details
  This feature verifies whether details like Number Plate,Kilometers,Body,Seats exist on any
  random used car

  Scenario Outline: Verify Used Car Details
    These test includes verifying details of a random used car listing#2149206009
    using both WEB and API.
    OAuth verification is done for the API end point.
    Given I access Used Cars Page using <Interface>
    When I view the details of any Used Car
    Then I verify that the following details of the car exists
      | Number plate |
      | Kilometres  |
      | Body         |
      | Seats        |

    Examples: Interface
    The test verifies using WEB and API interfaces
      | Interface |
      | WEB       |
      | API       |







Feature: Delete an existing Contact
  In order to be able to remove unused contacts from the Contacts Application
  As a Contacts Application user
  I want to be able to delete a contact from the Contacts Application

  Scenario Outline: Delete a contact
    Given a JSON object with <firstName>, <lastName>
    When I issue a DELETE to /contacts
    Then I receive a 204 Status code
    And a JSON with message "Successfully Deleted"

    Examples:
      | firstName | lastName    |
      | Alice     | Alvsson     |
      | Bob       | Björnsson   |
      | Chris     | Christenson |
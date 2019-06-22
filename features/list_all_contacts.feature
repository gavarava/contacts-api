Feature: List all contacts in the Contacts Application
  In order to be able to know if there are any saved contacts
  As a Contacts Application user
  I want to be able to list all the contacts in the the Contacts Application

  Scenario Outline: List all contacts
    Given there are <numberOfSavedContacts> contacts saved in the application
    When I issue a GET to /contacts
    Then I receive JSON array with <numberOfSavedContacts> contact entries
    And all entries are sorted in alphabetical order

    Examples:
      | numberOfSavedContacts |
      | 0                     |
      | 20                    |
      | 10                    |

  Scenario: List all contacts in sorted order
    Given there are 10 contacts
    And 3 out of them are marked favourite
    When I issue a GET to /contacts
    Then I receive JSON array with 10 contact entries
    And favourite contact entries are sorted first
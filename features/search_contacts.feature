Feature: Search for a Contact
  In order to be able find a particular contact details from the Contacts Application
  As a Contacts Application user
  I want to be able to search for contacts using any details in the contact

  Scenario Outline: Search contact which exists
    Given a request with the <searchTerm>
    When there are matching contacts results
    Then I receive a list of matching <searchResultsListSize> results

    Examples:
      | searchTerm | searchResultsListSize |
      | Alice      | 1                     |
      | Lexington  | 1                     |
      | 93270      | 2                     |


  Scenario: Search contact which does not exist
    Given a request with the "RandomContact"
    When there no matching results
    Then I receive an empty list
Feature: Add new Contact
  In order to be able to use Contacts Application for saving contacts
  As a Contacts Application user
  I want to be able to add a new contact to the Contacts Application

  Background: A running instance of the Contacts Application
    Given a running Contacts Application Server

  Scenario Outline: Add new contact
    Given a JSON object with <firstName>, <lastName>, <address>, <postcode>, <city>, <phoneNumber>
    When I issue a POST to /contacts
    Then I receive a 200 Status code
    And a JSON with message "Successfully Saved"

    Examples:
      | firstName | lastName    | address             | postcode | city       | phoneNumber  |
      | Alice     | Alvsson     | 24 Park Avenue      | 96122    | LA         | 530-322-3054 |
      | Bob       | Björnsson   | 13 Pittsfield       | 93270    | Chowchilla | 559-715-2735 |
      | Chris     | Christenson | 29 Lexington Avenue | 93270    | Chowchilla | 559-663-4598 |
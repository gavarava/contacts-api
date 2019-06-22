Feature: Mark a contact as favourite
  In order to be able to quickly access my frequent contacts
  As a Contacts Application user
  I want to be able to mark a contact as my favourite in the Contacts Application

  Scenario Outline: Mark favourite contact
    Given an already saved contact <firstName> <lastName>
    When a user marks it as a favourite
    Then <firstName> <lastName> is among favourite contacts

    Examples:
      | firstName | lastName    |
      | Alice     | Alvsdotter  |
      | Bob       | Björnsson   |
      | Chris     | Christenson |


  Scenario Outline: Mark favourite contact
    Given favourite marked contact <firstName> <lastName>
    When a user unmarks it from favourites
    Then <firstName> <lastName> is removed from favourite contacts

    Examples:
      | firstName | lastName    |
      | Alice     | Alvsdotter  |
      | Bob       | Björnsson   |
      | Chris     | Christenson |


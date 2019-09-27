Feature: Healthcheck
  In order know whether the Contacts Application is up & running successfully
  As a Contacts Application DevOps person
  I want to be able to do a get request for a health check

  Background: A running instance of the Contacts Application
    Given a running Contacts Application Server

  Scenario: Issuing a GET on healthcheck endpoint on the admin port responds OK
    When a client issues a GET to "/healthcheck"
    Then I receive "200" response
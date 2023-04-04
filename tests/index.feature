#encoding: UTF-8

## Login Page
Feature: User Login

    Feature Description: The user should be able to login to the system

    Scenario: Correct User Login
        Given I start the application
        And I am at the login screen
        When I fill the "Usuário" field with "Tom"
        And I fill the "Senha" field with "Tom"
        And click the "Entrar" button
        Then I should proceed to the main screen 

    Scenario: Incorrect User Login
        Given I start the application
        And I am at the login screen
        When I fill the "Usuário" field with "Tom"
        And I fill the "Senha" field with "SenhaErrada"
        And click the "Entrar" button
        Then I should see a modal saying "usuário e/ou senha inválidos"
        And I should stay at the login screen

## Main Page
Feature: User Logout

    Feature Description: The user should be able to logout from the system by clicking the "Sair" button in the main screen

    Scenario: User Logout at "Sair" button in the main screen
        Given I start the application
        And I am at the login screen
        When I fill the "Usuário" field with "Tom"
        And I fill the "Senha" field with "Tom"
        And click the "Entrar" button
        Then I should proceed to the main screen
        When I click the "Sair" button
        Then user should be logged out
        And the application should close

Feature: Open "Agendamento" page

    Feature Description: The user should be able to open the "Agendamento" page by clicking the "Agendamento" button in the main screen

    Scenario: Open "Agendamento" page at "Agendamento" button in the main screen
        Given I start the application
        And I am at the login screen
        When I fill the "Usuário" field with "Tom"
        And I fill the "Senha" field with "Tom"
        And click the "Entrar" button
        Then I should proceed to the main screen
        When I click the "Agendamento" button
        Then I should proceed to the "Agendamento" page

Feature: Open "Relatorio" page
  
      Feature Description: The user should be able to open the "Relatorio" page by clicking the "Relatorio" button in the main screen
  
      Scenario: Open "Relatorio" page at "Relatorio" button in the main screen
          Given I start the application
          And I am at the login screen
          When I fill the "Usuário" field with "Tom"
          And I fill the "Senha" field with "Tom"
          And click the "Entrar" button
          Then I should proceed to the main screen
          When I click the "Relatorio" button
          Then I should proceed to the "Relatorio" page

## Agendamento Page

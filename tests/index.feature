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
Feature: Schedule a task

    Feature Description: The user should be able to schedule a task in the "Agendamento" page  

    Background:
        Given I start the application
        And I am Logged in as "Tom" 

    Scenario: Fill the fields with valid values and Insert it into the report
        When I fill the "Descrição" field with "Exemplo"
        And I fill the "Representante" field with "Tom"
        And I fill the "Horario" field with "10:00"
        And I fill the "Data" field with "10/10/2023"
        And I set the "Estado" dropdown to "Aberto"
        And I set the "Tipo" dropdown to "Profissional"
        And I set the "Prioridade" dropdown to "Normal"
        And I click the "Inserir" button
        Then I should see a modal saying "cadastro realizado com sucesso"
        And the table containing the tasks in "Agendamento" page must be updated with the new data in the last line

    Scenario: Fill the "Horario" field with an invalid time
        When I fill the "Horario" field with "25:00"
        Then I should see a modal saying "Horário inválido"
        And The table containing the tasks in "Agendamento" page must not be updated

    Scenario: Fill the "Horario" field with a string
        When I fill the "Horario" field with "exemplo"
        Then I should see a modal saying "Horário inválido"
        And The table containing the tasks in "Agendamento" page must not be updated

    Scenario: Fill the "Data" field with an invalid date
        When I fill the "Data" field with "10/99/2020"
        Then I should see a modal saying "Data inválida"
        And The table containing the tasks in "Agendamento" page must not be updated

    Scenario: Fill the "Data" field with a string
        When I fill the "Data" field with "exemplo"
        Then I should see a modal saying "Data inválida"
        And The table containing the tasks in "Agendamento" page must not be updated

Feature: Update a task

    Feature Description: The user should be able to update a task in the "Agendamento" page

    Background:
        Given I start the application
        And I am Logged in as "Tom"
        And I am at the "Agendamento" page

    Scenario: Update a task by clicking in a row into the task table
        When I click a row in the task table
        Then I should see all the task property fields filled with the data of the task selected
        And I erase the "Descrição" field
        And I fill the "Descrição" field with "Novo Exemplo"
        And I erase the "Representante" field
        And I fill the "Representante" field with "Tomas"
        And I erase the "Horario" field
        And I fill the "Horario" field with "22:00"
        And I erase the "Data" field
        And I fill the "Data" field with "11/11/2024"
        And I set the "Estado" dropdown to "Fechada"
        And I set the "Tipo" dropdown to "Pessoal"
        And I set the "Prioridade" dropdown to "Urgente"
        And I click the "Alterar" button
        Then I should see a modal saying "Alterado com sucesso"
        And I should see the selected row updated with the new data inserted

Feature: Delete a task

    Feature Description: The user should be able to delete a task in the "Agendamento" page

    Background:
        Given I start the application
        And I am Logged in as "Tom"
        And I am at the "Agendamento" page
    
    Scenario: Delete a task by clicking in a row into the task table
        When I click a row in the task table
        Then I should see all the task property fields filled with the data of the task selected
        And I click the "Excluir" button
        Then I should see a modal saying "OBJETO EXCLUIDO"
        And the table containing the tasks in "Agendamento" page must be updated without the chosen row

Feature: Search a task in "Agendamento" page

    Feature Description: The user should be able to search a single task in the "Agendamento" page

    Background:
        Given I start the application
        And I am Logged in as "Tom"
        And I am at the "Agendamento" page

    Scenario: Search a task by filling the ID field
        When I fill the "ID" field with previously added valid task ID
        And I click the "Consultar ID" button
        Then the table containing the tasks in "Agendamento" page must show only the row with the task related to the ID inserted 

    Scenario: Search a task by filling the "Buscar" field
        When I fill the "Buscar" field with a previously added date
        And I click the "Consultar Data" button
        Then the table containing the tasks in "Agendamento" page must show all the rows that have tasks related to the date inserted

Feature: Close the "Agendamento" page

    Feature Description: The user should be able to close the "Agendamento" page by clicking the "Sair" button in the "Agendamento" page

    Background:
        Given I start the application
        And I am Logged in as "Tom"
        And I am at the "Agendamento" page

    Scenario: Close the "Agendamento" page at "Sair" button in the "Agendamento" page
        When I click the "Sair" button
        Then the current window must be closed

##Relatorio Page
Feature: Check the report

    Feature Description: The user should be able to check the report in the "Relatorio" page

    Scenario: Check the report by opening "Relatorio" page
        Given I start the application
        And I am Logged in as "Tom"
        And I am at the "Relatorio" page
        Then the table containing the tasks in "Relatorio" page must show all the rows with every task registered

    Scenario: Check the report in the "Relatorio" page after scheduling a new task in "Agendamento" page
        Given I start the application
        And I am Logged in as "Tom"
        And I am at the "Agendamento" page
        When I fill the "Descrição" field with "Texto de Exemplo"
        And I fill the "Representante" field with "Juca"
        And I fill the "Horario" field with "14:00"
        And I fill the "Data" field with "01/01/2025"
        And I set the "Estado" dropdown to "Aberto"
        And I set the "Tipo" dropdown to "Pessoal"
        And I set the "Prioridade" dropdown to "Urgente"
        And I click the "Inserir" button
        Then I should see a modal saying "cadastro realizado com sucesso"
        And the table containing the tasks in "Agendamento" page must be updated with the new data in the last line
        And I click the "Sair" button
        When I click the "Relatorio" button
        Then I should proceed to the "Relatorio" page
        And the table containing the tasks in "Relatorio" page must show all the rows with every task registered



Feature: Search a task in "Relatorio" page

    Feature Description: The user should be able to search a single task in the "Relatorio" page

    Background:
        Given I start the application
        And I am Logged in as "Tom"
        And I am at the "Relatorio" page

    Scenario: Search a task by filling the ID field
        When I fill the "ID" field with previously added valid task ID
        And I click the "Consultar ID" button
        Then the table containing the tasks in "Relatorio" page must show only the row with the task related to the ID inserted 

    Scenario: Search a task by filling the "Buscar" field
        When I fill the "Buscar" field with a previously added date
        And I click the "Consultar Data" button
        Then the table containing the tasks in "Relatorio" page must show all the rows that have tasks related to the date inserted
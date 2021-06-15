
Feature: Probar la busqueda en google
Scenario: Busco algo en GOOGLE
    Given Navego a Google
    When Busco algo
    And clickeo en el boton de buscar
    Then Obtengo resultados

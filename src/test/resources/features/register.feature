# new feature
# Tags: optional

Feature: llenar formulario para registrarme
  yo como usuario de la pagina
  quiero llenar el formulario
  para registrarme en la pagina

  Scenario: diligenciar el formulario para poder registrarme
    Given dado que me encuentro en el modulo de registro
    When estoy diligenciando los campos del formulario y presiono registrar
    Then el sistema muestra el mensaje de bienvenida

  Scenario: no diligenciar un campo para el registro
    Given dado que se encuentra en el modulo registro
    When no diligecia el campo phone
    Then el sistema muestra en pantalla el mensaje de bienvenida

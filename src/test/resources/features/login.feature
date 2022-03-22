# new feature
# Tags: optional

Feature: diligenciar formulario login para ingresar
  yo como usuario registrado en la pagina
  quiero hacer login
  para hacer transferencias

  Scenario: diligenciar los campos del login para ingresar
    Given dado que me encuentro en el login de la pagina
    When diligencio los campos del login y presiono ingresar
    Then el sistema debera mostrar el mensaje de bienvenida

  Scenario: ingresar contraseña incorrecta en el login
    Given dado que me encuentro en el campo password del login
    When ingrese un dato incorrecto
    Then el sistema debera mostrar el mensaje de error

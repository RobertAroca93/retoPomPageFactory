# new feature
# Tags: optional

Feature: enviar mensaje para obtener soporte
  yo como usuario de la pagina
  quiero enviar un mensaje
  para obtener soporte tecnico

  Scenario: diligenciar el formulario para enviar el mensaje
    Given dado que me encuentro en el modulo del contacto
    When estoy diligenciando los campos del formulario y envio el mensaje
    Then me muestra mensaje de envio exitoso


  Scenario: diligenciamiento incorrecto del formulario para enviar el mensaje
    Given dado que me encuentro en el modulo del contacto del banco
    When no diligencio uno de los campos
    Then el sistema debe solicitar que se diligencie ese campo

#language:es
#Author: josejulian_ramos@hotmail.com
Característica: Inicio de sesión Gmail
  Como Analista de certificación de gmail 
  quiero probar el inicio de sesión de la aplicación
  para validar su correcto funcionamiento

  Antecedentes: 
    Dado que el Analista se encuentra en la página de inicio de sesión de Gmail

  @tag1
  Escenario: Inicio de sesión exitoso
    Cuando el Analista inicia sesión
      | email              | contrasenia   |
      | tucorreo@gmail.com | tucontrasenia |
    Entonces deberá visualizar los correos recibidos

  @tag2
  Escenario: Inicio de sesión con email inválido
    Cuando el Analista ingresa un email inválido
      | email   |
      | a@gmai1 |
    Entonces deberá visualizar mensaje de error de correo electrónico inválido

  @tag3
  Escenario: Inicio de sesión con contraseña incorrecta
    Cuando el Analista ingresa una contraseña incorrecta
      | email              | contrasenia             |
      | tucorreo@gmail.com | tucontraseniaincorrecta |
    Entonces deberá visualizar mensaje de error de contraseña incorrecta

  @tag4
  Escenario: Inicio de sesión con correo electrónico en blanco
    Cuando el Analista deja el campo de correo electrónico en blanco
      | email |
      |       |
    Entonces deberá visualizar mensaje de error para introducir dirección de correo electrónico

  @tag5
  Escenario: Inicio de sesión con contraseña en blanco
    Cuando el Analista deja el campo de contraseña en blanco
      | email              | contrasenia |
      | tucorreo@gmail.com |             |
    Entonces deberá visualizar mensaje de error para introducir una contraseña

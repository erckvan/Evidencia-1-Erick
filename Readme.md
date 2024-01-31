## Instalacion y configuracion  ##

Clonar el repositorio: Clona el repositorio de tu proyecto desde GitHub o cualquier
otro sistema de control de versiones que utilices.

git clone <url_del_repositorio>

Compilación del programa: Para compilar el programa, asegúrate de tener la ultima version de Java instalada en tu sistema
desde la línea de comandos, navega hasta el directorio donde se encuentra tu proyecto y compila el archivo Main.java

javac Main.java

Ejecución del programa: Una vez compilado el archivo Main.java ejecuta el programa con el siguiente comando:

java Main


## Uso del programa ##

Una vez que hayas ejecutado el programa, podrás realizar las siguientes acciones:

1- Inicio de sesión: se te pedira que ingreses tu nombre de usuario y contraseña, debes proporcionar
as credenciales de administrador para acceder al sistema.

2- Menú principal: Después de iniciar sesión, se mostrará un menú con las siguientes opciones.

* Dar de alta doctor: Permite agregar un nuevo doctor al sistema.
* Dar de alta paciente: Permite agregar un nuevo paciente al sistema.
* Crear cita: Permite programar una cita médica entre un doctor y n paciente.
* Salir: Cierra el programa.

## Crear una cita ##

Crear cita: al seleccionar la opción crear cita, deberás proporcionar la información requerida,
como el ID del doctor y del paciente, la fecha y hora de la cita, así como el motivo de la misma.
El programa verificará la disponibilidad de los doctores y pacientes antes de confirmar la cita.


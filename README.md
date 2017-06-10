# MouseController 

MouseController (Mc) allow you to specify the IP from the computer that you want to control.

The soft is in two components:
* Server - His mouse is controlled.
* Client - Use his mouse to control server's mouse

### Building
MouseController dependencies:

* jnativehook-2.1.0
* swinger-1.0.0

![Soft](https://image.noelshack.com/fichiers/2017/23/6/1497093502-sans-titre.png)

Refer to the [website](https://github.com/azword/MouseController/website.io) for instructions on building from source.

### Installation

Simply as a finger in the ass :

``
java -jar MouseController.jar
``

### Known Issues
Known issues listed here will be corrected.

    - Server freeze when running (Not Threaded)
    - When resolutionClient < resolutionServer
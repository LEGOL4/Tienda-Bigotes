<p align="center">
  <img src="images/logo.svg" width="250" alt="Tienda Bigotes Logo" />
</p>

# Tienda Bigotes

> 📚 **CURSO:** Programación Orientada a Objetos - 2024

Para la construcción de este proyecto se utilizaron las siguientes tecnologías:

1. IDE: IntelliJ IDEA
2. Lenguaje: Java
3. Framework: JavaFX
4. Backend: NestJS
5. Base de datos: PostgreSQL
6. ORM: TypeORM
7. Control de versiones: Git

## INSTRUCCIONES

Para ejecutar el proyecto, siga los siguientes pasos:

> [!NOTE]
> Se recomienda tener instalado [Java JDK 21](https://adoptium.net/es/temurin/releases/?package=jdk&arch=x64&os=windows) o superior y [JavaFX 22](https://download2.gluonhq.com/openjfx/22/openjfx-22_windows-x64_bin-sdk.zip) para un correcto funcionamiento

1. Clonar el repositorio
2. Abrir el proyecto en IntelliJ IDEA
3. Compilar el proyecto con la opción `Build Artifacts`
4. Ejecutar el archivo  `moustacheshop.jar`
5. Ingresar al sistema con las siguientes credenciales:
    - **Usuario:** admin@gmail.com
    - **Contraseña:** Admin123
6. Disfrutar de la aplicación

> [!TIP]
> Si no logra ejecutar el archivo `moustacheshop.jar`, puedes seguir los siguientes pasos:

Crear un archivo `script.bat` con el siguiente contenido:

```bash
@echo off
java --module-path "C:\Program Files\Java\javafx-sdk-22\lib" --add-modules javafx.controls,javafx.fxml -jar ".\out\artifacts\moustacheshop_jar\moustacheshop.jar"
```

Si prefieres una ejecución silenciosa, puedes crear el archivo `start.vbs` con el siguiente contenido:

```vbscript
Set WshShell = CreateObject("WScript.Shell")
WshShell.Run "script.bat", 0, False
```
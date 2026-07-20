
![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Evaluación Final Transversal – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:**  Gabriel Alejandro Márquez Vidal
- **Sección:** PRY2202
- **Carrera:** DESARROLLO DE APLICACIONES


# 🏔️ Llanquihue Tour - Prototipo de Gestión Turística

Prototipo de software modular orientado a objetos diseñado para la agencia de turismo **Llanquihue Tour**. El sistema digitaliza la gestión manual de clientes y guías turísticos, permitiendo la carga automatizada de datos desde archivos de texto, el registro dinámico en memoria y la consulta filtrada de registros.

---

## 🛠️ Tecnologías y Conceptos Aplicados

* **Lenguaje:** Java (JDK 17+)
* **IDE:** IntelliJ IDEA
* **Paradigma:** Programación Orientada a Objetos (POO)
  * **Encapsulamiento:** Atributos privados con getters/setters y validaciones.
  * **Herencia:** Clase abstracta base `Persona` extendida por `Cliente` y `Guia`.
  * **Composición:** Relación entre `Persona` y `Direccion`.
  * **Polimorfismo e Interfaces:** Implementación de la interfaz `Registrable` y listas polimórficas.
* **Manejo de Excepciones:** Excepción personalizada `RutInvalidoExcepcion` para validación de formatos.
* **Persistencia Temporal:** Carga de datos mediante `BufferedReader` desde archivo de texto `.txt`.

---

## 📁 Estructura del Proyecto

El código está organizado modularmente en paquetes según sus responsabilidades:

```text
src/
 ├── app/
 │    └── Main.java                 # Punto de entrada y menú interactivo de la aplicación
 ├── interfaces/
 │    └── Registrable.java          # Interfaz para la estandarización de despliegue de datos
 ├── model/
 │    ├── Persona.java              # Clase base abstracta
 │    ├── Cliente.java              # Entidad Cliente (hereda de Persona)
 │    ├── Guia.java                 # Entidad Guía (hereda de Persona)
 │    ├── Direccion.java            # Clase para composición de direcciones
 │    ├── Producto.java             # Base para catálogo de servicios/tours
 │    └── OrdenDeCompra.java        # Base para la gestión de compras
 └── utils/
      ├── LectorArchivo.java        # Lectura y parseo del archivo datos_turismo.txt
      └── RutInvalidoExcepcion.java # Excepción personalizada para validación de RUT


---

## 🚀 Funcionalidades Principales

1. **Carga Automática:** Ingesta de datos desde `datos_turismo.txt` al iniciar el programa.
2. **Inscripción de Clientes y Guías:** Registro interactivo por consola con validación de RUT.
3. **Asignación por Defecto:** Uso de sobrecarga de constructores para la comuna (asigna *Llanquihue* si se deja vacía).
4. **Listado General:** Visualización completa de todas las personas registradas en el sistema.
5. **Filtrado Exclusivo de Clientes:** Filtro de la colección mediante el operador `instanceof`.
6. **Búsqueda por RUT:** Consulta directa de registros individuales.

---

## ⚙️ Cómo Ejecutar el Proyecto

1. Clona o descarga este repositorio.
2. Abre el proyecto en **IntelliJ IDEA**.
3. Asegúrate de que el archivo `datos_turismo.txt` esté ubicado en la raíz del proyecto.
4. Ejecuta la clase `Main.java` ubicada en el paquete `app`.

---



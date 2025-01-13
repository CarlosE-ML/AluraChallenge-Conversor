# Alura Challenge - Conversor de Monedas

Este es un proyecto simple de consola en Java que permite convertir entre diversas monedas utilizando tasas de cambio en tiempo real a través de una API externa.

## Características principales

- Conversión entre varias monedas (USD, EUR, BRL, ARS, COP, etc.)
- Obtención de tasas de cambio en tiempo real desde una API externa.
- Menú interactivo para seleccionar el tipo de conversión.
- Validación de entradas y manejo de excepciones para garantizar un uso correcto de la aplicación.

## Monedas disponibles para conversión

1. Dólar (USD) => Sol Peruano (PEN)
2. Sol Peruano (PEN) => Dólar (USD)
3. Dólar (USD) => Real Brasileño (BRL)
4. Real Brasileño (BRL) => Dólar (USD)
5. Dólar (USD) => Peso Argentino (ARS)
6. Peso Argentino (ARS) => Dólar (USD)
7. Salir

## Requisitos

- Java 8 o superior
- Librería Gson para procesar el JSON de la API (se puede incluir mediante Maven)

## Uso

1. Clonar el repositorio.
2. Incluir tu API Key en el archivo `ClienteAPI.java` en el URL de la API.
3. Ejecutar la clase `Menu` para iniciar el programa en consola.
4. Seleccionar la opción de conversión y proporcionar el valor a convertir.

## Dependencias

- **Gson**: Librería para el procesamiento de JSON. (Incluir en `pom.xml` si usas Maven)

## Contribuciones

Las contribuciones son bienvenidas. Si tienes alguna mejora o corrección, no dudes en enviar un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.


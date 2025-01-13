package com.conversor.menu;

import com.conversor.service.ConversorMoneda;

import java.util.Scanner;

public class Menu {
    private final ConversorMoneda conversor = new ConversorMoneda();

    public void mostrar() {
        Scanner entrada = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n*******************************************");
            System.out.println("Sea bienvenido al conversor de moneda:");
            System.out.println();
            System.out.println("1) Dólar => Sol Peruano");
            System.out.println("2) Sol Peruano => Dólar");
            System.out.println("3) Dólar => Real Brasileño");
            System.out.println("4) Real Brasileño => Dólar");
            System.out.println("5) Dólar => Peso Argentino");
            System.out.println("6) Peso Argentino => Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");
            opcion = entrada.nextLine(); // Leer entrada como texto

            if (esNumero(opcion)) {
                int opcionNumerica = Integer.parseInt(opcion);
                if (opcionNumerica >= 1 && opcionNumerica <= 6) {
                    manejarConversion(opcionNumerica);
                } else if (opcionNumerica != 7) {
                    System.out.println("Número inválido. Por favor, elija un número entre 1 y 7.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        } while (!opcion.equals("7"));

        System.out.println("Gracias por usar la aplicación. ¡Hasta luego!");
    }

    private void manejarConversion(int opcion) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el valor a convertir: ");
        double valor;

        try {
            valor = entrada.nextDouble();
            double resultado = conversor.convertir(opcion, valor);
            System.out.printf("El valor convertido es: %.2f\n", resultado);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la conversión: " + e.getMessage());
        }
    }

    // Método para verificar si una cadena es un número válido
    private boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena); // Intentar convertir a entero
            return true;
        } catch (NumberFormatException e) {
            return false; // No es un número
        }
    }
}

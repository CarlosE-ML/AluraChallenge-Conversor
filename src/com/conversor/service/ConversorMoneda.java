package com.conversor.service;

import com.conversor.api.ClienteApi;

public class ConversorMoneda {
    private final ClienteApi clienteApi = new ClienteApi();

    public double convertir(int opcion, double valor) throws Exception {
        String monedaOrigen, monedaDestino;

        switch (opcion) {
            case 1:
                monedaOrigen = "USD";
                monedaDestino = "PEN";
                break;
            case 2:
                monedaOrigen = "PEN";
                monedaDestino = "USD";
                break;
            case 3:
                monedaOrigen = "USD";
                monedaDestino = "BRL";
                break;
            case 4:
                monedaOrigen = "BRL";
                monedaDestino = "USD";
                break;
            case 5:
                monedaOrigen = "USD";
                monedaDestino = "ARS";
                break;
            case 6:
                monedaOrigen = "ARS";
                monedaDestino = "USD";
                break;
            default:
                throw new IllegalArgumentException("Opción no válida");
        }

        return clienteApi.obtenerTasaConversion(monedaOrigen, monedaDestino) * valor;
    }
}

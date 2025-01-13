package com.conversor.api;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClienteApi {
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/5421d89480e184e71964a730/pair/";
    private final Gson gson = new Gson();

    public double obtenerTasaConversion(String monedaOrigen, String monedaDestino) throws Exception {
        String urlCompleta = URL_API + monedaOrigen + "/" + monedaDestino;
        URL url = new URL(urlCompleta);

        // Conexión HTTP
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        // Verificar el código de respuesta
        int codigoRespuesta = conexion.getResponseCode();
        if (codigoRespuesta == 200) {
            // Leer la respuesta
            BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder respuesta = new StringBuilder();
            String linea;

            while ((linea = lector.readLine()) != null) {
                respuesta.append(linea);
            }
            lector.close();

            // Procesar JSON con Gson
            RespuestaApi respuestaApi = gson.fromJson(respuesta.toString(), RespuestaApi.class);

            System.out.println("Resultado: " + respuestaApi.result); // Para verificar valores
            System.out.println("Conversion Rate: " + respuestaApi.conversion_rate);

            // Validar el resultado y retornar la tasa de conversión
            if ("success".equalsIgnoreCase(respuestaApi.result)) {
                return respuestaApi.conversion_rate;
            } else {
                throw new Exception("Error en la API: " + respuestaApi.result);
            }
        } else {
            throw new Exception("Error al conectarse a la API. Código de respuesta: " + codigoRespuesta);
        }
    }

    // Clase interna para mapear la respuesta de la API
    private static class RespuestaApi {
        String result;
        double conversion_rate;
    }
}

package com.mycompany.prueba7_calculadora;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Historial {

    public static void guardarOperacion(String usuario, String operacion, double resultado) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(usuario + "_historial.txt", true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaActual = dateFormat.format(new Date());

            writer.println(fechaActual + " - Operación: " + operacion + " - Resultado: " + resultado);
        } catch (FileNotFoundException e) {
            System.out.println("Error al encontrar el archivo");
        } catch (IOException e) {
            System.out.println("Error al escribir en el historial.");
                    }
    }

    public static void mostrarHistorial(String usuario) {
        try (BufferedReader reader = new BufferedReader(new FileReader(usuario + "_historial.txt"))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El historial de operaciones esta vacío.");

        } catch (IOException e) {
            System.out.println("Error al leer el historial.");
        }
    }
}

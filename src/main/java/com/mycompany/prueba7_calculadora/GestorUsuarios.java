package com.mycompany.prueba7_calculadora;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class GestorUsuarios {
    private static final String FILE_PATH = "credenciales.json";
    private static Map<String, String> credenciales = cargarCredenciales();

    private static Map<String, String> cargarCredenciales() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            return new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            return new HashMap<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    private static void guardarCredenciales() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(credenciales, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registrarUsuario(String usuario, String contrasena) {
        credenciales.put(usuario, contrasena);
        System.out.println("Usuario registrado con éxito.");
        guardarCredenciales();
    }

    public static boolean iniciarSesion(String usuario, String contrasena) {
        if (credenciales.containsKey(usuario) && credenciales.get(usuario).equals(contrasena)) {
            return true;
        } else {
            System.out.println("Los datos de inicio de sesión no son correctos. Vuelve a intentarlo.");
            return false;
        }
    }
}
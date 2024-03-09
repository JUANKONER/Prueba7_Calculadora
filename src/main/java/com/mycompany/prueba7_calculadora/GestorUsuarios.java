package com.mycompany.prueba7_calculadora;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GestorUsuarios {
    private static Map<String, String> credenciales = new HashMap<>();

    public static void registrarUsuario(String usuario, String contrasena) {
        credenciales.put(usuario, contrasena);
        System.out.println("Usuario registrado con éxito.");
        guardarEnArchivo();
    }

    public static boolean iniciarSesion(String usuario, String contrasena) {
        return credenciales.containsKey(usuario) && credenciales.get(usuario).equals(contrasena);
    }

    private static void guardarEnArchivo() {
        try (FileWriter writer = new FileWriter("credenciales.txt")) {
            for (Map.Entry<String, String> entry : credenciales.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

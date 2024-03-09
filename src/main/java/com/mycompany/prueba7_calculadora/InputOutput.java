package com.mycompany.prueba7_calculadora;
import java.util.Scanner;

public class InputOutput {
private static Scanner scanner = new Scanner(System.in);

    public InputOutput() {
        scanner = new Scanner(System.in);
    }

    public static int leerEntero() {
        int numero = 0;
        boolean entradaCorrecta = false;
        do {
            try {
                String entrada = scanner.nextLine();
                numero = Integer.parseInt(entrada);
                entradaCorrecta = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número entero válido.");
            }
        } while (!entradaCorrecta);
        return numero;
    }

    public static String leerString() {

        return scanner.nextLine();
    }
    
     public static Double leerDouble(){

        while (true) {

            if (scanner.hasNextDouble()) {
                Double numero = scanner.nextDouble();
                scanner.nextLine();
                return numero;
            }else{
                System.out.print("Tienes que introducir un numero valido: ");
                scanner.nextLine();
            }
        }
    }
    

    public void cerrarScanner() {
        scanner.close();

    }
}

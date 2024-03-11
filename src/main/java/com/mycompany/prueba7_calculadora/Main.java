package com.mycompany.prueba7_calculadora;

public class Main {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        boolean sesionIniciada = false;
        String usuarioLogin = "";

        do {
            System.out.print("¿Es un usuario nuevo? (si o no)");
            String eleccion = InputOutput.leerString();
            if (eleccion.toLowerCase().equals("si") || eleccion.toLowerCase().equals("s")) {
                System.out.print("Ingrese su nombre de usuario para registrarse: ");
                String usuario = InputOutput.leerString();
                System.out.print("Ingrese su contraseña: ");
                String contraseña = InputOutput.leerString();
                GestorUsuarios.registrarUsuario(usuario, contraseña);
            }

            System.out.print("Ingrese su nombre de usuario para iniciar sesión: ");
            usuarioLogin = InputOutput.leerString();
            System.out.print("Ingrese su contraseña para iniciar sesión: ");
            String contraseñaLogin = InputOutput.leerString();
            sesionIniciada = GestorUsuarios.iniciarSesion(usuarioLogin, contraseñaLogin);

            if (!sesionIniciada) {
                System.out.println("Los datos de inicio de sesión no son correctos. Vuelve a intentarlo.");
            }

        } while (!sesionIniciada);

        int opcion;

        do {
            System.out.println("\n------------------");
            System.out.print("Bienvenido al menú de la calculadora");
            System.out.println("\n       MENU");
            System.out.println("------------------");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Raiz cuadrada");
            System.out.println("6. Potencia");
            System.out.println("7. Historial de operaciones");
            System.out.println("8. Salir");
            System.out.println("------------------");
            System.out.print("Ingrese la opción que desea realizar: ");
            opcion = InputOutput.leerEntero();

            switch (opcion) {
                case 1:
                    double resultadoSuma = calculadora.sumar();
                    Historial.guardarOperacion(usuarioLogin, "suma", resultadoSuma);
                    break;
                case 2:
                    double resultadoResta = calculadora.restar();
                    Historial.guardarOperacion(usuarioLogin, "resta", resultadoResta);
                    break;
                case 3:
                    double resultadoMultiplicacion = calculadora.multiplicar();
                    Historial.guardarOperacion(usuarioLogin, "multiplicacion", resultadoMultiplicacion);
                    break;
                case 4:
                    double resultadoDivision = calculadora.dividir();
                    Historial.guardarOperacion(usuarioLogin, "division", resultadoDivision);
                    break;
                case 5:
                    double resultadoRaizCuadrada = calculadora.raizCuadrada();
                    Historial.guardarOperacion(usuarioLogin, "raiz cuadrada", resultadoRaizCuadrada);
                    break;
                case 6:
                    double resultadoPotencia = calculadora.potencia();
                    Historial.guardarOperacion(usuarioLogin, "potencia", resultadoPotencia);
                    break;
                case 7:
                    Historial.mostrarHistorial(usuarioLogin);
                    break;
                case 8:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Opción no válida. Vuelve a intentarlo.");
                    break;
            }
        } while (opcion != 8);
    }
}

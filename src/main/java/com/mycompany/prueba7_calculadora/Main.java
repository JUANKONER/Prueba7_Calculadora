
package com.mycompany.prueba7_calculadora;


public class Main {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        
        System.out.print("¿Es un usuario nuevo?(si o no)");
        String eleccion = InputOutput.leerString();
        if(eleccion.toLowerCase().equals("si")){
            System.out.print("Ingrese su nombre de usuario: ");
            String usuario = InputOutput.leerString();
            System.out.print("Ingrese su contraseña: ");
            String contraseña = InputOutput.leerString();
            GestorUsuarios.registrarUsuario(usuario, contraseña);
        }
        System.out.print("Ingrese su nombre de usuario para iniciar sesion: ");
        String usuarioLogin = InputOutput.leerString();
        System.out.print("Ingrese su contraseña para iniciar sesion: ");
        String contraseñaLogin = InputOutput.leerString();
        if(GestorUsuarios.iniciarSesion(usuarioLogin, contraseñaLogin)){
            System.out.print("Se ha iniciado sesión");
        }else{
            System.out.print("Introduzca un usuario valido");
        }
        int opcion;
        
        
        do{
            System.out.print("Bienvenido al menu de la calculadora");
            System.out.println("       MENU");
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
        System.out.print("Ingrese la opcion que desea realizar: ");
        opcion = InputOutput.leerEntero();
        
        switch(opcion){
            case 1 -> {
                double resultadoSuma = calculadora.sumar();
                Historial.guardarOperacion(usuarioLogin, "suma", resultadoSuma);
                }
            case 2 -> {
                double resultadoResta = calculadora.restar();
                Historial.guardarOperacion(usuarioLogin, "resta", resultadoResta);
                }
               case 3 -> {
                   double resultadoMultiplicacion = calculadora.multiplicar();
                   Historial.guardarOperacion(usuarioLogin, "multiplicacion", resultadoMultiplicacion);
                }
            case 4 -> {
                double resultadoDivision = calculadora.dividir();
                Historial.guardarOperacion(usuarioLogin, "division", resultadoDivision);
                }
            case 5 -> {
                double resultadoRaizCuadrada = calculadora.raizCuadrada();
                Historial.guardarOperacion(usuarioLogin, "raiz cuadrada", resultadoRaizCuadrada);
                }
            case 6 -> {
                double resultadoPotencia = calculadora.potencia();
                Historial.guardarOperacion(usuarioLogin, "potencia", resultadoPotencia);
                }
            case 7 -> Historial.mostrarHistorial(usuarioLogin);
            case 8 -> System.out.print("Saliendo del menu");
            }
        }while(opcion != 8);
    }
}

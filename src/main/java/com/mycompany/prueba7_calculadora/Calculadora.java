package com.mycompany.prueba7_calculadora;
import java.io.*;

public class Calculadora {
    
    public int sumar(){
        System.out.print("Ingrese el primer numero: ");
        int num1 = InputOutput.leerEntero();
        System.out.print("Ingrese el segundo numero: ");
        int num2 = InputOutput.leerEntero();
        int resultado = num1 + num2;
        System.out.print("El resultado de la suma es " + resultado);
        return resultado;
    }
    public int restar(){
        System.out.print("Ingrese el primer numero: ");
        int num1 = InputOutput.leerEntero();
        System.out.print("Ingrese el segundo numero: ");
        int num2 = InputOutput.leerEntero();
        int resultado = num1 - num2;
        System.out.print("El resultado de la resta es " + resultado);
        return resultado;
    }
    public double multiplicar(){
        System.out.print("Ingrese el primer numero: ");
        double num1 = InputOutput.leerDouble();
        System.out.print("Ingrese el segundo numero: ");
        double num2 = InputOutput.leerDouble();
        double resultado = num1 * num2;
        System.out.print("El resultado de la multiplicación es " +  resultado);
        return resultado;
    }
    public double dividir(){
        double resultado=0;
        try{
            System.out.print("Ingrese el primer numero: ");
            double num1 = InputOutput.leerDouble();
            System.out.print("Ingrese el segundo numero: ");
            double num2 = InputOutput.leerDouble();
            resultado = num1 / num2;
            System.out.print("El resultado de la division es " + resultado);
            
        }catch(ArithmeticException e){
            System.out.print("No se puede dividir entre 0");
        }catch(Exception e){
            System.out.print("Ha ocurrido un error");
        }
        return resultado;
    }
    public double raizCuadrada(){
        double resultado = 0;
        try{
            System.out.print("Ingrese el primer numero: ");
            double num1 = InputOutput.leerDouble();
            resultado = Math.sqrt(num1);
            System.out.print("El resultado de la raiz cuadrada es " + resultado);
        }catch(ArithmeticException e){
            System.out.print("No se puede hacer la raíz cuadrada de un número negativo");
        }catch(Exception e){
            System.out.print("Ha ocurrido un error");
        }
        return resultado;
    }
    public double potencia(){
        System.out.print("Ingrese el numero de la base de la potencia: ");
        double num1 = InputOutput.leerDouble();
        System.out.print("Ingrese el exponente");
        double num2 = InputOutput.leerDouble();
        double resultado = Math.pow(num1, num2);
        System.out.print("El resultado de la potencia es " + resultado);
        return resultado;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inverso.java;

/**
 *
 * @author fredd
 */
public class Inverso {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Debe ingresar un número natural.");
            return;
        }

        int numero = Integer.parseInt(args[0]);
        int inverso = invertir(numero, 0);

        System.out.println(numero + " → " + inverso);
    }

    // Método recursivo con acumulador
    public static int invertir(int numero, int acumulado) {
        if (numero == 0) {
            return acumulado;
        }
        int residuo = numero % 10;
        int cociente = numero / 10;
        return invertir(cociente, acumulado * 10 + residuo);
    }
}

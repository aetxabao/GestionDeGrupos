package com.masanz.io;
import java.util.Scanner;

public class Entrada {

    public static int leerEntero(String txt, int min, int max) {
        Scanner teclado = new Scanner(System.in);
        int v = -1;
        while (v < min || v > max) {
            System.out.printf("%s [%d-%d]: ", txt, min, max);
            v = teclado.nextInt();
        }
        teclado.nextLine();
        return v;
    }

    public static int leerEnteroPositivo(String txt) {
        Scanner teclado = new Scanner(System.in);
        int v = -1;
        while (v < 0) {
            System.out.printf("%s: ", txt);
            v = teclado.nextInt();
        }
        teclado.nextLine();
        return v;
    }

    public static int leerDefaultEnteroPositivo(String txt, int def) {
        Scanner teclado = new Scanner(System.in);
        System.out.printf("%s (%s): ", txt, def);
        String s = teclado.nextLine();
        if (s.trim().length()>0) {
            int v =  Integer.parseInt(s);
            if (v >= 0) {
                return v;
            }
        }
        return def;
    }

    public static String leerString(String txt) {
        Scanner teclado = new Scanner(System.in);
        String s = "";
        while (s.trim().length()==0) {
            System.out.printf("%s: ", txt);
            s = teclado.nextLine();
        }
        return s;
    }

    public static String leerDefaultString(String txt, String def) {
        Scanner teclado = new Scanner(System.in);
        System.out.printf("%s (%s): ", txt, def);
        String s = teclado.nextLine();
        if (s.trim().length()==0) {
            return def;
        }else{
            return s;
        }
    }

    public static boolean leerConfirmacion(String txt) {
        Scanner teclado = new Scanner(System.in);
        String s = "";
        System.out.printf("%s [S/n]: ", txt);
        s = teclado.nextLine();
        return !s.toUpperCase().startsWith("N");
    }

    public static boolean leerConfirmacionPositiva(String txt) {
        Scanner teclado = new Scanner(System.in);
        String s = "";
        System.out.printf("%s [s/N]: ", txt);
        s = teclado.nextLine();
        return s.toUpperCase().startsWith("S");
    }

}
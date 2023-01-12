package com.masanz.menus;

import com.masanz.logic.GestorDeGrupos;
import com.masanz.io.Entrada;
import com.masanz.io.Salida;

public class MenuPrincipal {

    private final int M_PR_TERMINAR = 0;
    private final int M_PR_GRUPOS = 1;
    private final int M_PR_PERSONAS = 2;
    private final int N = 2;

    private GestorDeGrupos gdg;


    public static void main(String[] args) {
        new MenuPrincipal(new GestorDeGrupos()).run();
    }

    public MenuPrincipal(GestorDeGrupos gdg) {
        this.gdg = gdg;
    }

    public void run() {
        Salida.menuPrincipal();
        int opc = Entrada.leerEntero("Opción", 0, N);
        while (opc != M_PR_TERMINAR) {
            switch (opc) {
                case M_PR_GRUPOS:
                    operacionesGrupos();
                    break;
                case M_PR_PERSONAS:
                    operacionesPersonas();
                    break;
                default:
            }
            Salida.menuPrincipal();
            opc = Entrada.leerEntero("Opción", 0, N);
        }
    }

    private void operacionesGrupos() {
        new MenuGrupos(gdg).run();
    }

    private void operacionesPersonas() {
        new MenuPersonas(gdg).run();
    }

}
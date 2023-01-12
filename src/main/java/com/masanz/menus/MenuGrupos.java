package com.masanz.menus;

import com.masanz.logic.GestorDeGrupos;
import com.masanz.logic.Grupo;
import com.masanz.logic.Persona;
import com.masanz.io.Entrada;
import com.masanz.io.Salida;

public class MenuGrupos {

    private final int M_GR_TERMINAR = 0;
    private final int M_GR_LST_GRUPO = 1;
    private final int M_GR_LST_APELLIDOS = 2;
    private final int M_GR_LST_PUNTOS = 3;
    private final int M_GR_LST_SUSPENS = 4;
    private final int M_GR_PINTAR = 5;
    private final int N = 5;

    private GestorDeGrupos gdg;

    public static void main(String[] args) {
        MenuGrupos menu = new MenuGrupos(new GestorDeGrupos());
        menu.run();
    }

    public MenuGrupos(GestorDeGrupos gdg) {
        this.gdg = gdg;
    }

    public void run() {
        Salida.menuGrupos();
        int opc = Entrada.leerEntero("Opción", 0, N);
        while (opc != M_GR_TERMINAR) {
            switch (opc) {
                case M_GR_LST_GRUPO:
                    grupos();
                    break;
                case M_GR_LST_APELLIDOS:
                    personasPorApellido();
                    break;
                case M_GR_LST_PUNTOS:
                    personasPorPuntos();
                    break;
                case M_GR_LST_SUSPENS:
                    suspendidos();
                    break;
                case M_GR_PINTAR:
                    pintarSitios();
                    break;
                default:
            }
            Salida.menuGrupos();
            opc = Entrada.leerEntero("Opción", 0, N);
        }
    }

    private void grupos() {
        Salida.titGrListadoDeGrupos();
        Grupo[] grupos = gdg.getGrupos();
        Salida.listarGrupos(grupos);
    }

    private void personasPorApellido() {
        Salida.titGrPersonasPorApellido();
        String grupo = Entrada.leerString("Nombre del grupo");
        Grupo g = gdg.getGrupo(grupo);
        Persona[] personas = gdg.getPersonasPorApellido(grupo);
        Salida.listarPersonas(personas);
    }

    private void personasPorPuntos() {
        Salida.titGrPersonasDeUnGrupoPorPuntos();
        String grupo = Entrada.leerString("Nombre del grupo");
        Persona[] personas = gdg.getPersonasPorPuntos(grupo);
        Salida.listarPersonas(personas);
    }

    private void suspendidos() {
        Salida.titGrListadoSuspendidos();
        String grupo = Entrada.leerString("Nombre del grupo");
        Persona[] personas = gdg.getPersonasSuspendidas(grupo);
        Salida.listarPersonas(personas);
    }

    private void pintarSitios() {
        Salida.titGrPintarSitios();
        String grupo = Entrada.leerString("Nombre del grupo");
        Persona[][] personas = gdg.getPersonasSitios(grupo);
        Salida.pintar(personas);
    }

}

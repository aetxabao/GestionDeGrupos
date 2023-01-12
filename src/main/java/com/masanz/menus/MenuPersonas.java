package com.masanz.menus;

import com.masanz.logic.GestorDeGrupos;
import com.masanz.logic.Grupo;
import com.masanz.logic.Persona;
import com.masanz.io.Entrada;
import com.masanz.io.Salida;

public class MenuPersonas {

    private final int M_PE_TERMINAR = 0;
    private final int M_PE_CREAR = 1;
    private final int M_PE_BUSCAR = 2;
    private final int M_PE_ACTUALIZAR = 3;
    private final int M_PE_BORRAR = 4;
    private final int M_PE_LISTAR = 5;
    private final int N = 5;

    private GestorDeGrupos gdg;

    public static void main(String[] args) {
        MenuPersonas menu = new MenuPersonas(new GestorDeGrupos());
        menu.run();
    }

    public MenuPersonas(GestorDeGrupos gdg) {
        this.gdg = gdg;
    }

    public void run() {
        Salida.menuPersonas();
        int opc = Entrada.leerEntero("Opción", 0, N);
        while (opc != M_PE_TERMINAR) {
            switch (opc) {
                case M_PE_CREAR:
                    crear();
                    break;
                case M_PE_BUSCAR:
                    buscar();
                    break;
                case M_PE_ACTUALIZAR:
                    actualizar();
                    break;
                case M_PE_BORRAR:
                    borrar();
                    break;
                case M_PE_LISTAR:
                    listar();
                    break;
                default:
            }
            Salida.menuPersonas();
            opc = Entrada.leerEntero("Opción", 0, N);
        }
    }

    private void crear() {
        Salida.titPeNuevaPersona();
        String nombreGrupo = Entrada.leerString("Grupo");
        Grupo grupo = gdg.getGrupo(nombreGrupo);
        if (grupo==null) {
            Salida.warning("El grupo no existe.");
            return;
        }
        String nombre = Entrada.leerString("Nombre");
        String apellidos = Entrada.leerString("Apellidos");
        String siglas = Entrada.leerString("Siglas");
        int puntos = Entrada.leerEnteroPositivo("Puntos");
        int fila = Entrada.leerEnteroPositivo("Fila");
        int columna = Entrada.leerEnteroPositivo("Columna");
        Persona persona = new Persona(nombre, apellidos, siglas, puntos, fila, columna);
        if (grupo.add(persona)) {
            Salida.info("Persona agregada.");
        }else{
            Salida.warning("No se ha podido agregar la persona.");
        }
    }

    private void buscar() {
        Salida.titPeBuscarPorApellido();
        String nombreGrupo = Entrada.leerString("Grupo");
        Grupo grupo = gdg.getGrupo(nombreGrupo);
        if (grupo==null) {
            Salida.warning("El grupo no existe.");
            return;
        }
        String apellidos = Entrada.leerString("Apellidos");
        Persona[] personas = grupo.find(apellidos);
//        int idx = grupo.numeroPrimer(apellidos);
        int idx = grupo.numeroPrimer(apellidos);
        Salida.listarPersonas(personas, idx);
    }

    private void actualizar() {
        Salida.titPeModificarDatos();
        String nombreGrupo = Entrada.leerString("Grupo");
        Grupo grupo = gdg.getGrupo(nombreGrupo);
        if (grupo==null) {
            Salida.warning("El grupo no existe.");
            return;
        }
        int idx = Entrada.leerEnteroPositivo("Número de la persona");
        if (idx > grupo.getTamano()){
            Salida.warning("El tamaño del grupo es menor.");
            return;
        }
        Persona p = grupo.getPersonasPorApellidos()[idx-1];

        String nombre = Entrada.leerDefaultString("Nombre", p.getNombre());
        String apellidos = Entrada.leerDefaultString("Apellidos", p.getApellidos());
        String siglas = Entrada.leerDefaultString("Siglas", p.getSiglas());
        int puntos = Entrada.leerDefaultEnteroPositivo("Puntos", p.getPuntos());
        int fila = Entrada.leerDefaultEnteroPositivo("Fila", p.getPosicion().getFila());
        int columna = Entrada.leerDefaultEnteroPositivo("Columna", p.getPosicion().getColumna());

        if (p.actualizar(nombre, apellidos, siglas, puntos, fila, columna)) {
            Salida.info("Persona actualizada.");
        }else{
            Salida.warning("No se ha podido actualizar la persona.");
        }
    }

    private void borrar() {
        Salida.titPeBorrarPersonaDeUnGrupo();
        String nombreGrupo = Entrada.leerString("Grupo");
        Grupo grupo = gdg.getGrupo(nombreGrupo);
        if (grupo==null) {
            Salida.warning("El grupo no existe.");
            return;
        }
        int idx = Entrada.leerEnteroPositivo("Número de la persona");
        if (idx > grupo.getTamano()){
            Salida.warning("El tamaño del grupo es menor.");
            return;
        }
        Persona p = grupo.getPersona(idx);
        Salida.info(p.toString());
        if (Entrada.leerConfirmacionPositiva("Seguro que desea borrar")) {
            if (grupo.del(idx)) {
                Salida.info("Persona borrada.");
            }else{
                Salida.warning("No se ha podido borrar la persona.");
            }
        }
    }

    private void listar() {
        Salida.titPeListarPersonasDeUnGrupo();
        String nombreGrupo = Entrada.leerString("Grupo");
        Grupo grupo = gdg.getGrupo(nombreGrupo);
        if (grupo==null) {
            Salida.warning("El grupo no existe.");
            return;
        }
        Salida.listarPersonas(grupo.getPersonasPorApellidos());
    }

}

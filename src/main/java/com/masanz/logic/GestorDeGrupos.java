package com.masanz.logic;

import com.masanz.io.Salida;

public class GestorDeGrupos {

    private int MAX = 10;
    private Grupo[] grupos;
    private int numero;

    public GestorDeGrupos() {
        grupos = new Grupo[MAX];
        numero = 0;
        cargarGrupos();
        cargarPersonas();
    }

    public Grupo getGrupo(String nombre) {
        int idx = getIndiceGrupo(nombre);
        if (idx<0) {
            return null;
        }
        return grupos[idx];
    }

    public Grupo[] getGrupos() {
        Grupo[] g = new Grupo[numero];
        System.arraycopy(grupos,0, g,0, numero);
        return g;
    }

    public int getNumeroGrupos() {
        return numero;
    }

    /**
     * En el futuro los grupos se cargarán de un fichero y más adelante de una base de datos
     */
    private void cargarGrupos() {
        grupos = new Grupo[]{
                new Grupo("DAW1", 5, 7),
                new Grupo("DAM1", 5, 9),
                new Grupo("OTRO", 5, 9),
                null,null,null,null,null,null,null
        };
        numero = 3;
    }

    /**
     * En el futuro las personas se cargarán de un fichero y más adelante de una base de datos.
     */
    private void cargarPersonas() {
        Persona[] personasDAW1 = {
                new Persona("Reggi", "Attarge", "RA", 28, 1, 4),
                new Persona("Janis", "Belward", "JB", 44, 1, 1),
                new Persona("Fancie", "Canter", "FC", 76, 2, 1),
                new Persona("Aileen", "Coulbeck", "AC", 55, 2, 4),
                new Persona("Gardener", "Crabbe", "GC", 20, 3, 6),
                new Persona("Dollie", "Dottridge", "DD", 75, 4, 2),
                new Persona("Tait", "Embury", "TE", 15, 4, 4),
                new Persona("Barbette", "Fallows", "BF", 12, 1, 2),
                new Persona("Tristan", "García", "TG", 63, 4, 0),
                new Persona("Berenice", "Grandison", "BG", 43, 2, 6),
                new Persona("Cornelia", "Kensit", "CK", 8, 3, 4),
                new Persona("Mahmud", "McCahill", "MM", 89, 1, 0),
                new Persona("Myca", "Ojeda", "MO", 56, 4, 5),
                new Persona("Augie", "Poulgreen", "AP", 80, 4, 6),
                new Persona("Marlo", "Quainton", "MQ", 13, 1, 6),
                new Persona("Elva", "Rosen", "ER", 68, 3, 0),
                new Persona("Evvy", "Seago", "ES", 99, 2, 0),
                new Persona("Astrid", "Towner", "AT", 29, 2, 2),
                new Persona("Nadeen", "Urrey", "NU", 0, 3, 2),
                null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null
        };
        grupos[0].setPersonasTamano(personasDAW1,19);
        Persona[] personasDAM1 = {
            new Persona("Ignace", "Adamov", "IA", 72, 2, 1),
            new Persona("Gwenette", "Adderley", "GA", 97, 2, 4),
            new Persona("Sabrina", "Boncore", "SB", 52, 3, 0),
            new Persona("Bunni", "Bullan", "BB", 96, 1, 6),
            new Persona("Rebbecca", "Burstow", "RB", 80, 2, 7),
            new Persona("Thoma", "Crallan", "TC", 56, 1, 0),
            new Persona("Toby", "Crosen", "TC", 73, 1, 8),
            new Persona("Wilhelmina", "Danbi", "WD", 100, 4, 8),
            new Persona("Shana", "Dobel", "SD", 69, 4, 6),
            new Persona("Tore", "Dutch", "TD", 1, 3, 4),
            new Persona("Roslyn", "Gluyus", "RG", 82, 4, 4),
            new Persona("Vilma", "Kertess", "VK", 95, 4, 3),
            new Persona("Ethelred", "Kinnar", "EK", 89, 3, 1),
            new Persona("Brana", "Langstaff", "BL", 30, 3, 7),
            new Persona("Domeniga", "Matzke", "DM", 93, 2, 6),
            new Persona("Arnaldo", "Monger", "AM", 99, 3, 6),
            new Persona("Al", "Niblo", "AN", 53, 2, 0),
            new Persona("Claudianus", "O'Calleran", "CO", 58,4,7),
            new Persona("Adelaide", "Primrose", "AP", 10, 2, 8),
            new Persona("Merrilee", "Simonich", "MS", 16, 1, 7),
            new Persona("Jefferson", "Stevenson", "JS", 96, 3, 8),
            new Persona("Jacqui", "Thody", "JT", 34, 1, 4),
            new Persona("Barn", "Tongue", "BT", 23, 1, 3),
            null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null
        };
        grupos[1].setPersonasTamano(personasDAM1,23);
    }

    private void add(String grupo, Persona persona) {
        int i = getIndiceGrupo(grupo);
        if (i>=0 && i<MAX) {
            if (!grupos[i].add(persona)) {
                Salida.warning("Problema al insertar la persona: " + persona);
            }
        }
    }

    private int getIndiceGrupo(String grupo) {
        for (int i = 0; i < numero; i++) {
            if (grupos[i].getNombre().equals(grupo)) {
                return i;
            }
        }
        return -1;
    }

    public Persona[] getPersonas(String grupo) {
        int i = getIndiceGrupo(grupo);
        if (i<0 || i>=MAX) {
            return null;
        }
        return grupos[i].getPersonasPorApellidos();
    }

    public Persona[] getPersonasPorApellido(String grupo) {
        Grupo g = getGrupo(grupo);
        return g.getPersonasPorApellidos();
    }

    public Persona[] getPersonasPorPuntos(String grupo) {
        Grupo g = getGrupo(grupo);
        return g.getPersonasOrdenadasPorPuntos();
    }

    public Persona[] getPersonasSuspendidas(String grupo) {
        Grupo g = getGrupo(grupo);
        return g.getPersonasSuspendidas();
    }

    public Persona[][] getPersonasSitios(String grupo) {
        //TODO: getPersonasSitios
        return null;
    }

}

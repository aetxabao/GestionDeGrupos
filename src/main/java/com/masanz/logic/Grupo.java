package com.masanz.logic;

public class Grupo {

    private String nombre;
    private Persona[] personas;
    private int tamano;
    private int filas;
    private int columnas;

    public Grupo(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        personas = new Persona[filas*columnas];
        tamano = 0;
    }

    /**
     * Este método no tiene sentido en la lógica de la aplicación.
     * Se ha incorporado para ayudar a debuguear los métodos.
     * Hay que tener en cuenta que las personas deberan estar metidas
     * de forma ascendente en base a los apellidos y el nombre en el array.
     * @param personas Array de de personas ordenado, puede tener nulls al final.
     * @param tamano Cantidad de personas que se deben considerar.
     */
    public Grupo setPersonasTamano(Persona[] personas, int tamano) {
        this.personas = personas;
        this.tamano = tamano;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

//    public boolean add(Persona persona) {
//        //Esto no mete a la persona de forma ordenada, puntúa cero.
//        if (tamano < personas.length) {
//            personas[tamano++] = persona;
//            return true;
//        }
//        return false;
//    }

//    public boolean add(Persona persona) {
//        //TODO: add
//        if (tamano < personas.length) {
//            int idx = busquedaDicotomica(persona.getApellidosNombre());
//            if (persona.equals(personas[idx])){
//                return false;
//            }
//            personas[tamano] = persona;
//            for(int i=tamano;i>0;i--) {
//                if (personas[i].getApellidos().compareTo(personas[i-1].getApellidos())<0) {
//                    personas[i] = personas[i-1];
//                    personas[i-1] = persona;
//                }else if (personas[i].getApellidos().compareTo(personas[i-1].getApellidos())==0 &&
//                        personas[i].getNombre().compareTo(personas[i-1].getNombre())<0 ) {
//                    personas[i] = personas[i - 1];
//                    personas[i - 1] = persona;
//                }else {
//                    break;
//                }
//            }
//            tamano++;
//            return true;
//        }
//        return false;
//    }

    public boolean add(Persona persona) {
        //TODO: add
        if (tamano == personas.length) return false;
        int pos = busquedaDicotomica(persona.getApellidosNombre());
        if (pos < tamano && personas[pos].getApellidosNombre().equals(persona.getApellidosNombre())) {
            return false;
        }
        tamano++;
        for (int i = tamano-1; i > pos; i--) {
            personas[i] = personas[i-1];
        }
        personas[pos] = persona;
        return true;
    }

    public int getCuantosSuspendidosHay(){
        //TODO: getCuantosSuspendidosHay
        int n = 0;
        for (int i = 0; i < tamano; i++) {
            if (personas[i].getPuntos() < 50) {
                n++;
            }
        }
        return n;
    }

    public Persona[] getPersonasPorApellidos() {
        //TODO: getPersonasPorApellidos
        Persona[] a = new Persona[tamano];
        System.arraycopy(personas,0,a, 0, tamano);
        return a;
    }

    /**
     * Algoritmo de inserción directa de una persona p en un array a que ya tiene t personas.
     * @param a array de personas, de longitud n.
     * @param t numero de personas ya insertadas, t>=0 y t<=n-1
     * @param p persona a insertar con una cantidad de puntos
     */
//    public static void insercionDirectaPorPuntosCreciente(Persona[] a, int t,  Persona p) {
//        //TODO: insercionDirectaPorPuntosCreciente
//        if (t==0){
//            a[0] = p;
//        } else if (t==1) {
//            a[1] = p;
//            if (a[0].getPuntos()>a[1].getPuntos()){
//                a[1] = a[0];
//                a[0] = p;
//            }
//        }else {
//            int j = t - 1;
//            while (j >= 0 && a[j].getPuntos() > p.getPuntos()){
//                a[j + 1] = a[j];
//                j--;
//            }
//            a[j + 1] = p;
//        }
//    }
    public static void insercionDirectaPorPuntosCreciente(Persona[] a, int t,  Persona p) {
        //TODO: insercionDirectaPorPuntosCreciente
        int pos = t;
        while (pos > 0 && a[pos - 1].getPuntos() > p.getPuntos()) {
            a[pos] = a[pos - 1];
            pos--;
        }
        a[pos] = p;
    }

    public Persona[] getPersonasSuspendidas() {
        //TODO: getPersonasSuspendidas
        int n = getCuantosSuspendidosHay();
        Persona[] a = new Persona[n];
        int t = 0;
        for (int i = 0; i<tamano && t<n; i++) {
            if (personas[i].getPuntos() < 50) {
                Persona p = personas[i];
                insercionDirectaPorPuntosCreciente(a, t, p);
                t++;
            }
        }
        return a;
    }

    /**
     * Ordena un array de personas utilizando el algoritmo de ordenación por selección directa
     * de puntos de forma descendente.
     * @param a array de personas, todas las celdas tienen una referencia a un objeto persona
     *          distinto de null. Al final estarán ordenados por la puntuación de más a menos.
     */
    public static void ordenacionPorSeleccionDirectaDePuntosDescendente(Persona[] a) {
        //TODO: ordenacionPorSeleccionDirectaDePuntosDescendente
        for (int i = 0; i < a.length - 1; i++) {
            int posmax = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].getPuntos() > a[posmax].getPuntos()) {
                    posmax = j;
                }
            }
            Persona aux = a[posmax];
            a[posmax] = a[i];
            a[i] = aux;
        }
    }

    public Persona[] getPersonasOrdenadasPorPuntos() {
        Persona[] a = new Persona[tamano];
        System.arraycopy(personas,0,a,0,tamano);
        ordenacionPorSeleccionDirectaDePuntosDescendente(a);
        return a;
    }

    /**
     * Devuelve el índice, de 0 a tamano, de la posición que le corresponde a un texto
     * en la ordenación alfabética de apellidos y nombre si se fuese a insertar.
     * Si el texto coicide con getApellidosNombre se debe devolver esa posición.
     * Aunque en el array se considere que hay tamano personas, de 0 a tamano-1,
     * si alfabéticamente le correspondiese después del último, se debería devolver
     * el valor tamano, no tamano-1.
     * @param txt texto cuyo indice de inserción se busca, ej "García, Aiora"
     * @return posición del array en la que se insertaría
     */
//    public int busquedaDicotomica(String txt) {
//        //TODO: busquedaDicotomica
//        int izquierda = 0;
//        int derecha = tamano - 1;
//        int mitad;
//        String apellidosNombre;
//        while ( izquierda < derecha ) {
//            mitad = (izquierda + derecha) / 2;
//            apellidosNombre = personas[mitad].getApellidosNombre();
//            if (apellidosNombre.compareTo(txt)<0) {
//                izquierda = mitad + 1;
//            } else if (apellidosNombre.compareTo(txt)==0) {
//                return mitad;
//            } else {
//                derecha = mitad - 1;
//            }
//        }
//        if (tamano>0 && personas[izquierda].getApellidosNombre().compareTo(txt)<0) {
//            izquierda++;
//        }
//        return izquierda;
//    }
    public int busquedaDicotomica(String txt) {
        //TODO: busquedaDicotomica
        int izquierda = 0;
        int derecha = tamano - 1;
        int mitad;
        while (izquierda <= derecha) {
            mitad = (izquierda + derecha) / 2;
            if (personas[mitad].getApellidosNombre().compareToIgnoreCase(txt) == 0) {
                return mitad;
            }
            else if (personas[mitad].getApellidosNombre().compareTo(txt) > 0) {
                derecha = mitad - 1;
            }
            else {
                izquierda = mitad + 1;
            }
        }
        return izquierda;
    }


    /**
     * Devuelve un array de personas cuyos apellidos empiezan como se indica
     * @param apellidos texto por el cual deben empezar los apellidos
     * @return una array con las referencias a las personas, puede ser de tamaño 0.
     */
//    public Persona[] find(String apellidos) {
//        //TODO: find
//        int idx = busquedaDicotomica(apellidos);
//        int n = 0;
//        for (int i = idx; i < tamano; i++) {
//            if (personas[i].getApellidos().startsWith(apellidos)){
//                n++;
//            }else{
//                break;
//            }
//        }
//        Persona[] res = new Persona[n];
//        int j = 0;
//        for (int i = idx; i < tamano && j < n; i++) {
//            if (personas[i].getApellidos().startsWith(apellidos)){
//                res[j++] = personas[i];
//            }
//        }
//        return res;
//    }
    public Persona[] find(String apellidos) {
        //TODO: find
        int n = 0;
        int pos =  busquedaDicotomica(apellidos);
        for (int i = pos; i < tamano; i++) {
            if(personas[i].getApellidosNombre().startsWith(apellidos)){
                n++;
            }
        }
        Persona[] res = new Persona[n];
        System.arraycopy(personas, pos, res, 0, n);
        return res;
    }

    public int numeroPrimer(String apellidos) {
        return busquedaDicotomica(apellidos) + 1;
    }

    /**
     * Devuelve la persona según el índice alfabético mostrado
     * @param idx indice válido del 1 en adelante hasta tamaño incluido
     * @return persona o null si no existe
     */
    public Persona getPersona(int idx) {
        //TODO: getPersona
        if (idx<1 || idx>tamano) {
            return null;
        }
        return personas[idx-1];
    }

    /**
     * Borra una persona del grupo eliminandolo del array y dejandolo ordenado y seguido con el tamano reducido
     * @param idx indice válido del 1 en adelante hasta tamaño incluido
     */
//    public boolean del(int idx) {
//        //TODO: del
//        for (int i = idx-1; i < tamano-1; i++) {
//            personas[i] = personas[i+1];
//        }
//        personas[tamano-1] = null;
//        tamano--;
//        return true;
//    }
    public boolean del(int idx) {
        //TODO: del
        System.arraycopy(personas, idx, personas, idx - 1, tamano - idx);
        tamano--;
        return true;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre:\"" + nombre + "\"" +
                ", tamano:" + tamano +
                ", filas:" + filas +
                ", columnas:" + columnas +
                '}';
    }

}

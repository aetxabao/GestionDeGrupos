package com.masanz.logic;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GrupoTest {

    @Test
    @Order(1)
    void getCuantosSuspendidosHay() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        int n;
        n = gdg.getGrupo("DAW1").getCuantosSuspendidosHay();
        assertEquals(n,10,"DAW1 tiene inicialmente 10 suspensos.");
        n = gdg.getGrupo("DAM1").getCuantosSuspendidosHay();
        assertEquals(n,6,"DAW1 tiene inicialmente 6 suspensos.");
        n = gdg.getGrupo("OTRO").getCuantosSuspendidosHay();
        assertEquals(n,0,"OTRO tiene inicialmente 0 suspensos.");
    }

    @Test
    @Order(2)
    void getPersonasPorApellidosDAW1() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAW1";
        String siglas = "RAJBFCACGCDDTEBFTGBGCKMMMOAPMQERESATNU";
        Grupo g = gdg.getGrupo(nombre);
        StringBuilder sb = new StringBuilder();
        for (Persona p : g.getPersonasPorApellidos()){
            sb.append(p.getSiglas());
        }
        assertEquals(siglas,sb.toString(),"Comprueba " + nombre);
    }

    @Test
    @Order(3)
    void getPersonasPorApellidosDAM1() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAM1";
        String siglas = "IAGASBBBRBTCTCWDSDTDRGVKEKBLDMAMANCOAPMSJSJTBT";
        Grupo g = gdg.getGrupo(nombre);
        StringBuilder sb = new StringBuilder();
        for (Persona p : g.getPersonasPorApellidos()){
            sb.append(p.getSiglas());
        }
        assertEquals(siglas,sb.toString(),"Comprueba " + nombre);
    }

    @Test
    @Order(4)
    void insercionDirectaPorPuntosCreciente1() {
        String nombre;
        Persona[] a = new Persona[10];
        int t = 0;
        //Aihen, Aitzol, Aiert, Aiora, Aimar, Aitor
        Persona p1 = new Persona("Aimar","García", "AG1", 80, 0, 1);
        Persona p2 = new Persona("Aitzol","García", "AG2", 40, 0, 2);
        Persona p3 = new Persona("Aiert","García", "AG3", 50, 0, 3);
        Persona p4 = new Persona("Aitor","García", "AG4", 90, 0, 4);
        Persona p5 = new Persona("Aiora","García", "AG5", 70, 0, 5);
        Persona p6 = new Persona("Aihen","García", "AG6", 30, 0, 6);

        assertEquals(null, a[0], "Comprobación inicial null");

        Grupo.insercionDirectaPorPuntosCreciente(a,t,p1);
        t++;
        nombre = "Aimar";
        assertEquals(nombre, a[0].getNombre(), "Comprueba tras insertar p1 " + nombre);
        assertEquals(null, a[1], "Comprueba tras insertar p1 null");

        Grupo.insercionDirectaPorPuntosCreciente(a,t,p2);
        t++;
        nombre = "Aitzol";
        assertEquals(nombre, a[0].getNombre(), "Comprueba tras insertar p2 " + nombre);
        nombre = "Aimar";
        assertEquals(nombre, a[1].getNombre(), "Comprueba tras insertar p2 " + nombre);
        assertEquals(null, a[2], "Comprueba tras insertar p2 null");

        Grupo.insercionDirectaPorPuntosCreciente(a,t,p3);
        t++;
        nombre = "Aitzol";
        assertEquals(nombre, a[0].getNombre(), "Comprueba tras insertar p3 " + nombre);
        nombre = "Aiert";
        assertEquals(nombre, a[1].getNombre(), "Comprueba tras insertar p3 " + nombre);
        nombre = "Aimar";
        assertEquals(nombre, a[2].getNombre(), "Comprueba tras insertar p3 " + nombre);
        assertEquals(null, a[3], "Comprueba tras insertar p3 null");

        Grupo.insercionDirectaPorPuntosCreciente(a,t,p4);
        t++;
        nombre = "Aitzol";
        assertEquals(nombre, a[0].getNombre(), "Comprueba tras insertar p4 " + nombre);
        nombre = "Aiert";
        assertEquals(nombre, a[1].getNombre(), "Comprueba tras insertar p4 " + nombre);
        nombre = "Aimar";
        assertEquals(nombre, a[2].getNombre(), "Comprueba tras insertar p4 " + nombre);
        nombre = "Aitor";
        assertEquals(nombre, a[3].getNombre(), "Comprueba tras insertar p4 " + nombre);
        assertEquals(null, a[4], "Comprueba tras insertar p4 null");

        Grupo.insercionDirectaPorPuntosCreciente(a,t,p5);
        t++;
        nombre = "Aitzol";
        assertEquals(nombre, a[0].getNombre(), "Comprueba tras insertar p5 " + nombre);
        nombre = "Aiert";
        assertEquals(nombre, a[1].getNombre(), "Comprueba tras insertar p5 " + nombre);
        nombre = "Aiora";
        assertEquals(nombre, a[2].getNombre(), "Comprueba tras insertar p5 " + nombre);
        nombre = "Aimar";
        assertEquals(nombre, a[3].getNombre(), "Comprueba tras insertar p5 " + nombre);
        nombre = "Aitor";
        assertEquals(nombre, a[4].getNombre(), "Comprueba tras insertar p5 " + nombre);
        assertEquals(null, a[5], "Comprueba tras insertar p5 null");

        Grupo.insercionDirectaPorPuntosCreciente(a,t,p6);
        t++;
        nombre = "Aihen";
        assertEquals(nombre, a[0].getNombre(), "Comprueba tras insertar p6 " + nombre);
        nombre = "Aitzol";
        assertEquals(nombre, a[1].getNombre(), "Comprueba tras insertar p6 " + nombre);
        nombre = "Aiert";
        assertEquals(nombre, a[2].getNombre(), "Comprueba tras insertar p6 " + nombre);
        nombre = "Aiora";
        assertEquals(nombre, a[3].getNombre(), "Comprueba tras insertar p6 " + nombre);
        nombre = "Aimar";
        assertEquals(nombre, a[4].getNombre(), "Comprueba tras insertar p6 " + nombre);
        nombre = "Aitor";
        assertEquals(nombre, a[5].getNombre(), "Comprueba tras insertar p6 " + nombre);
        assertEquals(null, a[6], "Comprueba tras insertar p6 null");
    }

    @Test
    @Order(5)
    void insercionDirectaPorPuntosCreciente2() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAW1";
        Persona[] a = new Persona[100];
        int t = gdg.getGrupo(nombre).getTamano();
        System.arraycopy(gdg.getPersonasPorPuntos(nombre),0,a,0,t);
        //Aihen, Aitzol, Aiert, Aiora, Aimar, Aitor
        Persona[] ps = {
                new Persona("Aimar","García", "AG1", 80, 0, 1),
                new Persona("Aitzol","García", "AG2", 40, 0, 2),
                new Persona("Aiert","García", "AG3", 50, 0, 3),
                new Persona("Aitor","García", "AG4", 90, 0, 4),
                new Persona("Aiora","García", "AG5", 70, 0, 5),
                new Persona("Aihen","García", "AG6", 30, 0, 6)
        };
        for(Persona p : ps) {
            Grupo.insercionDirectaPorPuntosCreciente(a,t++,p);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(a[i].getSiglas()).append(a[i].getPuntos());
        }
        //AG6 30, AG2 40, AG3 50, AG5 70, AG1 80, AG4 90
        String result = "NU0CK8BF12MQ13TE15GC20RA28AT29AG630AG240BG43JB44AG350AC55MO56TG63ER68AG570DD75FC76AP80AG180MM89AG490ES99";
        assertEquals(result, sb.toString(), "Compruebalo");
    }

    @Test
    @Order(6)
    void insercionDirectaPorPuntosCreciente3() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAM1";
        Persona[] a = new Persona[100];
        int t = gdg.getGrupo(nombre).getTamano();
        System.arraycopy(gdg.getPersonasPorPuntos(nombre),0,a,0,t);
        //Aihen, Aitzol, Aiert, Aiora, Aimar, Aitor
        Persona[] ps = {
                new Persona("Aimar","García", "AG1", 80, 0, 1),
                new Persona("Aitzol","García", "AG2", 40, 0, 2),
                new Persona("Aiert","García", "AG3", 50, 0, 3),
                new Persona("Aitor","García", "AG4", 90, 0, 4),
                new Persona("Aiora","García", "AG5", 70, 0, 5),
                new Persona("Aihen","García", "AG6", 29, 0, 6)
        };
        for(Persona p : ps) {
            Grupo.insercionDirectaPorPuntosCreciente(a,t++,p);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(a[i].getSiglas()).append(a[i].getPuntos());
        }
        //AG6 30, AG2 40, AG3 50, AG5 70, AG1 80, AG4 90
        String result = "TD1AP10MS16BT23AG629BL30JT34AG240AG350SB52AN53TC56CO58SD69AG570IA72TC73RB80AG180RG82EK89AG490DM93VK95BB96JS96GA97AM99WD100";
        assertEquals(result, sb.toString(), "Compruebalo");
    }


    @Test
    @Order(7)
    void getPersonasSuspendidasDAW1() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAW1";
        String siglas = "NUCKBFMQTEGCRAATBGJB";
        Grupo g = gdg.getGrupo(nombre);
        StringBuilder sb = new StringBuilder();
        for (Persona p : g.getPersonasSuspendidas()) {
            sb.append(p.getSiglas());
        }
        assertEquals(siglas, sb.toString(),"Comprueba " + nombre);
    }

    @Test
    @Order(8)
    void getPersonasSuspendidasDAM1() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAM1";
        String siglas = "TDAPMSBTBLJT";
        Grupo g = gdg.getGrupo(nombre);
        StringBuilder sb = new StringBuilder();
        for (Persona p : g.getPersonasSuspendidas()) {
            sb.append(p.getSiglas());
        }
        assertEquals(siglas, sb.toString(),"Comprueba " + nombre);
    }

    @Test
    @Order(9)
    void ordenacionPorSeleccionDirectaDePuntosDescendente1() {
        String nombre;
        Persona[] a = new Persona[6];
        //Aihen, Aitzol, Aiert, Aiora, Aimar, Aitor
        a[0] = new Persona("Aimar","García", "AG1", 80, 0, 1);
        a[1] = new Persona("Aitzol","García", "AG2", 40, 0, 2);
        a[2] = new Persona("Aiert","García", "AG3", 50, 0, 3);
        a[3] = new Persona("Aitor","García", "AG4", 90, 0, 4);
        a[4] = new Persona("Aiora","García", "AG5", 70, 0, 5);
        a[5] = new Persona("Aihen","García", "AG6", 30, 0, 6);

        Grupo.ordenacionPorSeleccionDirectaDePuntosDescendente(a);
        nombre = "Aihen";
        assertEquals(nombre, a[5].getNombre(), "Comprueba");
        nombre = "Aitzol";
        assertEquals(nombre, a[4].getNombre(), "Comprueba");
        nombre = "Aiert";
        assertEquals(nombre, a[3].getNombre(), "Comprueba");
        nombre = "Aiora";
        assertEquals(nombre, a[2].getNombre(), "Comprueba");
        nombre = "Aimar";
        assertEquals(nombre, a[1].getNombre(), "Comprueba");
        nombre = "Aitor";
        assertEquals(nombre, a[0].getNombre(), "Comprueba");
    }

    @Test
    @Order(10)
    void ordenacionPorSeleccionDirectaDePuntosDescendente2() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAW1";
        int t = gdg.getGrupo(nombre).getTamano();
        Persona[] a = new Persona[t+6];
        System.arraycopy(gdg.getPersonasPorApellido(nombre),0,a,0,t);
        //Aihen, Aitzol, Aiert, Aiora, Aimar, Aitor
        a[t+0] = new Persona("Aimar","García", "AG1", 80, 0, 1);
        a[t+1] = new Persona("Aitzol","García", "AG2", 40, 0, 2);
        a[t+2] = new Persona("Aiert","García", "AG3", 50, 0, 3);
        a[t+3] = new Persona("Aitor","García", "AG4", 90, 0, 4);
        a[t+4] = new Persona("Aiora","García", "AG5", 70, 0, 5);
        a[t+5] = new Persona("Aihen","García", "AG6", 30, 0, 6);

        Grupo.ordenacionPorSeleccionDirectaDePuntosDescendente(a);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t+6; i++) {
            sb.append(a[i].getSiglas()).append(a[i].getPuntos());
        }
        //AG4 90, AG1 80, AG5 70, AG3 50, AG2 40, AG6 30
        String result = "ES99AG490MM89AP80AG180FC76DD75AG570ER68TG63MO56AC55AG350JB44BG43AG240AG630AT29RA28GC20TE15MQ13BF12CK8NU0";
        assertEquals(result, sb.toString(), "Compruebalo");
    }

    @Test
    @Order(11)
    void ordenacionPorSeleccionDirectaDePuntosDescendente3() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAM1";
        int t = gdg.getGrupo(nombre).getTamano();
        Persona[] a = new Persona[t+6];
        System.arraycopy(gdg.getPersonasPorApellido(nombre),0,a,0,t);
        //Aihen, Aitzol, Aiert, Aiora, Aimar, Aitor
        a[t+0] = new Persona("Aimar","García", "AG1", 80, 0, 1);
        a[t+1] = new Persona("Aitzol","García", "AG2", 40, 0, 2);
        a[t+2] = new Persona("Aiert","García", "AG3", 50, 0, 3);
        a[t+3] = new Persona("Aitor","García", "AG4", 90, 0, 4);
        a[t+4] = new Persona("Aiora","García", "AG5", 70, 0, 5);
        a[t+5] = new Persona("Aihen","García", "AG6", 29, 0, 6);

        Grupo.ordenacionPorSeleccionDirectaDePuntosDescendente(a);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t+6; i++) {
            sb.append(a[i].getSiglas()).append(a[i].getPuntos());
        }
        //AG4 90, AG1 80, AG5 70, AG3 50, AG2 40, AG6 29
        String result = "WD100AM99GA97BB96JS96VK95DM93AG490EK89RG82RB80AG180TC73IA72AG570SD69CO58TC56AN53SB52AG350AG240JT34BL30AG629BT23MS16AP10TD1";
        assertEquals(result, sb.toString(), "Compruebalo");
    }

    @Test
    @Order(12)
    void busquedaDicotomica1() {
        int n;
        Grupo g = new Grupo("OTRO", 4, 3);
        Persona[] personas = {
                new Persona("Aiert","García", "AG3", 50, 2, 0),
                new Persona("Aihen","García", "AG6", 30, 3, 2),
                new Persona("Aimar","García", "AG1", 80, 1, 0),
                new Persona("Aiora","García", "AG5", 70, 3, 0),
                new Persona("Aitor","García", "AG4", 90, 2, 2),
                new Persona("Aitzol","García", "AG2", 40, 1, 2)
        };
        g.setPersonasTamano(personas, 6);
        n = g.busquedaDicotomica("A");
        assertEquals(0, n, "Un apellido A iría al principio.");
        n = g.busquedaDicotomica("García, A");
        assertEquals(0, n, "Un nombre A.");
        n = g.busquedaDicotomica("García, Aiert");
        assertEquals(0, n, "Un nombre Aiert.");
        n = g.busquedaDicotomica("García, Aig");
        assertEquals(1, n, "Un nombre Aig.");
        n = g.busquedaDicotomica("García, Aimare");
        assertEquals(3, n, "Un nombre Aimare.");
        n = g.busquedaDicotomica("García, Aio");
        assertEquals(3, n, "Un nombre Aio.");
        n = g.busquedaDicotomica("García, Aiora");
        assertEquals(3, n, "Un nombre Aiora.");
        n = g.busquedaDicotomica("García, Aitzol");
        assertEquals(5, n, "Un nombre Aitzol.");
        n = g.busquedaDicotomica("García, Aitzole");
        assertEquals(6, n, "Un nombre Aitzole.");
        n = g.busquedaDicotomica("Z");
        assertEquals(6, n, "Un apellido que empiece por Z iría al final.");
    }

    @Test
    @Order(13)
    void busquedaDicotomica2() {
        int n;
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAW1";
        Grupo g = gdg.getGrupo(nombre);
        n = g.busquedaDicotomica("Atta");
        assertEquals(0, n, "Test 1");
        n = g.busquedaDicotomica("Bata");
        assertEquals(1, n, "Test 2");
        n = g.busquedaDicotomica("Bela");
        assertEquals(1, n, "Test 3");
        n = g.busquedaDicotomica("Belz");
        assertEquals(2, n, "Test 4");
        n = g.busquedaDicotomica("Garc");
        assertEquals(8, n, "Test 5");
        n = g.busquedaDicotomica("Urre");
        assertEquals(18, n, "Test 6");
        n = g.busquedaDicotomica("Urro");
        assertEquals(19, n, "Test 7");
        n = g.busquedaDicotomica("Zara");
        assertEquals(19, n, "Test 8");
    }

    @Test
    @Order(14)
    void find1() {
        StringBuilder sb = new StringBuilder();
        int n;
        Grupo g1 = new Grupo("OTRO1", 4, 3);
        Persona[] personas = {
                new Persona("Aiert","García", "AG3", 50, 2, 0),
                new Persona("Aihen","García", "AG6", 30, 3, 2),
                new Persona("Aimar","García", "AG1", 80, 1, 0),
                new Persona("Aiora","García", "AG5", 70, 3, 0),
                new Persona("Aitor","García", "AG4", 90, 2, 2),
                new Persona("Aitzol","García", "AG2", 40, 1, 2)
        };
        g1.setPersonasTamano(personas, 6);
        for (int i = 0; i < 6; i++) {
            sb.append(personas[i].getSiglas()).append(personas[i].getPuntos());
        }
        String s1 = sb.toString();

        Persona[] res = g1.find("Garc");

        sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(res[i].getSiglas()).append(res[i].getPuntos());
        }
        String s2 = sb.toString();

        assertEquals(s1, s2, "Los mismos.");
    }

    @Test
    @Order(15)
    void find2() {
        int n;
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAW1";
        Grupo g = gdg.getGrupo(nombre);

        Persona[] res = g.find("C");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i].getSiglas()).append(res[i].getPuntos());
        }
        String s = sb.toString();

        assertEquals("FC76AC55GC20", s, "Apellido empieza por C.");
    }

    @Test
    @Order(16)
    void find3() {
        int n;
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAW1";
        Grupo g = gdg.getGrupo(nombre);

        Persona[] res = g.find("G");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i].getSiglas()).append(res[i].getPuntos());
        }
        String s = sb.toString();

        assertEquals("TG63BG43", s, "Apellido empieza por G.");
    }

    @Test
    @Order(17)
    void find4() {
        int n;
        GestorDeGrupos gdg = new GestorDeGrupos();
        String nombre = "DAW1";
        Grupo g = gdg.getGrupo(nombre);

        Persona[] res = g.find("I");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i].getSiglas()).append(res[i].getPuntos());
        }
        String s = sb.toString();

        assertEquals("", s, "Apellido empieza por I.");
    }

    @Test
    @Order(18)
    void getPersona() {
        Persona p;
        Grupo g = new Grupo("OTRO1", 4, 3);
        Persona[] personas = {
                new Persona("Aiert","García", "AG3", 50, 2, 0),
                new Persona("Aihen","García", "AG6", 30, 3, 2),
                new Persona("Aimar","García", "AG1", 80, 1, 0),
                new Persona("Aiora","García", "AG5", 70, 3, 0),
                new Persona("Aitor","García", "AG4", 90, 2, 2),
                new Persona("Aitzol","García", "AG2", 40, 1, 2),
                null, null, null, null
        };
        g.setPersonasTamano(personas, 6);
        p = g.getPersona(0);
        assertEquals(p, null, "Test 1");
        p = g.getPersona(1);
        assertEquals("Aiert", p.getNombre(), "Test 2");
        p = g.getPersona(6);
        assertEquals("Aitzol", p.getNombre(), "Test 3");
        p = g.getPersona(7);
        assertEquals(p, null, "Test 4");
    }

    @Test
    @Order(19)
    void del1() {
        boolean b = true;
        Grupo g = new Grupo("OTRO", 4, 3);
        Persona[] personas = {
                new Persona("Aiert","García", "AG3", 50, 2, 0),
                new Persona("Aihen","García", "AG6", 30, 3, 2),
                new Persona("Aimar","García", "AG1", 80, 1, 0),
                new Persona("Aiora","García", "AG5", 70, 3, 0),
                new Persona("Aitor","García", "AG4", 90, 2, 2),
                new Persona("Aitzol","García", "AG2", 40, 1, 2),
                null, null, null, null
        };
        g.setPersonasTamano(personas, 6);
        b = b && g.del(1);
        b = b && g.del(1);
        b = b && g.del(3);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= g.getTamano(); i++) {
            sb.append(g.getPersona(i).getSiglas());
        }
        String s = sb.toString();

        assertEquals("AG1AG5AG2", s, "Borrados 3.");
    }

    @Test
    @Order(20)
    void del2() {
        boolean b = true;
        Grupo g = new Grupo("OTRO", 4, 3);
        Persona[] personas = {
                new Persona("Aiert","García", "AG3", 50, 2, 0),
                new Persona("Aihen","García", "AG6", 30, 3, 2),
                new Persona("Aimar","García", "AG1", 80, 1, 0),
                new Persona("Aiora","García", "AG5", 70, 3, 0),
                new Persona("Aitor","García", "AG4", 90, 2, 2),
                new Persona("Aitzol","García", "AG2", 40, 1, 2),
                null, null, null, null
        };
        g.setPersonasTamano(personas, 6);
        b = b && g.del(6);
        b = b && g.del(1);
        b = b && g.del(2);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= g.getTamano(); i++) {
            sb.append(g.getPersona(i).getSiglas());
        }
        String s = sb.toString();

        assertEquals("AG6AG5AG4", s, "Borrados 3.");
    }

    @Test
    @Order(21)
    void del3() {
        boolean b = true;
        Grupo g = new Grupo("OTRO", 4, 3);
        Persona[] personas = {
                new Persona("Aiert","García", "AG3", 50, 2, 0),
                new Persona("Aihen","García", "AG6", 30, 3, 2),
                new Persona("Aimar","García", "AG1", 80, 1, 0),
                new Persona("Aiora","García", "AG5", 70, 3, 0),
                new Persona("Aitor","García", "AG4", 90, 2, 2),
                new Persona("Aitzol","García", "AG2", 40, 1, 2),
                null, null, null, null
        };
        g.setPersonasTamano(personas, 6);
        for (int i = 6; i >= 1; i--) {
            b = b && g.del(1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= g.getTamano(); i++) {
            sb.append(g.getPersona(i).getSiglas());
        }
        String s = sb.toString();

        assertEquals("", s, "Borrados todos.");
    }

    @Test
    @Order(22)
    void add1() {
        Grupo g = new Grupo("OTRO", 4, 3);
        Persona[] personas = {
                new Persona("Aihen","García", "AG6", 30, 3, 2),
                new Persona("Aitzol","García", "AG2", 40, 1, 2),
                new Persona("Aiert","García", "AG3", 50, 2, 0),
                new Persona("Aiora","García", "AG5", 70, 3, 0),
                new Persona("Aimar","García", "AG1", 80, 1, 0),
                new Persona("Aitor","García", "AG4", 90, 2, 2)
        };
        String[] iniciales = { "AG6" , "AG6AG2", "AG3AG6AG2", "AG3AG6AG5AG2", "AG3AG6AG1AG5AG2", "AG3AG6AG1AG5AG4AG2"};
        for (int i = 0; i < personas.length; i++) {
            g.add(personas[i]);
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= g.getTamano(); j++) {
                sb.append(g.getPersona(j).getSiglas());
            }
            String s = sb.toString();
            assertEquals(iniciales[i], s, "Add " + personas[i].getNombre());
        }
    }

    @Test
    @Order(23)
    void add2() {
        Grupo g = new Grupo("OTRO", 4, 3);
        Persona[] personas = {
                new Persona("Aimar","García", "AG3", 80, 1, 0),
                new Persona("Aihen","García", "AG2", 30, 3, 2),
                new Persona("Aiert","García", "AG1", 50, 2, 0),
                new Persona("Aiora","García", "AG4", 70, 3, 0),
                new Persona("Aitor","García", "AG5", 90, 2, 2),
                new Persona("Aitzol","García", "AG6", 40, 1, 2)
        };
        String[] iniciales = { "AG3" , "AG2AG3", "AG1AG2AG3", "AG1AG2AG3AG4", "AG1AG2AG3AG4AG5", "AG1AG2AG3AG4AG5AG6"};
        for (int i = 0; i < personas.length; i++) {
            g.add(personas[i]);
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= g.getTamano(); j++) {
                sb.append(g.getPersona(j).getSiglas());
            }
            String s = sb.toString();
            assertEquals(iniciales[i], s, "Add " + personas[i].getNombre());
        }
    }

    @Test
    @Order(24)
    void add3() {
        Grupo g = new Grupo("OTRO", 4, 3);
        Persona[] personas = {
                new Persona("Aiert","García", "AG1", 50, 2, 0),
                new Persona("Aiert","García", "AG1", 50, 2, 0),
                new Persona("Aihen","García", "AG2", 30, 3, 2),
                new Persona("Aihen","García", "AG2", 30, 3, 2),
        };
        for (int i = 0; i < personas.length; i++) {
            g.add(personas[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= g.getTamano(); j++) {
            sb.append(g.getPersona(j).getSiglas());
        }
        String s = sb.toString();
        assertEquals("AG1AG2", s, "Add 2 repes ");
    }

}
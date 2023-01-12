package com.masanz.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorDeGruposTest {

    @Test
    void getPersonasSitios() {
        GestorDeGrupos gdg = new GestorDeGrupos();
        Persona[][] personas = gdg.getPersonasSitios("DAW1");
        Grupo g = gdg.getGrupo("DAW1");
        for (int i = 0; i < g.getColumnas(); i++) {
            assertEquals(null, personas[0][i],"La fila 0 está vacía.");
        }
        assertEquals("MM", personas[1][0].getSiglas(),"Fíjate en los sitios pintados.");
        assertEquals("TG", personas[4][0].getSiglas(),"Fíjate en los sitios pintados.");
        assertEquals("BF", personas[1][2].getSiglas(),"Fíjate en los sitios pintados.");
        assertEquals(null, personas[1][3],"Fíjate en los sitios pintados.");
        assertEquals(null, personas[4][3],"Fíjate en los sitios pintados.");
        assertEquals("TE", personas[4][4].getSiglas(),"Fíjate en los sitios pintados.");
        assertEquals("MO", personas[4][5].getSiglas(),"Fíjate en los sitios pintados.");
        assertEquals("AP", personas[4][6].getSiglas(),"Fíjate en los sitios pintados.");
        assertEquals("MQ", personas[1][6].getSiglas(),"Fíjate en los sitios pintados.");
    }

}
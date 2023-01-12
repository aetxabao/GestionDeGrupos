package com.masanz.io;

import com.masanz.logic.GestorDeGrupos;
import com.masanz.logic.Grupo;
import com.masanz.logic.Persona;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SalidaTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


    @Test
    @Order(1)
    void listarGrupos() {
        int i = 0;
        String[] a = {
                "    1. DAW1 (19)",
                "    2. DAM1 (23)",
                "    3. OTRO (0)"
        };
        Grupo[] grupos = {
                new Grupo("DAW1", 0,0).setPersonasTamano(null, 19),
                new Grupo("DAM1", 0,0).setPersonasTamano(null, 23),
                new Grupo("OTRO", 0,0),
        };
        Salida.listarGrupos(grupos);
        Scanner sc = new Scanner(outputStreamCaptor.toString());
        sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
        while (sc.hasNext()) {
            assertEquals(a[i++].trim(),sc.next().trim(),"Debe coincidir exactamente.");
        }
    }

    @Test
    @Order(2)
    void listarPersonas1() {
        int i = 0;
        String[] a = {
                "    1. Attarge, Reggi (RA,1,4): 28" ,
                "    2. Belward, Janis (JB,1,1): 44" ,
                "    3. Canter, Fancie (FC,2,1): 76" ,
                "    4. Coulbeck, Aileen (AC,2,4): 55" ,
                "    5. Crabbe, Gardener (GC,3,6): 20" ,
                "    6. Dottridge, Dollie (DD,4,2): 75" ,
                "    7. Embury, Tait (TE,4,4): 15" ,
                "    8. Fallows, Barbette (BF,1,2): 12" ,
                "    9. García, Tristan (TG,4,0): 63" ,
                "   10. Grandison, Berenice (BG,2,6): 43" ,
                "   11. Kensit, Cornelia (CK,3,4): 8" ,
                "   12. McCahill, Mahmud (MM,1,0): 89" ,
                "   13. Ojeda, Myca (MO,4,5): 56" ,
                "   14. Poulgreen, Augie (AP,4,6): 80" ,
                "   15. Quainton, Marlo (MQ,1,6): 13" ,
                "   16. Rosen, Elva (ER,3,0): 68" ,
                "   17. Seago, Evvy (ES,2,0): 99" ,
                "   18. Towner, Astrid (AT,2,2): 29" ,
                "   19. Urrey, Nadeen (NU,3,2): 0"
        };

        Persona[] personas = {
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
            new Persona("Nadeen", "Urrey", "NU", 0, 3, 2)
        };
        Salida.listarPersonas(personas);
        Scanner sc = new Scanner(outputStreamCaptor.toString());
        sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
        while (sc.hasNext()) {
            assertEquals(a[i++].trim(),sc.next().trim(),"Debe coincidir exactamente.");
        }
    }

    @Test
    @Order(3)
    void listarPersonas2() {
        int i = 0;
        String[] a = {
                "    3. Canter, Fancie (FC,2,1): 76" ,
                "    4. Coulbeck, Aileen (AC,2,4): 55" ,
                "    5. Crabbe, Gardener (GC,3,6): 20"
        };

        Persona[] personas = {
                new Persona("Fancie", "Canter", "FC", 76, 2, 1),
                new Persona("Aileen", "Coulbeck", "AC", 55, 2, 4),
                new Persona("Gardener", "Crabbe", "GC", 20, 3, 6)
        };
        Salida.listarPersonas(personas, 3);
        Scanner sc = new Scanner(outputStreamCaptor.toString());
        sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
        while (sc.hasNext()) {
            assertEquals(a[i++].trim(),sc.next().trim(),"Debe coincidir exactamente.");
        }
    }

    @Test
    @Order(4)
    void pintar1() {
        int i = 0;
        String[] a = {
                "TG      DD      TE  MO  AP  " ,
                "ER      NU      CK      GC  " ,
                "ES  FC  AT      AC      BG  " ,
                "MM  JB  BF      RA      MQ  " ,
                "                            "
        };
        Persona[][] sitios = {
                {null, null, null, null, null, null, null},
                {
                        new Persona("Mahmud", "McCahill", "MM", 89, 1, 0),
                        new Persona("Janis", "Belward", "JB", 44, 1, 1),
                        new Persona("Barbette", "Fallows", "BF", 12, 1, 2),
                        null,
                        new Persona("Reggi", "Attarge", "RA", 28, 1, 4),
                        null,
                        new Persona("Marlo", "Quainton", "MQ", 13, 1, 6),
                },
                {
                        new Persona("Evvy", "Seago", "ES", 99, 2, 0),
                        new Persona("Fancie", "Canter", "FC", 76, 2, 1),
                        new Persona("Astrid", "Towner", "AT", 29, 2, 2),
                        null,
                        new Persona("Aileen", "Coulbeck", "AC", 55, 2, 4),
                        null,
                        new Persona("Berenice", "Grandison", "BG", 43, 2, 6)
                },
                {
                        new Persona("Elva", "Rosen", "ER", 68, 3, 0),
                        null,
                        new Persona("Nadeen", "Urrey", "NU", 0, 3, 2),
                        null,
                        new Persona("Cornelia", "Kensit", "CK", 8, 3, 4),
                        null,
                        new Persona("Gardener", "Crabbe", "GC", 20, 3, 6)
                },
                {
                        new Persona("Tristan", "García", "TG", 63, 4, 0),
                        null,
                        new Persona("Dollie", "Dottridge", "DD", 75, 4, 2),
                        null,
                        new Persona("Tait", "Embury", "TE", 15, 4, 4),
                        new Persona("Myca", "Ojeda", "MO", 56, 4, 5),
                        new Persona("Augie", "Poulgreen", "AP", 80, 4, 6),
                },
        };
        Salida.pintar(sitios);
        Scanner sc = new Scanner(outputStreamCaptor.toString());
        sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
        while (sc.hasNext()) {
            assertEquals(a[i++].trim(),sc.next().trim(),"Debe coincidir exactamente.");
        }
    }

    @Test
    @Order(5)
    void pintar2() {
        int i = 0;
        String[] a = {
                "            VK  RG      SD  CO  WD  " ,
                "SB  EK          TD      AM  BL  JS  " ,
                "AN  IA          GA      DM  RB  AP  " ,
                "TC          BT  JT      BB  MS  TC  " ,
                "                                    "
        };
        Salida.pintar(new GestorDeGrupos().getPersonasSitios("DAM1"));
        Scanner sc = new Scanner(outputStreamCaptor.toString());
        sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
        while (sc.hasNext()) {
            assertEquals(a[i++].trim(),sc.next().trim(),"Depende de getPersonasSitios.");
        }
    }
}

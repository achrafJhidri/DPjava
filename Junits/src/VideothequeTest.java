import org.junit.*;

import static org.junit.Assert.*;

public class VideothequeTest {

    public static Videotheque videotheque;
    public static Client client ;

    @BeforeClass
    public static void setUpBeforeClass() {
        videotheque = new Videotheque();
        client=new Client("Achraf",videotheque);
        System.out.println("videotheque crée");
    }


    @AfterClass
    public static void tearDownAfterClass()  {
        System.out.println("videotheque supprimée");
    }

    @Before
    public void setUp()   {
        System.out.println("avant chaque");
        videotheque.addClient("achraf");
        videotheque.addDVD("çukur");
    }

    @After
    public void tearDown()   {
        System.out.println("après chaque");
        videotheque.clean();
    }

    @Test
    public void addClient() {
        assertTrue("ajout d'un 2ème client avec le même nom", videotheque.addClient("achraf"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getClientBorneNegative() throws IllegalArgumentException {
        videotheque.getClient(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getClientBorneSupSize() throws IllegalArgumentException {
        videotheque.getClient(1);
    }

    @Test
    public void getClient() {
        assertEquals("test récup premier client", "achraf", videotheque.getClient(0).toString());
    }

    @Test
    public void sizeClient() {
        assertEquals("taille de la liste après ajout d'un seul client", 1, videotheque.sizeClient());
    }

    @Test
    public void indexOfClient() {
        assertEquals("le client n'existe pas", -1, videotheque.indexOfClient("mmm"));
        assertEquals("le client existe", 0, videotheque.indexOfClient("achraf"));
    }

    @Test
    public void addDVD() {
        assertFalse("nom dvd invalide", videotheque.addDVD(null));
        assertFalse("nom dvd invalide", videotheque.addDVD(""));
        assertFalse("dvd déja dans la base", videotheque.addDVD("çukur"));
        assertTrue("another new dvd", videotheque.addDVD("çukureda"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDVDBorneNegative() {
        videotheque.getDVD(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDVDBorneSupSize() {
        videotheque.getDVD(1);
    }

    @Test
    public void getDVD() {
        assertEquals("çukur", videotheque.getDVD(0).toString());
    }
   @Test
    public void sizeDVD() {
        assertEquals("vérification taille dvd avec 1 seul element",1,videotheque.sizeDVD());
    }

    @Test
    public void indexOfDVD() {
        assertEquals("nom dvd null",-1,videotheque.indexOfDVD(null));
        assertEquals("nom dvd vide",-1,videotheque.indexOfDVD(""));
        assertEquals("nom dvd non enrgistré dans la videotheque",-1,videotheque.indexOfDVD("mmmmm"));
        assertEquals("nom dvd existant",0,videotheque.indexOfDVD("çukur"));
    }

    @Test(expected = NullPointerException.class)
    public void getDVDEmpruntéClientNull() {
        videotheque.getDVDEmprunté(null);
    }
    @Test
    public void getDVDEmprunté() {
        videotheque.getDVDEmprunté(client);
    }
/*
    @Test
    public void vérifieReservations() {
    }

    @Test
    public void annuleReservation() {
    }*/
}
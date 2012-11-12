import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class _JuegoTest {
    Juego juego = new Juego();

    @Test
    public void moverAlEste() throws Exception {
        juego.adicionarCamino(1, 2, "ESTE");
        juego.ponerJugadorEnCaverna(1);

        juego.mover("ESTE");

        assertEquals(2, juego.cavernaDelJugador());
    }

    @Test
    public void moverAlNorte() throws Exception {
        juego.adicionarCamino(2, 3, "NORTE");
        juego.ponerJugadorEnCaverna(2);

        juego.mover("NORTE");

        assertEquals(3, juego.cavernaDelJugador());
    }

    @Test
    public void moverAlEsteTeniendoDosCaminos() throws Exception {
        juego.adicionarCamino(2, 3, "ESTE");
        juego.adicionarCamino(3, 4, "ESTE");
        juego.ponerJugadorEnCaverna(2);

        juego.mover("ESTE");

        assertEquals(3, juego.cavernaDelJugador());
    }

    @Test
    public void moverDosVeces() throws Exception {
        juego.adicionarCamino(2, 3, "ESTE");
        juego.adicionarCamino(3, 4, "NORTE");
        juego.ponerJugadorEnCaverna(2);

        juego.mover("ESTE");
        juego.mover("NORTE");

        assertEquals(4, juego.cavernaDelJugador());
    }

    @Test
    public void moverAlEsteYVolver() throws Exception {
        juego.adicionarCamino(1, 2, "ESTE");
        juego.ponerJugadorEnCaverna(1);

        juego.mover("ESTE");
        juego.mover("OESTE");

        assertEquals(1, juego.cavernaDelJugador());
    }

    @Test
    public void puedeOlerABestia() throws Exception {
        juego.adicionarCamino(1, 2, "ESTE");
        juego.ponerJugadorEnCaverna(1);
        juego.ponerBestia(2);

        assertTrue(juego.puedoOlerBestia());
    }

    @Test
    public void noPuedeOlerABestia() throws Exception {
        juego.adicionarCamino(1, 2, "ESTE");
        juego.adicionarCamino(2, 3, "ESTE");
        juego.ponerJugadorEnCaverna(1);
        juego.ponerBestia(3);

        assertFalse(juego.puedoOlerBestia());
    }

    @Test
    public void recogeUnaFlecha() throws Exception {
        juego.adicionarCamino(1, 2, "NORTE");
        juego.ponerJugadorEnCaverna(1);
        juego.ponerFlechaEnCaverna(2);
        juego.ponerBolsaDeFlechasEn(0);

        juego.mover("NORTE");

        assertEquals(1, juego.obtenerBolsaDeFlechas());
        assertEquals(0, juego.flechasEnCaverna(2));
    }

    /*@Test
    public void recogeDosFlechas() throws Exception {
        juego.adicionarCamino(1, 2, "NORTE");
        juego.adicionarCamino(2, 3, "ESTE");
        juego.ponerJugadorEnCaverna(1);
        juego.ponerFlechaEnCaverna(2);
        juego.ponerFlechaEnCaverna(3);
        juego.ponerBolsaDeFlechasEn(0);

        juego.mover("NORTE");
        juego.mover("ESTE");

        assertEquals(2, juego.obtenerBolsaDeFlechas());
        assertEquals(0, juego.flechasEnCaverna(2));
        assertEquals(0, juego.flechasEnCaverna(3));

    }*/





}

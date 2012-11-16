import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class _PresentadorJuegoTest {

    @Test
    public void imprimirBienvenida() throws Exception {
        Consola consola = new _ConsolaParaTest();
        PresentadorJuego p = new PresentadorJuego(consola);

        p.imprimirBienvenida();

        assertTrue(consola.ultimoMensajeImpreso("BIENVENIDO AL JUEGO DE LA BESTIA"));
    }

}

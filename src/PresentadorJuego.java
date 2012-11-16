
public class PresentadorJuego {

    private final Consola consola;

    public PresentadorJuego(Consola consola) {
        this.consola = consola;
    }

    public void imprimirBienvenida() {
        consola.imprimir("BIENVENIDO AL JUEGO DE LA BESTIA");
    }

}


public class JuegoDeLaBestia {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Consola consola = new ConsolaModoCaracter();
        PresentadorJuego presentador = new PresentadorJuego(consola);
        presentador.imprimirBienvenida();
    }

}

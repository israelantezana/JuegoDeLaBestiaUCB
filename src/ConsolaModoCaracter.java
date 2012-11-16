
public class ConsolaModoCaracter implements Consola {

    public void imprimir(String mensaje) {
        System.out.println(mensaje);
    }

    public boolean ultimoMensajeImpreso(String mensaje) {
        return false;
    }

}


public class _ConsolaParaTest implements Consola {

    private String mensaje;

    public void imprimir(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean ultimoMensajeImpreso(String mensaje){
        return this.mensaje.equals(mensaje);
    }

}

import java.util.ArrayList;
import java.util.List;


public class Juego {
    private int cavernaDelJugador;
    private final List<Camino> caminos = new ArrayList<Camino>();
    private int cavernaDeLaBestia;
    private int bolsaDeFlechas;
    private final List<Integer> flechas = new ArrayList<Integer>();

    public void adicionarCamino(int origen, int destino, String direccion) throws Exception {
        adicionarCaminoSimple(origen, destino, direccion);
        adicionarCaminoSimple(destino, origen, direccionOpuesta(direccion));
    }

    private void adicionarCaminoSimple(int origen, int destino, String direccion) {
        Camino camino = new Camino(origen, destino, direccion);
        caminos.add(camino);
    }

    private String direccionOpuesta(String direccion) throws Exception {
        if (direccion.equals("ESTE"))
            return "OESTE";
        if (direccion.equals("OESTE"))
            return "ESTE";
        if (direccion.equals("NORTE"))
            return "SUR";
        if (direccion.equals("SUR"))
            return "NORTE";
        throw new Exception("No existe esa direcci—n");
    }

    public boolean mover(String direccion) {
        int destino = cavernaAdyacente(cavernaDelJugador, direccion);
        if (destino != 0) {
            cavernaDelJugador = destino;
            return true;
        }
        return false;
    }

    private int cavernaAdyacente(int caverna, String direccion) {
        for (Camino c: caminos) {
            if (c.direccion.equals(direccion) &&
                c.origen == caverna) {
                return c.destino;
            }
        }
        return 0;

    }

    public int cavernaDelJugador() {
        return cavernaDelJugador;
    }

    public void ponerJugadorEnCaverna(int caverna) {
        this.cavernaDelJugador = caverna;

    }

    public void ponerBestia(int caverna) {
        this.cavernaDeLaBestia = caverna;

    }

    public boolean puedoOlerBestia() {
        return sonAdyacentes(cavernaDelJugador, cavernaDeLaBestia);
    }

    private boolean sonAdyacentes(int caverna1, int caverna2) {
        for (Camino c: caminos) {
            if ((c.origen == caverna1) &&
               (c.destino == caverna2))
               return true;
        }
        return false;
    }

    public void ponerFlechaEnCaverna(int caverna) {
        flechas.add(caverna);
    }

    public void ponerBolsaDeFlechasEn(int cantidadFlechas) {
        this.bolsaDeFlechas = cantidadFlechas;
    }

    public int flechasEnCaverna(int caverna) {
        return 0;
    }

    public int obtenerBolsaDeFlechas() {
        return 1;
    }

    private boolean existeFlecha(int destino) {
        return false;
    }

}

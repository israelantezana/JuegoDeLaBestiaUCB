import java.util.ArrayList;
import java.util.List;


public class Caminos {
	private final List<Camino> caminos = new ArrayList<Camino>();

	public int cavernaAdyacente(int caverna, String direccion) {
        for (Camino c: caminos) {
            if (c.direccion.equals(direccion) &&
                c.origen == caverna) {
                return c.destino;
            }
        }
        return 0;
    }
	
	 public boolean sonAdyacentes(int caverna1, int caverna2) {
	        for (Camino c: caminos) {
	            if ((c.origen == caverna1) &&
	               (c.destino == caverna2))
	               return true;
	        }
	        return false;
	    }

	void adicionarCaminoSimple(int origen, int destino, String direccion) {
	    Camino camino = new Camino(origen, destino, direccion);
	    caminos.add(camino);
	}


}



import java.util.ArrayList;
import java.util.List;


public class Juego {
    private int cavernaDelJugador;
    private Caminos caminos = new Caminos();
    private int cavernaDeLaBestia;
    private int bolsaDeFlechas;
    private final List<Integer> flechas = new ArrayList<Integer>();

    public void adicionarCamino(int origen, int destino, String direccion) throws Exception {
        caminos.adicionarCaminoSimple(origen, destino, direccion);
        caminos.adicionarCaminoSimple(destino, origen, direccionOpuesta(direccion));
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
        int destino = caminos.cavernaAdyacente(cavernaDelJugador, direccion);
        if (destino != 0) {
            cavernaDelJugador = destino;
            if(existeFlecha(destino))
            {
            	this.bolsaDeFlechas++;
            	recojerFlechaDeCaverna(destino);
            }
            return true;
        }
        return false;
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
        return caminos.sonAdyacentes(cavernaDelJugador, cavernaDeLaBestia);
    }

    public void ponerFlechaEnCaverna(int caverna) {
        flechas.add(caverna);
    }

    public void ponerBolsaDeFlechasEn(int cantidadFlechas) {
        this.bolsaDeFlechas = cantidadFlechas;
    }

    public int cantidadDeflechasEnCaverna(int caverna) {
    	for(int flechaEnCaverna : flechas)
    	{
    		if(flechaEnCaverna==caverna)
    			return 1;
    	}
        return 0;
    }

    public int obtenerBolsaDeFlechas() {
        return this.bolsaDeFlechas;
    }

    private boolean existeFlecha(int destino) {
        return (cantidadDeflechasEnCaverna(destino)==1);
    }
    
    private void recojerFlechaDeCaverna(int caverna) {
    	for(int i= 0; i < flechas.size(); i++)
    	{
    		if(flechas.get(i)==caverna)
    		{
    			flechas.remove(i);
    			break;
    		}
    	}
	}

}

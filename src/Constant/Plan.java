package Constant;

import java.util.ArrayList;

import Metier.Etape;
import Metier.Ligne;
import Metier.Station;

/*Plan utilisé dans le main :
 * 
 * 		1-------2-------3
 * 				|
 * 				|
 * 				4
 * 				|
 * 				|
 * 		5-------6-------7
 */

public class Plan {
	public static final int VITESSE = 1; // vitesse d'un utilisateur a pied
	public static final int ATTENTE = 300; // temps d'attente moyen d'un metro en secondes
	private static ArrayList<Ligne> LIGNES = new ArrayList<Ligne>();
	private static ArrayList<Station> ListeStations = new ArrayList<Station>();
	private static ArrayList<Etape> ETAPES = new ArrayList<Etape>();
	
	
	
	public static Station findByName(String nom){
		Station res = null;
		int i = 0;
		while (res == null && i <getListeStations().size()){
			if(getListeStations().get(i).getNom().compareTo(nom) == 0)
				res = getListeStations().get(i);
			i++;
		}
		return res;
	}



	public static void setListeStations(ArrayList<Station> listeStations) {
		ListeStations = listeStations;
	}



	public static ArrayList<Station> getListeStations() {
		return ListeStations;
	}



	public static ArrayList<Ligne> getLIGNES() {
		return LIGNES;
	}



	public static void setLIGNES(ArrayList<Ligne> lIGNES) {
		LIGNES = lIGNES;
	}



	public static ArrayList<Etape> getETAPES() {
		return ETAPES;
	}



	public static void setETAPES(ArrayList<Etape> eTAPES) {
		ETAPES = eTAPES;
	}
}

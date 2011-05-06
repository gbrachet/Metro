package Constant;

import java.util.ArrayList;

import Metier.Ligne;
import Metier.Station;

public class Plan {
	
	private static ArrayList<Ligne> LIGNES = new ArrayList<Ligne>();
	private static ArrayList<Station> ListeStations = new ArrayList<Station>();
	
	
	
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
}

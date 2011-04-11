package Metier;
import java.util.ArrayList;


public class Station {
	
	private static ArrayList<Station> ListeStations = new ArrayList<Station>();
	private int arret;	//Temps d'arrêt en secondes
	private String nom;
	private int x;
	private int y;
	private boolean incident = false;

	/**
	 * @param arret
	 * @param nom
	 * @param x
	 * @param y
	 */
	public Station(int arret, String nom, int x, int y) {
		this.arret = arret;
		this.nom = nom;
		this.x = x;
		this.y = y;
		ListeStations.add(this);
	}

	public int getArret() {
		return arret;
	}

	public void setArret(int arret) {
		this.arret = arret;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isIncident() {
		return incident;
	}

	public void setIncident(boolean incident) {
		this.incident = incident;
	}
	
	public static Station findByName(String nom){
		Station res = null;
		int i = 0;
		while (res == null && i <ListeStations.size()){
			if(ListeStations.get(i).getNom().compareTo(nom) == 0)
				res = ListeStations.get(i);
			i++;
		}
		return res;
		
	}
	
	
	

}

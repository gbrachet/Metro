package Metier;
import java.util.ArrayList;

import Constant.Plan;


public class Ligne {
	
	private String nom; // nom de la station (unique)
	private ArrayList<Station> stations; // liste des stations de la ligne
	private ArrayList<Integer> temps; // temps entre chaque station temps(0) est egal au temps entre la station 0 et la station 1
	
	public Ligne(String n, ArrayList<Station> s, ArrayList<Integer> t){
		nom = n;
		stations = s;
		temps = t;
		Plan.getLIGNES().add(this);
	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}

	public ArrayList<Integer> getTemps() {
		return temps;
	}

	public void setTemps(ArrayList<Integer> temps) {
		this.temps = temps;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}

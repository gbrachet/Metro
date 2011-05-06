package Metier;
import java.util.ArrayList;

import Constant.Plan;


public class Ligne {
	
	
	private ArrayList<Station> stations;
	private ArrayList<Integer> temps;
	
	public Ligne(ArrayList<Station> s, ArrayList<Integer> t){
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
}

package Metier;

import Constant.Plan;

public class Etape {

	private int x;
	private int y;
	private Station station;
	private Noeud noeud;
	
	public Etape(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.station = Station.findByCoord(x,y);
		Plan.getETAPES().add(this);
	}
	
	public Etape(String station)
	{
		Station s = Plan.findByName(station);
		this.x = s.getX();
		this.y = s.getY();
		this.station = s;
		Plan.getETAPES().add(this);
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

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Noeud getNoeud() {
		return noeud;
	}

	public void setNoeud(Noeud noeud) {
		this.noeud = noeud;
	}
	
	public String toString(){
		String res;
		if(station != null)
			res = "Station : "+station.getNom();
		else res = "x : "+x+"\ty : "+y;
		return res;
	}
	
}

package calculchemin;

import Constant.Plan;
import Metier.Ligne;
import Metier.Station;

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
	}
	
	public Etape(String station)
	{
		Station s = Plan.findByName(station);
		this.x = s.getX();
		this.y = s.getY();
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
		
	}
	
}

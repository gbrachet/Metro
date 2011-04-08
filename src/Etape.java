
public class Etape {

	private int x;
	private int y;
	private Station station;
	
	public Etape(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Etape(String station)
	{
		Station s = Station.findByName(station);
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
	
	
}

import java.util.ArrayList;


public class Ligne {

	private ArrayList<Station> stations;
	private ArrayList<Integer> temps;
	
	public Ligne(ArrayList<Station> s, ArrayList<Integer> t){
		stations = s;
		temps = t;
	}
}

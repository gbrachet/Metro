package Metier;

public abstract class Coordonnees {

	public int calculDistance(int x1, int y1,int x2, int y2){
		double res = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		return (int)Math.round(res);
		
	}
}

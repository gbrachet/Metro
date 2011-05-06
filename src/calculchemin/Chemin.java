package calculchemin;
import java.util.ArrayList;

import Constant.Plan;
import Metier.Station;

public class Chemin {
	
	private ArrayList<Etape> chemin = new ArrayList<Etape>();
	
	
	/* calcule la distance entre les points (x1,y1) et (x2,y2) */
	public double distance(int x1, int y1, int x2, int y2){
		
	    /* distance euclidienne */
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	/**
	 * 
	 * @param etape  (etape actuelle)
	 */
	public void ajouterEtape(Etape etape){
		//noeud a ajouter dans la prochaine étape
		Noeud n;
		
		
		for (Station tmp : Plan.getListeStations()){
			//Si l'étape fait partie du plan (100 sur 100) et qu'elle n'a pas d'incidents
			if(tmp.getX()<100 && tmp.getX()>0 && tmp.getY()<100 && tmp.getY()>0 && !tmp.isIncident()){
				
			}
		}
		
	}
}

package calculchemin;
import java.util.ArrayList;

import Constant.Plan;
import Metier.Ligne;
import Metier.Station;
import Metier.Utilisateur;

public class Chemin {
	
	private int COUT_MAX = 99999;
	private ArrayList<Etape> chemin = new ArrayList<Etape>();
	private ArrayList<Etape> listeOuverte = new ArrayList<Etape>();
	private ArrayList<Etape> listeFermee = new ArrayList<Etape>();
	private Etape destination;
	private Etape depart;
	private Etape courant;
	
	
	public Chemin(Etape dest, Etape dep){
		destination = dest;
		depart = dep;
	}
	
	
	
	
	/* calcule la distance au carr� entre les points (x1,y1) et (x2,y2) */
	
	public int tempsTheorique(int x1, int y1, int x2, int y2){
		
	    /* distance euclidienne divisee par la vitesse de l'utilisateur a pied */
		return (int) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2))/Plan.VITESSE;
	}
	
	
	
	
	/**
	 * 
	 * @param e1 etape de depart
	 * @param e2 etape d'arriv�e
	 * @return
	 */
	public int tempsReel(Etape e1, Etape e2){
		
		int res;
		//si les deux etapes sont des stations
		if(e1.getStation() != null && e2.getStation() != null){
			// on calcule le temps entre les deux stations
			res = e1.getStation().temps(e2.getStation());
			
		//sinon si l'etape 1 n'est pas une station et l'�tape 2 si on doit ajouter
		//le temps d'attente d'un metro en plus du temps pour arriver a la station	
		}else if (e1.getStation()==null && e2.getStation() !=null){
			res = tempsTheorique(e1.getX(),e1.getY(),e2.getX(),e2.getY()) + Plan.ATTENTE;
		}else {// sinon on calcule le temps a pied
				res = tempsTheorique(e1.getX(),e1.getY(),e2.getX(),e2.getY());
		}
	return res;
	}
	
	
	// retourne l'�tape avec le coutF le plus faible
	public Etape meilleureEtape(){
		int f = COUT_MAX;
		int tmp;
		Etape res = null;
		for(Etape e : listeOuverte){
			tmp = e.getNoeud().getCoutF();
			if (tmp < f){
				f = tmp;
				res = e; 
			}
		}
		return res;
	}
	
	
	
	//ajoute une etape a la liste ferm�e et la supprime de la liste ouverte
	
	public void ajouterListeFermee(Etape etape){
		listeFermee.add(etape);
		listeOuverte.remove(etape);
	}
	
	public void retrouverChemin(){
		//l'arriv�e est le dernier �l�ment de la liste ferm�e
		Etape tmp = listeFermee.get(listeFermee.size()-1);
		chemin.add(tmp);
		while(tmp.getX() != depart.getX() && tmp.getY()!=depart.getY()){
			tmp = tmp.getNoeud().getParent();
			chemin.add(tmp);
		}
	}
	
	/**
	 * 
	 * @param etape  (etape actuelle)
	 */
	public void ajouterEtape(Etape etape){
		
		for (Etape tmp : Plan.getETAPES()){
			//Si l'�tape n'a pas d'incidents et qu'elle n'est pas l'�tape courante on l'ajoute � la liste ouverte.
			if(!tmp.getStation().isIncident() && (tmp.getX()!=etape.getStation().getX() || tmp.getY()!=etape.getStation().getY())){
				//calcul du coutG pour le noeud
				int g = etape.getNoeud().getCoutG()+ tempsReel(etape,tmp);
				//calcul du coutH
				int h = tempsTheorique(tmp.getX(),tmp.getY(),destination.getX(),destination.getY());
				//calcul du coutF
				int f = g + h;
				Noeud temporaire = new Noeud (g, h, f, etape);
					
					
				//si l'etape est d�j� dans la liste ouverte on doit comparer les co�ts
				boolean present = false;
				for (Etape e : listeOuverte){
					if(e.getX() == tmp.getX() && e.getY()==tmp.getY()){// etape trouvee dans la liste ouverte
						present = true;
						//si le cout est meilleur maintenant que celui dans la liste ouverte
						if(temporaire.getCoutF()< e.getNoeud().getCoutF()){
							e.setNoeud(temporaire);
						}//sinon on ne change rien
						
					}
				}
				//si l'�tape n'est pas pr�sente on l'y ajoute
				if (!present){
					tmp.setNoeud(temporaire);
					listeOuverte.add(tmp);
				}
			}
		}
	}	
	
	// calcul du meilleur chemin disponible
	
	public void calculChemin(){
		//initialisation
		courant = new Etape(depart.getX(),depart.getY());
		int h = tempsTheorique(courant.getX(), courant.getY(), destination.getX(),destination.getY());
		courant.setNoeud(new Noeud(0,h,h));
		//ajout de courant dans la liste ouverte
		listeOuverte.add(courant);
		ajouterListeFermee(courant);
		ajouterEtape(courant);
		
		/* tant que la destination n'a pas �t� atteinte et qu'il reste des noeuds � explorer dans la liste ouverte */
	    while( !((courant.getX() == destination.getX()) && (courant.getY() == destination.getY()))
	    		&& (!listeOuverte.isEmpty())
	         ){
	    	/* on cherche le meilleur noeud de la liste ouverte, on sait qu'elle n'est pas vide donc il existe */
	        courant = meilleureEtape();
	        
	        /* on le passe dans la liste fermee, il ne peut pas d�j� y �tre */
	        ajouterListeFermee(courant);
	        
	        /* on recommence la recherche des noeuds adjacents */
	        ajouterEtape(courant);    
	   
	    }
	    
	    /* la destination est atteinte, on remonte le chemin */
	    if ((courant.getX() == destination.getX()) && (courant.getY() == destination.getY())){
	        retrouverChemin();
	        for(Etape e : chemin){
	        	e.toString();
	        	}
	        }else{
	        	/* pas de solution */
	        	}
	    }
	
}

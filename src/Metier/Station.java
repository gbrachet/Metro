package Metier;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import Constant.Plan;

/**
 * Classe représentant une station de métro.
 * @author BALLAND Cyriel, BRACHET Gautier, DARTOIS Romain, PERRIN Maxence
 * @version 2.0 (11/04/11)
 */
public class Station extends Etape implements Serializable {
	
	/* Attributs */

	private static final long serialVersionUID = 2649939823400596083L;
	private static String cheminSauvegarde = ".";
	
	private int arret;					//Temps d'arrêt en secondes
	private String nom;					//Nom de la station
	private boolean incident = false;	//Présence d'un incident de la station
	
	/* Contructeurs */

	/**
	 * @param arret
	 * @param nom
	 * 
	 */
	public Station(int arret, String nom, int x, int y) {
		super(x,y);
		this.arret = arret;
		this.nom = nom;
		Plan.getListeStations().add(this);
	}
	
	/* Get & Set */
	

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


	public boolean isIncident() {
		return incident;
	}

	public void setIncident(boolean incident) {
		this.incident = incident;
	}
	
	/* Méthodes */
	
	
	
	
// trouve la station correspondant aux coordonnées données en parametre
	public static Station findByCoord(int x, int y){
		Station s = null;
		for(Station station : Plan.getListeStations()){
			if(station.getX()== x && station.getY()==y)
				s = station;
		}
		return s;
	}
	
	
// renvoie la ligne commune aux deux stations si elle existe
// ou null si elle n'existe pas
	
	public Ligne memeLigne(Station s){
		
		Ligne res = null;
		boolean trouve = false;
			// on compare la liste de lignes de la station1 avec la liste de lignes de la station2
			// pour voir les correspondances.
			/*for(Ligne l1 : lignes){
				for(Ligne l2 : s.getLignes()){
					if (l1.getNom().compareTo(l2.getNom()) == 0)
						res = l1;
				}
			}
		return res;*/
		for(Ligne l : Plan.getLIGNES()){
			for(Station s1 : l.getStations()){
				// si s est dans la ligne courante 
				if (s1 == s){
					if(trouve){
						res = l;
					}
					trouve = true;
				}
				// si la station courante est dans la ligne
				if(s1==this){
					if(trouve){
						res = l;
					}
					trouve = true;
				}
				
			}
			trouve = false;
		}
		return res;
	}
	
	public int temps(Station s){
		boolean adjacent = false;
		int temps = 0;
		//on verifie si les deux stations sont sur une même ligne
		Ligne ligne = this.memeLigne(s);
		//si une ligne commune a été trouvée
		if(ligne != null){
			
		Station tmp = ligne.getStations().get(0);
			//on parcoure la liste de station de la ligne pour voir si les deux stations sont adjacentes
			for(int i = 1; i<ligne.getStations().size(); i++){
				//si la station temporaire correspond a une des deux stations recherchées
				if (tmp.getNom().compareTo(nom)==0 ||
					tmp.getNom().compareTo(s.getNom())==0){
					//on vérifie si la station suivante correspond a l'autre station recherchée
					if (ligne.getStations().get(i).getNom().compareTo(nom)==0 ||
						ligne.getStations().get(i).getNom().compareTo(s.getNom())==0	){
						//les deux station sont l'une a coté de l'autre on met adjacent a true
						adjacent = true;
						// on prend le temps entre la station tmp et la station courante et on ajoute le temps d'arrêt de la station courante
						temps = ligne.getTemps().get(i-1) + ligne.getStations().get(i).getArret();;
					}
				}
				//on change la station temporaire et on recommence
				tmp = ligne.getStations().get(i);
			}
		}else{// si les stations ne sont pas sur la même ligne on renvoit le temps pour parcourir la distance entre les deux stations à pied
			temps = (int)Math.sqrt((super.getX()-s.getX())*(super.getX()-s.getX()) + (super.getY()-s.getY())*(super.getY()-s.getY()))/Plan.VITESSE*10;
		}
		
		return temps;
	}
	
	public String toString()
	{
		return "Nom de la sation : "+this.nom+"\n"
			  +"Temps d'arrêt de la station : "+this.arret+"\n"
			  +"X : "+super.getX()+"\n"
			  +"Y : "+super.getY()+"\n"
			  +"Incident : "+this.incident
		;		
	}
	
	public void save()
	{
		try{
			//Ouverture en écriture du fichier de sauvegarde
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Station.cheminSauvegarde+"/"+this.nom+".serial"));
			
			//Copie des données
			oos.writeObject(this);
			
			//Vidage du tampon
			oos.flush();
			
			//Fermeture propre
			oos.close();			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/* Méthodes statiques */
	
	public static Station load(String fichier)
	{
		//Initialisation de la valeur de retour
		Station retour = null;
		
		try{
			//Ouverture du fichier en lecture
			ObjectInputStream ios = new ObjectInputStream(new FileInputStream(Station.cheminSauvegarde+"/"+fichier));
			
			//Désérialisation
			retour = (Station) ios.readObject(); 			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		//Retour du résultat
		return retour;
	}


/*	public static void main(String[] args)
	{
		//Création d'une station de test
		Station s1 = new Station(60, "Station1", 10, 20);
		
		//Sauvegarde de la station
		s1.save();
		
		//Chargement du fichier
		Station s2 = Station.load("Station1.serial");
		
		System.out.println(s1+"\n"+s2);
		
		System.out.println("ok");
		
	}
	*/
	
	

}

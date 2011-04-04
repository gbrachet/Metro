
public class Station {
	
	private int arret;	//Temps d'arrêt en secondes
	private String nom;
	private int x;
	private int y;
	private boolean incident = false;

	/**
	 * @param arret
	 * @param nom
	 * @param x
	 * @param y
	 */
	public Station(int arret, String nom, int x, int y) {
		this.arret = arret;
		this.nom = nom;
		this.x = x;
		this.y = y;
	}
	
	
	

}

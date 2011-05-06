package Metier;

public class Utilisateur {

	private int posx;
	private int posy;
	
	public Utilisateur (int x, int y){
		posx = x;
		posy = y;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}
}

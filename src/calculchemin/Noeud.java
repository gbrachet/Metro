package calculchemin;
//le coutG (le cout pour aller du point de départ au noeud considéré)
//le coutH (le cout pour aller du noeud considéré au point de destination)
//le coutF (somme des précédents mais mémorisé pour ne pas le recalculer à chaque fois)
//le parent (noeud parent)
public class Noeud {

	private int coutG;
	private int coutH;
	private int coutF;
	private Noeud parent;
	
	public Noeud(int g, int h, int f, Noeud p){
		coutG = g;
		coutH = h;
		coutF = f;
		parent = p;
	}

	public int getCoutG() {
		return coutG;
	}

	public void setCoutG(int coutG) {
		this.coutG = coutG;
	}

	public int getCoutH() {
		return coutH;
	}

	public void setCoutH(int coutH) {
		this.coutH = coutH;
	}

	public int getCoutF() {
		return coutF;
	}

	public void setCoutF(int coutF) {
		this.coutF = coutF;
	}

	public Noeud getParent() {
		return parent;
	}

	public void setParent(Noeud parent) {
		this.parent = parent;
	}
}

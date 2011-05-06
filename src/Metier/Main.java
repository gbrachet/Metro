package Metier;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		try{
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			Utilisateur u=new Utilisateur(0,0);
			while(true){
				System.out.println("Bonjour, Voulez -vous vous rendre:");
				System.out.println("choix 1: à une station");
				System.out.println("choix 2: à des coordonnées précises");
				int choix =sc.nextInt();
				if(choix==1){
					//il entre le nom de la station souhaitée
					System.out.println("Veuillez SVP entrer le lieu ou vous voulez vous rendre");
					String lieu=sc.next();
					System.out.println(lieu);
				}
				else if(choix==2){
					//il entre les coordonnées de la position souhaitée
					System.out.println("Veuillez SVP entrer l'abscisse du lieu ou vous voulez vous rendre");
					int abs=sc.nextInt();
					System.out.println("Veuillez SVP entrer l'ordonnee du lieu ou vous voulez vous rendre");
					int ord=sc.nextInt();
					System.out.println(abs+" "+ord);
				}
				else{
					System.out.println("Erreur: entier entré non valide");
				}
				
				
			}
		}catch(Exception e){
			System.out.println("ERREUR !!");
		}
		
			
			/*switch(choix){
			case 1:
				//lieu connu
				break;
			case 2:

				break;
				
				
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
				
			default:
				break;
			}*/
	}
}

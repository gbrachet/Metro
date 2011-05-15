package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Constant.Plan;
import Metier.Etape;
import Metier.Ligne;
import Metier.Station;
import Metier.Utilisateur;

import calculchemin.Chemin;


public class Main {

	
	/**
	 * @param args
	 */
	
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Etape> let=new ArrayList<Etape>();
	static ArrayList<Chemin> lch=new ArrayList<Chemin>();
	static Etape dep;
	static Etape arr;
	static Utilisateur u=new Utilisateur(10,10);
	static int mode;
	
	public static void choixArrivee(){
		
		dep=new Etape(u.getPosx(),u.getPosy());
		System.out.println("Bonjour, vous êtes actuellement en "+u.getPosx()+","+u.getPosy());
		System.out.println("Vous souhaitez vous rendre :");
		System.out.println("1 : à une station");
		System.out.println("2 : à des coordonnées précises");
		int choix =sc.nextInt();
		while(choix !=1 && choix !=2){
			//si erreur
			System.out.println("Erreur: entier entré non valide");
			System.out.println();
			System.out.println("Bonjour, vous êtes actuellement en "+u.getPosx()+","+u.getPosy());
			System.out.println("Vous souhaitez vous rendre:");
			System.out.println("1 : à une station");
			System.out.println("2 : à des coordonnées précises");
			choix =sc.nextInt();
		}
		if(choix==1){
			//il entre le nom de la station souhaitée
			System.out.println("Veuillez SVP entrer le nom de la station ou vous voulez vous rendre");
			String lieu=sc.next();
			System.out.println(lieu);
			arr= Plan.findByName(lieu);
		}
		else if(choix==2){
			//il entre les coordonnées de la position souhaitée
			try{
				System.out.println("Veuillez SVP entrer l'abscisse du lieu ou vous voulez vous rendre");
				int abs=sc.nextInt();
				System.out.println("Veuillez SVP entrer l'ordonnee du lieu ou vous voulez vous rendre");
				int ord=sc.nextInt();
				System.out.println(abs+" "+ord);
				arr=new Etape(abs,ord);
			}
			catch(InputMismatchException e){
				System.out.println("Erreur: il faut entrer un entier");
				System.out.println("retour au début");
				System.out.println();
				main(null);
			}
		}
	}
	
	public static int choixNbEtapes(){
		int nbEtapes=0;
		System.out.println("Veuillez entrer le nombre d'étapes intermédiaires que vous voulez faire. Entrez 0 si vous n'avez pas de préférence.");
		try{
			nbEtapes=sc.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Erreur: il faut entrer un entier");
			System.out.println("retour au début");
			System.out.println();
			main(null);
			
		}
		return nbEtapes;
	}
	public static void choixMode(){
		System.out.println("Préférence pour le trajet :");
		System.out.println("1 : Le plus court");
		System.out.println("2 : Avec le moins de changements possibles (pas implémenté)");
		mode = sc.nextInt();
		
	}
	public static void choixEtape(int i){
		System.out.println("Etape "+(i+1)+": Est-ce:");
		System.out.println("1 : une station");
		System.out.println("2 : des coordonnées précises");
		int choix=sc.nextInt();
		while(choix !=1 && choix !=2){
			//si erreur
			System.out.println("Erreur: entier entré non valide");
			System.out.println();
			System.out.println("Etape "+(i+1)+": Est-ce:");
			System.out.println("choix 1:une station");
			System.out.println("choix 2:des coordonnées précises");
			choix =sc.nextInt();
		}
		if(choix==1){
			//il entre le nom de la station souhaitée
			System.out.println("Veuillez SVP entrer le nom de la station");
			String lieu=sc.next();
			System.out.println(lieu);
			let.add(Plan.findByName(lieu));
		}
		else if(choix==2){
			//il entre les coordonnées de la position souhaitée
			try{
				System.out.println("Veuillez SVP entrer l'abscisse de l'étape");
				int abs=sc.nextInt();
				System.out.println("Veuillez SVP entrer l'ordonnee de l'étape");
				int ord=sc.nextInt();
				System.out.println(abs+" "+ord);
				let.add(new Etape(abs,ord));
			}
			catch(InputMismatchException e){
				System.out.println("Erreur: il faut entrer un entier");
				System.out.println("retour au début...");
				System.out.println();
				main(null);
			}
		}
	}
	
	public static void main(String[] args){
			// TODO Auto-generated method stub
		
		//on crée le plan du métro
		
		ArrayList<Integer> temps1 = new ArrayList<Integer>();
		ArrayList<Integer> temps2 = new ArrayList<Integer>();
		ArrayList<Integer> temps3 = new ArrayList<Integer>();
		
		ArrayList<Station> s1 = new ArrayList<Station>();
		ArrayList<Station> s2 = new ArrayList<Station>();
		ArrayList<Station> s3 = new ArrayList<Station>();
		
		Station station1;
		Station station2;
		Station station3;
		Station station4;
		Station station5;
		Station station6;
		Station station7;
		
		Ligne ligne1;
		Ligne ligne2;
		Ligne ligne3;
		
		temps1.add(100);
		temps1.add(200);
		temps2.add(150);
		temps2.add(150);
		temps3.add(200);
		temps3.add(100);
		
		station1 = new Station(20,"station1",0,0);
		station2 = new Station(20,"station2",50,0);
		station3 = new Station(20,"station3",100,0);
		station4 = new Station(20,"station4",50,50);
		station5 = new Station(20,"station5",0,100);
		station6 = new Station(20,"station6",50,100);
		station7 = new Station(20,"station7",100,100);
		
		s1.add(station1);
		s1.add(station2);
		s1.add(station3);
		s2.add(station2);
		s2.add(station4);
		s2.add(station6);
		s3.add(station5);
		s3.add(station6);
		s3.add(station7);
		
		ligne1 = new Ligne("ligne1",s1,temps1);
		ligne2 = new Ligne("ligne2",s2,temps2);
		ligne3 = new Ligne("ligne3",s3,temps3);

		
			while(true){
				// on choisit l'arrivée
				choixArrivee();
				
				//on choisi le nombre d'étapes
				int nbEtapes=choixNbEtapes();
				
				//on choisi chaque étape
				for(int i=0;i<nbEtapes;i++){
					choixEtape(i);
				}
				
				// on choisi le mode 
				choixMode();
				
				//on crée les chemins et on les ajoute
				
				//s'il y a des étapes intermédiaires
				if(nbEtapes !=0){
					lch.add(new Chemin(let.get(0),dep));
					for(int i=0;i<nbEtapes-1;i++){
						lch.add(new Chemin(let.get(i+1),let.get(i)));
					}
					lch.add(new Chemin(arr,let.get(let.size()-1)));
				}
				
				// s'il n'y a pas d'étapes
				else{
					lch.add(new Chemin(arr,dep));
				}
				//calcule les chemins
				
				for(Chemin ch: lch){
					ch.calculChemin();
				}
				
				// affiche chaque chemin
				for(Chemin ch: lch){
					ch.afficherChemin();
				}
				//on met a jour la position de l'utilisateur
				u.setPosx(arr.getX());
				u.setPosy(arr.getY());
			}
		}
}
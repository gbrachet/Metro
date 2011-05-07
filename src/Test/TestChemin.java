package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Metier.Ligne;
import Metier.Station;

import calculchemin.Chemin;
import calculchemin.Etape;

public class TestChemin {

	public ArrayList<Etape> chemin = new ArrayList<Etape>();
	ArrayList<Station> s1 = new ArrayList<Station>();
	ArrayList<Integer> temps1 = new ArrayList<Integer>();
	ArrayList<Station> s2 = new ArrayList<Station>();
	ArrayList<Ligne> liste1 = new ArrayList<Ligne>();
	ArrayList<Ligne> liste2 = new ArrayList<Ligne>();
	Etape etape1;
	Etape etape2;
	Etape etape3;
	Etape etape4;
	Etape etape5;
	Etape etape6;
	Etape etape7;
	Etape etape8;
	Etape etape9;
	Ligne ligne1;
	Ligne ligne2;
	Station station6;
	Station station7;
	Station station8;
	Station station9;
	
	@Before
	public void setUp() throws Exception {
		
		temps1.add(200);
		temps1.add(200);
		
		ligne1 = new Ligne("station1",s1,temps1);
		ligne2 = new Ligne("station2",s2,temps1);
		
		liste1.add(ligne1);
		liste2.add(ligne2);
		
		etape1 = new Etape(0,10);
		etape2 = new Etape(10,20);
		etape3 = new Etape(10,0);
		etape4 = new Etape(30,40);
		etape5 = new Etape(80,10);
		
		station6 = new Station(20,"station6",20,30,liste1);
		station7 = new Station(20,"station7",0,90,liste1);
		station8 = new Station(20,"station8",0,40,liste2);
		station9 = new Station(20,"station9",80,20,liste2);
		
		s1.add(station6);
		s1.add(station7);
		s2.add(station8);
		s2.add(station9);
		
		station6.getLignes().get(0).setStations(s1);
		station7.getLignes().get(0).setStations(s1);
		station8.getLignes().get(0).setStations(s2);
		station9.getLignes().get(0).setStations(s2);
		
		etape6 = new Etape("station6");
		etape7 = new Etape("station7");
		etape8 = new Etape("station8");
		etape9 = new Etape("station9");
		
		chemin.add(etape1);
		chemin.add(etape2);
		chemin.add(etape3);
		chemin.add(etape4);
		chemin.add(etape5);
		chemin.add(etape6);
		chemin.add(etape7);
		chemin.add(etape8);
		chemin.add(etape9);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testTempsTheorique() {
		assertTrue(Chemin.tempsTheorique(1,10,1,0) == 100);
		//fail("Not yet implemented");
	}

	@Test
	public void testTempsReel() {
		assertTrue(Chemin.tempsReel(etape6, etape7)== 220);
		assertTrue(Chemin.tempsReel(etape7, etape8)== 500);
		//fail("Not yet implemented");
	}



	@Test
	public void testAjouterEtape() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculChemin() {
		fail("Not yet implemented");
	}

}

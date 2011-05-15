package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Constant.Plan;
import Metier.Etape;
import Metier.Ligne;
import Metier.Station;

import calculchemin.Chemin;

public class TestChemin {

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
	
	Chemin ch;
	
	@Before
	public void setUp() throws Exception {
		
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
		
		
		ch = new Chemin(new Etape(90,0),new Etape(10,10));
		ch.calculChemin();
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	
	
	public void testTempsTheorique() {
		assertTrue(Chemin.tempsTheorique(0,10,0,20) == 100);
		//fail("Not yet implemented");
	}

	@Test
	public void testTempsReel() {
		assertTrue(Chemin.tempsReel(station1, station2)== 120);
		assertTrue(Chemin.tempsReel(station1, station5)== 1000);
		//fail("Not yet implemented");
	}


	@Test
	public void testAjouterEtape() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculChemin() {
		 assertEquals(4, ch.getChemin().size());
		  //  assertEquals(list.get(1), "Insert");
		
		//fail("Not yet implemented");
	}


}

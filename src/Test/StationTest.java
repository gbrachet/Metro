package Test;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculchemin.Etape;

import Constant.Plan;
import Metier.*;


public class StationTest {

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
		temps1.add(200);
		
		ligne1 = new Ligne("station1",s1,temps1);
		ligne2 = new Ligne("station2",s2,temps1);
		
		liste1.add(ligne1);
		liste2.add(ligne2);
		
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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindByName() {
		Station test = Plan.findByName("station6");
		assertTrue(test.getNom().compareTo("station6")==0);
//		fail("Not yet implemented");
	}
	
	@Test
	public void testMemeLigne(){
		assertTrue(station6.memeLigne(station7) == ligne1);
	}
	
	@Test
	public void testTemps(){
		assertTrue(station6.temps(station7) == 220);
		assertTrue(station7.temps(station8) == 500);
	}
	

}

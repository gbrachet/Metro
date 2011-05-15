package Test;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import Constant.Plan;
import Metier.*;


public class StationTest {

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
		assertTrue(station6.memeLigne(station7) == ligne3);
		assertTrue(station1.memeLigne(station5)== null);
		assertTrue(station1.memeLigne(station2) == ligne1);
	}
	
	@Test
	public void testTemps(){
		
		assertTrue(station1.temps(station2) == 120);
		assertTrue(station1.temps(station5) == 1000);
		
	}
	

}

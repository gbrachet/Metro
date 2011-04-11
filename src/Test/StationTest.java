package Test;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Metier.*;


public class StationTest {

	private ArrayList<Station> ListeStations;
	
	@Before
	public void setUp() throws Exception {
		
		ListeStations = new ArrayList<Station>();
		ListeStations.add(new Station(5,"station1",0,10));
		ListeStations.add(new Station(3,"station2",10,20));
		ListeStations.add(new Station(10,"station3",25,75));
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindByName() {
		Station test = Station.findByName("station2");
		assert(test.getNom().compareTo("String")==0);
//		fail("Not yet implemented");
	}
	

}

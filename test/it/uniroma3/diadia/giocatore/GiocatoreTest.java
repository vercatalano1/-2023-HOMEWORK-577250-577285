package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class GiocatoreTest {
	Giocatore g1=new Giocatore();
	Giocatore g2=new Giocatore();
	Giocatore g3=new Giocatore();
	    
	
	@Before
	public void initMethod() {
		g1.setCfu(20);
		g3.setCfu(0);
	}


	@Test
	public void testCfuIniziali() {
           assertEquals("il valore di cfu coincide", 20, g1.getCfu());
	}
    
	@Test
	public void testCfuDiversi() {
		   assertNotEquals("non sono gli stessi valori", 5, g2.getCfu());
	}
	
	@Test
	public void testCfuNulli() {
		   assertEquals("non sono presenti cfu",0, g3.getCfu());
	}
	
	@Test
	public void testBorsa() {
		   assertNotNull(g1.getBorsa());
	}
	
	
}

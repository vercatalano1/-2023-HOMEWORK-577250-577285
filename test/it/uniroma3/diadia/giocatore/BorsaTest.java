package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import it.uniroma3.diadia.attrezzi.*;
import org.junit.Test;
import org.junit.Before;

public class BorsaTest {
	Borsa b1= new Borsa();
	Borsa b2= new Borsa();
	Borsa b3=new Borsa();
	
	Attrezzo a1= new Attrezzo("martello",10 );
	Attrezzo a2=new Attrezzo("spada", 5);
	
	@Before
    public void setUp() { 
		b1.addAttrezzo(a2);
		b2.addAttrezzo(a2);
		b3.addAttrezzo(a1);
    }
    
	@Test
	public void testAttrezzoAggiunto() {
		   assertTrue(b1.addAttrezzo(a2));
	}
	
	
	@Test
	public void testAttrezzoDaRimuovere() {
		   assertEquals("attrezzo rimosso", a2, b1.removeAttrezzo("spada"));
	}
	
	@Test
	public void testAttrezzoNonRimosso() {
		   assertEquals(null, b3.removeAttrezzo("spada"));
	}
    
	@Test
	public void testNotHasAttrezzo() {
		   assertEquals(false, b2.hasAttrezzo("martello"));
	}
	
	@Test
	public void testHasAttrezzo() {
		    assertEquals(true, b3.hasAttrezzo("martello"));
	}
	
	@Test
	public void testPesoAttrezzo(){
		   assertEquals(10,b3.getPeso());
	}
	
	@Test
	public void testBorsaSenzaAttrezzo() {
		   assertNotEquals(a1, b2.getAttrezzo("spada"));
	}
	
	@Test
	public void testBorsaConAttrezzo() {
		   assertEquals(a2, b1.getAttrezzo("spada"));
	}
}

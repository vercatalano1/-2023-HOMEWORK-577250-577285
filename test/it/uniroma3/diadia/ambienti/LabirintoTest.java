package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
    
	Labirinto l1=new Labirinto();
	Stanza s1=new Stanza("s1");
	Stanza s2=new Stanza("s2");
	
	
	
	@Before
	public void setUp() {
		s1=this.l1.getStanzaVincente();
		s2=this.l1.getStanzaCorrente();
	}

	
	@Test
	public void testStanzaVincente() {
		   assertEquals(s1, l1.getStanzaVincente());
	}
	
	@Test
	public void testNonVincente() {
		   assertNotEquals(s2, l1.getStanzaVincente());
	}
	
	@Test
	public void testStanzaCorrente() {
		   assertEquals(s2, l1.getStanzaCorrente());
	}
    
	@Test
	public void testNnCorrente() {
		   assertNotEquals(s1, l1.getStanzaCorrente());
	}
}

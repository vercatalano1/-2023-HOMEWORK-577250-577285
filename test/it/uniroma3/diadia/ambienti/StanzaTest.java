package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
       Stanza s1=new Stanza("s1");
       Stanza s2=new Stanza("s2");
       Stanza s3=new Stanza("s3");
       Stanza s4=new Stanza("s4");
       Stanza s5= new Stanza(null);
       Attrezzo a1=new Attrezzo("martello", 10);
       Attrezzo a2= new Attrezzo("cacciavite", 5);
       Attrezzo a3=new Attrezzo("forbice", 3);
       
       
       
       @Before
       public void initMethod() {
    	      System.out.println("Inizio test");
       }
       
       
       @Test
       public void testStanzaNUll() {
    	      s1.impostaStanzaAdiacente("est",s5);
    	      assertNull( null, s1.getStanzaAdiacente(null));
       }
       
       @Test
       public void testStanza1() {
    	      s1.impostaStanzaAdiacente("nord", s2);
    	      assertEquals("trovata la stanza adiacente",s2, s1.getStanzaAdiacente("nord"));
       }
       
       @Test
       public void testStanzaNonAdiacente() {
    	      s1.impostaStanzaAdiacente("nord", s2);
    	      assertNotEquals("le due stanze non sono adiacenti", s2, s1.getStanzaAdiacente("est"));
       }
       
       @Test
       public void testStanzaConAttrezzo1() {
    	      assertTrue(s1.addAttrezzo(a1));
       }
       
       @Test
       public void testNonHaStanzaAttrezzo2() {
    	      s3.addAttrezzo(a3);
      	      assertEquals(true, s3.hasAttrezzo("forbice"));
       }
       
       @Test
       public void testStanzahaAttrezzo() {
    	      s2.addAttrezzo(a3);
    	      assertEquals(true, s2.hasAttrezzo("forbice"));
       }
       
       
       
       @Test
       public void testRimozioneAttrezzoDallaStanza() {
    	      s1.addAttrezzo(a2);
    	      assertEquals(true, s1.removeAttrezzo(a2));
       }
       
       @Test
       public void testNonRimozione() {
    	      s4.addAttrezzo(a2);
    	      assertFalse(s4.removeAttrezzo(a1));
       }
       
       @Test
       public void RimozioneNullo() {
    	      assertFalse(s5.removeAttrezzo(a2));
       }
       
       @Test
       public void testGetAttrezzoStanza() {
    	      assertNotEquals(a2, s4.getAttrezzo("forbice"));
       }
       
       @Test
       public void testGetNullo() {
    	      assertEquals( null, s5.getAttrezzo(null));
       }
}
